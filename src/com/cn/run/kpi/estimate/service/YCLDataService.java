package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.entity.YCLData;
import com.cn.run.kpi.estimate.entity.YCLExampleData;


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
	List<YCLData> getList(YCLData yclData);

	/**
	 * 获取所有的预处理数据条数
	 * @param yclData
	 * @return Integer
	 */
	Integer getTotal(YCLData yclData);

	/**
	 * 根据id查询预处理数据信息
	 * @param id
	 * @return
	 */
	YCLData selectById(Integer id);

	/**
	 * 查询某属性近一周的值
	 * @param tranformData
	 * @return
	 */
	List<YCLData> selectDetail(YCLData yclData);

	/**
	 * 获取预处理样例包详情
	 * @param id
	 * @return
	 */
	List<YCLExampleData> getExampleList(YCLExampleData yclExampleData);


	
}
