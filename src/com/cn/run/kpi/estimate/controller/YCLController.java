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
import com.cn.run.kpi.estimate.common.ActionConfig;
import com.cn.run.kpi.estimate.common.LogConstants;
import com.cn.run.kpi.estimate.common.YCLConstants;
import com.cn.run.kpi.estimate.entity.YCLInfo;
import com.cn.run.kpi.estimate.entity.TransInfo;
import com.cn.run.kpi.estimate.entity.YCLExample;
import com.cn.run.kpi.estimate.service.YCLDataService;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.StringUtil;

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
	 * 获取数据源
	 * @return
	 */
	@RequestMapping("/getDataSource")
	@ResponseBody
	public JSONObject getDataSource() {
		JSONObject jsonObject = new JSONObject();
		List<YCLInfo> list = yclDataService.getDataSource();
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
		List<YCLInfo> list = yclDataService.getBProtocol();
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
		List<YCLInfo> list = yclDataService.getSProtocol();
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
		List<YCLInfo> list = yclDataService.getActionType();
		if(null!=list&&!list.isEmpty()) {
			for (YCLInfo info : list) {
				String actionTypeDesc = ActionConfig.getValue(info.getChkVal());
				info.setChkDisplay(actionTypeDesc);
			}
			
			jsonObject.put("result", list);
		}
		return jsonObject;
	}
	
	
	
	/**
	 * 获取ycl数据列表
	 * @return  Map<String,Object>
	 */
	@RequestMapping("getList")
	@ResponseBody
	public Map<String,Object> getList(HttpServletRequest request,YCLInfo yclData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Integer start = Integer.valueOf(request.getParameter("currentPage"));
			Integer length = Integer.valueOf(request.getParameter("pageSize"));
			yclData.setStart(start-1);
			yclData.setLength(length);
			yclData.setCreateDate(DateUtil.getDate());
			
			List<YCLInfo> yclDatas = yclDataService.getList(yclData);
			if(!yclDatas.isEmpty() && null != yclDatas) {
				for (YCLInfo yclInfo : yclDatas) {
					String actionTypeDesc = ActionConfig.getValue(yclInfo.getActionType());
					yclInfo.setActionTypeDesc(actionTypeDesc);
				}
			}
			
			Integer total = yclDataService.getTotal(yclData);

			resultMap.put("total", total);
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
			YCLInfo yclInfo = yclDataService.selectById(yclData.getId());
			yclInfo.setColName(yclData.getColName());
			//yclData.setCreateDate(DateUtil.getDate());
			List<YCLInfo> yclList = yclDataService.selectDetail(yclInfo);
			
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
	public JSONObject getExampleList(YCLInfo yclData) {
		JSONObject json = new JSONObject();
		try {
			YCLInfo yclInfo = yclDataService.selectById(yclData.getId());
			YCLExample yclExample = new YCLExample();
			yclExample.setDsCode(yclInfo.getDsCode());
			yclExample.setbProtocolCode(yclInfo.getbProtocolCode());
			List<YCLExample> yclExampleDatas = yclDataService.getExampleList(yclExample);
			if(!yclExampleDatas.isEmpty()&&null != yclExampleDatas) {
				for (YCLExample yclExample2 : yclExampleDatas) {
					String val = yclExample2.getSourceDesc();
					yclExample2.setSourceDesc(YCLConstants.getExample(val));
				}
			}
			
			Integer total = YCLConstants.NORMAL_SIZE+YCLConstants.UNNORMAL_SIZE;
			
			json.put("total", total);
			json.put("data", yclExampleDatas);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return json;
	}
}
