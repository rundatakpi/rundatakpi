package com.cn.run.kpi.estimate.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.estimate.dao.StoreLogDao;
import com.cn.run.kpi.estimate.entity.StoreFieldData;
import com.cn.run.kpi.estimate.entity.StoreLogData;
import com.cn.run.kpi.estimate.service.StoreLogService;


/**
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class StoreLogServiceImpl implements StoreLogService {

	@Autowired
	private StoreLogDao storeLogDao;
	
	
	/**
	 * 查询同一数据源下大协议各指标均值（总值）
	 */
	@Override
	public List<StoreLogData> getList(StoreLogData storeLogData) {
		return storeLogDao.getList(storeLogData);
	}

	/**
	 * 查询同一数据源下大协议总数
	 */
	@Override
	public Integer getTotal(StoreLogData storeLogData) {
		return storeLogDao.getTotal(storeLogData);
	}

	/**
	 * 查询大协议某属性数据近一周趋势
	 */
	@Override
	public List<StoreLogData> selectDetail(StoreLogData storeLogData) {
		return storeLogDao.selectDetail(storeLogData);
	}

	@Override
	public List<StoreLogData> getTableInfo(StoreLogData storeLogData) {
		List<StoreLogData> storeList = storeLogDao.getProtocolInfo(storeLogData);
		for (StoreLogData storeLog : storeList) {
			List<StoreFieldData> fieldList =storeLogDao.getFieldInfo(storeLog);
			storeLog.setStoreFieldList(fieldList);
		}
		
		return storeList;
	}

	/**
	 * 获取每个字段的详情
	 */
	@Override
	public List<StoreLogData> getFeildDetail(StoreLogData storeLogData) {
		return storeLogDao.getFeildDetail(storeLogData);
	}

}
