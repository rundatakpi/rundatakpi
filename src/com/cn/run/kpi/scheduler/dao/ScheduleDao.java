package com.cn.run.kpi.scheduler.dao;

import com.cn.run.kpi.scheduler.entity.ScheduleBean;

public interface ScheduleDao {

	public ScheduleBean getScheduleByType(Integer type);
	
	public void updateSchedule(ScheduleBean scheduleBean);

}
