package com.cn.run.kpi.datamonitor.compress.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.compress.entity.BacklogEntity;
import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressNumEntity;
import com.cn.run.kpi.datamonitor.compress.service.CompressService;
import com.cn.run.kpi.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * 积压监测
 * @author zg
 *
 */
@Controller
@RequestMapping("/backlog")
public class CompressController {
	
	@Autowired
	private CompressService compressService;

	@RequestMapping("/init")
	@ResponseBody
	public String init() {
		JSONObject object = new JSONObject();
		
		Callable<JSONObject> kafkaNumCallable = new Callable<JSONObject>() {

			@Override
			public JSONObject call() throws Exception {
		        JSONObject kafkaNumJson = new JSONObject();
				List<String> date = new ArrayList<>();
				List<Long> num = new ArrayList<>();
				List<KafkaCompressNumEntity> kafkaCompressNum = compressService.getKafkaCompressNum();
				if (kafkaCompressNum != null && !kafkaCompressNum.isEmpty()) {
					for (KafkaCompressNumEntity kafkaCompressNumEntity : kafkaCompressNum) {
						date.add(kafkaCompressNumEntity.getDate());
						num.add(kafkaCompressNumEntity.getNum());
					}
					kafkaNumJson.put("date", date);
					kafkaNumJson.put("kafkaNum", num);
				}
				return kafkaNumJson;
			}
			
		};
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<JSONObject> future = executorService.submit(kafkaNumCallable);
		
		
//		FutureTask<JSONObject> futureTask = new FutureTask<>(kafkaNumCallable);
		try {
			object.put("kafkaNumJson", future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		getBacklogData(object);
		
		return object.toString();
	}

	private void getBacklogData(JSONObject object) {
		List<BacklogEntity> backlog = compressService.getKafkaBacklogData();
		if (backlog != null && !backlog.isEmpty()) {
			List<String> date = new ArrayList<String>();
			List<Long> machineBacklogNum = new ArrayList<>();
			List<Long> machineBacklogSize = new ArrayList<>();
			List<Long> kafkaBacklogNum = new ArrayList<>();
			List<Long> kafkaBacklogSize = new ArrayList<>();
			for (BacklogEntity backlogEntity : backlog) {
				date.add(backlogEntity.getCreateDate());
				machineBacklogNum.add(StringUtil.isEmpty(backlogEntity.getMachineBacklogNum()) ? 0L : backlogEntity.getMachineBacklogNum());
				machineBacklogSize.add(StringUtil.isEmpty(backlogEntity.getMachineBacklogSize()) ? 0L : backlogEntity.getMachineBacklogSize());
				kafkaBacklogNum.add(StringUtil.isEmpty(backlogEntity.getKafkaBacklogNum()) ? 0L : backlogEntity.getKafkaBacklogNum());
				kafkaBacklogSize.add(StringUtil.isEmpty(backlogEntity.getKafkaBacklogSize()) ? 0L : backlogEntity.getKafkaBacklogSize());
			}
			
			object.put("date", date);
			object.put("machineBacklogNum", machineBacklogNum);
			object.put("machineBacklogSize", machineBacklogSize);
			object.put("kafkaBacklogNum", kafkaBacklogNum);
			object.put("kafkaBacklogSize", kafkaBacklogSize);
		}
	}
}
