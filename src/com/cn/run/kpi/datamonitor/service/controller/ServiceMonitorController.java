package com.cn.run.kpi.datamonitor.service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.service.entity.AppInvokeProtocolEntity;
import com.cn.run.kpi.datamonitor.service.entity.AppMiddleWareEntity;
import com.cn.run.kpi.datamonitor.service.service.ServiceMonitorService;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.StringUtil;

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
	public String init() {
		JSONObject object = new JSONObject();
		try {
//			getAppInvokeMiddleWareData(object);
			getAppInvokeProtocolData(object);
		} catch (Exception e) {
			LOG.error(">>>>>init error", e);
		}
		return object.toString();
	}

	private void getAppInvokeProtocolData(JSONObject object) throws Exception {
		List<AppMiddleWareEntity> appInvokeProtocol = serviceMonitorService.getAppInvokeMiddlewareData();
		if (appInvokeProtocol != null && !appInvokeProtocol.isEmpty()) {
			JSONObject appInvokeProtocolJson = new JSONObject();
			List<String> app = new ArrayList<String>();
			List<String> appInvokeProtocolDate = new ArrayList<String>();
			Map<String, List<Long>> invokeMap = new HashMap<String, List<Long>>();
			for (AppMiddleWareEntity appInvokeProtocolEntity : appInvokeProtocol) {
				String key = appInvokeProtocolEntity.getCreateDate();
				Long invoke = StringUtil.isEmpty(appInvokeProtocolEntity.getInvokeNum()) ? 0L: appInvokeProtocolEntity.getInvokeNum();
				if (invokeMap.containsKey(key)) {
					invokeMap.get(key).add(invoke);
				} else {
					List<Long> list = new ArrayList<Long>();
					list.add(appInvokeProtocolEntity.getInvokeNum());
					app.add(appInvokeProtocolEntity.getApp());
					appInvokeProtocolDate.add(appInvokeProtocolEntity.getCreateDate());
					invokeMap.put(key, list);
				}
			}
			appInvokeProtocolJson.put("app", app);
			appInvokeProtocolJson.put("invokeNum", invokeMap);
			appInvokeProtocolJson.put("appInvokeProtocolDate", appInvokeProtocolDate);
			object.put("appInvokeProtocolJson", appInvokeProtocolJson);
		}
	}

	private void getAppInvokeMiddleWareData(JSONObject object) throws Exception {
		List<AppMiddleWareEntity> appInvokeMiddleWare = serviceMonitorService.getAppInvokeMiddlewareData();
		if (appInvokeMiddleWare != null && !appInvokeMiddleWare.isEmpty()) {
			JSONObject appInvokeMiddleWareJson = new JSONObject();
			List<String> app = new ArrayList<String>();
			List<Long> invokeNum = new ArrayList<Long>();
			List<String> appMiddleWareDate = new ArrayList<String>();
			for (AppMiddleWareEntity appMiddleWareEntity : appInvokeMiddleWare) {
				appMiddleWareDate.add(appMiddleWareEntity.getCreateDate());
				app.add(appMiddleWareEntity.getApp());
				invokeNum.add(StringUtil.isEmpty(appMiddleWareEntity.getInvokeNum()) ? 0L : appMiddleWareEntity.getInvokeNum());
			}
			appInvokeMiddleWareJson.put("app", app);
			appInvokeMiddleWareJson.put("invokeNum", invokeNum);
			appInvokeMiddleWareJson.put("appMiddleWareDate", appMiddleWareDate);
			object.put("appInvokeMiddleWareJson", appInvokeMiddleWareJson);
		}
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test () throws Exception {
		JSONObject object = new JSONObject();
		List<String> createDate = new ArrayList<String>();
		for (int i = 6; i >= 0; i--) {
			String da = DateUtil.getDateBefore(new Date(), i);
			createDate.add(da);
		}
		
		List<String> app = new ArrayList<String>();
		app.add("r");
		app.add("s");
		
		List<String> createDateApp = new ArrayList<String>();
		for (String d: createDate) {
			for (String ap : app) {
				createDateApp.add(d + ap);
			}
		}
		
		Map<String, List<Long>> map = new HashMap<String, List<Long>>();
		for (String date : createDate) {
			List<Long> invoke = new ArrayList<Long>();
			map.put(date, invoke);
		}
		
		List<AppMiddleWareEntity> appInvokeMiddleWare = serviceMonitorService.getAppInvokeMiddlewareData();
		Map<String, Long> appMiddleMap = new HashMap<String, Long>();
		for (AppMiddleWareEntity appMiddleWareEntity : appInvokeMiddleWare) {
			appMiddleMap.put(appMiddleWareEntity.getCreateDate() + appMiddleWareEntity.getApp(), appMiddleWareEntity.getInvokeNum());
		}
		
		for (String cda : createDateApp) {
			List<Long> list = map.get(cda.substring(0, 10));
			if (appMiddleMap.containsKey(cda)) {
				list.add(appMiddleMap.get(cda));
			} else {
				list.add(0L);
			}
			map.put(cda.substring(0, 10), list);
		}
		object.put("map", map);
		return object.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("2018-08-14r".substring(0, 10));
	}
}
