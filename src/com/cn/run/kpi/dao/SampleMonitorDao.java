package com.cn.run.kpi.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.entity.SampleMonitor;

public interface SampleMonitorDao {

	public List<SampleMonitor> list(Map<String, Object> queryCondition) throws Exception;
}
