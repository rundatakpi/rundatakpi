package com.cn.run.kpi.alarm.controller;

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

import com.cn.run.kpi.alarm.service.WarnService;
import com.cn.run.kpi.index.entity.WarnMessage;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/warn")
public class WarnController {
	
	private static final Logger LOG = Logger.getLogger(WarnController.class);
	
	@Autowired
	private WarnService warnService;

	@RequestMapping("/list")
	@ResponseBody
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		List<WarnMessage> warnMessageList = null;
		try {
			Map<String, Object> queryCondition = new HashMap<String, Object>();
			warnMessageList = warnService.list(queryCondition);
		} catch (Exception e) {
			LOG.error(">>>>>get warnmessage failed...", e);
		}
		JSONObject object = new JSONObject();
		object.put("warnMessage", warnMessageList);
		return object.toString();
	}
}
