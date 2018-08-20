package com.cn.run.kpi.estimate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.run.kpi.estimate.dao.TransDao;
import com.cn.run.kpi.estimate.entity.TransInfo;
import com.cn.run.kpi.estimate.service.TransService;

/**
 * 格转接入数据service
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class TransformServiceImpl implements TransService {
	
	
	@Autowired
	private TransDao transformDao;

	/**
	 *获取格转接入数据列表
	 */
	@Override
	public List<TransInfo> getList(TransInfo transformData) {
		return transformDao.getList(transformData);
	}

	/**
	 * 获取所有的格转接入数据
	 */
	@Override
	public Integer getTotal(TransInfo transformData) {
		return transformDao.getTotal(transformData);
	}

	/**
	 * 根据个爪接入数据信息和列名查询近一周指标值
	 */
	@Override
	public List<TransInfo> selectDetail(TransInfo tranformData) {
		return transformDao.selectDetail(tranformData);
	}

}
