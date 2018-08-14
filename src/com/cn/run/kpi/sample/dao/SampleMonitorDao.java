package com.cn.run.kpi.sample.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.sample.entity.SampleMonitor;

public interface SampleMonitorDao {

	public List<SampleMonitor> list(Map<String, Object> queryCondition) throws Exception;
	
	public void insertInfoList(List<SampleMonitor> sampleMonitors);
	
	public void insertInfo(SampleMonitor sampleMonitors);

}
