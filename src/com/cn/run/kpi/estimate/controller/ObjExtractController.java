package com.cn.run.kpi.estimate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.cn.run.kpi.estimate.entity.ObjInfo;
import com.cn.run.kpi.estimate.service.ObjExtractService;
import com.cn.run.kpi.utils.DateUtil;
import net.sf.json.JSONObject;


/**
 * 对象化提取Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/obj")
public class ObjExtractController {
	
	private static final Logger LOGGER = Logger.getLogger(ObjExtractController.class);
	
	@Autowired
	private ObjExtractService objectExtractService;
	
	/**
	 * 获取对象类型
	 * @return
	 */
	@RequestMapping("/getObjType")
	@ResponseBody
	public JSONObject getObjType() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<ObjInfo> objs =  objectExtractService.getObjType();
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			jsonObject.put("json", "error");
		}
		return jsonObject;
	}
	
	/**
	 * 获取特征串
	 */
	@RequestMapping("/getFeartureString")
	@ResponseBody
	public JSONObject getFeartureString() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<ObjInfo> feartureStrings = objectExtractService.getFeartureString();
			jsonObject.put("json", feartureStrings);
		}catch(Exception e) {
			LOGGER.error(e.getMessage(),e);
			jsonObject.put("json", "error");
		}
		return jsonObject;
	}
	
	/**
	 * 获取数据源
	 */
	@RequestMapping("/getDataSource")
	@ResponseBody
	public JSONObject getDataSource() {
		JSONObject jsonObject = new JSONObject();
		try {
			List<ObjInfo> dataSources = objectExtractService.getDataSource();
			jsonObject.put("json", dataSources);
		}catch(Exception e) {
			LOGGER.error(e.getMessage(),e);
			jsonObject.put("json", "error");
		}
		return jsonObject;
	}
	
	
	/**
	 * 查询对象化提取数据列表
	 * @param request
	 * @param objectExtractData
	 * @return
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,ObjInfo objDataInfo){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Integer start = Integer.valueOf(request.getParameter("start"));
			Integer length = Integer.valueOf(request.getParameter("length"));
			objDataInfo.setStart(start);
			objDataInfo.setLength(length);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(new Date());
			objDataInfo.setCreateDate(currDate);
			
			List<ObjInfo> objectExtractDatas = objectExtractService.getList(objDataInfo);
			Integer total = objectExtractService.getTotal(objDataInfo);
			
			resultMap.put("recordsTotal",total);
			resultMap.put("recordsFiltered",total);
			resultMap.put("data", objectExtractDatas);
		}catch(Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return resultMap;
		
	}
	
	/**
	 * 查询某种数据近一周趋势图
	 * @param id
	 * @param colName
	 * @return
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public JSONObject getDetail(ObjInfo objDataInfo) {
		JSONObject json = new JSONObject();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startDateStr = DateUtil.getDateBefore(new Date(), 7);
			String endDateStr = sdf.format(new Date());
			objDataInfo.setStartTime(startDateStr);
			objDataInfo.setEndTime(endDateStr);
			
			List<ObjInfo> objs = objectExtractService.getDetail(objDataInfo);
			json.put("data", objs);
		}catch(Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return json;
	}
}
