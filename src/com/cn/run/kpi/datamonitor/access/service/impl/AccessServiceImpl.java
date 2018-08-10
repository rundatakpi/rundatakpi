package com.cn.run.kpi.datamonitor.access.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.access.dao.AccessDao;
import com.cn.run.kpi.datamonitor.access.entity.AccessDiscardEntiy;
import com.cn.run.kpi.datamonitor.access.entity.AccessInputEntity;
import com.cn.run.kpi.datamonitor.access.service.AccessService;
import com.cn.run.kpi.utils.DateUtil;

/**
 * 接入监测服务实现类
 * @author zg
 *
 */
@Service
public class AccessServiceImpl implements AccessService {
	
	@Autowired
	private AccessDao accessDao;

	@Override
	public List<AccessInputEntity> getAccessInputData(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getAccessInputData(queryCondition);
	}

	@Override
	public List<AccessDiscardEntiy> getAccessDiscardData(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getAccessDiscardData(queryCondition);
	}

	@Override
	public Long getTotalAccessInputNum(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getTotalAccessInputNum(queryCondition);
	}

	@Override
	public Double getAverageAccessInputNum(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getAverageAccessInputNum(queryCondition);
	}

	@Override
	public Long getAccessInputNumByDay(Map<String, Object> queryCondition) throws Exception {
		queryCondition.put("createDate", DateUtil.getDateBefore(new Date(), 1));
		return accessDao.getAccessInputNumByDay(queryCondition);
	}
}
