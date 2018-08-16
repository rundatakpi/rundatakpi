package com.cn.run.kpi.datamonitor.task.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.datamonitor.store.controller.StoreMonitorController;
import com.cn.run.kpi.datamonitor.task.entity.CompletedTask;
import com.cn.run.kpi.datamonitor.task.entity.FailedTask;
import com.cn.run.kpi.datamonitor.task.entity.RunningTask;
import com.cn.run.kpi.datamonitor.task.entity.Task;
import com.cn.run.kpi.datamonitor.task.service.TaskMonitorService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 任务监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/task")
public class TaskMonitorController {
	private static final Logger LOG = Logger.getLogger(StoreMonitorController.class);
	
	@Autowired
	private TaskMonitorService taskMonitorService;
	
	@RequestMapping("/init")
	@ResponseBody
	public String init(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		
		// 获取运行任务数据
		getRunningTaskDate(object);
		
		// 获取已完成任务数据
		getCompletedTaskData(object);
		
		return object.toString();
	}
	
	@RequestMapping("/runningJob")
	@ResponseBody
	public String getRunningJob(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		Map<String, Object> queryCondition = new HashMap<>();
		
		try {
			List<Task> runningTask = taskMonitorService.getRunningTask(queryCondition);
			int total = 0;
			if (runningTask != null && !runningTask.isEmpty()) {
				total = runningTask.size();
				array = JSONArray.fromObject(runningTask);
			}
			object.put("total", total);
			object.put("data", array);
		} catch (Exception e) {
			LOG.error(">>>>>get running task failed...", e);
		}
		System.out.println(object.toString());
		return object.toString();
	}
	
	@RequestMapping("/failJob")
	@ResponseBody
	public String getFailedJob(HttpServletRequest request, HttpServletResponse response) {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		Map<String, Object> queryCondition = new HashMap<>();
		
		try {
			List<FailedTask>  failedTask = taskMonitorService.getFailedTask(queryCondition);
			if (failedTask != null && !failedTask.isEmpty()) {
				int total = failedTask.size();
				array = JSONArray.fromObject(failedTask);
				object.put("total", total);
				object.put("data", array);
			}
		} catch (Exception e) {
			LOG.error(">>>>>get failed task failed...", e);
		}
		System.out.println(object.toString());
		return object.toString();
	}

	/**
	 * 获取已完成任务数据
	 * @param object
	 */
	private void getCompletedTaskData(JSONObject object) {
		try {
			List<CompletedTask> completedTask = taskMonitorService.getCompletedTaskData("");
			JSONObject completedJson = new JSONObject();
			if (completedTask != null && !completedTask.isEmpty()) {
				List<String> completedDate = new ArrayList<>();
				List<Long> completedNum = new ArrayList<>();
				for (CompletedTask completed : completedTask) {
					completedDate.add(completed.getTime());
					completedNum.add(completed.getTaskNum());
				}
				completedJson.put("runDate", completedDate);
				completedJson.put("runningNum", completedNum);
			}
			object.put("completedJson", completedJson);
		} catch (Exception e) {
			LOG.error(">>>>get complete task num failed", e);
		}
	}

	/**
	 * 获取运行任务数据
	 * @param object
	 */
	private void getRunningTaskDate(JSONObject object) {
		try {
		    List<RunningTask> runningTask = taskMonitorService.getRunningTaskData("");
			JSONObject runningJson = new JSONObject();
			if (runningTask != null && !runningTask.isEmpty()) {
		    List<String> runningDate = new ArrayList<>();
			List<Long> runningNum = new ArrayList<>();
			for (RunningTask run : runningTask) {
				runningDate.add(run.getTime());
				runningNum.add(run.getTaskNum());
				}
				runningJson.put("runDate", runningDate);
				runningJson.put("runningNum", runningNum);
			}
			object.put("runningJson", runningJson);
		} catch (Exception e) {
			LOG.error(">>>>get running task num failed", e);
		}
	}
	
}
