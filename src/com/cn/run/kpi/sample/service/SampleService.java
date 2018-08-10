package com.cn.run.kpi.sample.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.sample.entity.SampleMonitor;

public interface SampleService {

	/**
	 * 获取样例数据列表
	 * @param queryCondition
	 * @return
	 * @throws Exception
	 */
	public List<SampleMonitor> list(Map<String, Object> queryCondition) throws Exception;
}
