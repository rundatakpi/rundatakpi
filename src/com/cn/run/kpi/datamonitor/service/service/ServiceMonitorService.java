package com.cn.run.kpi.datamonitor.service.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.service.entity.AppInvokeProtocolEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppMiddleWareEntity;
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
	List<AppMiddleWareEntity> getAppInvokeMiddlewareData();
	
	/**
	 * 获取各应用调用协议频次
	 * @return
	 */
	List<AppInvokeProtocolEntity> getAppInvokePrototolData();
	
	/**
	 * 获取服务调用异常信息列表
	 * @param queryCondition
	 * @return
	 */
	List<ServiceInvokeException> list(Map<String, Object> queryCondition);
	
}
