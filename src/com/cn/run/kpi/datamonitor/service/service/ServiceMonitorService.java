package com.cn.run.kpi.datamonitor.service.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.service.entity.AppInvokeProtocolEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppMiddleWareEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppQueryRecord;
import com.cn.run.kpi.datamonitor.service.entity.ServiceInvokeException;

/**
 * 服务监测
 * @author zg
 *
 */
public interface ServiceMonitorService {

	/**
	 * 获取个应用调用中间件频次
	 * @return
	 */
	List<AppMiddleWareEntity> getAppInvokeMiddlewareData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取各应用调用协议频次
	 * @return
	 */
	List<AppInvokeProtocolEntity> getAppInvokePrototolData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取服务调用异常信息列表
	 * @param queryCondition
	 * @return
	 */
	List<ServiceInvokeException> list(Map<String, Object> queryCondition) throws Exception;

	/**
	 * 插入服务监测数据
	 * @param appQueryRecord
	 */
	public void insertAppQueryRecord(AppQueryRecord appQueryRecord);
	
	List<String> getApp(Map<String, Object> queryCondition) throws Exception;
	
}
