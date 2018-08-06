package com.cn.run.kpi.estimate.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.estimate.entity.StoreLogData;
import com.cn.run.kpi.estimate.service.StoreLogDataService;


/**
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class StoreLogDataServiceImpl implements StoreLogDataService {

	@Override
	public List<StoreLogData> getList(StoreLogData storeLogData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotal(StoreLogData storeLogData) {
		// TODO Auto-generated method stub
		return null;
	}

}
