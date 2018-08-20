package com.cn.run.kpi.datamonitor.preprocess.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.preprocess.entity.PreProcessEntity;
import com.cn.run.kpi.datamonitor.preprocess.service.PreProcessService;
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
	public String init() {
		JSONObject object = new JSONObject();
		List<String> date = new ArrayList<>();
		List<Long> inputNum = new ArrayList<>();
		List<Long> outputNum = new ArrayList<>();
		try {
			List<PreProcessEntity> inputData = preProcessService.getPreProcessInputData();
			if (inputData != null && !inputData.isEmpty()) {
				for (PreProcessEntity preProcessEntity : inputData) {
					date.add(preProcessEntity.getCreateTime());
					inputNum.add(preProcessEntity.getDataNum());
				}
			}
			System.out.println(inputData.isEmpty());
		} catch (Exception e) {
			LOG.error(">>>>>get preprocess inputdata failed", e);
		}
		
		try {
			List<PreProcessEntity> outputData = preProcessService.getPreProcessOutputData();
			if (outputData != null && !outputData.isEmpty()) {
				for (PreProcessEntity preProcessEntity : outputData) {
					outputNum.add(preProcessEntity.getDataNum());
				}
			}
		    System.out.println(outputData.size());
		} catch (Exception e) {
			LOG.error(">>>>>get preprocess outputdata failed", e);
		}
		object.put("date", date);
		object.put("inputNum", inputNum);
		object.put("outputNum", outputNum);
		
		
		getRepeatData(object);
		getErrorData(object);
		return object.toString();
	}

	private void getErrorData(JSONObject object) {
		try {
			List<PreProcessEntity> errorData = preProcessService.getErrorData();
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

	private void getRepeatData(JSONObject object) {
		// 获取重复率
		try {
			List<PreProcessEntity> repeatData = preProcessService.getPreProcessInputData();
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
}
