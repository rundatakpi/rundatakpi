package com.cn.run.kpi.estimate.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.service.TransformDataService;

/**
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class TransformDataServiceImpl implements TransformDataService {

	@Override
	public List<TransformData> getList(TransformData transformData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotal(TransformData transformData) {
		// TODO Auto-generated method stub
		return null;
	}

}
