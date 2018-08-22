package com.cn.run.kpi.datamonitor.task.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.task.dao.TaskMonitorDao;
import com.cn.run.kpi.datamonitor.task.entity.CompletedTask;
import com.cn.run.kpi.datamonitor.task.entity.FailedTask;
import com.cn.run.kpi.datamonitor.task.entity.RunningTask;
import com.cn.run.kpi.datamonitor.task.entity.Task;
import com.cn.run.kpi.datamonitor.task.service.TaskMonitorService;

@Service
public class TaskMonitorServiceImpl implements TaskMonitorService {
	
	@Autowired
	private TaskMonitorDao taskMonitorDao;

	@Override
	public List<RunningTask> getRunningTaskData(Map<String, Object> queryCondition) throws Exception {
		return taskMonitorDao.getRunningTaskData(queryCondition);
	}

	@Override
	public List<CompletedTask> getCompletedTaskData(Map<String, Object> queryCondition) throws Exception {
		return taskMonitorDao.getCompletedTaskData(queryCondition);
	}

	@Override
	public List<Task> list(Map<String, Object> queryCondition) throws Exception {
		return taskMonitorDao.list(queryCondition);
	}

	@Override
	public List<FailedTask> getFailedTask(Map<String, Object> queryCondition) throws Exception {
		return taskMonitorDao.getFailedTask(queryCondition);
	}

	@Override
	public List<Task> getRunningTask(Map<String, Object> queryCondition) throws Exception {
		return taskMonitorDao.getRunningTask(queryCondition);
	}

	@Override
	public Long getTotalTaskNum(Map<String, Object> queryCondition) throws Exception {
		return taskMonitorDao.getTotalTaskNum(queryCondition);
	}

}
