package com.cn.run.kpi.estimate.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.run.kpi.estimate.entity.ObjInfo;
import com.cn.run.kpi.estimate.service.ObjExtractService;
import com.cn.run.kpi.utils.DateUtil;

import net.sf.json.JSONObject;



/**
 * 对象化提取Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/obj")
public class ObjExtractController {
	
	private static final Logger LOGGER = Logger.getLogger(ObjExtractController.class);
	
	@Autowired
	private ObjExtractService objectExtractService;
	
	@RequestMapping("/getList")
	@ResponseBody
	public JSONObject getList(HttpServletRequest request,ObjInfo objInfo) {
		JSONObject jsonObject = new JSONObject();
		try {
			Integer start = Integer.valueOf(request.getParameter("currentPage"));
			Integer length = Integer.valueOf(request.getParameter("pageSize"));
			objInfo.setCreateDate(DateUtil.getDate());
			objInfo.setStart(start-1);
			objInfo.setLength(length);
			
			List<ObjInfo> list = objectExtractService.getList(objInfo);
			Integer total = objectExtractService.getTotal(objInfo);
			
			jsonObject.put("data", list);
			jsonObject.put("total", total);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return jsonObject;
	}
}
