package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.YCLData;
import com.cn.run.kpi.estimate.entity.YCLExampleData;


/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface YCLDataDao {

	/**
	 * @param transformData
	 * @return
	 */
	List<YCLData> getList(YCLData yclData);

	/**
	 * @param transformData
	 * @return
	 */
	Integer getTotal(YCLData yclData);

	/**
	 * 
	 * @param id
	 * @return
	 */
	YCLData selectById(Integer id);

	/**
	 * 
	 * @param tranformData
	 * @param colName
	 * @return
	 */
	List<YCLData> selectDetail(YCLData yclData);

	/**
	 * 
	 * @param yclExampleData
	 * @return
	 */
	List<YCLExampleData> getYCLExample(YCLExampleData yclExampleData);

	

}
