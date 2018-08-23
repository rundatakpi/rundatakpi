package com.cn.run.kpi.datamonitor.preprocess.controller;

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
import com.cn.run.kpi.datamonitor.preprocess.entity.PreProcessEntity;
import com.cn.run.kpi.datamonitor.preprocess.service.PreProcessService;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.StringUtil;

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
	public String init(HttpServletRequest request, HttpServletResponse response) {
		Map<String ,Object> queryCondition = getQueryCondition(request);
		
		JSONObject object = new JSONObject();
		getRealTimeData(object, queryCondition);
		getRepeatData(object, queryCondition);
		getErrorData(object, queryCondition);
		return object.toString();
	}

	private Map<String, Object> getQueryCondition(HttpServletRequest request) {
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		String classfication = request.getParameter("classfication");
		String dataSource = request.getParameter("dataSource");
		String bProtocol = request.getParameter("bProtocol");
		String sProtocol = request.getParameter("sProtocol");
		String action = request.getParameter("action");
		String collectPlace = request.getParameter("collectPlace");
		String realDay = request.getParameter("realDay");
		String repeatDay = request.getParameter("repeatDay");
		
		if (StringUtil.isNotEmpty(classfication) && !Constants.QUERY_ALL.equals(classfication)) {
			queryCondition.put("classfication", classfication);
		}
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
		if (StringUtil.isNotEmpty(collectPlace) && !Constants.QUERY_ALL.equals(collectPlace)) {
			queryCondition.put("collectPlace", collectPlace);
		}
		if (StringUtil.isNotEmpty(realDay)) {
			queryCondition.put("realDay", realDay);
		} else {
			queryCondition.put("realDay", 7);
		}
		if (StringUtil.isNotEmpty(repeatDay)) {
			queryCondition.put("repeatDay", repeatDay);
		} else {
			queryCondition.put("repeatDay", 7);
		}
		
		return queryCondition;
	}

	/**
	 * 获取预处理实时监控数据
	 * @param object
	 * @param request
	 */
	private void getRealTimeData(JSONObject object, Map<String, Object> queryCondition) {
		List<String> date = new ArrayList<>();
		List<Long> inputNum = new ArrayList<>();
		List<Long> outputNum = new ArrayList<>();
		
		String day = queryCondition.get("realDay").toString();
		date = DateUtil.getDate(Integer.parseInt(day));
		
		try {
			List<PreProcessEntity> inputData = preProcessService.getPreProcessInputData(queryCondition);
			if (inputData != null && !inputData.isEmpty()) {
				
				Map<String, Long> inputMap = converObjectToMap(inputData);
				for (String d : date) {
					Long num = inputMap.get(d);
					inputNum.add(StringUtil.isEmpty(num) ? 0L : num);
				}	
			}
		} catch (Exception e) {
			LOG.error(">>>>>get preprocess inputdata failed", e);
		}
		
		try {
			List<PreProcessEntity> outputData = preProcessService.getPreProcessOutputData(queryCondition);
			if (outputData != null && !outputData.isEmpty()) {
				
				Map<String, Long> outputMap = converObjectToMap(outputData);
				for (String d : date) {
					Long num = outputMap.get(d);
					outputNum.add(StringUtil.isEmpty(num) ? 0L : num);
				}	
			}
		} catch (Exception e) {
			LOG.error(">>>>>get preprocess outputdata failed", e);
		}
		object.put("date", date);
		object.put("inputNum", inputNum);
		object.put("outputNum", outputNum);
	}

	private Map<String, Long> converObjectToMap(List<PreProcessEntity> inputData) {
		Map<String, Long> inputMap = new HashMap<String, Long>();
		
		for (PreProcessEntity preProcessEntity : inputData) {
			inputMap.put(preProcessEntity.getCreateTime(), preProcessEntity.getDataNum());
		}
		return inputMap;
	}

	/**
	 * 获取预处理错误数据量
	 * @param object
	 * @param request
	 */
	private void getErrorData(JSONObject object, Map<String, Object> queryCondition) {
		try {
			List<PreProcessEntity> errorData = preProcessService.getErrorData(queryCondition);
			JSONObject errorJson = new JSONObject();
			List<Long> errorNum = new ArrayList<>(); 
			List<String> errorType = new ArrayList<>(); 
			if (errorData != null && !errorData.isEmpty()) {
				for (PreProcessEntity preProcessEntity : errorData) {
					errorNum.add(StringUtil.isEmpty(preProcessEntity.getDataNum()) ? 0L : preProcessEntity.getDataNum());
					errorType.add(preProcessEntity.getErrorType());
				}
				errorJson.put("errorNum", errorNum);
				errorJson.put("errorType", errorType);
				object.put("errorJson", errorJson);
			}
		} catch (Exception e) {
			LOG.error(">>>>>get preprocess error data failed", e);
		}
	}

	/**
	 * 获取输入数据流重复率
	 * @param object
	 * @param request
	 */
	private void getRepeatData(JSONObject object, Map<String, Object> queryCondition) {
		try {
			List<PreProcessEntity> repeatData = preProcessService.getRepeatData(queryCondition);
			if (repeatData != null && !repeatData.isEmpty()) {
				JSONObject repeatJson = new JSONObject();
				List<String> createDate = new ArrayList<>();
				List<Long> repeatNum = new ArrayList<>();
				for (PreProcessEntity preProcessEntity : repeatData) {
					createDate.add(preProcessEntity.getCreateTime());
					repeatNum.add(preProcessEntity.getDataNum());
				}
				repeatJson.put("date", createDate);
				repeatJson.put("repeatNum", repeatNum);
				object.put("repeatJson", repeatJson);
			}
		} catch (Exception e) {
			LOG.error(">>>>>get preprocess repeat data failed", e);
		}
	}
	
	/**
	 * 获取预处理实时数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/realtime")
	@ResponseBody
	public String getRealTimeData(HttpServletRequest request) {
		Map<String ,Object> queryCondition = getQueryCondition(request);
		String day = request.getParameter("realDay");
		
		if (StringUtil.isEmpty(day)) {
			day = "7";
		}
		queryCondition.put("realDay", day);
		JSONObject object = new JSONObject();
		getRealTimeData(object, queryCondition);
		return object.toString();
	}
	
	/**
	 * 获取预处理实时数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/repeat")
	@ResponseBody
	public String getRepeatData(HttpServletRequest request) {
		Map<String ,Object> queryCondition = getQueryCondition(request);
		String day = request.getParameter("repeatDay");
		
		if (StringUtil.isEmpty(day)) {
			day = "7";
		}
		queryCondition.put("repeatDay", day);
		JSONObject object = new JSONObject();
		getRepeatData(object, queryCondition);
		return object.toString();
	}
}
