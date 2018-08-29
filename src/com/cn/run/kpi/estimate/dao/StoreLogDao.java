package com.cn.run.kpi.estimate.dao;

import java.util.List;
import com.cn.run.kpi.estimate.entity.LogField;
import com.cn.run.kpi.estimate.entity.LogInfo;


public interface StoreLogDao {

	List<LogInfo> getList(LogInfo storeLogData);

	Integer getTotal(LogInfo storeLogData);

	List<LogInfo> getOutDetail(LogInfo storeLogData);

	List<LogInfo> getProtocolInfo(LogInfo storeLogData);
	
	List<LogField> getFieldInfo(LogInfo storeLog);

	List<LogInfo> getFeildDetail(LogInfo storeLogData);

	List<LogInfo> getDataSource();

	List<LogInfo> getBProtocol();

	List<LogInfo> getSProtocol();

	LogInfo selectById(long id);

	List<LogInfo> getSProtocolList(LogInfo logInfo);
	
	List<LogField> getFields(LogInfo log);

	Integer getMoreTotal(LogInfo logInfo);

	List<LogField> getInDetail(LogField field);


}
