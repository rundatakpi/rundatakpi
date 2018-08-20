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
import com.cn.run.kpi.scheduler.entity.JobMonitorBean;
import com.cn.run.kpi.scheduler.entity.LogCount;
import com.cn.run.kpi.scheduler.entity.ObjectCount;
import com.cn.run.kpi.scheduler.entity.OfflineJob;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.entity.StoreMonitorBean;
import com.cn.run.kpi.scheduler.service.ScheduleService;
import com.cn.run.kpi.scheduler.utils.JDBCUtil;

/**
 * NOSQL监测调度任务
 * @author zjw
 */
@Component("storageToMysqlTask")
public class StorageToMysqlTask {
	private static final Logger LOG = Logger.getLogger(StorageToMysqlTask.class);
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private AlarmDataService alarmDataService;
	
	/**
	 * 资源库表调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void storageDataToMysqlTask() {
		LOG.info("start storageDataToMysqlTask...");
		//获取资源库表监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
	    String sql = "select TIMEKEY,DATASOURCE, sum(TOTALCNT) TOTALCNT from T_LOG_COUNT"
	    		+ " group by TIMEKEY,DATASOURCE having INPUT_TIME>to_date('"+startTimeStr+"','yyyy-MM-dd')";
        try {
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            Long maxNum=0l;
            while(res.next()){
            	Date timekey=res.getDate("TIMEKEY");
            	String timekeyStr=sdf.format(timekey);
            	String dataSource=res.getString("DATASOURCE");
            	long datacnt=res.getLong("TOTALCNT");
            	//插入到数据库
            	StoreMonitorBean storeMonitorBean=new StoreMonitorBean();
            	storeMonitorBean.setCreatetime(timekeyStr);
            	storeMonitorBean.setDatatype(1);
            	storeMonitorBean.setSourcename(dataSource);
            	storeMonitorBean.setStore(datacnt);
            	scheduleService.insertStoreData(storeMonitorBean);
            	//获取最大时间
            	long dateTime=timekey.getTime();
            	if(dateTime>maxTime) {
            		maxTime=dateTime;
            	}
            	maxNum+=datacnt;
            	scheduleService.insertStoreData(storeMonitorBean);
            }
            //告警
            if(maxNum==0) {
            	AlarmData alarmData=new AlarmData();
        		String dateStr=sdf.format(new Date(maxTime));
        		String content=dateStr+" 资源库中数据量为0";
        		alarmData.setAlarmContent(content);
        		alarmData.setAlarmLevel("2");
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
          LOG.info("end storageDataToMysqlTask...");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
	}
	/**
	 * 对象库表调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void objectDataToMysqlTask() {
		LOG.info("start objectDataToMysqlTask...");
		//获取对象库表监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(3);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
        String sql = "select TIMEKEY,OBJECTTYPE, sum(TOTALCNT) TOTALCNT from T_OBJECT_COUNT"
	    		+ " group by TIMEKEY,OBJECTTYPE having INPUT_TIME>to_date('"+startTimeStr+"','yyyy-MM-dd')";
        try {
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            Long maxNum=0l;
            while(res.next()){
            	Date timekey=res.getDate("TIMEKEY");
            	String timekeyStr=sdf.format(timekey);
            	String dataSource=res.getString("OBJECTTYPE");
            	long datacnt=res.getLong("TOTALCNT");
            	//插入到数据库
            	StoreMonitorBean storeMonitorBean=new StoreMonitorBean();
            	storeMonitorBean.setCreatetime(timekeyStr);
            	storeMonitorBean.setDatatype(2);
            	storeMonitorBean.setSourcename(dataSource);
            	storeMonitorBean.setStore(datacnt);
            	scheduleService.insertStoreData(storeMonitorBean);
            	//获取最大时间
            	long dateTime=timekey.getTime();
            	if(dateTime>maxTime) {
            		maxTime=dateTime;
            	}
            	maxNum+=datacnt;
            }
            //告警
            if(maxNum==0) {
            	AlarmData alarmData=new AlarmData();
        		String dateStr=sdf.format(new Date(maxTime));
        		String content=dateStr+" 对象库中数据量为0";
        		alarmData.setAlarmContent(content);
        		alarmData.setAlarmLevel("2");
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
          LOG.info("end objectDataToMysqlTask...");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
	}
	
	/**
	 * 离线任务表调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void outlineDataToMysqlTask() {
		LOG.info("start outlineDataToMysqlTask...");
		//获取对象库表监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(4);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
	    String sql = "select * from T_OFFLINE_JOB where TIMEKEY>to_date('"+startTimeStr+"','yyyy-MM-dd')";
        try {
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
            	JobMonitorBean jobMonitorBean=new JobMonitorBean();
            	String timekey=res.getString("TIMEKEY");
            	jobMonitorBean.setTimekey(timekey);
            	int status=res.getInt("JOB_STATUS");
            	jobMonitorBean.setJob_status(status);
            	String jobName=res.getString("JOB_NAME");
            	jobMonitorBean.setJob_name(jobName);
            	jobMonitorBean.setStart_time(res.getString("START_TIME"));
            	jobMonitorBean.setEnd_time(res.getString("END_TIME"));
            	jobMonitorBean.setInput_time(res.getString("INPUT_TIME"));
            	scheduleService.insertJobData(jobMonitorBean);
            	//获取最大时间
            	long dateTime=sdf.parse(timekey).getTime();
            	if(dateTime>maxTime) {
            		maxTime=dateTime;
            	}
                //告警(失败的任务)
                if(status==0) {
                	AlarmData alarmData=new AlarmData();
            		String dateStr=sdf.format(new Date(dateTime));
            		String content=dateStr+" "+jobName+" 执行失败!";
            		alarmData.setAlarmContent(content);
            		alarmData.setAlarmLevel("1");
            		alarmData.setAlarmTime(dateStr);
            		alarmData.setProcessState("1");
            		alarmDataService.insertInfo(alarmData);
                }
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
          LOG.info("end outlineDataToMysqlTask...");
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
	}
}
