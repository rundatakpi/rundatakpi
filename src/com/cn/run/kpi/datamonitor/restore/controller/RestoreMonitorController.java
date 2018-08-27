package com.cn.run.kpi.datamonitor.restore.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.cn.run.kpi.datamonitor.restore.entity.RestoreInputEntity;
import com.cn.run.kpi.datamonitor.restore.entity.RestoreOutputEntity;
import com.cn.run.kpi.datamonitor.restore.service.RestoreService;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * 还原监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/restore")
public class RestoreMonitorController {
	
	public static final Logger LOG = Logger.getLogger(RestoreMonitorController.class);

	@Autowired
	private RestoreService restoreService;
	
	@RequestMapping("/init")
	@ResponseBody
	public String init(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> queryCondition = getQueryCondition(request);
		
		JSONObject object =new JSONObject();
		
		// 协议还原数据实时输入数据量
		getRestoreInputData(queryCondition, object);
		
		// 协议还原数据实时输出数据量
		getRestoreOutputData(queryCondition, object);
		
		// 输入数据总量
		JSONObject currentDataJson = new JSONObject();
		Long totalInputNum = getTotalInputNum(queryCondition);
		currentDataJson.put("totalInputNum", totalInputNum);
		
		// 输出数据总量
		Long totalOutputNum = getTotalOutputNum(queryCondition);
		currentDataJson.put("totalOutputNum", totalOutputNum);
		
		// 丢弃数据总量
		Long totalDiscardNum = getTotalDiscardNum(queryCondition);
		currentDataJson.put("totalDiscardNum", totalDiscardNum);
		object.put("currentDataJson", currentDataJson);
		
		JSONObject yesterdayDataJson = new JSONObject();
		
		// 昨日输入数据量
		Long yesterdayInputNum = getYesterdayInputNum(queryCondition);
		yesterdayDataJson.put("yesterdayInputNum", yesterdayInputNum);
		
		// 昨日输出数据量
		Long yesterdayOutputNum = getYesterdayOutNumByDay(queryCondition);
		yesterdayDataJson.put("yesterdayOutputNum", yesterdayOutputNum);
		object.put("yesterdayDataJson", yesterdayDataJson);
		
		return object.toString();
	}

	private Map<String, Object> getQueryCondition(HttpServletRequest request) {
		
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		String inputDay = request.getParameter("inputDay");
		String outputDay = request.getParameter("outputDay");
		
		if (StringUtil.isNotEmpty(inputDay)) {
			queryCondition.put("inputDay", inputDay);
		} else {
			queryCondition.put("inputDay", 7);
		}
		if (StringUtil.isNotEmpty(outputDay)) {
			queryCondition.put("outputDay", outputDay);
		} else {
			queryCondition.put("outputDay", 7);
		}
		return queryCondition;
	}

	private void getRestoreOutputData(Map<String, Object> queryCondition, JSONObject object) {
		try {
			List<RestoreOutputEntity> outputData = restoreService.getRestoreOutputData(queryCondition);

			if (outputData != null && !outputData.isEmpty()) {
				JSONObject outputJson = new JSONObject();
				List<String> outputDate = new ArrayList<String>();
				List<Long> outputNum = new ArrayList<Long>();
				for (RestoreOutputEntity outputEntity : outputData) {
					outputNum.add(StringUtil.isEmpty(outputEntity.getOutputNum()) ? 0L : outputEntity.getOutputNum());
					outputDate.add(outputEntity.getTime());
				}
				outputJson.put("outputNum", outputNum);
				outputJson.put("outputDate", outputDate);
				object.put("outputJson", outputJson);
			}
		} catch (Exception e) {
			LOG.error(">>>>>get restoreOutputData faild......", e);
		}
	}

	private void getRestoreInputData(Map<String, Object> queryCondition, JSONObject object) {
		try {
			List<RestoreInputEntity> inputData = restoreService.getRestoreInputData(queryCondition);
			if (inputData != null && !inputData.isEmpty()) {
				JSONObject inputJson = new JSONObject();
				List<String> inputDate = new ArrayList<String>();
				List<Long> inputNum = new ArrayList<Long>();
				for (RestoreInputEntity inputEntity : inputData) {
					inputNum.add(StringUtil.isEmpty(inputEntity.getInputNum()) ? 0L : inputEntity.getInputNum());
					inputDate.add(inputEntity.getTime());
				}
				inputJson.put("inputNum", inputNum);
				inputJson.put("inputDate", inputDate);
				object.put("inputJson", inputJson);
			}
		} catch (Exception e) {
			LOG.error(">>>>>get restoreInputData faild......", e);
		}
	}

	private Long getYesterdayOutNumByDay(Map<String, Object> queryCondtion) {
		Long outputNumByDay = 0L;
		try {
			String date = DateUtil.getDateBefore(new Date(), 1);
			queryCondtion.put("today", date);
			outputNumByDay = restoreService.getRestoreOutputNumByDay(queryCondtion);
		} catch (Exception e) {
			LOG.error(">>>>>get today input num failed...", e);
		}
		return StringUtil.isEmpty(outputNumByDay) ? 0L : outputNumByDay;
	}

	private Long getYesterdayInputNum(Map<String, Object> queryCondtion) {
		Long inputNumByDay = 0L;
		try {
			String date = DateUtil.getDateBefore(new Date(), 1);
			queryCondtion.put("yesterday", date);
			inputNumByDay = restoreService.getRestoreInputNumByDay(queryCondtion);
		} catch (Exception e) {
			LOG.error(">>>>>get today input num failed...", e);
		}
		return StringUtil.isEmpty(inputNumByDay) ? 0L : inputNumByDay;
	}

	private Long getTotalDiscardNum(Map<String, Object> queryCondtion) {
		Long totalDiscardNum = 0L;
		try {
			totalDiscardNum = restoreService.getTotalRestoreDiscardNum(queryCondtion);
		} catch (Exception e) {
			LOG.error(">>>>>get total discard num failed...", e);
		}
		return StringUtil.isEmpty(totalDiscardNum) ? 0L : totalDiscardNum;
	}

	private Long getTotalOutputNum(Map<String, Object> queryCondtion) {
		Long totalOuptNum = 0L;
		try {
			totalOuptNum = restoreService.getTotalRestoreOutputNum(queryCondtion);
		} catch (Exception e) {
			LOG.error(">>>>>get total output num failed...", e);
		}
		return StringUtil.isEmpty(totalOuptNum) ? 0L : totalOuptNum;
	}

	private Long getTotalInputNum(Map<String, Object> queryCondtion) {
		Long totalInputNum = 0L;
		try {
			totalInputNum = restoreService.getTotalRestoreInputNum(queryCondtion);
		} catch (Exception e) {
			LOG.error(">>>>>get total input num failed...", e);
		}
		return StringUtil.isEmpty(totalInputNum) ? 0L : totalInputNum;
	}
	
	@RequestMapping("/input")
	@ResponseBody
	public String getInputData(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		
		getRestoreInputData(getQueryCondition(request), object);
		return object.toString();
	}
	
	@RequestMapping("/output")
	@ResponseBody
	public String getOutputData(HttpServletRequest request) {
		JSONObject object = new JSONObject();
		
		getRestoreOutputData(getQueryCondition(request), object);
		return object.toString();
	}
}
