package com.cn.run.kpi.estimate.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.estimate.entity.YCLData;
import com.cn.run.kpi.estimate.service.YCLDataService;


/**
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class YCLDataServiceImpl implements YCLDataService {

	@Override
	public List<YCLData> getList(YCLData yclData, Integer length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotal(YCLData yclData) {
		// TODO Auto-generated method stub
		return null;
	}

}
