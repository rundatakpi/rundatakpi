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
			jsonObject.put("result", list);
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
	public JSONObject getBProtocol() {
		JSONObject jsonObject = new JSONObject();
		List<TransInfo> list = transformService.getBProtocol();
		if(null!=list&&!list.isEmpty()) {
			jsonObject.put("result", list);
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
	public JSONObject getSProtocol() {
		JSONObject jsonObject = new JSONObject();
		List<TransInfo> list = transformService.getSProtocol();
		if(null!=list&&!list.isEmpty()) {
			jsonObject.put("result", list);
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
	public JSONObject getActionType() {
		JSONObject jsonObject = new JSONObject();
		List<TransInfo> list = transformService.getActionType();
		if(null!=list&&!list.isEmpty()) {
			for (TransInfo info : list) {
				String actionTypeDesc = ActionConfig.getValue(info.getChkVal());
				info.setChkDisplay(actionTypeDesc);
			}
			
			jsonObject.put("result", list);
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
			if(null == transformData) {
				return resultMap;
			}
			
			Integer start = Integer.valueOf(request.getParameter("currentPage"));
			Integer length = Integer.valueOf(request.getParameter("pageSize"));
			transformData.setStart(start-1);
			transformData.setLength(length);
			transformData.setCreateDate(DateUtil.getDate());
			
			List<TransInfo> tanformDatas = transformService.getList(transformData);
			for (TransInfo transInfo : tanformDatas) {
				String actionType = transInfo.getActionType();
				String actionTypeDesc = ActionConfig.getValue(actionType);
				transInfo.setActionTypeDesc(actionTypeDesc);
			}
			
			Integer total = transformService.getTotal(transformData);
			resultMap.put("total",total);
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
			if(null!= tranformData) {
				TransInfo transInfo = transformService.selectById(tranformData.getId());
				transInfo.setColName(tranformData.getColName());
				//transInfo.setCreateDate(DateUtil.getDate());
				List<TransInfo> transformList = transformService.selectDetail(transInfo);	
				json.put("data",transformList);
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return json;
		
	}
	
}
