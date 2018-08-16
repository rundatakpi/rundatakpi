package com.cn.run.kpi.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.sample.entity.SampleMonitor;
import com.cn.run.kpi.sample.service.SampleService;

/**
 * 主动监测调度任务
 * @author zjw
 */
@Component("sampleToMysqlTask")
public class SampleToMysqlTask {
	
	@Autowired
	private SampleService sampleService;
	
	/**
	 * 主动监测调度任务 定时任务每分钟执行一次
	 */
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void sampleToMysqlTask() {
//		SampleMonitor sampleMonitor=new SampleMonitor();
//		sampleMonitor.setDataSource("test");
//		sampleMonitor.setbProtocol("123");
//		sampleMonitor.setsProtocol("321");
//		sampleMonitor.setOriginalFieldState(1);
//		sampleMonitor.setPreprocessingFieldState(1);
//		sampleMonitor.setStructExtractFieldState(1);
//		sampleMonitor.setObjectExtractFieldState(1);
//		sampleService.insertInfo(sampleMonitor);
//		System.out.println("id:"+sampleMonitor.getId());
//		System.out.println("kaishi");
//		List<SampleMonitor> sampleMonitors=new ArrayList<SampleMonitor>();
//		for(int i=0 ;i<2;i++) {
//			SampleMonitor sampleMonitor=new SampleMonitor();
//			sampleMonitor.setDataSource("test");
//			sampleMonitor.setbProtocol("123");
//			sampleMonitor.setsProtocol("321");
//			sampleMonitor.setOriginalFieldState(2);
//			sampleMonitor.setPreprocessingFieldState(2);
//			sampleMonitor.setStructExtractFieldState(2);
//			sampleMonitor.setObjectExtractFieldState(2);
//			sampleMonitors.add(sampleMonitor);
//		}
//		sampleService.insertInfoList(sampleMonitors);
//		System.out.println("kaishi");
	}

}
