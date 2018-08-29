package com.cn.run.kpi.datamonitor.service.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.commons.content.Constants;
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
		
		Map<String, String> map = Constants.PROTOCOLMAP;
		Map<String, Object> queryCondition = new HashMap<>();
		queryCondition.put("day", Constants.DAY_WEEK);
		JSONObject object = new JSONObject();
		
		getAppInvokeMiddleWareData(queryCondition, object);
		
		getAppInvokeProtocolData(queryCondition, object);
		
		return object.toString();
	}

	private void getAppInvokeMiddleWareData(Map<String, Object> queryCondition, JSONObject object) {
		List<String> createDate = new ArrayList<String>();
		int day = (int) queryCondition.get("day");
		for (int i = day; i >= 0; i--) {
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
		
		Map<String, Integer> protocolData = new TreeMap<String, Integer>();
		List<String> appInvokeProtocol;
		try {
			appInvokeProtocol = serviceMonitorService.getAppInvokePrototolData(queryCondition);
			if (appInvokeProtocol != null && !appInvokeProtocol.isEmpty()) {
				String pattern = "WA_\\w*";
				Pattern p = Pattern.compile(pattern);
				
				JSONObject invokeProtocolJson = new JSONObject();
				for (String appInvokeProtocolEntity : appInvokeProtocol) {
					/*protocol.add(appInvokeProtocolEntity.getProtocol());
					invokeNum.add(appInvokeProtocolEntity.getInvokeNum());*/
					Matcher m = p.matcher(appInvokeProtocolEntity);
					while (m.find()) {
						String protocol = m.group(0);
						if (protocolData.containsKey(protocol)) {
							Integer invokeNum = protocolData.get(protocol) + 1;
							protocolData.put(protocol, invokeNum);
						} else {
							protocolData.put(protocol, 1);
						}
					}
				}
				Map<String, Integer> sortMap = sortMapByValue(protocolData);
				if (sortMap != null && !sortMap.isEmpty()) {
					Set<Entry<String, Integer>> entrySet = sortMap.entrySet();
					List<String> protocolList = new ArrayList<>();
					List<Integer> invokeNum = new ArrayList<>();
					for (Entry<String, Integer> entry : entrySet) {
						String protocolName = Constants.PROTOCOLMAP.get(entry.getKey());
						if (StringUtil.isNotEmpty(protocolName)) {
							protocolList.add(protocolName);
							invokeNum.add(entry.getValue());
						}
					}
					invokeProtocolJson.put("protocol", protocolList);
					invokeProtocolJson.put("invokeNum", invokeNum);
					object.put("invokeProtocolJson", invokeProtocolJson);
				}
			}
		} catch (Exception e) {
			LOG.error("get app invoke protocol data failed...", e);
		}
	}
	
	/**
     * 使用 Map按value进行排序
     * @param map
     * @return
     */
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
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
	
	@RequestMapping("/app")
	@ResponseBody
	public String getAppData(HttpServletRequest request) {
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		String day = request.getParameter("day");
		if (StringUtil.isNumeric(day)) {
			queryCondition.put("day", Integer.parseInt(day));
		} else {
			queryCondition.put("day", Constants.DAY_WEEK);
		}
		JSONObject object = new JSONObject();
		getAppInvokeMiddleWareData(queryCondition, object);
		return object.toString();
	}
	
	public static void main(String[] args) {
		String pattern = "RWA_\\w*";
		String test = "'RWA_OBJECT_Z002_9954' Wsodj RWA_OBJECT_Z002_9985 test";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(test);
		
		while (m.find()) {
			System.out.println(m.group(0));
//			System.out.println(m.group(1));
		}
		
	}
}

class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Entry<String, Integer> me1, Entry<String, Integer> me2) {

        return me2.getValue().compareTo(me1.getValue());
    }
}
