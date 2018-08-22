package com.cn.run.kpi.datamonitor.preprocess.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.preprocess.dao.PreProcessDao;
import com.cn.run.kpi.datamonitor.preprocess.entity.ExceptionEntity;
import com.cn.run.kpi.datamonitor.preprocess.entity.InputRepetionEntity;
import com.cn.run.kpi.datamonitor.preprocess.entity.PreProcessEntity;
import com.cn.run.kpi.datamonitor.preprocess.entity.PreProcessRealTimeEntity;
import com.cn.run.kpi.datamonitor.preprocess.service.PreProcessService;

@Service
public class PreProcessServiceImpl implements PreProcessService {
	
	@Autowired
	PreProcessDao preProcessDao;

	@Override
	public List<PreProcessEntity> getPreProcessData(Map<String, Object> queryCondition) {
		return preProcessDao.getPreProcessData(queryCondition);
	}

	@Override
	public List<PreProcessRealTimeEntity> getPreProcessRealTimeData(Map<String, Object> queryCondition) {
		return preProcessDao.getPreProcessRealTimeData(queryCondition);
	}

	@Override
	public List<InputRepetionEntity> getInputRepetionRate(Map<String, Object> queryCondition) {
		return preProcessDao.getInputRepetionRate(queryCondition);
	}

	@Override
	public List<ExceptionEntity> getExceptionData(Map<String, Object> queryCondition) {
		return preProcessDao.getExceptionData(queryCondition);
	}

	@Override
	public List<PreProcessEntity> getErrorData(Map<String, Object> queryCondition) {
		return preProcessDao.getErrorData(queryCondition);
	}

	@Override
	public List<PreProcessEntity> getPreProcessInputData(Map<String, Object> queryCondition) {
		return preProcessDao.getPreProcessInputData(queryCondition);
	}

	@Override
	public List<PreProcessEntity> getPreProcessOutputData(Map<String, Object> queryCondition) {
		return preProcessDao.getPreProcessOutputData(queryCondition);
	}

	@Override
	public List<PreProcessEntity> getRepeatData(Map<String, Object> queryCondition) {
		return preProcessDao.getRepeatData(queryCondition);
	}

}
