package com.cn.run.kpi.estimate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.estimate.common.ActionConfig;
import com.cn.run.kpi.estimate.common.LogConstants;
import com.cn.run.kpi.estimate.common.YCLConstants;
import com.cn.run.kpi.estimate.entity.LogField;
import com.cn.run.kpi.estimate.entity.LogInfo;
import com.cn.run.kpi.estimate.service.StoreLogService;
import com.cn.run.kpi.utils.DateUtil;

import net.sf.json.JSONObject;

/**
 * 入库日志数据Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/log")
public class StoreLogController {
	
	private static Logger LOGGER = Logger.getLogger(StoreLogController.class);

	@Autowired
	private StoreLogService storeLogDataService;
	
	
	/**
	 * 获取数据源类型
	 */
	@RequestMapping("/getDataSource")
	@ResponseBody
	public JSONObject getDataSource() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<LogInfo> list = storeLogDataService.getDataSource();
			jsonObject.put("result", list);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return jsonObject;
		
	}
	

	/**
	 * 获取大协议类型
	 */
	@RequestMapping("/getBProtocol")
	@ResponseBody
	public JSONObject getBProtocol() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<LogInfo> list = storeLogDataService.getBProtocol();
			jsonObject.put("result", list);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return jsonObject;
		
	}
	
	/**
	 * 获取小协议类型
	 */
	@RequestMapping("/getSProtocol")
	@ResponseBody
	public JSONObject getSProtocol() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<LogInfo> list = storeLogDataService.getSProtocol();
			jsonObject.put("result", list);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return jsonObject;
		
	}
	
	/**
	 * 查询入库日志数据列表
	 * @return Map<String,Object>
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,LogInfo logInfo){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Integer start = Integer.valueOf(request.getParameter("currentPage"));
		Integer length = Integer.valueOf(request.getParameter("pageSize"));
		logInfo.setCreateDate(DateUtil.getDate());
		logInfo.setStart(start-1);
		logInfo.setLength(length);
		
		List<LogInfo> storeLogDatas = storeLogDataService.getList(logInfo);
		Integer total = storeLogDataService.getTotal(logInfo);
		
		resultMap.put("total", total);
		resultMap.put("data", storeLogDatas);
		
		return resultMap;

	}
	
	
	/**
	 * 查询某种大协议下面所有的小协议
	 * @param transformStr
	 */
	@RequestMapping("/getMore")
	@ResponseBody
	public JSONObject getMore(LogInfo logData,HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		try {
			Integer start = Integer.valueOf(request.getParameter("currentPage"));
			Integer length = Integer.valueOf(request.getParameter("pageSize"));
			
			LogInfo logInfo = storeLogDataService.selectById(logData.getId());
			logInfo.setStart(start-1);
			logInfo.setLength(length);
			
			List<LogInfo> logInfoList = storeLogDataService.getMore(logInfo);
			for (LogInfo logInfo2 : logInfoList) {
				String actionType = logInfo2.getActionType();
				String actionTypeDesc = ActionConfig.getValue(actionType);
				logInfo2.setActionTypeDesc(actionTypeDesc);
			}
			
			Integer total = storeLogDataService.getMoreTotal(logInfo);
			
			json.put("data",logInfoList);
			json.put("total",total);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return json;
		
	}
	
	
	/**
	 * 查询某种协议  输入数据条数/输入数据字段填充率...   近一周数据量
	 * @param transformStr
	 */
	@RequestMapping("/getOutDetail")
	@ResponseBody
	public JSONObject getOutDetail(LogInfo logData){
		JSONObject json = new JSONObject();
		
		try {
			LogInfo logInfo = storeLogDataService.selectById(logData.getId());
			String colName = LogConstants.getLogSql(logData.getColName());
			logInfo.setColName(colName);

			List<LogInfo> logList = storeLogDataService.getOutDetail(logInfo);
			
			json.put("data",logList);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return json;
		
	}
	
	
	/**
	 * 查询某种小协议填充率，准确率，代码符合度，  近一周数据量
	 * @param transformStr
	 */
	@RequestMapping("/getInDetail")
	@ResponseBody
	public JSONObject getInDetail(LogField logField){
		JSONObject json = new JSONObject();
		
		try {
			String colName = LogConstants.getLogSql(logField.getColName());
			logField.setColName(colName);
			if(logField.getFieldCode()!=null&&logField.getFieldCode()!="") {
				logField.setFieldCode(logField.getFieldCode());
			}
			
			List<LogField> logList = storeLogDataService.getInDetail(logField);
			json.put("data",logList);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return json;
		
	}
}
