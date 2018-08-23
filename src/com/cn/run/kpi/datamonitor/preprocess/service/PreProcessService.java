package com.cn.run.kpi.datamonitor.preprocess.service;

import java.util.List;
import java.util.Map;

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
	List<PreProcessEntity> getPreProcessData(Map<String, Object> queryCondition);
	
	/**
	 * 获取近X天预处理输入量、输出量
	 * @return
	 */
	List<PreProcessRealTimeEntity> getPreProcessRealTimeData(Map<String, Object> queryCondition);
	
	/**
	 * 获取近X天输入数据流重复率
	 * @return
	 */
	List<InputRepetionEntity> getInputRepetionRate(Map<String, Object> queryCondition);
	
	/**
	 * 获取预处理异常数据量
	 * @return
	 */
	List<ExceptionEntity> getExceptionData(Map<String, Object> queryCondition);
	
	/**
	 * 预处理错误数据量
	 * @return
	 */
	List<PreProcessEntity> getErrorData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取近X天预处理输入量
	 * @return
	 */
	List<PreProcessEntity> getPreProcessInputData(Map<String, Object> queryCondition) throws Exception;
	
	/**
	 * 获取近X天预处理丢弃量
	 * @return
	 */
	List<PreProcessEntity> getPreProcessOutputData(Map<String, Object> queryCondition) throws Exception;

	/**
	 * 获取重复率数据
	 * @param queryCondition
	 * @return
	 */
	List<PreProcessEntity> getRepeatData(Map<String, Object> queryCondition);
}
