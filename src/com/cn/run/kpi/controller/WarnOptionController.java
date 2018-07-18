package com.cn.run.kpi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.commons.content.Constants;
import com.cn.run.kpi.entity.WarnResult;

import net.sf.json.JSONObject;

/**
 * @author run
 * 告警结构Controller
 */
@Component
@RequestMapping("/warnOption")
public class WarnOptionController {

	public static final Logger LOG = Logger.getLogger(WarnOptionController.class);
	
	/**
	 * 获取告警结果列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public JSONObject listWarnResult(HttpServletRequest request, HttpServletResponse reponse) {
		HashMap<String, Object> queryCondition = getQueryCondition(request);
		List<WarnResult> list = new ArrayList<WarnResult>();
		int total = 0;
		try {
			LOG.warn("listWarnResult");
			list = testListWarnResult(queryCondition);
			total = list.size();
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject warnResult = new JSONObject();
		warnResult.put("data", list);
		if (list != null) {
			warnResult.put("recordsTotal", total);
			warnResult.put("recordsFiltered", 15);
		}
		return warnResult;
	}
	
	private List<WarnResult> testListWarnResult(HashMap<String,Object> queryCondition) {
		List<WarnResult> list = new ArrayList<WarnResult>();
		
		for (int i= 0; i < 15; i++) {
			WarnResult warnResult = new WarnResult();
			warnResult.setId((long)i);
			warnResult.setCity("" + i);
			warnResult.setWarnSource("" + i);
			warnResult.setWarnType("");
			warnResult.setCluster("" + i);
			warnResult.setWarnOption("" + i);
			warnResult.setConcreteWarnOption("" + i);
			warnResult.setNodeName("" + i);
			warnResult.setNodeIp("" + i);
			warnResult.setExceptinResult("" + i);
			warnResult.setWarnTime("" + i);
			warnResult.setWarnGrade("" + i);
			warnResult.setStatus("" + i);
			warnResult.setOperation("" + i);
			warnResult.setPersonInCharge("" + i);
			warnResult.setResolveTime("" + i);
			list.add(warnResult);
		}
		return list;
	}

	/**
	 * 封装查询参数
	 * @param request
	 * @return
	 */
	private HashMap<String, Object> getQueryCondition(HttpServletRequest request) {
		HashMap<String, Object> queryCondition = new HashMap<String, Object>();
		String start = request.getParameter(Constants.PAGE_START);
		String size = request.getParameter(Constants.PAGE_SIZE);
		String warnGrade = request.getParameter("warnGrade");
		String warnSource = request.getParameter("warnSource");
		System.out.println("warnGarde = " + warnGrade);
		System.out.println("warnSource = " + warnSource);
		queryCondition.put("start", start);
		queryCondition.put("length", size);
		return queryCondition;
	}
}
