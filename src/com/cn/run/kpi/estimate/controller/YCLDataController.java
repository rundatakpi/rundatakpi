package com.cn.run.kpi.estimate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.run.kpi.estimate.entity.YCLData;
import com.cn.run.kpi.estimate.service.YCLDataService;



/**
 * 预处理数据质量Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/ycl")
public class YCLDataController {
	
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
		Integer length = Integer.valueOf(request.getParameter("length"));
		
		List<YCLData> yclDatas = yclDataService.getList(yclData,length);
		Integer total = yclDataService.getTotal(yclData);
		
		resultMap.put("recordsTotal", Integer.toString(total));
		resultMap.put("recordsFiltered",  Integer.toString(yclDatas.size()));
		resultMap.put("data", yclDatas);
		
		return resultMap;
	}
}
