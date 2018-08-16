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

import com.cn.run.kpi.scheduler.entity.LogCount;
import com.cn.run.kpi.scheduler.entity.ObjectCount;
import com.cn.run.kpi.scheduler.entity.OfflineJob;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
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
	    String sql = "select * from T_LOG_COUNT where TIMEKEY>to_date('"+startTimeStr+"','yyyy-MM-dd')";
        try {
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            //调用将结果集转换成实体对象方法
            List list=new ArrayList();
			try {
				list = JDBCUtil.Populate(res, LogCount.class);
			} catch (InstantiationException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
            //循环遍历结果
            for(int i=0;i<list.size();i++){
            	LogCount data = (LogCount) list.get(i);
            	//获取最大时间
            	long dateTime=data.getTimekey().getTime();
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
	    String sql = "select * from T_OBJECT_COUNT where TIMEKEY>to_date('"+startTimeStr+"','yyyy-MM-dd')";
        try {
            pre = conn.prepareStatement(sql);
            res = pre.executeQuery();
            //调用将结果集转换成实体对象方法
            List list=new ArrayList();
			try {
				list = JDBCUtil.Populate(res, ObjectCount.class);
			} catch (InstantiationException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
            //循环遍历结果
            for(int i=0;i<list.size();i++){
            	ObjectCount data = (ObjectCount) list.get(i);
            	//获取最大时间
            	long dateTime=data.getTimekey().getTime();
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
            //调用将结果集转换成实体对象方法
            List list=new ArrayList();
			try {
				list = JDBCUtil.Populate(res, OfflineJob.class);
			} catch (InstantiationException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
            //循环遍历结果
            for(int i=0;i<list.size();i++){
            	OfflineJob data = (OfflineJob) list.get(i);
            	//获取最大时间
            	long dateTime=data.getTimekey().getTime();
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
          LOG.info("end outlineDataToMysqlTask...");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
	}
}
