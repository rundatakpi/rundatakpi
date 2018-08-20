package com.cn.run.kpi.scheduler.service;

import com.cn.run.kpi.scheduler.entity.AppQueryRecord;
import com.cn.run.kpi.scheduler.entity.JobMonitorBean;
import com.cn.run.kpi.scheduler.entity.RestoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.entity.StoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.YCLDataBean;

public interface ScheduleService {
	/**
	 * 获取某模块的调度任务
	 * @param type
	 * @return
	 */
	public ScheduleBean getScheduleByType(Integer type);
	/**
	 * 更新最新时间
	 * @param scheduleBean
	 */
	public void updateSchedule(ScheduleBean scheduleBean);
	/**
	 * 插入预处理监测数据
	 * @param yclData
	 */
	public void insertYCLData(YCLDataBean yclData);
	/**
	 * 插入协议还原数据
	 * @param restoreMonitorBean
	 */
	public void insertRestore(RestoreMonitorBean restoreMonitorBean);
	/**
	 * 插入服务监测数据
	 * @param appQueryRecord
	 */
	public void insertAppQueryRecord(AppQueryRecord appQueryRecord);
	/**
	 * 插入存储监测数据
	 */
	public void insertStoreData(StoreMonitorBean storeMonitorBean);
	/**
	 * 插入离线任务数据
	 */
	public void insertJobData(JobMonitorBean jobMonitorBean);
}
