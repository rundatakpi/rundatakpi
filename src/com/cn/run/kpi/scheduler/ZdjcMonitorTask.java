package com.cn.run.kpi.scheduler;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;
import com.cn.run.kpi.datamonitor.compress.entity.BacklogEntity;
import com.cn.run.kpi.datamonitor.compress.service.CompressService;
import com.cn.run.kpi.datamonitor.service.service.ServiceMonitorService;
import com.cn.run.kpi.exampledata.service.ExampleZipService;
import com.cn.run.kpi.scheduler.service.ScheduleService;
import com.cn.run.kpi.utils.RandomValue;

/**
 * 主动监测调度任务
 * @author lbn
 */
@Component("zdjcMonitorTask")
public class ZdjcMonitorTask {
	private static final Logger LOG = Logger.getLogger(ZdjcMonitorTask.class);
	@Autowired
	private ExampleZipService exampleZipService;
	
	/**
	 * 预警定时任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/5 * * * ? ")
	public void genExampleData() {
		String dataSets="WA_SOURCE_0005";
		Map<String, String> map = RandomValue.genData(1,dataSets);
		exampleZipService.saveExampleData(map);
	}

}
