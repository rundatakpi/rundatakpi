package com.cn.run.kpi.datamonitor.preprocess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

/**
 * 预处理监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/preprocess")
public class PreProcessMonitorController {

	@RequestMapping("/init")
	@ResponseBody
	public String init() {
		JSONObject object = new JSONObject();
		return object.toString();
	}
}
