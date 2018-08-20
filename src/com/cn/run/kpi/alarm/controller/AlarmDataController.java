package com.cn.run.kpi.alarm.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.cn.run.kpi.alarm.entity.AlarmData;
import com.cn.run.kpi.alarm.service.AlarmDataService;
import com.cn.run.kpi.alarm.utils.ExportExcelUtil;

import net.sf.json.JSONArray;
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
	public void getList(HttpServletRequest request,HttpServletResponse response,AlarmData alarmData){
		// 每页显示条数。
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		// 当前页码。
		int currentPage = Integer.valueOf(request.getParameter("currentPage"));
		System.out.println("begin...");
		Integer start = (currentPage - 1) * pageSize;
		alarmData.setStart(start);
		alarmData.setLength(pageSize);
		List<AlarmData> alarmDatas = alarmDataService.getList(alarmData);
		Integer total = alarmDataService.getTotal(alarmData);
		// 新建JSON对象。
		JSONObject resultJsonObject = new JSONObject();
		
		// 将值赋给json对象。（total和data）
		resultJsonObject.element("total", total);
		resultJsonObject.element("data", JSONArray.fromObject(alarmDatas));
		
		// 将生成的json字符串传给response，再给前台。
		writeJson(resultJsonObject.toString(), response);
	}
	
	/**
	 * 删除某一条告警信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public void delAlarms(Integer id,HttpServletResponse response) {
		JSONObject json = new JSONObject();
		boolean flag=false;
		try {
			alarmDataService.del(id);
			flag=true;
		}catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
		if(flag){
			json.element("flag", "1");
		}else{
			json.element("flag", "2");
		}
		writeJson(json.toString(), response);
	}
	
	/**
	 * 修改告警处理信息
	 * @param alarmData
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public void editAlarm(AlarmData alarmData,HttpServletResponse response) {
		JSONObject json = new JSONObject();
		boolean flag=false;
		try {
			alarmDataService.edit(alarmData);
			flag=true;
		}catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
		if(flag){
			json.element("flag", "1");
		}else{
			json.element("flag", "2");
		}
		writeJson(json.toString(), response);
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
	public void exportExcel(AlarmData alarmData,HttpServletResponse response,HttpServletRequest request){
		try {
			System.out.println("begin...");
			List<String> listName = new ArrayList<>();
	        listName.add("主键ID");
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
	        exportBeanExcelUtil.exportExcel("告警信息表",listName,listId,list,response,request);
	        
	        System.out.println("sucess...");
		}catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
	
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
	
	/**
	 * 把json写入页面
	 * @param json
	 * @param response
	 */
	protected void writeJson(String json,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf8");
		try {
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (Exception e) {
			try {
				response.getWriter().close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
