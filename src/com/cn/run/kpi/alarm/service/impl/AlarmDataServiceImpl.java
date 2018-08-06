package com.cn.run.kpi.alarm.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

	@Override
	public List<AlarmData> getList(AlarmData alarmData) {
		return null;
	}

	@Override
	public Integer getTotal() {
		return null;
	}



}
