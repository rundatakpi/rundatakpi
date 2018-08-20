package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.TransInfo;

/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface TransDao {

	/**
	 * @param transformData
	 * @return
	 */
	List<TransInfo> getList(TransInfo transformData);

	/**
	 * @param transformData
	 * @return
	 */
	Integer getTotal(TransInfo transformData);

	/**
	 * 
	 * @param tranformData
	 * @param colName
	 * @return
	 */
	List<TransInfo> selectDetail(TransInfo tranformData);

}
