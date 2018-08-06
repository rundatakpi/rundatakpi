package com.cn.run.kpi.datamonitor.compress.service;

import java.util.List;

import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressEntity;
import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressNumEntity;
import com.cn.run.kpi.datamonitor.compress.entity.MachineCompressNumEntity;
import com.cn.run.kpi.datamonitor.compress.entity.MachineCompressSizeEntity;

/**
 * 积压监测服务
 * @author zg
 *
 */
public interface CompressService {

	/**
	 * 获取kafka积压数据
	 * @return
	 */
	List<KafkaCompressEntity> getKafkaCompressData();
	
	/**
	 * 获取七天接口机实时积压数据量
	 * @return
	 */
	List<MachineCompressNumEntity> getMachineCompressNum();
	
	/**
	 * 获取七天接口机实时积压数据大小
	 * @return
	 */
	List<MachineCompressSizeEntity> getMachineCompressSize();
	
	/**
	 * 获取Kafka实时积压数据量
	 * @return
	 */
	List<KafkaCompressNumEntity> getKafkaCompressNum();
}
