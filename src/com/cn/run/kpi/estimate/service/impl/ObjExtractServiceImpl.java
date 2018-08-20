package com.cn.run.kpi.estimate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.estimate.dao.ObjDao;
import com.cn.run.kpi.estimate.entity.ObjInfo;
import com.cn.run.kpi.estimate.service.ObjExtractService;


/**
 * 对象化提取数据实现类
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class ObjExtractServiceImpl implements ObjExtractService {
	
	@Autowired
	private ObjDao objectDao;

	@Override
	public List<ObjInfo> getList(ObjInfo objDataInfo) {
		return objectDao.getList(objDataInfo);
	}

	@Override
	public Integer getTotal(ObjInfo objDataInfo) {
		return objectDao.getTotal(objDataInfo);
	}

	/**
	 * 查询对象类型
	 */
	@Override
	public List<ObjInfo> getObjType() {
		return objectDao.getObjType();
	}

	/**
	 * 查询特征串类型
	 */
	@Override
	public List<ObjInfo> getFeartureString() {
		return objectDao.getFeartureString();
	}

	/**
	 * 查询数据源类型
	 */
	@Override
	public List<ObjInfo> getDataSource() {
		return objectDao.getDataSource();
	}

	/**
	 * 获取详情
	 */
	@Override
	public List<ObjInfo> getDetail(ObjInfo objDataInfo) {
		return objectDao.getDetail(objDataInfo);
	}

}
