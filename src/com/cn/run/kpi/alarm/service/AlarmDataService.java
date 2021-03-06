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
	Integer getTotal(AlarmData alarmData);

	/**
	 * 删除某一条告警信息
	 * @param id
	 */
	void del(Integer id);

	/**
	 * 修改告警信息的处理状态
	 * @param alarmData
	 */
	void edit(AlarmData alarmData);

	/**
	 * 查询所有的告警信息
	 * @param alarmData
	 * @return
	 */
	List<AlarmData> getAllData(AlarmData alarmData);

	
	/**
	 * 添加一条告警信息
	 * @param alarmData
	 */
	void insertInfo(AlarmData alarmData);

}
