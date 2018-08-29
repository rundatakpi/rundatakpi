package com.cn.run.kpi.estimate.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.estimate.dao.StoreLogDao;
import com.cn.run.kpi.estimate.entity.LogField;
import com.cn.run.kpi.estimate.entity.LogInfo;
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
	public List<LogInfo> getList(LogInfo storeLogData) {
		return storeLogDao.getList(storeLogData);
	}

	/**
	 * 查询同一数据源下大协议总数
	 */
	@Override
	public Integer getTotal(LogInfo storeLogData) {
		return storeLogDao.getTotal(storeLogData);
	}

	/**
	 * 查询大协议某属性数据近一周趋势
	 */
	@Override
	public List<LogInfo> getOutDetail(LogInfo storeLogData) {
		return storeLogDao.getOutDetail(storeLogData);
	}

	/**
	 * 获取数据源类型
	 */
	@Override
	public List<LogInfo> getDataSource() {
		return storeLogDao.getDataSource();
	}

	/**
	 * 获取大协议类型
	 */
	@Override
	public List<LogInfo> getBProtocol() {
		return storeLogDao.getBProtocol();
	}

	/**
	 * 获取小协议类型
	 */
	@Override
	public List<LogInfo> getSProtocol() {
		return storeLogDao.getSProtocol();
	}
	
	
	/**
	 * 根据id获取入库日志信息
	 */
	@Override
	public LogInfo selectById(long id) {
		return storeLogDao.selectById(id);
	}

	/**
	 * 查询某大协议下对应的所有小协议及字段信息
	 */
	@Override
	public List<LogInfo> getMore(LogInfo logInfo) {
		
		List<LogInfo> logInfoList = storeLogDao.getSProtocolList(logInfo);
		if(logInfoList!=null&&!logInfoList.isEmpty()) {
			for (LogInfo logInfo2 : logInfoList) {
				List<LogField> list = storeLogDao.getFields(logInfo2);
				logInfo2.setLogFieldList(list);
			}
		}
		
		return logInfoList;
	}

	
	/**
	 * 获取小协议个数
	 */
	@Override
	public Integer getMoreTotal(LogInfo logInfo) { 
		return storeLogDao.getMoreTotal(logInfo);
	}


	/**
	 * 查询小协议某指标近一周值
	 */
	@Override
	public List<LogField> getInDetail(LogField field) {
		return storeLogDao.getInDetail(field);
	}


}
