package com.cn.run.kpi.datamonitor.service.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ServiceMonitorDao serviceMonitorDao;

	@Override
	public List<AppMiddleWareEntity> getAppInvokeMiddlewareData() throws Exception {
		return serviceMonitorDao.getAppInvokeMiddlewareData();
	}

	@Override
	public List<AppInvokeProtocolEntity> getAppInvokePrototolData() throws Exception {
		return serviceMonitorDao.getAppInvokePrototolData();
	}

	@Override
	public List<ServiceInvokeException> list(Map<String, Object> queryCondition) throws Exception {
		return serviceMonitorDao.list(queryCondition);
	}
	
}
