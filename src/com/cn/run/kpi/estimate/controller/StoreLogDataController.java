package com.cn.run.kpi.estimate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.estimate.entity.StoreLogData;
import com.cn.run.kpi.estimate.service.StoreLogDataService;



/**
 * 入库日志数据Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
public class StoreLogDataController {

	@Autowired
	private StoreLogDataService storeLogDataService;
	
	/**
	 * 查询入库日志数据列表
	 * @return Map<String,Object>
	 */
	@RequestMapping("/storeLogData")
	@ResponseBody
	public Map<String,Object> getList(StoreLogData storeLogData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		List<StoreLogData> storeLogDatas = storeLogDataService.getList(storeLogData);
		Integer total = storeLogDataService.getTotal(storeLogData);
		
		resultMap.put("recordsTotal", Integer.toString(total));
		resultMap.put("recordsFiltered",  Integer.toString(storeLogDatas.size()));
		resultMap.put("data", storeLogDatas);
		
		return resultMap;
		
		
	}
}
