package com.cn.run.kpi.scheduler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import com.cn.run.kpi.datamonitor.service.service.ServiceMonitorService;
import com.cn.run.kpi.scheduler.entity.AppQueryRecord;
import com.cn.run.kpi.scheduler.entity.ObjDataSetBean;
import com.cn.run.kpi.scheduler.entity.QueryRecord;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.service.ScheduleService;
import com.cn.run.kpi.scheduler.utils.JDBCUtil;

/**
 * 中间件查询表调度任务
 * @author zjw
 */
@Component("queryToMysqlTask")
public class QueryToMysqlTask {
	private static final Logger LOG = Logger.getLogger(QueryToMysqlTask.class);
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private ServiceMonitorService serviceMonitorService;
	@Autowired
	private AlarmDataService alarmDataService;
	
	/**
	 * 中间件查询调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void queryToMysqlTask(){
		LOG.info("start queryToMysqlTask...");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取预处理监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(6);
		//获取开始时间
		String startTimeStr=scheduleBean.getDatestr();
		//最大时间
		long maxTime=Long.parseLong(startTimeStr);
		//获取连接
		Connection conn = JDBCUtil.getConn();   
        PreparedStatement pre = null;
        ResultSet res = null;
	    String sql = "select * from T_QUERY_RECORD where TIMEKEY>?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,startTimeStr);
            res = pre.executeQuery();
            long errorNum=0l;
            List<ObjDataSetBean> objList=scheduleService.getObjDataSetList();
            while(res.next()){
            	long dateTime=res.getLong("TIMEKEY");
            	String protocolName=getProtocolName(sql, objList);
            	String input_timeStr=sdf.format(new Date(dateTime));
            	String sqlStr=res.getString("SQL");
            	String system_id=res.getString("SYSTEM_ID");
            	String status=res.getString("STATUS");
            	String error_desc=res.getString("ERROR_DESC");
            	AppQueryRecord appQueryRecord=new AppQueryRecord();
            	appQueryRecord.setCapturetime(input_timeStr);
            	appQueryRecord.setSqlstr(sqlStr);
            	appQueryRecord.setSystem_id(system_id);
            	appQueryRecord.setStatus(status);
            	appQueryRecord.setError_desc(error_desc);
            	if(!protocolName.equals("")) {
            		appQueryRecord.setProtocol(protocolName);
            	}
            	//插入到数据库中
            	scheduleService.insertAppQueryRecord(appQueryRecord);
            	if(dateTime>maxTime) {
            		maxTime=dateTime;
            	}
            	if(Integer.parseInt(status)==1) {
            		errorNum++;
            	}
            }
            //告警提示
            if(errorNum!=0) {
        		AlarmData alarmData=new AlarmData();
        		String dateStr=sdf.format(new Date(maxTime));
        		String content=dateStr+" 中间件服务异常数量达到"+errorNum;
        		String level="1";
        		if(errorNum<Integer.parseInt(scheduleBean.getSeriousalarm())&&errorNum>=Integer.parseInt(scheduleBean.getCommonlyalarm())) {
        			level="2";
        		}else if(errorNum<Integer.parseInt(scheduleBean.getCommonlyalarm())) {
        			level="3";
        		}
        		alarmData.setAlarmContent(content);
        		alarmData.setAlarmLevel(level);
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
          //开始时间时间戳
          long startTime=Long.parseLong(startTimeStr);
          if(maxTime>startTime) {
        	  scheduleBean.setDatestr(String.valueOf(maxTime));
        	  scheduleService.updateSchedule(scheduleBean);
          }
          LOG.info("end queryToMysqlTask...");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
	}
	/**
	 * 获取协议名称
	 * @param sql
	 * @param objList
	 * @return
	 */
	private String getProtocolName(String sql,List<ObjDataSetBean> objList) {
		String objName="";
		if(objList!=null&&objList.size()>0) {
			for(ObjDataSetBean objDateSet:objList) {
				String name=objDateSet.getName();
				String code=objDateSet.getCode();
				if(sql.contains(name)||sql.contains(code)) {
					objName=name;
					break;
				}
			}
		}
		return objName;
	}
}
