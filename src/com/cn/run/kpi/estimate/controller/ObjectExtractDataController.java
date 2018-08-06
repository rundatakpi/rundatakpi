package com.cn.run.kpi.estimate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.estimate.entity.ObjectExtractData;
import com.cn.run.kpi.estimate.service.ObjectExtractDataService;


/**
 * 对象化提取Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/objectExtractData")
public class ObjectExtractDataController {
	
	@Autowired
	private ObjectExtractDataService objectExtractService;
	
	/**
	 * 查询对象化提取数据列表
	 * @param request
	 * @param objectExtractData
	 * @return
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(ObjectExtractData objectExtractData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		List<ObjectExtractData> objectExtractDatas = objectExtractService.getList(objectExtractData);
		Integer total = objectExtractService.getTotal(objectExtractData);
		
		resultMap.put("recordsTotal", Integer.toString(total));
		resultMap.put("recordsFiltered",  Integer.toString(objectExtractDatas.size()));
		resultMap.put("data", objectExtractDatas);
		
		return resultMap;
		
	}
}
