package com.cn.run.kpi.datamonitor.restore.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.restore.dao.RestoreDao;
import com.cn.run.kpi.datamonitor.restore.entity.DeviseLoadEntity;
import com.cn.run.kpi.datamonitor.restore.entity.RestoreInputEntity;
import com.cn.run.kpi.datamonitor.restore.entity.RestoreOutputEntity;
import com.cn.run.kpi.datamonitor.restore.service.RestoreService;

/**
 * 还原监测服务实现类
 * @author zg
 *
 */
@Service
public class RestoreServiceImpl implements RestoreService {
	
	@Autowired
	RestoreDao restoreDao;

	@Override
	public List<RestoreInputEntity> getRestoreInputData(Map<String, Object> queryCondition) {
		return restoreDao.getRestoreInputData(queryCondition);
	}

	@Override
	public List<RestoreOutputEntity> getRestoreOutputData(Map<String, Object> queryCondition) {
		return restoreDao.getRestoreOutputData(queryCondition);
	}

	@Override
	public Long getTotalRestoreInputNum() {
		return restoreDao.getTotalRestoreInputNum();
	}

	@Override
	public Long getTotalRestoreOutputNum() {
		return restoreDao.getTotalRestoreOutputNum();
	}

	@Override
	public Long getTotalRestoreDiscardNum() {
		return restoreDao.getTotalRestoreDiscardNum();
	}

	@Override
	public Long getRestoreInputNumByDay(String date) {
		return restoreDao.getRestoreInputNumByDay(date);
	}

	@Override
	public Long getRestoreOutputNumByDay(String date) {
		return restoreDao.getRestoreOutputNumByDay(date);
	}

	@Override
	public Double getRestoreRepetionRate() {
		return restoreDao.getRestoreRepetionRate();
	}

	@Override
	public Double getErrorRate() {
		return restoreDao.getErrorRate();
	}

	@Override
	public Double getAccuracy() {
		return restoreDao.getAccuracy();
	}

	@Override
	public DeviseLoadEntity getDeviseLoadData() {
		return restoreDao.getDeviseLoadData();
	}

}
