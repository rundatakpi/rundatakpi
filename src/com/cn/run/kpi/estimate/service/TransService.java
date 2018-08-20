package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.TransInfo;


/**
 * 格转接入数据Service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface TransService {

	/**
	 * 查询格转接入数据
	 * @param transformData
	 * @return List<TransformData>
	 */
	public List<TransInfo> getList(TransInfo transformData);

	/**
	 * 查询所有格转接入数据个数
	 * @param transformData
	 * @return Integer
	 */
	public Integer getTotal(TransInfo transformData);

	/**
	 * 根据格转接入数据和列名查询该列近一周的指标值
	 * @param tranformData
	 * @param colName
	 * @return
	 */
	public List<TransInfo> selectDetail(TransInfo tranformData);;
}