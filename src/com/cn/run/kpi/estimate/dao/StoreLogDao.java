package com.cn.run.kpi.estimate.dao;

import java.util.List;
import com.cn.run.kpi.estimate.entity.StoreFieldData;
import com.cn.run.kpi.estimate.entity.StoreLogData;


public interface StoreLogDao {

	List<StoreLogData> getList(StoreLogData storeLogData);

	Integer getTotal(StoreLogData storeLogData);

	List<StoreLogData> selectDetail(StoreLogData storeLogData);

	List<StoreLogData> getProtocolInfo(StoreLogData storeLogData);
	
	List<StoreFieldData> getFieldInfo(StoreLogData storeLog);
}
