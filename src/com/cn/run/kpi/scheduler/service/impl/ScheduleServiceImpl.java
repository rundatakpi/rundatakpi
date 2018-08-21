package com.cn.run.kpi.scheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.scheduler.dao.ScheduleDao;
import com.cn.run.kpi.scheduler.entity.AppQueryRecord;
import com.cn.run.kpi.scheduler.entity.JobMonitorBean;
import com.cn.run.kpi.scheduler.entity.ObjDataSetBean;
import com.cn.run.kpi.scheduler.entity.RestoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.entity.StoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.YCLDataBean;
import com.cn.run.kpi.scheduler.service.ScheduleService;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleDao scheduleDao;

	@Override
	public ScheduleBean getScheduleByType(Integer type) {
		return scheduleDao.getScheduleByType(type);
	}

	@Override
	public void updateSchedule(ScheduleBean scheduleBean) {
		scheduleDao.updateSchedule(scheduleBean);
	}

	@Override
	public void insertYCLData(YCLDataBean yclData) {
		scheduleDao.insertYCLData(yclData);
	}

	@Override
	public void insertRestore(RestoreMonitorBean restoreMonitorBean) {
		scheduleDao.insertRestore(restoreMonitorBean);
	}

	@Override
	public void insertAppQueryRecord(AppQueryRecord appQueryRecord) {
		scheduleDao.insertAppQueryRecord(appQueryRecord);
	}

	@Override
	public void insertStoreData(StoreMonitorBean storeMonitorBean) {
		scheduleDao.insertStoreData(storeMonitorBean);
	}

	@Override
	public void insertJobData(JobMonitorBean jobMonitorBean) {
		scheduleDao.insertJobData(jobMonitorBean);
	}

	@Override
	public List<ObjDataSetBean> getObjDataSetList() {
		return scheduleDao.getObjDataSetList();
	}

}
