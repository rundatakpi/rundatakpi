package com.cn.run.kpi.scheduler.dao;

import java.util.List;

import com.cn.run.kpi.scheduler.entity.AppQueryRecord;
import com.cn.run.kpi.scheduler.entity.JobMonitorBean;
import com.cn.run.kpi.scheduler.entity.ObjDataSetBean;
import com.cn.run.kpi.scheduler.entity.RestoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.entity.StoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.YCLDataBean;

public interface ScheduleDao {

	public ScheduleBean getScheduleByType(Integer type);
	
	public void updateSchedule(ScheduleBean scheduleBean);
	
	public void insertYCLData(YCLDataBean yclData);
	
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
	/**
	 * 获取对象化数据集
	 * @return
	 */
	public List<ObjDataSetBean> getObjDataSetList();
}
