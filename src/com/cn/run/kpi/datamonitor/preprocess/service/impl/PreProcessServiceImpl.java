package com.cn.run.kpi.datamonitor.preprocess.service.impl;

import java.util.List;

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
	public List<PreProcessEntity> getPreProcessData() {
		return preProcessDao.getPreProcessData();
	}

	@Override
	public List<PreProcessRealTimeEntity> getPreProcessRealTimeData() {
		return preProcessDao.getPreProcessRealTimeData();
	}

	@Override
	public List<InputRepetionEntity> getInputRepetionRate() {
		return preProcessDao.getInputRepetionRate();
	}

	@Override
	public List<ExceptionEntity> getExceptionData() {
		return preProcessDao.getExceptionData();
	}

	@Override
	public List<PreProcessEntity> getErrorData() {
		return preProcessDao.getErrorData();
	}

	@Override
	public List<PreProcessEntity> getPreProcessInputData() {
		return preProcessDao.getPreProcessInputData();
	}

	@Override
	public List<PreProcessEntity> getPreProcessOutputData() {
		return preProcessDao.getPreProcessOutputData();
	}

}
