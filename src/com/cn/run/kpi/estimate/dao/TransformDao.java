package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.TransformData;

/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface TransformDao {

	/**
	 * @param transformData
	 * @return
	 */
	List<TransformData> getList(TransformData transformData);

	/**
	 * @param transformData
	 * @return
	 */
	Integer getTotal(TransformData transformData);

	/**
	 * 
	 * @param id
	 * @return
	 */
	TransformData selectById(Integer id);

	/**
	 * 
	 * @param tranformData
	 * @param colName
	 * @return
	 */
	List<TransformData> selectDetail(TransformData tranformData);

}
