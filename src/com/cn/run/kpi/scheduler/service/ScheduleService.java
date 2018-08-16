package com.cn.run.kpi.scheduler.service;

import com.cn.run.kpi.scheduler.entity.ScheduleBean;

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
}
