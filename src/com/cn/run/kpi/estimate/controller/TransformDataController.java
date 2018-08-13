package com.cn.run.kpi.estimate.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.run.kpi.alarm.controller.AlarmDataController;
import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.service.TransformDataService;
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
public class TransformDataController {
	
	private static final Logger LOG = Logger.getLogger(AlarmDataController.class);
	
	@Autowired
	private TransformDataService transformService;
	
	/**
	 * 展示格转接入数据列表
	 * @return List<TransformData>
	 */
	@RequestMapping("/getList")
	@ResponseBody
	public Map<String,Object> getList(TransformData transformData){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			List<TransformData> tanformDatas = transformService.getList(transformData);
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
	public JSONObject getDetail(Integer id,String colName){
		JSONObject json = new JSONObject();

		try {
			TransformData tranformData = transformService.selectById(id);

			tranformData.setColName(colName);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date beforeDate = sdf.parse(tranformData.getCreateTime());
			String beforeDateStr = DateUtil.getDateBefore(beforeDate, 7);
			tranformData.setStartTime(beforeDateStr);
			tranformData.setEndTime(tranformData.getCreateTime());
			List<TransformData> transformList = transformService.selectDetail(tranformData);
			
			json.put("data",transformList);

		} catch (ParseException e) {
			LOG.error(e.getMessage(), e);
		}

		return json;
		
	}
	
}
