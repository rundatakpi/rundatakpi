package com.cn.run.kpi.estimate.controller;

import java.text.ParseException;
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

import com.cn.run.kpi.estimate.common.YCLConstants;
import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.entity.YCLData;
import com.cn.run.kpi.estimate.entity.YCLExampleData;
import com.cn.run.kpi.estimate.service.YCLDataService;
import com.cn.run.kpi.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import cn.gbase.pool.log.Log;
import net.sf.json.JSONObject;
import sun.util.logging.resources.logging;



/**
 * 预处理数据质量Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/ycl")
public class YCLDataController {
	
	private static final Logger LOGGER = Logger.getLogger(YCLDataController.class);
	
	@Autowired
	private YCLDataService yclDataService;
	
	
	/**
	 * 获取ycl数据列表
	 * @return  Map<String,Object>
	 */
	@RequestMapping("getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,YCLData yclData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Integer start = Integer.valueOf(request.getParameter("start"));
			Integer length = Integer.valueOf(request.getParameter("length"));
			yclData.setStart(start);
			yclData.setLength(length);
			
			List<YCLData> yclDatas = yclDataService.getList(yclData);
			Integer total = yclDataService.getTotal(yclData);
			
			resultMap.put("recordsTotal", total);
			resultMap.put("recordsFiltered", total);
			resultMap.put("data", yclDatas);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return resultMap;
	}
	
	/**
	 * 查询某种协议  输入数据条数/输入数据字段填充率...   近一周数据量
	 * @param transformStr
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public JSONObject getDetail(Integer id,String colName){
		JSONObject json = new JSONObject();

		try {
			YCLData yclData = yclDataService.selectById(id);

			yclData.setColName(colName);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date beforeDate = sdf.parse(yclData.getCreateDate());
			String beforeDateStr = DateUtil.getDateBefore(beforeDate, 7);
			yclData.setStartTime(beforeDateStr);
			yclData.setEndTime(yclData.getCreateDate());
			List<YCLData> yclList = yclDataService.selectDetail(yclData);
			
			json.put("data",yclList);

		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return json;
		
	}
	
	/**
	 * 获取某条预处理数据的样例包详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/getExampleList")
	@ResponseBody
	public JSONObject getExampleList(Integer id) {
		JSONObject json = new JSONObject();
		try {
			YCLExampleData yclExampleData = new YCLExampleData();
			yclExampleData.setQid(id);
			
			List<YCLExampleData> yclExampleDatas = yclDataService.getExampleList(yclExampleData);
			Integer total = YCLConstants.NORMAL_SIZE+YCLConstants.UNNORMAL_SIZE;
			
			json.put("recordsTotal", total);
			json.put("recordsFiltered", total);
			json.put("data", yclExampleDatas);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return json;
	}
}
