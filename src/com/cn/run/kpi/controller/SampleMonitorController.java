package com.cn.run.kpi.controller;

import java.util.ArrayList;
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

import com.cn.run.kpi.entity.SampleMonitor;
import com.cn.run.kpi.service.SampleMonitorService;

import net.sf.json.JSONObject;


/**
 * 样例包检测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/sampleMonitor")
public class SampleMonitorController {
	
	private static final Logger LOG = Logger.getLogger(SampleMonitorController.class);
	
	@Autowired
	private SampleMonitorService sampleMonitorService;
	
	/**
	 * 获取样例包检测列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		queryCondition.put("dataSource", "固网");
		
		List<SampleMonitor> sampleMonitorList = new ArrayList<SampleMonitor>();
		try {
			sampleMonitorList = sampleMonitorService.list(queryCondition);
		} catch (Exception e) {
			LOG.error(">>>>>get sampleMonitorList failed...", e);
		}
		
		JSONObject object = new JSONObject();
		object.put("sampleMonitor", sampleMonitorList);
		return object.toString();
	}

}
