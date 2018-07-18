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
import com.cn.run.kpi.entity.ResultReport;
import com.cn.run.kpi.utils.DateUtil;

import net.sf.json.JSONObject;

/**
 * @author run
 * 告警结构Controller
 */
@Component
@RequestMapping("/resultReport")
public class ResultReportController {

	public static final Logger LOG = Logger.getLogger(ResultReportController.class);
	
	/**
	 * 获取告警结果列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public JSONObject listWarnResult(HttpServletRequest request, HttpServletResponse reponse) {
		HashMap<String, Object> queryCondition = getQueryCondition(request);
		List<ResultReport> list = new ArrayList<ResultReport>();
		int total = 0;
		try {
			LOG.warn("listWarnResult");
			list = testListResultReport(queryCondition);
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

	private List<ResultReport> testListResultReport(HashMap<String,Object> queryCondition) {
		List<ResultReport> list = new ArrayList<ResultReport>();
		
		for (int i= 0; i < 15; i++) {
			ResultReport resultReport = new ResultReport();
			resultReport.setId((long)i);
			resultReport.setCity("广州" + i);
			resultReport.setWarnSource("硬件" + i);
			resultReport.setWarnType("" + i);
			resultReport.setWarnOption("cpu" + i);
			resultReport.setConcreteWarnOption("cpu" + i);
			resultReport.setNodeIp("192.168.1." + i);
			resultReport.setWarnTime(DateUtil.getDateFrom("yyyy-MM-dd HH:mm:ss", new Date().getTime()));
			resultReport.setWarnGrade("" + i);
			resultReport.setReportStatus("" + i);
			resultReport.setOperation("发送" + i);
			resultReport.setPersonInCharge("Lucy" + i);
			resultReport.setNotifyObject("Lily" + i);
			resultReport.setNotifyObjectRole("admin" + i);
			resultReport.setContract("1502675685" + i);
			list.add(resultReport);
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
