package com.cn.run.kpi.index.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressEntity;
import com.cn.run.kpi.datamonitor.compress.service.CompressService;
import com.cn.run.kpi.datamonitor.preprocess.entity.PreProcessEntity;
import com.cn.run.kpi.datamonitor.preprocess.service.PreProcessService;
import com.cn.run.kpi.datamonitor.store.entity.ObjectEntity;
import com.cn.run.kpi.datamonitor.store.service.StoreService;
import com.cn.run.kpi.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * 首页-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private PreProcessService preProcessService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private CompressService compressService;

	@RequestMapping("/init")
	@ResponseBody
	public String init(HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject object = new JSONObject();
		
		// 获取预处理检测数据
		List<PreProcessEntity> preProcessDate = preProcessService.getPreProcessData();
		
		JSONObject preProcess = new JSONObject();
		List<Long> inputList = new ArrayList<Long>();
		List<Long> outputList = new ArrayList<Long>();
		List<Long> discardList = new ArrayList<Long>();
		List<String> dataSourceList = new ArrayList<String>();
		
		if (preProcessDate != null && !preProcessDate.isEmpty()) {
			for (PreProcessEntity preProcessEntity : preProcessDate) {
				dataSourceList.add(preProcessEntity.getDataSource());
				inputList.add(StringUtil.isEmpty(preProcessEntity.getInputNum()) ? 0L : preProcessEntity.getInputNum());
				outputList.add(StringUtil.isEmpty(preProcessEntity.getOutputNum()) ? 0L : preProcessEntity.getOutputNum());
				discardList.add(StringUtil.isEmpty(preProcessEntity.getDiscardNum()) ? 0L : preProcessEntity.getDiscardNum());
			}
		}
		
		preProcess.put("dataSource", dataSourceList);
		preProcess.put("input", inputList);
		preProcess.put("output", outputList);
		preProcess.put("discard", discardList);
		
		object.put("preProcess", preProcess);
		
		// 获取对象化数据
		List<ObjectEntity> objectData = new ArrayList<>();
		try {
			objectData = storeService.getObjectData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Long> dataNumList = new ArrayList<Long>();
		List<Long> accurateNumList = new ArrayList<Long>();
		List<Long> associateNumList = new ArrayList<Long>();
		List<String> objectNameList = new ArrayList<String>();
		
		if (objectData != null && !objectData.isEmpty()) {
			for (ObjectEntity objectEntity : objectData) {
				objectNameList.add(objectEntity.getObjectName());
				dataNumList.add(StringUtil.isEmpty(objectEntity.getDataNum()) ? 0L : objectEntity.getDataNum());
				accurateNumList.add(StringUtil.isEmpty(objectEntity.getAccurateNum()) ? 0L : objectEntity.getAccurateNum());
				associateNumList.add(StringUtil.isEmpty(objectEntity.getAssociateNum()) ? 0L : objectEntity.getAssociateNum());
			}
		}
		
		
		
		
		// 获取Kafka积压数据
		List<KafkaCompressEntity> kafkaCompressData = compressService.getKafkaCompressData();
		List<Long> kafkaInputNum = new ArrayList<Long>();
		List<Long> kafkaCompressNum = new ArrayList<Long>();
		List<Long> kafkaProcessNum = new ArrayList<Long>();
		List<String> kafkaDate = new ArrayList<String>();
		
		if (kafkaCompressData != null && !kafkaCompressData.isEmpty()) {
			for (KafkaCompressEntity kafkaCompressEntity : kafkaCompressData) {
				kafkaDate.add(kafkaCompressEntity.getTime());
				kafkaInputNum.add(StringUtil.isEmpty(kafkaCompressEntity.getInputNum()) ? 0L : kafkaCompressEntity.getInputNum());
				kafkaCompressNum.add(StringUtil.isEmpty(kafkaCompressEntity.getCompressNum()) ? 0L : kafkaCompressEntity.getCompressNum());
				kafkaProcessNum.add(StringUtil.isEmpty(kafkaCompressEntity.getProcessNum()) ? 0L : kafkaCompressEntity.getProcessNum());
			}
		}
		
		// 获取数据存储数据
//		List<StoreEntity> storeData = storeService.getStoreData();
		return "";
	}
	
}
