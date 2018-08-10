package com.cn.run.kpi.datamonitor.store.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.store.dao.StoreDao;
import com.cn.run.kpi.datamonitor.store.entity.NineResourceEntity;
import com.cn.run.kpi.datamonitor.store.entity.ObjectEntity;
import com.cn.run.kpi.datamonitor.store.entity.ObjectLibEntity;
import com.cn.run.kpi.datamonitor.store.entity.StoreEntity;
import com.cn.run.kpi.datamonitor.store.service.StoreService;

/**
 * 存储量监测服务实现类
 * @author zg
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDao storeDao;

	@Override
	public List<ObjectEntity> getObjectData() {
		return storeDao.getObjectData();
	}

	@Override
	public List<StoreEntity> getStoreData() {
		return storeDao.getStoreData();
	}

	@Override
	public List<NineResourceEntity> getNineResourceData(Map<String, Object> queryCondition) {
		return storeDao.getNineResourceData(queryCondition);
	}

	@Override
	public List<ObjectLibEntity> getObjectData(Map<String, Object> queryCondition) {
		return storeDao.getObjectData(queryCondition);
	}

}
