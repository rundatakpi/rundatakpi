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
import com.cn.run.kpi.alarm.controller.AlarmDataController;
import com.cn.run.kpi.estimate.common.ActionConfig;
import com.cn.run.kpi.estimate.entity.TransInfo;
import com.cn.run.kpi.estimate.service.TransService;
import com.cn.run.kpi.utils.DateUtil;
import net.sf.json.JSONObject;




/**
 * 格转接入数据质量Controller
 * @author chenyan
 * 2018年8月6日
 *
 */

@Controller
@RequestMapping("/transform")
public class TransController {
	
	private static final Logger LOG = Logger.getLogger(AlarmDataController.class);
	
	@Autowired
	private TransService transformService;
	
	/**
	 * 获取数据源
	 * @return
	 */
	@RequestMapping("/getDataSource")
	@ResponseBody
	public JSONObject getDataSource() {
		JSONObject jsonObject = new JSONObject();
		List<TransInfo> list = transformService.getDataSource();
		if(null!=list&&!list.isEmpty()) {
			jsonObject.put("trans", list);
		}
		return jsonObject;
	}
	
	/**
	 * 获取大协议
	 * @param transInfo
	 * @return
	 */
	@RequestMapping("/getBProtocol")
	@ResponseBody
	public JSONObject getBProtocol(TransInfo transInfo) {
		JSONObject jsonObject = new JSONObject();
		List<TransInfo> list = transformService.getBProtocol(transInfo);
		if(null!=list&&!list.isEmpty()) {
			jsonObject.put("trans", list);
		}
		return jsonObject;
	}
	
	/**
	 * 获取小协议
	 * @param transInfo
	 * @return
	 */
	@RequestMapping("/getSProtocol")
	@ResponseBody
	public JSONObject getSProtocol(TransInfo transInfo) {
		JSONObject jsonObject = new JSONObject();
		List<TransInfo> list = transformService.getSProtocol(transInfo);
		if(null!=list&&!list.isEmpty()) {
			jsonObject.put("trans", list);
		}
		return jsonObject;
	}
	
	/**
	 * 获取动作类型
	 * @param transInfo
	 * @return
	 */
	@RequestMapping("/getActionType")
	@ResponseBody
	public JSONObject getActionType(TransInfo transInfo) {
		JSONObject jsonObject = new JSONObject();
		List<TransInfo> list = transformService.getActionType(transInfo);
		if(null!=list&&!list.isEmpty()) {
			for (TransInfo info : list) {
				String actionTypeDesc = ActionConfig.getValue(info.getActionType());
				info.setActionTypeDesc(actionTypeDesc);
			}
			
			jsonObject.put("trans", list);
		}
		return jsonObject;
	}
	
	
	
	/**
	 * 展示格转接入数据列表
	 * @return List<TransformData>
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,TransInfo transformData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			
			Integer start = Integer.valueOf(request.getParameter("start"));
			Integer length = Integer.valueOf(request.getParameter("length"));
			transformData.setStart(start);
			transformData.setLength(length);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = sdf.format(new Date());
			transformData.setCreateDate(currDate);
			
			List<TransInfo> tanformDatas = transformService.getList(transformData);
			for (TransInfo transInfo : tanformDatas) {
				String actionType = transInfo.getActionType();
				String actionTypeDesc = ActionConfig.getValue(actionType);
				transInfo.setActionTypeDesc(actionTypeDesc);
			}
			
			Integer total = transformService.getTotal(transformData);
			resultMap.put("recordsTotal", total);
			resultMap.put("recordsFiltered",total);
			resultMap.put("data", tanformDatas);
		}catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return resultMap;
	}
	
	/**
	 * 查询某种协议  输入数据条数/输入数据字段填充率...   近一周数据量
	 * @param transformStr
	 */
	@RequestMapping("/getDetail")
	@ResponseBody
	public JSONObject getDetail(TransInfo tranformData){
		JSONObject json = new JSONObject();
		
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String startDateStr = DateUtil.getDateBefore(new Date(), 7);
			String endDateStr = sdf.format(new Date());
			tranformData.setStartTime(startDateStr);
			tranformData.setEndTime(endDateStr);
			List<TransInfo> transformList = transformService.selectDetail(tranformData);	
			json.put("data",transformList);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return json;
		
	}
	
}
