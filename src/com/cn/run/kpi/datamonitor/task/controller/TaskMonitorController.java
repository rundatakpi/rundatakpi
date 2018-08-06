package com.cn.run.kpi.datamonitor.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.run.kpi.datamonitor.task.service.TaskMonitorService;

/**
 * 任务监测-Controller
 * @author zg
 *
 */
@Controller
@RequestMapping("/task")
public class TaskMonitorController {
	
	@Autowired
	private TaskMonitorService taskMonitorService;
	
}
