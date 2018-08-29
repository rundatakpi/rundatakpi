package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.LogField;
import com.cn.run.kpi.estimate.entity.LogInfo;
import com.cn.run.kpi.estimate.entity.TransInfo;


/**
 * 入库日志数据Service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface StoreLogService {

	/**
	 * @param storeLogData
	 * @param length
	 * @return
	 */
	public List<LogInfo> getList(LogInfo storeLogData);

	/**
	 * @param storeLogData
	 * @return
	 */
	public Integer getTotal(LogInfo storeLogData);

	/**
	 * 
	 * @param tranformData
	 * @return
	 */
	public List<LogInfo> getOutDetail(LogInfo storeLogData);

	/**
	 * 获取数据源类型
	 * @return
	 */
	public List<LogInfo> getDataSource();

	/**
	 * 获取大协议类型
	 * @return
	 */
	public List<LogInfo> getBProtocol();

	/**
	 * 获取小协议类型
	 * @return
	 */
	public List<LogInfo> getSProtocol();

	/**
	 * 根据id获取日志对象 
	 * @param id
	 * @return
	 */
	public LogInfo selectById(long id);

	/**
	 * 查询某大协议下面对应的所有小协议
	 * @param logInfo
	 * @return
	 */
	public List<LogInfo> getMore(LogInfo logInfo);

	/**
	 * 获取小协议个数
	 * @return
	 */
	public Integer getMoreTotal(LogInfo logInfo);

	/**
	 * 查询小协议某指标值对应的近一周指标值
	 * @param field
	 * @return
	 */
	public List<LogField> getInDetail(LogField field);

	
	
}
