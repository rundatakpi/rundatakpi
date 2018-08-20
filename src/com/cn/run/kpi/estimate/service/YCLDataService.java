package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.TransInfo;
import com.cn.run.kpi.estimate.entity.YCLInfo;
import com.cn.run.kpi.estimate.entity.YCLExample;


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
	List<YCLInfo> getList(YCLInfo yclData);

	/**
	 * 获取所有的预处理数据条数
	 * @param yclData
	 * @return Integer
	 */
	Integer getTotal(YCLInfo yclData);

	/**
	 * 查询某属性近一周的值
	 * @param tranformData
	 * @return
	 */
	List<YCLInfo> selectDetail(YCLInfo yclData);

	/**
	 * 获取预处理样例包详情
	 * @param id
	 * @return
	 */
	List<YCLExample> getExampleList(YCLExample yclExampleData);


	
}
