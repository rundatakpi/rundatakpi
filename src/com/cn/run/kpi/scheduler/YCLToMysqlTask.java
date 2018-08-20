package com.cn.run.kpi.scheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.entity.YCLDataBean;
import com.cn.run.kpi.scheduler.service.ScheduleService;
import com.cn.run.kpi.scheduler.utils.JDBCUtil;

/**
 * 数据监控页面调度任务
 * @author zjw
 */
@Component("yclToMysqlTask")
public class YCLToMysqlTask {
	private static final Logger LOG = Logger.getLogger(YCLToMysqlTask.class);
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private AlarmDataService alarmDataService;
	
	
	/**
	 * 预处理监测调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void yclToMysqlTask(){
		LOG.info("start yclToMysqlTask...");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//获取预处理监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(1);
		//获取开始时间
		String startTimeStr=scheduleBean.getDatestr();
		//最大时间
		long maxTime=Long.parseLong(startTimeStr);
		//获取连接
		Connection conn = JDBCUtil.getConn();   
        PreparedStatement pre = null;
        ResultSet res = null;
        String conditionStr=getSqlCondition();
	    String sql = "select * from YCLTABLE where TS>? and MID in("+conditionStr+")";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,startTimeStr);
            res = pre.executeQuery();
            Long inputNum=0l;
            Long outputNUm=0l;
            while(res.next()){
            	String timekey=res.getString("TS");
            	//获取最大时间
            	long time=Long.parseLong(timekey);
            	if(time>maxTime) {
            		maxTime=time;
            	}
            	YCLDataBean yclDataBean=new YCLDataBean();
            	yclDataBean.setDataSource(res.getString("DataSource"));
            	String mid=res.getString("MID");
            	yclDataBean.setDataType(mid);
            	yclDataBean.setCreatetime(timekey);
            	Long BCPCnt=res.getLong("BCPCnt");
            	yclDataBean.setDataNum(BCPCnt);
            	yclDataBean.setProtocol(res.getString("DataType"));
            	yclDataBean.setProtocolId(res.getString("ProtocolId"));
            	yclDataBean.setActionType(res.getString("ActionType"));
            	yclDataBean.setCollectPlace(res.getString("CollectPlace"));
            	yclDataBean.setErrorType(res.getInt("FilterType"));
            	scheduleService.insertYCLData(yclDataBean);
            	//输入数据统计
            	if(mid.equals("2001")) {
            		inputNum+=BCPCnt;
            	}
            	//输出数据统计
            	if(mid.equals("2003")||mid.equals("2005")||mid.equals("2009")||mid.equals("2012")||mid.equals("2006")){
            		outputNUm+=BCPCnt;
            	}

            }
            
          //告警提示
          if(inputNum==0||outputNUm==0) {
      		AlarmData alarmData=new AlarmData();
      		String dateStr=sdf.format(new Date(maxTime));
      		String content="";
      		if(inputNum==0) {
      			content=dateStr+" 预处理数据输入数据量为0";
      		}else if(outputNUm==0){
      			content=dateStr+" 预处理数据输出数据量为0";
      		}
      		alarmData.setAlarmContent(content);
      		alarmData.setAlarmLevel("1");
      		alarmData.setAlarmTime(dateStr);
      		alarmData.setProcessState("1");
      		alarmDataService.insertInfo(alarmData);
          }
          //更新最大时间
          //开始时间时间戳
          long startTime=Long.parseLong(startTimeStr);
          if(maxTime>startTime) {
        	  scheduleBean.setDatestr(String.valueOf(maxTime));
        	  scheduleService.updateSchedule(scheduleBean);
          }
          LOG.info("end yclToMysqlTask...");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
	}
	private String getSqlCondition() {
		String sqlCondition="2001,2002,2003,2004,2005,2009,2012,2044,2045";
		return sqlCondition;
	}

}
