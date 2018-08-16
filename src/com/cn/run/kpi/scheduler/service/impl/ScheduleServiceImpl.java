package com.cn.run.kpi.scheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.run.kpi.scheduler.dao.ScheduleDao;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
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

}
