package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.ObjectExtractData;


/**
 * 对象化提取数据Service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface ObjectExtractDataService {

	/**
	 * 查询条件下对象化提取数据
	 * @param objectExtractData
	 * @return List<ObjectExtractData>
	 */
	List<ObjectExtractData> getList(ObjectExtractData objectExtractData);

	/**
	 * 查询所有对象化提取数据条数
	 * @param objectExtractData
	 * @return Integer
	 */
	Integer getTotal(ObjectExtractData objectExtractData);

}