package com.cn.run.kpi.datamonitor.restore.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.datamonitor.restore.entity.DeviseLoadEntity;
import com.cn.run.kpi.datamonitor.restore.entity.RestoreInputEntity;
import com.cn.run.kpi.datamonitor.restore.entity.RestoreOutputEntity;

/**
 * 还原监测Dao
 * @author zg
 *
 */
public interface RestoreDao {
	
	/**
	 * 获取近七天协议还原数据实时输入数据量
	 * @param queryCondition
	 * @return
	 */
	public List<RestoreInputEntity> getRestoreInputData(Map<String, Object> queryCondition);

	/**
	 * 获取当前协议还原输出数据总量
	 * @param queryCondition
	 * @return
	 */
	public List<RestoreOutputEntity> getRestoreOutputData(Map<String, Object> queryCondition);

	public Long getTotalRestoreInputNum();

	public Long getTotalRestoreOutputNum();

	public Long getTotalRestoreDiscardNum();

	public Long getRestoreInputNumByDay(String date);

	public Long getRestoreOutputNumByDay(String date);

	public Double getRestoreRepetionRate();

	public Double getErrorRate();

	public Double getAccuracy();

	public DeviseLoadEntity getDeviseLoadData();
}
