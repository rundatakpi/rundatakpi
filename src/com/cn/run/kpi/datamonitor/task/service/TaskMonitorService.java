package com.cn.run.kpi.datamonitor.task.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.task.entity.CompletedTask;
import com.cn.run.kpi.datamonitor.task.entity.FailedTask;
import com.cn.run.kpi.datamonitor.task.entity.RunningTask;
import com.cn.run.kpi.datamonitor.task.entity.Task;

/**
 * 任务监测
 * @author Administrator
 *
 */
public interface TaskMonitorService {

	/**
	 * 获取7天实时运行任务量
	 * @param date
	 * @return
	 */
	List<RunningTask> getRunningTaskData(String date) throws Exception;
	
	/**
	 * 获取近七天实时已完成任务量数据
	 * @param date
	 * @return
	 */
	List<CompletedTask> getCompletedTaskData(String date) throws Exception;
	
	/**
	 * 获取任务列表
	 * @param queryCondition
	 * @return
	 */
	List<Task> list(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取失败任务列表
	 * @return
	 * @throws Exception
	 */
	public List<FailedTask> getFailedTask(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取运行任务列表
	 * @return
	 * @throws Exception
	 */
	public List<Task> getRunningTask(Map<String, Object> queryCondition) throws Exception;
}
