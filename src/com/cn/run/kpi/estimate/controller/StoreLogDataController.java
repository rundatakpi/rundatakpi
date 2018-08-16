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
import com.cn.run.kpi.estimate.common.YCLConstants;
import com.cn.run.kpi.estimate.entity.StoreLogData;
import com.cn.run.kpi.estimate.service.StoreLogDataService;
import com.cn.run.kpi.utils.DateUtil;
import com.sun.org.apache.bcel.internal.classfile.ConstantClass;
import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * 入库日志数据Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/storeLog")
public class StoreLogDataController {
	
	private static Logger LOG = Logger.getLogger(StoreLogDataController.class);

	@Autowired
	private StoreLogDataService storeLogDataService;
	
	/**
	 * 查询入库日志数据列表
	 * @return Map<String,Object>
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,StoreLogData storeLogData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Integer start = Integer.valueOf(request.getParameter("start"));
		Integer length = Integer.valueOf(request.getParameter("length"));
		storeLogData.setStart(start);
		storeLogData.setLength(length);
		
		List<StoreLogData> storeLogDatas = storeLogDataService.getList(storeLogData);
		Integer total = storeLogDataService.getTotal(storeLogData);
		
		resultMap.put("recordsTotal", total);
		resultMap.put("recordsFiltered", total);
		resultMap.put("data", storeLogDatas);
		
		return resultMap;

	}
	
	/**
	 * 查询某种协议  输入数据条数/输入数据字段填充率...   近一周数据量
	 * @param transformStr
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public JSONObject getDetail(StoreLogData storeLogData){
		JSONObject json = new JSONObject();
		
		try {
			String newName = YCLConstants.getLogSql(storeLogData.getColName());     
			storeLogData.setColName(newName);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startDateStr = DateUtil.getDateBefore(new Date(), 7);
			String endDateStr = sdf.format(new Date());
			storeLogData.setStartTime(startDateStr);
			storeLogData.setEndTime(endDateStr);
			
			List<StoreLogData> logList = storeLogDataService.selectDetail(storeLogData);
			
			json.put("data",logList);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return json;
		
	}
	
	/**
	 * 获取表头的信息
	 */
	@RequestMapping("/getTableInfo")
	@ResponseBody
	public JSON getTableInfo(StoreLogData storeLogData) {
		JSONObject jsonObject = new JSONObject();
		List<StoreLogData> storeLogs = storeLogDataService.getTableInfo(storeLogData);
		jsonObject.put("logs", storeLogs);
		return jsonObject;
		
	}
}
