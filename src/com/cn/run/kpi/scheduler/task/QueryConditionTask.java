package com.cn.run.kpi.scheduler.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.datamonitor.access.service.AccessService;

/**
 * 从数据库获取各模块的查询条件并写入json文件
 * @author zg
 *
 */
@Component("queryConditionTask")
public class QueryConditionTask {

	private static final Logger LOG = Logger.getLogger(QueryConditionTask.class);
	
	@Autowired
	private AccessService accessService;
	
	@Autowired
//	private PreProcessService preProcessService;
	
	
	/**
	 * 获取接入监测的查询条件并写入json文件
	 */
	@Scheduled(cron = "0/50 * * * * ? ")
	public void getAccessQueryCondition() {
		if (LOG.isDebugEnabled()) {
			LOG.debug(">>>>>create query condition json file");
		}
		accessService.initJson();
	}

	/**
	 * 获取预处理监测的查询条件并写入json文件
	 */
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void getPreProcessQueryCondition() {
		
	}
}
