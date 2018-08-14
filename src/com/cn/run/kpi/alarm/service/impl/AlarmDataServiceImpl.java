package com.cn.run.kpi.alarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.alarm.dao.AlarmDataDao;
import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;


/**
 * 告警信息实现类
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class AlarmDataServiceImpl implements AlarmDataService{
	
	@Autowired
	private AlarmDataDao alarmDataDao;

	/**
	 * 获取指定页数的告警信息
	 */
	@Override
	public List<AlarmData> getList(AlarmData alarmData) {
		return alarmDataDao.getList(alarmData);
	}

	/**
	 * 获取所有的告警条数
	 */
	@Override
	public Integer getTotal(AlarmData alarmData) {
		return alarmDataDao.getTotal(alarmData);
	}

	/**
	 * 删除某一条告警信息
	 */
	@Override
	public void del(Integer id) {
		alarmDataDao.del(id);	
	}

	/**
	 * 修改某条告警信息的处理状态
	 */
	@Override
	public void edit(AlarmData alarmData) {
		alarmDataDao.edit(alarmData);
		
	}

	/**
	 * 查询所有的告警信息
	 */
	@Override
	public List<AlarmData> getAllData(AlarmData alarmData) {
		return alarmDataDao.getAllData(alarmData);
	}

	/**
	 * 添加一条告警信息
	 */
	@Override
	public void insertInfo(AlarmData alarmData) {
		 alarmDataDao.insertInfo(alarmData);
	}



}
