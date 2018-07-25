package com.cn.run.kpi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.dao.SampleMonitorDao;
import com.cn.run.kpi.entity.SampleMonitor;
import com.cn.run.kpi.service.SampleMonitorService;

@Service("sampleMonitorService")
public class SampleMonitorServiceImpl implements SampleMonitorService {

	@Autowired
	private SampleMonitorDao sampleMonitorDao;
	
	@Override
	public List<SampleMonitor> list(Map<String, Object> queryCondition) throws Exception {
		return sampleMonitorDao.list(queryCondition);
	}

}
