package com.cn.run.kpi.datamonitor.service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.service.dao.ServiceMonitorDao;
import com.cn.run.kpi.datamonitor.service.entity.AppInvokeProtocolEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppMiddleWareEntity;
import com.cn.run.kpi.datamonitor.service.entity.ServiceInvokeException;
import com.cn.run.kpi.datamonitor.service.service.ServiceMonitorService;

/**
 * 服务监测服务实现类
 * @author zg
 *
 */
@Service
public class ServiceMonitorServiceImpl implements ServiceMonitorService {

	private ServiceMonitorDao serviceMonitorDao;
	
	@Override
	public List<AppMiddleWareEntity> getAppInvokeMiddlewareData() {
		return serviceMonitorDao.getAppInvokeMiddlewareData();
	}

	@Override
	public List<AppInvokeProtocolEntity> getAppInvokePrototolData() {
		return serviceMonitorDao.getAppInvokePrototolData();
	}

	@Override
	public List<ServiceInvokeException> list(Map<String, Object> queryCondition) {
		return serviceMonitorDao.list(queryCondition);
	}
}
