package com.cn.run.kpi.exampledata.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.exampledata.entity.Account;
import com.cn.run.kpi.exampledata.entity.Alarm;
import com.cn.run.kpi.exampledata.entity.ExampleZip;
import com.cn.run.kpi.exampledata.entity.ExampleZipItem;
import com.cn.run.kpi.exampledata.entity.PageBean;
import com.cn.run.kpi.exampledata.service.ExampleZipService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author libingnan
 * 2018年8月18日
 */
@Controller
@RequestMapping("/exampleZipController")
public class ExampleZipController extends BaseController{
	@Autowired
	private ExampleZipService exampleZipService;
	
	@RequestMapping("/getList")
	@ResponseBody
	public String getList(HttpServletRequest request,HttpServletResponse response,ExampleZip example)  {
		Page page = setPages(example);
		List<ExampleZip> exampleZips= exampleZipService.getList(example);
		//writeJson(elements.toString(), response);
		JSONObject json = getJsonObject(exampleZips,(int)page.getTotal());
		return json.toString();
	}
	
	@RequestMapping("/getAlarmList")
	@ResponseBody
	public String getAlarmList(HttpServletRequest request,HttpServletResponse response,Alarm example)  {
		Page page = setPages(example);
		List<Alarm> exampleZips= exampleZipService.getAlarmList(example);
		//writeJson(elements.toString(), response);
		JSONObject json = getJsonObject(exampleZips,(int)page.getTotal());
		return json.toString();
	}
	
	
	@RequestMapping("/getSubList")
	@ResponseBody
	public String getSubList(HttpServletRequest request,HttpServletResponse response,ExampleZipItem exampleitem)  {
		List<ExampleZipItem> exampleZips= exampleZipService.getSubList(exampleitem);
		JSONObject json = getJsonObject(exampleZips,exampleZips.size());
		return json.toString();
	}
	
	@RequestMapping("/save")
	public void save(HttpServletRequest request,HttpServletResponse response,Account example)  {
		int r = exampleZipService.save(example);
		writeTxt(r+"", response);
	}
	
	private Page setPages(PageBean pg) {
		Integer pageNum = pg.getCurrentPage()!=null?pg.getCurrentPage():1;
        Integer pageSize = pg.getPageSize()!=null?pg.getPageSize():10;
		Page page = PageHelper.startPage(pageNum, pageSize, true);
		return page;
	}
	
	private JSONObject getJsonObject(List list,Integer size){
		JSONObject resultJsonObject = new JSONObject();
		// 将值赋给json对象。（total和data）
		resultJsonObject.element("total", size);
		resultJsonObject.element("data",JSONArray.fromObject(list));
		return resultJsonObject;
	}
}
