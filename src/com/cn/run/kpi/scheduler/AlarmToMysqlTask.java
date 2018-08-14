package com.cn.run.kpi.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;

/**
 * 预警中心调度任务
 * @author zjw
 */
@Component("alarmToMysqlTask")
public class AlarmToMysqlTask {
	
	@Autowired
	private AlarmDataService alarmDataService;
	
	/**
	 * 预警定时任务 定时任务每分钟执行一次
	 */
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void alarmToMysqlTask() {
		//插入告警信息
//		AlarmData alarmData=new AlarmData();
//		alarmData.setAlarmContent("测试插入");
//		alarmData.setAlarmLevel("1");
//		alarmData.setAlarmTime("2018-08-13 14:06:00");
//		alarmData.setProcessState("1");
//		alarmDataService.insertInfo(alarmData);
//		System.out.println("id:"+alarmData.getId());
	}

}
