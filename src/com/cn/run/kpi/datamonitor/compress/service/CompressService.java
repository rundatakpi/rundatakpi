package com.cn.run.kpi.datamonitor.compress.service;

import java.util.List;

import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressEntity;

/**
 * 积压监测服务
 * @author zg
 *
 */
public interface CompressService {

	List<KafkaCompressEntity> getKafkaCompressData();
}
