package com.cn.run.kpi.datamonitor.compress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.run.kpi.datamonitor.compress.dao.CompressDao;
import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressEntity;
import com.cn.run.kpi.datamonitor.compress.entity.KafkaCompressNumEntity;
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
		return compressDao.getKafkaCompressNum();
	}
	

}
