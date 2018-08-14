package com.cn.run.kpi.datamonitor.compress.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.compress.dao.CompressDao;
import com.cn.run.kpi.datamonitor.compress.entity.BacklogEntity;
import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressEntity;
import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressNumEntity;
import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressSizeEntity;
import com.cn.run.kpi.datamonitor.compress.entity.MachineCompressNumEntity;
import com.cn.run.kpi.datamonitor.compress.entity.MachineCompressSizeEntity;
import com.cn.run.kpi.datamonitor.compress.service.CompressService;

@Service
public class CompressServiceImpl implements CompressService {
	
	@Autowired
	private CompressDao compressDao;

	@Override
	public List<KafkaCompressEntity> getKafkaCompressData() {
		return compressDao.getKafkaCompressData();
	}

	@Override
	public List<MachineCompressNumEntity> getMachineCompressNum() {
		return compressDao.getMachineCompressNum();
	}

	@Override
	public List<MachineCompressSizeEntity> getMachineCompressSize() {
		return compressDao.getMachineCompressSize();
	}

	@Override
	public List<KafkaCompressNumEntity> getKafkaCompressNum() {
		
		List<KafkaCompressNumEntity> test = new ArrayList<>();
		KafkaCompressNumEntity k1 = new KafkaCompressNumEntity();
		k1.setDate("2018-08-10");
		k1.setNum(73435L);
		
		KafkaCompressNumEntity k2 = new KafkaCompressNumEntity();
		k2.setDate("2018-08-11");
		k2.setNum(83985L);
		test.add(k2);
//		return compressDao.getKafkaCompressNum();
		return test;
	}

	@Override
	public List<KafkaCompressSizeEntity> getKafkaCompressSize() {
		return compressDao.getKafkaCompressSize();
	}

	@Override
	public List<BacklogEntity> getKafkaBacklogData() {
		return compressDao.getKafkaBacklogData();
	}

}
