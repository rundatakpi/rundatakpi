package com.cn.run.kpi.datamonitor.task.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.task.entity.CompletedTask;
import com.cn.run.kpi.datamonitor.task.entity.RunningTask;
import com.cn.run.kpi.datamonitor.task.entity.Task;

/**
 * 任务监测Dao
 * @author zg
 *
 */
public interface TaskMonitorDao {

	/**
	 * 获取7天实时运行任务量
	 * @param date
	 * @return
	 */
	public List<RunningTask> getRunningTaskData(String date);

	/**
	 * 获取近七天实时已完成任务量数据
	 * @param date
	 * @return
	 */
	public List<CompletedTask> getCompletedTaskData(String date);

	/**
	 * 获取任务列表
	 * @param queryCondition
	 * @return
	 */
	public List<Task> list(Map<String, Object> queryCondition);
}
