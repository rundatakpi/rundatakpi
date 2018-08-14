package com.cn.run.kpi.alarm.dao;

import java.util.List;

import com.cn.run.kpi.alarm.entity.AlarmData;

/**
 * 告警中心Dao层
 * @author chenyan
 * 2018年8月7日
 *
 */
public interface AlarmDataDao {

	/**
	 * @param alarmData
	 * @return
	 */
	List<AlarmData> getList(AlarmData alarmData);

	/**
	 * @return  Integer
	 */
	Integer getTotal(AlarmData alarmData);

	/**
	 * @param id
	 * @return
	 */
	void del(Integer id);

	/**
	 * @param alarmData
	 */
	void edit(AlarmData alarmData);

	/**
	 * @param alarmData
	 * @return
	 */
	List<AlarmData> getAllData(AlarmData alarmData);

	/**
	 * @param alarmData
	 * @return
	 */
	void insertInfo(AlarmData alarmData);

	
}
