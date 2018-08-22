package com.cn.run.kpi.datamonitor.service.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.service.entity.AppInvokeProtocolEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppMiddleWareEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppQueryRecord;
import com.cn.run.kpi.datamonitor.service.entity.ServiceInvokeException;

/**
 * 服务监测Dao
 * @author zg
 *
 */
public interface ServiceMonitorDao {
	
	/**
	 * 获取个应用调用中间件频次
	 * @return
	 */
	public List<AppMiddleWareEntity> getAppInvokeMiddlewareData(Map<String, Object> queryCondition);

	/**
	 * 获取各应用调用协议频次
	 * @return
	 */
	public List<AppInvokeProtocolEntity> getAppInvokePrototolData(Map<String, Object> queryCondition);

	/**
	 * 获取服务调用异常信息列表
	 * @param queryCondition
	 * @return
	 */
	public List<ServiceInvokeException> list(Map<String, Object> queryCondition);

	/**
	 * 插入服务监测数据
	 * @param appQueryRecord
	 */
	public void insertAppQueryRecord(AppQueryRecord appQueryRecord);
	
	public List<String> getApp(Map<String, Object> queryCondition);
	
	/**
	 * 获取服务调用异常信息总数
	 * @param queryCondition
	 * @return
	 */
	Long getTotal(Map<String, Object> queryCondition);

}
