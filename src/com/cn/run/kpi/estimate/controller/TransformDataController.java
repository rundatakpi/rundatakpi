package com.cn.run.kpi.estimate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.service.TransformDataService;



/**
 * 格转接入数据质量Controller
 * @author chenyan
 * 2018年8月6日
 *
 */

@Controller
@RequestMapping("/transform")
public class TransformDataController {
	
	@Autowired
	private TransformDataService transformService;
	
	/**
	 * 展示格转接入数据列表
	 * @return List<TransformData>
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(TransformData transformData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		List<TransformData> tanformDatas = transformService.getList(transformData);
		Integer total = transformService.getTotal(transformData);
		
		resultMap.put("recordsTotal", Integer.toString(total));
		resultMap.put("recordsFiltered",  Integer.toString(tanformDatas.size()));
		resultMap.put("data", tanformDatas);

		
		return resultMap;
	}
	
}
