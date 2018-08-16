package com.cn.run.kpi.scheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	/**
	 * kafka数据调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void kfakaToMysqlTask() {
		LOG.info("start kfakaToMysqlTask...");
		//获取资源库表监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(5);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取开始时间
		String startTimeStr=scheduleBean.getDatestr();
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
	    String sql = "select * from T_KAFKA_DATA where INPUT_TIME>to_date('"+startTimeStr+"','yyyy-MM-dd HH:mm:ss')";
        try {
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            //调用将结果集转换成实体对象方法
            List list=new ArrayList();
			try {
				list = JDBCUtil.Populate(res, KafkaData.class);
			} catch (InstantiationException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
            //循环遍历结果
            for(int i=0;i<list.size();i++){
            	KafkaData data = (KafkaData) list.get(i);
            	//获取最大时间
            	long dateTime=data.getInput_time().getTime();
            	if(dateTime>maxTime) {
            		maxTime=dateTime;
            	}
            	//解析数据入库，
            	
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
