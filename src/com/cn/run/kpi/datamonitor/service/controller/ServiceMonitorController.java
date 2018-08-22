package com.cn.run.kpi.datamonitor.service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.service.entity.AppInvokeProtocolEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppMiddleWareEntity;
import com.cn.run.kpi.datamonitor.service.entity.ServiceInvokeException;
import com.cn.run.kpi.datamonitor.service.service.ServiceMonitorService;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 服务监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/service")
public class ServiceMonitorController {
	
	private static final Logger LOG = Logger.getLogger(ServiceMonitorController.class);
	
	@Autowired
	private ServiceMonitorService serviceMonitorService;
	
	@RequestMapping("/get")
	@ResponseBody
	public String init(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> queryCondition = new HashMap<>();
		JSONObject object = new JSONObject();
		
		getAppInvokeMiddleWareData(queryCondition, object);
		
		getAppInvokeProtocolData(queryCondition, object);
		
		return object.toString();
	}

	private void getAppInvokeMiddleWareData(Map<String, Object> queryCondition, JSONObject object) {
		List<String> createDate = new ArrayList<String>();
		for (int i = 6; i >= 0; i--) {
			String da = DateUtil.getDateBefore(new Date(), i);
			createDate.add(da);
		}
		
		List<String> app = getApp(queryCondition);
		if (app == null || app.isEmpty()) {
			return;
		}
		List<String> createDateApp = new ArrayList<String>();
		for (String d: createDate) {
			for (String ap : app) {
				createDateApp.add(d + ap);
			}
		}
		
		Map<String, List<Long>> map = new HashMap<String, List<Long>>();
		for (String appName : app) {
			List<Long> invoke = new ArrayList<Long>();
			map.put(appName, invoke);
		}
		
		List<AppMiddleWareEntity> appInvokeMiddleWare;
		try {
			appInvokeMiddleWare = serviceMonitorService.getAppInvokeMiddlewareData(queryCondition);
			Map<String, Long> appMiddleMap = new HashMap<String, Long>();
			for (AppMiddleWareEntity appMiddleWareEntity : appInvokeMiddleWare) {
				appMiddleMap.put(appMiddleWareEntity.getCreateDate() + appMiddleWareEntity.getApp(), appMiddleWareEntity.getInvokeNum());
			}
			
			for (String appName : app) {
				List<Long> list = map.get(appName);
				for (String cd: createDate) {
					String key = cd + appName;
					if (appMiddleMap.containsKey(key)) {
						list.add(appMiddleMap.get(key));
					} else {
						list.add(0L);
					}
				}
			}
			
			JSONObject invokeMiddlewareJson = new JSONObject();
			invokeMiddlewareJson.put("createDate", createDate);
			invokeMiddlewareJson.put("app", app);
			invokeMiddlewareJson.put("data", map);
			object.put("invokeMiddlewareJson", invokeMiddlewareJson);
		} catch (Exception e) {
			LOG.error(">>>>>get app invoke middleWare data failed...", e);
		}
		
	}

	private void getAppInvokeProtocolData(Map<String, Object> queryCondition, JSONObject object) {
		List<AppInvokeProtocolEntity> appInvokeProtocol;
		try {
			appInvokeProtocol = serviceMonitorService.getAppInvokePrototolData(queryCondition);
			if (appInvokeProtocol != null && !appInvokeProtocol.isEmpty()) {
				JSONObject invokeProtocolJson = new JSONObject();
				List<String> protocol = new ArrayList<>();
				List<Long> invokeNum = new ArrayList<>();
				for (AppInvokeProtocolEntity appInvokeProtocolEntity : appInvokeProtocol) {
					protocol.add(appInvokeProtocolEntity.getProtocol());
					invokeNum.add(appInvokeProtocolEntity.getInvokeNum());
				}
				invokeProtocolJson.put("protocol", protocol);
				invokeProtocolJson.put("invokeNum", invokeNum);
				object.put("invokeProtocolJson", invokeProtocolJson);
			}
		} catch (Exception e) {
			LOG.error("get app invoke protocol data failed...", e);
		}
	}
	
	private List<String> getApp(Map<String, Object> queryCondition) {
		List<String> app = new ArrayList<>();
		try {
			app = serviceMonitorService.getApp(queryCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return app;
	}

	/**
	 * 获取服务异常信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/serverException")
	@ResponseBody
	public String getServerException(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		Map<String, Object> queryCondition = getQueryCondition(request);
		try {
			List<ServiceInvokeException> serviceInvokeException = serviceMonitorService.list(queryCondition);
			Long totalException = serviceMonitorService.getTotal(queryCondition);
			Long total = StringUtil.isEmpty(totalException) ? 0L : totalException;
			if (serviceInvokeException != null && !serviceInvokeException.isEmpty()) {
				object.put("total", total);
				object.put("data", JSONArray.fromObject(serviceInvokeException));
			}
		} catch (Exception e) {
			LOG.error(">>>>>get server exception failed", e);
		}
		
		return object.toString();
	}

	private Map<String, Object> getQueryCondition(HttpServletRequest request) {
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		String pageSizeStr = request.getParameter("pageSize");
		
		
		Integer pageSize = StringUtil.isNull(pageSizeStr) ? 0 : Integer.parseInt(pageSizeStr);
		
		String currentPageStr = request.getParameter("currentPage");
		Integer currentPage = StringUtil.isNull(currentPageStr) ? 0 : Integer.parseInt(currentPageStr);
		
		Integer start = (currentPage - 1) * pageSize;
//		Integer end = currentPage * pageSize;
		queryCondition.put("start", start);
		queryCondition.put("end", pageSize);
		return queryCondition;
	}
}
