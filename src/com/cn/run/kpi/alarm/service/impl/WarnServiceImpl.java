package com.cn.run.kpi.alarm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.alarm.dao.WarnDao;
import com.cn.run.kpi.alarm.service.WarnService;
import com.cn.run.kpi.index.entity.WarnMessage;

@Service("warnService")
public class WarnServiceImpl implements WarnService {

	@Autowired
	private WarnDao warnDao;
	
	@Override
	public List<WarnMessage> list(Map<String, Object> queryCondition) throws Exception {
		return warnDao.list(queryCondition);
	}

}
