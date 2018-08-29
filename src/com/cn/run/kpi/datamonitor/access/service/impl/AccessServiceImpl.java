package com.cn.run.kpi.datamonitor.access.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.commons.content.Constants;
import com.cn.run.kpi.datamonitor.access.dao.AccessDao;
import com.cn.run.kpi.datamonitor.access.entity.AccessDiscardEntiy;
import com.cn.run.kpi.datamonitor.access.entity.AccessInputEntity;
import com.cn.run.kpi.datamonitor.access.service.AccessService;
import com.cn.run.kpi.scheduler.entity.QueryCondition;
import com.cn.run.kpi.utils.DateUtil;
import com.cn.run.kpi.utils.FileUtils;
import com.cn.run.kpi.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * 接入监测服务实现类
 * @author zg
 *
 */
@Service
public class AccessServiceImpl implements AccessService {
	
	private static final Logger LOG = Logger.getLogger(AccessServiceImpl.class); 
	
	@Autowired
	private AccessDao accessDao;

	@Override
	public List<AccessInputEntity> getAccessInputData(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getAccessInputData(queryCondition);
	}

	@Override
	public List<AccessDiscardEntiy> getAccessDiscardData(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getAccessDiscardData(queryCondition);
	}

	@Override
	public Long getTotalAccessInputNum(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getTotalAccessInputNum(queryCondition);
	}

	@Override
	public Double getAverageAccessInputNum(Map<String, Object> queryCondition) throws Exception {
		return accessDao.getAverageAccessInputNum(queryCondition);
	}

	@Override
	public Long getAccessInputNumByDay(Map<String, Object> queryCondition) throws Exception {
		queryCondition.put("createDate", DateUtil.getDateBefore(new Date(), 1));
		return accessDao.getAccessInputNumByDay(queryCondition);
	}

	@Override
	public void getClassfication() throws Exception {
		List<String> classfiction = accessDao.getClassfication();
		createJson(classfiction, "classfiction");
	}

	@Override
	public void getDataSource() throws Exception {
		List<String> dataSource = accessDao.getDataSource();
		createJson(dataSource, "datasource");
		
	}
	
	private void createJson(List<String> query, String fileName) {
		List<String> q = new ArrayList<>();
		q.add("全部");
		q.addAll(query);
		createJsonFile(q, fileName);
	}

	@Override
	public void getBprotocol() throws Exception {
		List<String> bProtocol = accessDao.getBprotocol();
		createJson(bProtocol, "bProtocol");
	}

	@Override
	public void getSprotocol() throws Exception {
		List<String> sProtocol = accessDao.getSprotocol();
		createJson(sProtocol, "sProtocol");
	}

	@Override
	public void getAction() throws Exception {
		List<String> action = accessDao.getAction();
		createJson(action, "action");
	}

	@Override
	public void getCollectPlace() throws Exception {
		List<String> collectPlace = accessDao.getCollectPlace();
		createJson(collectPlace, "collectPlace");
	}
	
	private void createJsonFile(List<String> query, String fileName) {
		if (query != null && !query.isEmpty()) {
			List<QueryCondition> condition = new ArrayList<>();
			for (int i = 0; i < query.size(); i++) {
				QueryCondition queryCondition = new QueryCondition();
				queryCondition.setChkVal(i + "");
				queryCondition.setChkDisplay(query.get(i));
				condition.add(queryCondition);
			}
			
			JSONObject object = new JSONObject();
			object.put("result", condition);
			String jsonString = object.toString();
			String root = Constants.ROOT;
			if (StringUtil.isNull(root)) {
				root = System.getProperty("web.root");
			}
			String filePath = root + "/kpi/json/";
			FileUtils.createJsonFile(jsonString, filePath, fileName);
		}
	}

	@Override
	public void initJson() {
		try {
			//getClassfication();
		} catch (Exception e) {
			LOG.error(">>>>get classfication failed", e);
		}
		
		try {
			getDataSource();
		} catch (Exception e) {
			LOG.error(">>>>get datasource failed", e);
		}
		
		try {
			getBprotocol();
		} catch (Exception e) {
			LOG.error(">>>>get bProtocol failed", e);
		}
		
		try {
			getSprotocol();
		} catch (Exception e) {
			LOG.error(">>>>get sProtocol failed", e);
		}
		
		try {
			getAction();
		} catch (Exception e) {
			LOG.error(">>>>get action failed", e);
		}
		
		try {
			getCollectPlace();
		} catch (Exception e) {
			LOG.error(">>>>get collect place failed", e);
		}
	}
	
	
}
