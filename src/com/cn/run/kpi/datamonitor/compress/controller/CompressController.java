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
		Callable<JSONObject> kafkaNumCallable = new Callable<JSONObject>() {

			@Override
			public JSONObject call() throws Exception {
				JSONObject object = new JSONObject();
		        JSONObject kafkaJson = new JSONObject();
		        JSONObject machineJson = new JSONObject();
				List<String> date = new ArrayList<>();
				List<Long> kafkaNum = new ArrayList<>();
				List<Long> kafkaSize = new ArrayList<>();
				List<Long> machineNum = new ArrayList<>();
				List<Long> machineSize = new ArrayList<>();
				List<BacklogEntity> backlog = compressService.getKafkaBacklogData();
				if (backlog != null && !backlog.isEmpty()) {
					for (BacklogEntity backlogEntity : backlog) {
						date.add(backlogEntity.getCreateDate());
						kafkaNum.add(backlogEntity.getKafkaBacklogSize());
						kafkaSize.add(backlogEntity.getKafkaBacklogSize());
						machineNum.add(backlogEntity.getMachineBacklogNum());
						machineSize.add(backlogEntity.getMachineBacklogSize());
					}
					kafkaJson.put("date", date);
					kafkaJson.put("kafkaNum", kafkaNum);
					kafkaJson.put("kafkaSize", kafkaSize);
					
					machineJson.put("date", date);
					machineJson.put("machineNum", machineNum);
					machineJson.put("machineSize", machineSize);
					
					object.put("kafkaJson", kafkaJson);
					object.put("machineJson", machineJson);
				}
				return object;
			}
			
		};
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<JSONObject> future = executorService.submit(kafkaNumCallable);
		
		
//		FutureTask<JSONObject> futureTask = new FutureTask<>(kafkaNumCallable);
		JSONObject object = new JSONObject();
		try {
			object = future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		//getBacklogData(object);
		
		return object.toString();
	}

	@SuppressWarnings("unused")
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
