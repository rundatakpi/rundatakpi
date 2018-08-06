package com.cn.run.kpi.estimate.service;

import java.util.List;
import com.cn.run.kpi.estimate.entity.YCLData;


/**
 * 预处理数据service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface YCLDataService {

	/**
	 * 获取条件下的预处理数据
	 * @param yclData
	 * @param length
	 * @return List<YCLData>
	 */
	List<YCLData> getList(YCLData yclData, Integer length);

	/**
	 * 获取所有的预处理数据条数
	 * @param yclData
	 * @return Integer
	 */
	Integer getTotal(YCLData yclData);

	
}
