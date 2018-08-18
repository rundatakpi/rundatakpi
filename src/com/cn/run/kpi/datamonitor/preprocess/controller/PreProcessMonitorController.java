package com.cn.run.kpi.datamonitor.preprocess.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.preprocess.service.PreProcessService;

import net.sf.json.JSONObject;

/**
 * 预处理监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/preprocess")
public class PreProcessMonitorController {
	
	public static final Logger LOG = Logger.getLogger(PreProcessMonitorController.class);
	
	@Autowired
	private PreProcessService preProcessService;

	@RequestMapping("/init")
	@ResponseBody
	public String init() {
		JSONObject object = new JSONObject();
		
		preProcessService.getPreProcessRealTimeData();
		return object.toString();
	}
}
