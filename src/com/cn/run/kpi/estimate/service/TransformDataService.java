package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.TransformData;


/**
 * 格转接入数据Service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface TransformDataService {

	/**
	 * 查询格转接入数据
	 * @param transformData
	 * @return List<TransformData>
	 */
	public List<TransformData> getList(TransformData transformData);

	/**
	 * 查询所有格转接入数据个数
	 * @param transformData
	 * @return Integer
	 */
	public Integer getTotal(TransformData transformData);;
}
