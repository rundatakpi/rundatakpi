package com.cn.run.kpi.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.sample.dao.SampleMonitorDao;
import com.cn.run.kpi.sample.entity.SampleMonitor;
import com.cn.run.kpi.sample.service.SampleService;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMonitorDao sampleMonitorDao;
	
	@Override
	public List<SampleMonitor> list(Map<String, Object> queryCondition) throws Exception {
		return sampleMonitorDao.list(queryCondition);
	}

}
