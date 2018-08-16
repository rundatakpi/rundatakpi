package com.cn.run.kpi.datamonitor.store.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.store.entity.NineResourceEntity;
import com.cn.run.kpi.datamonitor.store.entity.ObjectLibEntity;
import com.cn.run.kpi.datamonitor.store.service.StoreService;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * 存储量监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/store")
public class StoreMonitorController {
	
	private static final Logger LOG = Logger.getLogger(StoreMonitorController.class);
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/init")
	@ResponseBody
	public String init() {
		JSONObject object = new JSONObject();
		
		// 获取九大资源实时数据量和昨日数据量
		getNineResourceData(object);
		
		// 获取对象库数据量和昨日数据量
		getObjectData(object);
		return object.toString();
	}

	/**
	 * 获取对象库数据量和昨日数据量
	 * @param object
	 */
	private void getObjectData(JSONObject object) {
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		try {
			JSONObject objectJson = new JSONObject();
			 List<ObjectLibEntity> objectLib = storeService.getObjectData(queryCondition);
			 List<String> objectName = new ArrayList<>();
			 if (objectLib != null && !objectLib.isEmpty()) {
				 List<Long> objectNum = new ArrayList<>();
				 for (ObjectLibEntity objectLibEntity : objectLib) {
					 objectName.add(objectLibEntity.getObject());
					 objectNum.add(objectLibEntity.getDataNum());
				 }
				 objectJson.put("objectName", objectName);
				 objectJson.put("objectNum", objectNum);
			 }
			 String yesterday = DateUtil.getDateBefore(new Date(), 1);
			 queryCondition.put("yesterday", yesterday);
			 List<ObjectLibEntity> yesterdayObjectLib = storeService.getObjectData(queryCondition);
			 
			 Map<String, Long> yesterdayResourceMap = getYesterdayObjectNum(yesterdayObjectLib);
			 List<Long> yesterdayObjectNum = new ArrayList<>();
			 for (String name : objectName) {
				 Long num = yesterdayResourceMap.get(name);
				 yesterdayObjectNum.add(StringUtil.isEmpty(num) ? 0L : num);
			 }
			 objectJson.put("yesterdayObjectNum", yesterdayObjectNum);
			 object.put("objectJson", objectJson);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取九大资源实时数据量和昨日数据量
	 * @param object
	 */
	private void getNineResourceData(JSONObject object) {
		Map<String, Object> queryCondition = new HashMap<String, Object>();
		List<String> resourceName = new ArrayList<>();
		try {
			JSONObject resourceJson = new JSONObject();
			List<NineResourceEntity> nineResource = storeService.getNineResourceData(queryCondition);
			if (nineResource != null && !nineResource.isEmpty()) {
				List<Long> resourceNum = new ArrayList<>();
				for (NineResourceEntity nineResourceEntity : nineResource) {
					resourceName.add(nineResourceEntity.getResource());
					resourceNum.add(nineResourceEntity.getDataNum());
				}
				resourceJson.put("resourceName", resourceName);
				resourceJson.put("resourceNum", resourceNum);
			}
			queryCondition.put("yesterday", DateUtil.getDateBefore(new Date(), 1));
			List<NineResourceEntity> yesterdayResourceNum = storeService.getNineResourceData(queryCondition);
			Map<String, Long> yesterdayResourceMap = getYesterdayResourceNum(yesterdayResourceNum);
			
			List<Long> yesterdayNum = new ArrayList<>();
			for (String name : resourceName) {
				Long num = yesterdayResourceMap.get(name);
				yesterdayNum.add(StringUtil.isEmpty(num) ? 0L : num);
			}
			resourceJson.put("yesterdayNum", yesterdayNum);
			object.put("resourceJson", resourceJson);
		} catch (Exception e) {
			LOG.error(">>>>>get nine resource failed...", e);
		}
	}

	private Map<String, Long> getYesterdayObjectNum(List<ObjectLibEntity> yesterdayObjectLib) {
		Map<String, Long> yesterdayResourceMap = new HashMap<>();
		if (yesterdayObjectLib != null && !yesterdayObjectLib.isEmpty()) {
			for (ObjectLibEntity objectLibEntity : yesterdayObjectLib) {
				yesterdayResourceMap.put(objectLibEntity.getObject(), objectLibEntity.getDataNum());
			}
		}
		return yesterdayResourceMap;
	}

	private Map<String, Long> getYesterdayResourceNum(List<NineResourceEntity> yesterdayResourceNum) {
		Map<String, Long> yesterdayResourceMap = new HashMap<>();
		if (yesterdayResourceNum != null && !yesterdayResourceNum.isEmpty()) {
			for (NineResourceEntity nineResourceEntity : yesterdayResourceNum) {
				yesterdayResourceMap.put(nineResourceEntity.getResource(), nineResourceEntity.getDataNum());
			}
		}
		return yesterdayResourceMap;
	}

}
