package com.cn.run.kpi.alarm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;


/**
 * 告警中心模块Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/alarmData")
public class AlarmDataController {

	@Autowired
	private AlarmDataService alarmDataService;
	
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,AlarmData alarmData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		List<AlarmData> alarmDatas = alarmDataService.getList(alarmData);
		Integer total = alarmDataService.getTotal();
		
		resultMap.put("recordsTotal", Integer.toString(total));
		resultMap.put("recordsFiltered", Integer.toString(alarmDatas.size()));
		resultMap.put("data", alarmDatas);
		
		return resultMap;
	}
}
