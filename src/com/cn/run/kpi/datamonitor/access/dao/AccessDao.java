package com.cn.run.kpi.datamonitor.access.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.access.entity.AccessDiscardEntiy;
import com.cn.run.kpi.datamonitor.access.entity.AccessInputEntity;

/**
 * 接入监测Dao
 * @author zg
 *
 */
public interface AccessDao {

	/**
	 * 获取近七天接入数据输入量
	 * @param queryCondition
	 * @return
	 */
	List<AccessInputEntity> getAccessInputData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 查询抛弃量
	 * @param queryCondition
	 * @return
	 */
	List<AccessDiscardEntiy> getAccessDiscardData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取当前接入输入数据总量
	 * @param queryCondition
	 * @return
	 */
	Long getTotalAccessInputNum(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取当前接入输入数据平均流量
	 * @param queryCondition
	 * @return
	 */
	Double getAverageAccessInputNum(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 查询某天接入输入数据量
	 * @param queryCondition
	 * @return
	 */
	Long getAccessInputNumByDay(Map<String, Object> queryCondition) throws Exception;

}
