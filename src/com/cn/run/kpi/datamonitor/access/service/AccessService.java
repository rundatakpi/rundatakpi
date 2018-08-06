package com.cn.run.kpi.datamonitor.access.service;

import java.util.List;

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
	List<AccessInputEntity> getAccessInputData();
	
	/**
	 * 查询抛弃量
	 * @return
	 */
	List<AccessDiscardEntiy> getAccessDiscardData();
	
	/**
	 * 获取当前接入输入数据总量
	 * @return
	 */
	Long getTotalAccessInputNum();
	
	/**
	 * 获取当前接入输入数据平均流量
	 * @return
	 */
	Double getAverageAccessInputNum();
	
	/**
	 * 查询某天接入输入数据量
	 * @param day
	 * @return
	 */
	Long getAccessInputNumByDay(String day);
}
