package com.cn.run.kpi.alarm.service;

import java.util.List;

import com.cn.run.kpi.alarm.entity.AlarmData;


/**
 * 告警模块Service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface AlarmDataService {

	/**
	 * 获取条件下的告警信息
	 * @param alarmData
	 * @return
	 */
	List<AlarmData> getList(AlarmData alarmData);

	/**
	 * 获取所有的告警条数
	 * @return
	 */
	Integer getTotal();

}
