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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.run.kpi.alarm.controller.AlarmDataController;
import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.service.TransformDataService;
import com.cn.run.kpi.utils.DateUtil;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import net.sf.json.JSON;
import net.sf.json.JSONObject;




/**
 * 格转接入数据质量Controller
 * @author chenyan
 * 2018年8月6日
 *
 */

@Controller
@RequestMapping("/transform")
public class TransformDataController {
	
	private static final Logger LOG = Logger.getLogger(AlarmDataController.class);
	
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
		try {
			List<TransformData> tanformDatas = transformService.getList(transformData);
			Integer total = transformService.getTotal(transformData);
			resultMap.put("recordsTotal", total);
			resultMap.put("recordsFiltered",total);
			resultMap.put("data", tanformDatas);
		}catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return resultMap;
	}
	
	/**
	 * 查询某种协议  输入数据条数/输入数据字段填充率...   近一周数据量
	 * @param transformStr
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public JSONObject getDetail(TransformData tranformData){
		JSONObject json = new JSONObject();
		
		try {
			//JSONObject jsonobject = JSONObject.fromObject(transData);
			//TransformData tranformData = (TransformData)JSONObject.toBean(jsonobject,TransformData.class);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startDateStr = DateUtil.getDateBefore(new Date(), 7);
			String endDateStr = sdf.format(new Date());
			tranformData.setStartTime(startDateStr);
			tranformData.setEndTime(endDateStr);
			
			List<TransformData> transformList = transformService.selectDetail(tranformData);
			
			json.put("data",transformList);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return json;
		
	}
	
}
