package com.cn.run.kpi.datamonitor.access.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.access.entity.AccessDiscardEntiy;
import com.cn.run.kpi.datamonitor.access.entity.AccessInputEntity;

/**
 * 接入监测服务
 * @author zg
 *
 */
public interface AccessService {

	/**
	 * 获取近七天接入数据输入量
	 * @return
	 */
	List<AccessInputEntity> getAccessInputData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 查询抛弃量
	 * @return
	 */
	List<AccessDiscardEntiy> getAccessDiscardData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取当前接入输入数据总量
	 * @return
	 */
	Long getTotalAccessInputNum(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取当前接入输入数据平均流量
	 * @return
	 */
	Double getAverageAccessInputNum(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 查询某天接入输入数据量
	 * @param day
	 * @return
	 */
	Long getAccessInputNumByDay(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取近一个月的分类列表
	 * @return
	 * @throws Exception
	 */
	void getClassfication() throws Exception;
	
	/**
	 * 获取近一个月的数据源列表
	 * @return
	 * @throws Exception
	 */
	void getDataSource() throws Exception;
	
	
	/**
	 * 获取近一个月的大协议列表
	 * @return
	 * @throws Exception
	 */
	void getBprotocol() throws Exception;
	
	/**
	 * 获取近一个月的小协议列表
	 * @return
	 * @throws Exception
	 */
	void getSprotocol() throws Exception;
	
	/**
	 * 获取近一个月的动作类型列表
	 * @return
	 * @throws Exception
	 */
	void getAction() throws Exception;
	
	/**
	 * 获取近一个月的采集地列表
	 * @return
	 * @throws Exception
	 */
	void getCollectPlace() throws Exception;
	
	void initJson();
	
}
