package com.cn.run.kpi.datamonitor.access.controller;

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

import com.cn.run.kpi.commons.content.Constants;
import com.cn.run.kpi.datamonitor.access.entity.AccessDiscardEntiy;
import com.cn.run.kpi.datamonitor.access.entity.AccessInputEntity;
import com.cn.run.kpi.datamonitor.access.service.AccessService;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.NumberUtils;
import com.cn.run.kpi.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * 接入监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/access")
public class AccessMonitorController {
	
	public static final Logger LOG = Logger.getLogger(AccessMonitorController.class);
	
	@Autowired
	private AccessService accessService;
	
	@RequestMapping("/data")
	@ResponseBody
	public String getAccessData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> queryCondition = getQueryCondition(request);
		
		JSONObject object = new JSONObject();
		
		// 获取近X天接入数据输入量
		JSONObject accessInputJson = getAccessInputData(queryCondition);
		object.put(Constants.INPUT_DATA, accessInputJson);
		
		// 查询抛弃数据量
		JSONObject discardJson = getAccessDiscardData(queryCondition);
		object.put(Constants.DISCARD_DATA, discardJson);
		
		// 获取当前接入输入数据总量
		Long totalInputNum = 0L;
		try {
			totalInputNum = accessService.getTotalAccessInputNum(queryCondition);
		} catch (Exception e) {
			LOG.error(">>>>>get todayInputNum failed", e);
		}
		object.put(Constants.TOTAL_INPUT_NUM, totalInputNum);
		
		// 当前接入输入数据平均流量（1h）
		Double averageInputNum = 0D;
		try {
			String date = DateUtil.getDate();
			queryCondition.put("createDate", date);
			Long total = accessService.getTotalAccessInputNum(queryCondition);
			if (total != null) {
				averageInputNum = NumberUtils.round(total / 24D, 2);
			}
		} catch (Exception e) {
			LOG.error(">>>>>get averageInputNum failed", e);
		}
		object.put(Constants.AVERAGE_INPUT_NUM, StringUtil.isEmpty(averageInputNum) ? 0 : averageInputNum);
		
		// 昨日接入输入数据量
		Long yesterdayInputNum = 0L;
		try {
			yesterdayInputNum = accessService.getAccessInputNumByDay(queryCondition);
		} catch (Exception e) {
			LOG.error(">>>>>get yesterdayInputNum failed", e);
		}
		object.put(Constants.YESTERDAY_INPUT_NUM, StringUtil.isEmpty(yesterdayInputNum) ? 0 : yesterdayInputNum);
		
		return object.toString();
	}

	private Map<String, Object> getQueryCondition(HttpServletRequest request) {
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		String dataSource = request.getParameter("dataSource");
		String bProtocol = request.getParameter("bProtocol");
		String sProtocol = request.getParameter("sProtocol");
		String action = request.getParameter("action");
		
		if (StringUtil.isNotEmpty(dataSource) && !Constants.QUERY_ALL.equals(dataSource)) {
			queryCondition.put("dataSource", dataSource);
		}
		if (StringUtil.isNotEmpty(bProtocol) && !Constants.QUERY_ALL.equals(bProtocol)) {
			queryCondition.put("bProtocol", bProtocol);
		}
		if (StringUtil.isNotEmpty(sProtocol) && !Constants.QUERY_ALL.equals(sProtocol)) {
			queryCondition.put("sProtocol", sProtocol);
		}
		if (StringUtil.isNotEmpty(action) && !Constants.QUERY_ALL.equals(action)) {
			queryCondition.put("action", action);
		}
		
		String inputDay = request.getParameter("inputDay");
		String discardDay = request.getParameter("discardDay");
		
		if (StringUtil.isNotEmpty(inputDay)) {
			queryCondition.put("inputDay", inputDay);
		} else {
			queryCondition.put("inputDay", 7);
		}
		if (StringUtil.isNotEmpty(discardDay)) {
			queryCondition.put("discardDay", discardDay);
		} else {
			queryCondition.put("discardDay", 7);
		}
		return queryCondition;
	}

	/**
	 * 获取近七天接入数据输入量
	 * @param queryCondition
	 * @return
	 */
	private JSONObject getAccessInputData(Map<String, Object> queryCondition) {
		List<AccessInputEntity> accessInputData = new ArrayList<AccessInputEntity>();
		JSONObject accessInputJson = new JSONObject();
		try {
			accessInputData = accessService.getAccessInputData(queryCondition);
			if (accessInputData != null && !accessInputData.isEmpty()) {
				List<String> date = new ArrayList<String>();
				List<Long> accessInputNum = new ArrayList<Long>();
				for (AccessInputEntity accessInputEntity : accessInputData) {
					date.add(accessInputEntity.getDate());
					accessInputNum.add(StringUtil.isEmpty(accessInputEntity.getInputNum()) ? 0L : accessInputEntity.getInputNum());
				}
				accessInputJson.put(Constants.ACCESS_DATE, date);
				accessInputJson.put(Constants.ACCESS_INPUT_NUM, accessInputNum);
			}
		} catch (Exception e) {
			LOG.error(">>>>>getAccessInputData failed", e);
		}
		
		return accessInputJson;
	}
	
	/**
	 * 查询抛弃数据量
	 * @param queryCondition
	 * @return
	 */
	private JSONObject getAccessDiscardData(Map<String, Object> queryCondition) {
		List<AccessDiscardEntiy> discardData = new ArrayList<AccessDiscardEntiy>();
		JSONObject discardJson = new JSONObject();
		try {
			discardData = accessService.getAccessDiscardData(queryCondition);
			List<String> discardReason = new ArrayList<String>();
			List<Long> discardNum = new ArrayList<Long>();
			if (discardData != null && !discardData.isEmpty()) {
				for (AccessDiscardEntiy accessDiscardEntiy : discardData) {
					discardReason.add(accessDiscardEntiy.getDiscardReason());
					discardNum.add(StringUtil.isEmpty(accessDiscardEntiy.getDiscardNum()) ? 0L : accessDiscardEntiy.getDiscardNum());
				}
				discardJson.put(Constants.DISCARD_REASON, discardReason);
				discardJson.put(Constants.DISCARD_NUM, discardNum);
			}
		} catch (Exception e) {
			LOG.error(">>>>>getAccessDiscardData failed", e);
		}
		
		return discardJson;
	}
	
	@RequestMapping("/input")
	@ResponseBody
	public String getInputData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> queryCondition = getQueryCondition(request);
		JSONObject object = getAccessInputData(queryCondition);
		return object.toString();
	}
	
	@RequestMapping("/discard")
	@ResponseBody
	public String getDiscardData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> queryCondition = getQueryCondition(request);
		JSONObject object = getAccessDiscardData(queryCondition);
		return object.toString();
	}
}
