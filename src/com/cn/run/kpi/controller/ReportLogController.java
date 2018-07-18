package com.cn.run.kpi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.commons.content.Constants;
import com.cn.run.kpi.entity.ReportLog;

import net.sf.json.JSONObject;

/**
 * @author run
 * 告警结构Controller
 */
@Component
@RequestMapping("/reportLog")
public class ReportLogController {

	public static final Logger LOG = Logger.getLogger(ReportLogController.class);
	
	/**
	 * 获取告警结果列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public JSONObject listWarnResult(HttpServletRequest request, HttpServletResponse reponse) {
		HashMap<String, Object> queryCondition = getQueryCondition(request);
		List<ReportLog> list = new ArrayList<ReportLog>();
		int total = 0;
		try {
			LOG.warn("listWarnResult");
			list = testListReportLog(queryCondition);
			total = list.size();
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject warnResult = new JSONObject();
		warnResult.put("data", list);
		if (list != null) {
			warnResult.put("recordsTotal", total);
			warnResult.put("recordsFiltered", total);
		}
		return warnResult;
	}
	
	private List<ReportLog> testListReportLog(HashMap<String,Object> queryCondition) {
		List<ReportLog> list = new ArrayList<ReportLog>();
		
		for (int i= 0; i < 15; i++) {
			ReportLog reportLog = new ReportLog();
			reportLog.setId((long)i);
			reportLog.setMessageContent("" + i);
			reportLog.setMessageType("" + i);
			reportLog.setNotifyObject("test" + i);
			reportLog.setNotifyObjectRole("testrole" + i);
			reportLog.setReceiveNum("" + i);
			reportLog.setSendStatus("" + i);
			reportLog.setSendTime(new Date().toString());
			list.add(reportLog);
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
		queryCondition.put("start", start);
		queryCondition.put("length", size);
		return queryCondition;
	}
}
