package com.cn.run.kpi.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.entity.SampleMonitor;

public interface SampleMonitorService {

	public List<SampleMonitor> list(Map<String, Object> queryCondition) throws Exception;
}
