package com.cn.run.kpi.scheduler;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;
import com.cn.run.kpi.datamonitor.compress.entity.BacklogEntity;
import com.cn.run.kpi.datamonitor.compress.service.CompressService;
import com.cn.run.kpi.datamonitor.service.service.ServiceMonitorService;
import com.cn.run.kpi.scheduler.entity.AppQueryRecord;
import com.cn.run.kpi.scheduler.entity.JobMonitorBean;
import com.cn.run.kpi.scheduler.entity.ObjDataSetBean;
import com.cn.run.kpi.scheduler.entity.RestoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.StoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.YCLDataBean;
import com.cn.run.kpi.scheduler.service.ScheduleService;

/**
 * 预警中心调度任务
 * @author zjw
 */
@Component("alarmToMysqlTask")
public class AlarmToMysqlTask {
	private static final Logger LOG = Logger.getLogger(AlarmToMysqlTask.class);
	@Autowired
	private AlarmDataService alarmDataService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private CompressService compressService;
	
	/**
	 * 预警定时任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void alarmToMysqlTask() {
		System.out.println("test");
		//插入告警信息
//		AlarmData alarmData=new AlarmData();
//		alarmData.setAlarmContent("测试插入");
//		alarmData.setAlarmLevel("1");
//		alarmData.setAlarmTime("2018-08-13 14:06:00");
//		alarmData.setProcessState("1");
//		alarmDataService.insertInfo(alarmData);
//		System.out.println("id:"+alarmData.getId());
		
//		BacklogEntity BacklogEntity=new BacklogEntity();
//    	BacklogEntity.setCreateDate("2018-08-15");
//    	BacklogEntity.setKafkaBacklogNum((long)123);
//    	//插入到数据库中
//    	compressService.insertBackLogData(BacklogEntity);
		
//		AppQueryRecord appQueryRecord=new AppQueryRecord();
//    	appQueryRecord.setCapturetime("2018-05-08 12:00:00");
//    	appQueryRecord.setSqlstr("qwe");
//    	appQueryRecord.setSystem_id("111");
//    	appQueryRecord.setStatus("0");
//    	appQueryRecord.setError_desc("asd");
//    	//插入到数据库中
//    	serviceMonitorService.insertAppQueryRecord(appQueryRecord);
		List<ObjDataSetBean> objList=scheduleService.getObjDataSetList();
		
		for(ObjDataSetBean objDataSetBean:objList) {
			System.out.println("code:"+objDataSetBean.getCode()+"  name:"+objDataSetBean.getName());
		}
    	
    	System.out.println("end...");
	}

}
