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
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.entity.YCLOrgData;
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
	
	
	/**
	 * 预处理监测调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void yclToMysqlTask(){
		LOG.info("start yclToMysqlTask...");
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
	    String sql = "select * from YCLTABLE where TS>?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,startTimeStr);
            res = pre.executeQuery();
            //调用将结果集转换成实体对象方法
            List list=new ArrayList();
			try {
				list = JDBCUtil.Populate(res, YCLOrgData.class);
			} catch (InstantiationException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
            //循环遍历结果
            for(int i=0;i<list.size();i++){
            	YCLOrgData data = (YCLOrgData) list.get(i);
            	//获取最大时间
            	long time=Long.parseLong(data.getTS());
            	if(time>maxTime) {
            		maxTime=time;
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
	

}
