package com.cn.run.kpi.datamonitor.store.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.store.entity.NineResourceEntity;
import com.cn.run.kpi.datamonitor.store.entity.ObjectEntity;
import com.cn.run.kpi.datamonitor.store.entity.ObjectLibEntity;
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
	
	/**
	 * 查询九大资源数据量
	 * @param queryCondition
	 * @return
	 */
	List<NineResourceEntity> getNineResourceData(Map<String, Object> queryCondition);
	
	/**
	 * 查询对象库数据量
	 * @param queryCondition
	 * @return
	 */
	List<ObjectLibEntity> getObjectData(Map<String, Object> queryCondition);
}
