package com.cn.run.kpi.estimate.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.run.kpi.estimate.common.LogConstants;
import com.cn.run.kpi.estimate.entity.YCLInfo;
import com.cn.run.kpi.estimate.entity.YCLExample;
import com.cn.run.kpi.estimate.service.YCLDataService;
import com.cn.run.kpi.utils.DateUtil;
import net.sf.json.JSONObject;




/**
 * 预处理数据质量Controller
 * @author chenyan
 * 2018年8月6日
 *
 */
@Controller
@RequestMapping("/ycl")
public class YCLController {
	
	private static final Logger LOGGER = Logger.getLogger(YCLController.class);
	
	@Autowired
	private YCLDataService yclDataService;
	
	
	/**
	 * 获取ycl数据列表
	 * @return  Map<String,Object>
	 */
	@RequestMapping("getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,YCLInfo yclData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Integer start = Integer.valueOf(request.getParameter("start"));
			Integer length = Integer.valueOf(request.getParameter("length"));
			yclData.setStart(start);
			yclData.setLength(length);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(new Date());
			yclData.setCreateDate(currDate);
			
			List<YCLInfo> yclDatas = yclDataService.getList(yclData);
			Integer total = yclDataService.getTotal(yclData);
			
			resultMap.put("recordsTotal", total);
			resultMap.put("recordsFiltered", total);
			resultMap.put("data", yclDatas);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return resultMap;
	}
	
	/**
	 * 查询某种协议  输入数据条数/输入数据字段填充率...   近一周数据量
	 * @param transformStr
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public JSONObject getDetail(YCLInfo yclData){
		JSONObject json = new JSONObject();

		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String startDateStr = DateUtil.getDateBefore(new Date(), 7);
			yclData.setStartTime(startDateStr);
			String endDateStr = sdf.format(new Date());
			yclData.setEndTime(endDateStr);
			List<YCLInfo> yclList = yclDataService.selectDetail(yclData);
			
			json.put("data",yclList);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return json;
		
	}
	
	/**
	 * 获取某条预处理数据的样例包详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/getExampleList")
	@ResponseBody
	public JSONObject getExampleList(YCLExample yclExampleData) {
		JSONObject json = new JSONObject();
		try {

			List<YCLExample> yclExampleDatas = yclDataService.getExampleList(yclExampleData);
			Integer total = LogConstants.NORMAL_SIZE+LogConstants.UNNORMAL_SIZE;
			
			json.put("recordsTotal", total);
			json.put("recordsFiltered", total);
			json.put("data", yclExampleDatas);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return json;
	}
}
