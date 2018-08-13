package com.cn.run.kpi.estimate.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.run.kpi.estimate.entity.ObjectExtractData;
import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.service.ObjectExtractDataService;


/**
 * 对象化提取数据实现类
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class ObjectExtractDataServiceImpl implements ObjectExtractDataService {

	@Override
	public List<ObjectExtractData> getList(ObjectExtractData objectExtractData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotal(ObjectExtractData objectExtractData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransformData findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
