package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.YCLInfo;
import com.cn.run.kpi.estimate.entity.YCLExample;


/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface YCLDao {

	/**
	 * @param transformData
	 * @return
	 */
	List<YCLInfo> getList(YCLInfo yclData);

	/**
	 * @param transformData
	 * @return
	 */
	Integer getTotal(YCLInfo yclData);

	/**
	 * 
	 * @param tranformData
	 * @param colName
	 * @return
	 */
	List<YCLInfo> selectDetail(YCLInfo yclData);

	/**
	 * 
	 * @param yclExampleData
	 * @return
	 */
	List<YCLExample> getYCLExample(YCLExample yclExampleData);

	

}
