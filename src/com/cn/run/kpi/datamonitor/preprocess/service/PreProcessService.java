package com.cn.run.kpi.datamonitor.preprocess.service;

import java.util.List;

import com.cn.run.kpi.datamonitor.preprocess.entity.ErrorEntity;
import com.cn.run.kpi.datamonitor.preprocess.entity.ExceptionEntity;
import com.cn.run.kpi.datamonitor.preprocess.entity.InputRepetionEntity;
import com.cn.run.kpi.datamonitor.preprocess.entity.PreProcessEntity;
import com.cn.run.kpi.datamonitor.preprocess.entity.PreProcessRealTimeEntity;

/**
 * 预处理服务
 * @author zg
 *
 */
public interface PreProcessService {

	/**
	 * 查询各数据源预处理输入量、输出量、抛弃量
	 * @return 
	 */
	List<PreProcessEntity> getPreProcessData();
	
	/**
	 * 获取近XX预处理输入量、输出量
	 * @return
	 */
	List<PreProcessRealTimeEntity> getPreProcessRealTimeData();
	
	/**
	 * 获取近XX输入数据流重复率
	 * @return
	 */
	List<InputRepetionEntity> getInputRepetionRate();
	
	/**
	 * 获取预处理异常数据量
	 * @return
	 */
	List<ExceptionEntity> getExceptionData();
	
	/**
	 * 预处理错误数据量
	 * @return
	 */
	List<ErrorEntity> getErrorData();
}
