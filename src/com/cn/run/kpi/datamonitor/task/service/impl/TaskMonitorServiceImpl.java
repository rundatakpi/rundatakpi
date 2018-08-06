package com.cn.run.kpi.datamonitor.task.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.task.dao.TaskMonitorDao;
import com.cn.run.kpi.datamonitor.task.entity.CompletedTask;
import com.cn.run.kpi.datamonitor.task.entity.RunningTask;
import com.cn.run.kpi.datamonitor.task.entity.Task;
import com.cn.run.kpi.datamonitor.task.service.TaskMonitorService;

@Service
public class TaskMonitorServiceImpl implements TaskMonitorService {
	
	@Autowired
	private TaskMonitorDao taskMonitorDao;

	@Override
	public List<RunningTask> getRunningTaskData(String date) {
		return taskMonitorDao.getRunningTaskData(date);
	}

	@Override
	public List<CompletedTask> getCompletedTaskData(String date) {
		return taskMonitorDao.getCompletedTaskData(date);
	}

	@Override
	public List<Task> list(Map<String, Object> queryCondition) {
		return taskMonitorDao.list(queryCondition);
	}

}
