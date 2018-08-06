package com.cn.run.kpi.datamonitor.restore.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.restore.entity.DeviseLoadEntity;
import com.cn.run.kpi.datamonitor.restore.entity.RestoreInputEntity;
import com.cn.run.kpi.datamonitor.restore.entity.RestoreOutputEntity;

/**
 * 还原监测服务
 * @author zg
 *
 */
public interface RestoreService {

	/**
	 * 获取近七天协议还原数据实时输入数据量
	 * @return
	 */
	List<RestoreInputEntity> getRestoreInputData(Map<String, Object> queryCondition);
	
	/**
	 * 获取当前协议还原输出数据总量
	 * @return
	 */
	List<RestoreOutputEntity> getRestoreOutputData(Map<String, Object> queryCondition);
	
	/**
	 * 获取当前协议还原输入数据总量
	 * @return
	 */
	Long getTotalRestoreInputNum();
	
	/**
	 * 获取当前协议还原输出数据总量
	 * @return
	 */
	Long getTotalRestoreOutputNum();
	
	/**
	 * 当前协议还原丢弃数据总量
	 * @return
	 */
	Long getTotalRestoreDiscardNum();
	
	/**
	 * 获取某天协议还原输入数据量
	 * @param date
	 * @return
	 */
	Long getRestoreInputNumByDay(String date);
	
	/**
	 * 获取某天协议还原输出数据量
	 * @param date
	 * @return
	 */
	Long getRestoreOutputNumByDay(String date);
	
	/**
	 * 获取数据重复率
	 * @return
	 */
	Double getRestoreRepetionRate();
	
	/**
	 * 获取数据错误率
	 * @return
	 */
	Double getErrorRate();
	
	/**
	 * 获取数据准确率
	 * @return
	 */
	Double getAccuracy();
	
	DeviseLoadEntity getDeviseLoadData();
}
