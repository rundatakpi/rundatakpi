package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.StoreLogData;
import com.cn.run.kpi.estimate.entity.TransInfo;


/**
 * 入库日志数据Service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface StoreLogService {

	/**
	 * @param storeLogData
	 * @param length
	 * @return
	 */
	public List<StoreLogData> getList(StoreLogData storeLogData);

	/**
	 * @param storeLogData
	 * @return
	 */
	public Integer getTotal(StoreLogData storeLogData);

	/**
	 * 
	 * @param tranformData
	 * @return
	 */
	public List<StoreLogData> selectDetail(StoreLogData storeLogData);

	/**
	 * 
	 * @param storeLogData
	 * @return
	 */
	public List<StoreLogData> getTableInfo(StoreLogData storeLogData);

	/**
	 * 
	 * 
	 * @param storeLogData
	 * @return
	 */
	public List<StoreLogData> getFeildDetail(StoreLogData storeLogData);

	
	
}
