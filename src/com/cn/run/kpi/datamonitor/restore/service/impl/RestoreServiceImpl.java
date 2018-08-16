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
	public Long getTotalRestoreInputNum(Map<String, Object> queryCondition) {
		return restoreDao.getTotalRestoreInputNum(queryCondition);
	}

	@Override
	public Long getTotalRestoreOutputNum(Map<String, Object> queryCondition) {
		return restoreDao.getTotalRestoreOutputNum(queryCondition);
	}

	@Override
	public Long getTotalRestoreDiscardNum(Map<String, Object> queryCondition) {
		return restoreDao.getTotalRestoreDiscardNum(queryCondition);
	}

	@Override
	public Long getRestoreInputNumByDay(Map<String, Object> queryCondition) {
		return restoreDao.getRestoreInputNumByDay(queryCondition);
	}

	@Override
	public Long getRestoreOutputNumByDay(Map<String, Object> queryCondition) {
		return restoreDao.getRestoreOutputNumByDay(queryCondition);
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
