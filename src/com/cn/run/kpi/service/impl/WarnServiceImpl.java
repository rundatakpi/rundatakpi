package com.cn.run.kpi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.dao.WarnDao;
import com.cn.run.kpi.entity.WarnMessage;
import com.cn.run.kpi.service.WarnService;

@Service("warnService")
public class WarnServiceImpl implements WarnService {

	@Autowired
	private WarnDao warnDao;
	
	@Override
	public List<WarnMessage> list(Map<String, Object> queryCondition) throws Exception {
		return warnDao.list(queryCondition);
	}

}
