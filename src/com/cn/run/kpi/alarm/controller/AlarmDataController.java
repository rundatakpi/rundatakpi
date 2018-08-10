package com.cn.run.kpi.alarm.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;
import com.cn.run.kpi.alarm.utils.ExportExcelUtil;
import com.cn.run.kpi.sample.controller.SampleMonitorController;
import net.sf.json.JSON;
import net.sf.json.JSONObject;


/**
 * 告警中心模块Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/alarmData")
public class AlarmDataController {
	
	private static final Logger LOG = Logger.getLogger(AlarmDataController.class);

	@Autowired
	private AlarmDataService alarmDataService;
	
	/**
	 * 获取告警信息列表
	 * @param request
	 * @param alarmData
	 * @return	
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,AlarmData alarmData){
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Integer start = Integer.valueOf(request.getParameter("start"));
		Integer length = Integer.valueOf(request.getParameter("length"));
		alarmData.setStart(start);
		alarmData.setLength(length);
		try {
			List<AlarmData> alarmDatas = alarmDataService.getList(alarmData);
			Integer total = alarmDataService.getTotal(alarmData);
			resultMap.put("recordsTotal", total);
			resultMap.put("recordsFiltered", total);
			resultMap.put("data", alarmDatas);
		}catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return resultMap;
	}
	
	/**
	 * 删除某一条告警信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public JSONObject delAlarms(Integer id) {
		JSONObject json = new JSONObject();
		try {
			alarmDataService.del(id);
		}catch(Exception e) {
			json.put("msg", "操作失败");
			LOG.error(e.getMessage(), e);
		}
		
		json.put("msg", "操作成功！");
		
		return json;
	}
	
	/**
	 * 修改告警处理信息
	 * @param alarmData
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject editAlarm(AlarmData alarmData) {
		JSONObject json = new JSONObject();
		try {
			alarmDataService.edit(alarmData);
		}catch(Exception e) {
			json.put("msg", "操作失败");
			LOG.error(e.getMessage(), e);
		}
		
		json.put("msg", "操作成功");
		return json;
	} 
	
	/**
	 * 查询某一条告警信息的详情
	 * @param alarmData
	 * @return
	 */
	@RequestMapping("/detail")
	@ResponseBody
	public Map<String,Object> getDetail(AlarmData alarmData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		return resultMap;
	}
	
	
	/**
	 * 批量导出告警信息
	 * @param alarmData
	 * @return
	 */
	@RequestMapping("/exportExcel")
	@ResponseBody
	public JSONObject exportExcel(AlarmData alarmData,HttpServletResponse response){
		JSONObject json = new JSONObject();
		try {
				
			List<String> listName = new ArrayList<>();
	        listName.add("编号");
	        listName.add("告警时间");
	        listName.add("告警级别");
	        listName.add("告警内容");
	        listName.add("告警状态");
	        
	        List<String> listId = new ArrayList<>();
	        listId.add("id");
	        listId.add("alarmTime");
	        listId.add("alarmLevel");
	        listId.add("alarmContent");
	        listId.add("processState");
	        
	        List<AlarmData> list = alarmDataService.getAllData(alarmData);
	        
	        ExportExcelUtil<AlarmData> exportBeanExcelUtil = new ExportExcelUtil();
	        exportBeanExcelUtil.exportExcel("告警信息表",listName,listId,list);
	        
	        
		}catch(Exception e) {
			json.put("msg", "下载失败！");
			LOG.error(e.getMessage(), e);
		}
		json.put("msg", "下载成功！文件存放在D盘根目录下。");
		return json;
	
	}
	
	/**
	 * 添加一条告警信息
	 * @param alarmData
	 * @return
	 */
	@RequestMapping("/insertInfo")
	@ResponseBody
	public JSONObject insertInfo(AlarmData alarmData) {
		JSONObject resultJson = new JSONObject();
		try {
			alarmDataService.insertInfo(alarmData);
		}catch(Exception e){
			resultJson.put("msg", "添加失败");
			LOG.error(e.getMessage(),e);
		}
		resultJson.put("msg", "添加成功");
		return resultJson;
	}
}
