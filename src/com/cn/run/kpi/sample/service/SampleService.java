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
	/**
	 * 批量插入样例包数据
	 * @param sampleMonitors
	 */
	public void insertInfoList(List<SampleMonitor> sampleMonitors);
	/**
	 * 插入一条样例包数据
	 * @param sampleMonitor
	 */
	public void insertInfo(SampleMonitor sampleMonitor);
}
