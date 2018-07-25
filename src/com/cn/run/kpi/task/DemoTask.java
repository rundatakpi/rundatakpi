package com.cn.run.kpi.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 使用定时器产生告警信息
 * @author zg 
 */
@Component("demoTask")
public class DemoTask {

	/**
	 * 重点区域统计定时任务 定时任务每五分钟执行一次
	 */
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void demo() {
		System.out.println("demo...");
	}

}
