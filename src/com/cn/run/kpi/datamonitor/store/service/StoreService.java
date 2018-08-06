package com.cn.run.kpi.datamonitor.store.service;

import java.util.List;

import com.cn.run.kpi.datamonitor.store.entity.ObjectEntity;
import com.cn.run.kpi.datamonitor.store.entity.StoreEntity;

/**
 * 存储量监测服务类
 * @author zg
 *
 */
public interface StoreService {

	/**
	 * 查询对象化数据
	 * @return
	 */
	List<ObjectEntity> getObjectData();
	
	/**
	 * 获取近7天数据存储大小、对象化数据存储大小
	 * @return
	 */
	List<StoreEntity> getStoreData();
}
