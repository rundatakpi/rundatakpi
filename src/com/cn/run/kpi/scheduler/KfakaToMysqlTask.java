package com.cn.run.kpi.scheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;
import com.cn.run.kpi.datamonitor.compress.entity.BacklogEntity;
import com.cn.run.kpi.datamonitor.compress.service.CompressService;
import com.cn.run.kpi.scheduler.entity.KafkaData;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.service.ScheduleService;
import com.cn.run.kpi.scheduler.utils.JDBCUtil;

/**
 * kafka数据调度任务
 * @author zjw
 */
@Component("kfakaToMysqlTask")
public class KfakaToMysqlTask {
	private static final Logger LOG = Logger.getLogger(KfakaToMysqlTask.class);
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private CompressService compressService;
	@Autowired
	private AlarmDataService alarmDataService;
	
	/**
	 * kafka数据调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void kfakaToMysqlTask() {
		LOG.info("start kfakaToMysqlTask...");
		//获取资源库表监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(5);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//获取开始时间
		String startTimeStr=scheduleBean.getDatestr();
		//告警阈值
		double seriousNum=Double.parseDouble(scheduleBean.getSeriousalarm());
		//积压最大值(测试值)
		double seriourMax=1111;
		Date startDate=null;
		try {
			startDate=sdf.parse(startTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		//开始时间戳
		long startTime=startDate.getTime();
		//最大时间
		long maxTime=startDate.getTime();
		//获取连接
		Connection conn = JDBCUtil.getConn();   
        PreparedStatement pre = null;
        ResultSet res = null;
	    String sql = "select INPUT_TIME,sum(UNCONSUME_COUNT) UNCONSUME_COUNT from T_KAFKA_DATA "
	    		+ "group by INPUT_TIME having INPUT_TIME>to_date('"+startTimeStr+"','yyyy-MM-dd')";
        try {
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            Long allNum=0l;
            while(res.next()){
            	Date input_time=res.getDate("INPUT_TIME");
            	String input_timeStr=sdf.format(input_time);
            	long count=res.getLong("UNCONSUME_COUNT");
            	BacklogEntity BacklogEntity=new BacklogEntity();
            	BacklogEntity.setCreateDate(input_timeStr);
            	BacklogEntity.setKafkaBacklogNum(count);
            	//插入到数据库中
            	compressService.insertBackLogData(BacklogEntity);
            	//获取最大时间
            	long dateTime=input_time.getTime();
            	if(dateTime>maxTime) {
            		maxTime=dateTime;
            	}
            	//总积压量
            	allNum+=count;
            }
            //告警提示
            if(allNum.doubleValue()/seriourMax>seriousNum) {
        		AlarmData alarmData=new AlarmData();
        		String dateStr=sdf.format(new Date(maxTime));
        		DecimalFormat df = new DecimalFormat("0.00%");
        		String r = df.format(allNum.doubleValue()/seriourMax);
        		String content=dateStr+" Kafka实时积压数据大小达到设备空间的"+df;
        		alarmData.setAlarmContent(content);
        		alarmData.setAlarmLevel("1");
        		alarmData.setAlarmTime(dateStr);
        		alarmData.setProcessState("1");
        		alarmDataService.insertInfo(alarmData);
            }
          //关闭数据库连接
            try{
                if(conn != null){
                	conn.close();
                }
                if(pre != null){
                	pre.close();
                }
                if(res!= null){
                	res.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
                LOG.error(e.getMessage());
            }
          
          //更新最大时间
          if(maxTime>startTime) {
        	  scheduleBean.setDatestr(sdf.format(new Date(maxTime)));
        	  scheduleService.updateSchedule(scheduleBean);
          }
          LOG.info("end kfakaToMysqlTask...");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
	}
}
