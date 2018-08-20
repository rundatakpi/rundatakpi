package com.cn.run.kpi.estimate.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.run.kpi.estimate.common.LogConstants;
import com.cn.run.kpi.estimate.dao.YCLDao;
import com.cn.run.kpi.estimate.entity.TransInfo;
import com.cn.run.kpi.estimate.entity.YCLInfo;
import com.cn.run.kpi.estimate.entity.YCLExample;
import com.cn.run.kpi.estimate.service.YCLDataService;


/**
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class YCLDataServiceImpl implements YCLDataService {

	@Autowired
	private YCLDao yclDataDao;
	
	/**
	 * 获取预处理数据列表
	 */
	@Override
	public List<YCLInfo> getList(YCLInfo yclData) {
		return yclDataDao.getList(yclData);
	}

	/**
	 * 获取预处理数据总条数
	 */
	@Override
	public Integer getTotal(YCLInfo yclData) {
		return yclDataDao.getTotal(yclData);
	}

	/**
	 * 查询某属性近一周的值
	 */
	@Override
	public List<YCLInfo> selectDetail(YCLInfo yclData) {
		return yclDataDao.selectDetail(yclData);
	}

	/**
	 * 获取预处理样例包详情
	 */
	@Override
	public List<YCLExample> getExampleList(YCLExample yclExampleData) {
		List<YCLExample> total = new ArrayList<YCLExample>();
		
		//正常数据和异常数据各取指定条数
		yclExampleData.setSourceDesc("1");
		yclExampleData.setSize(LogConstants.NORMAL_SIZE);
		List<YCLExample> normal = yclDataDao.getYCLExample(yclExampleData);
		for (YCLExample ycl : normal) {
			total.add(ycl);
		}
		
		yclExampleData.setSourceDesc("0");
		yclExampleData.setSize(LogConstants.UNNORMAL_SIZE);
		List<YCLExample> unNormal = yclDataDao.getYCLExample(yclExampleData);
		for (YCLExample ycl : unNormal) {
			total.add(ycl);
		}

		return total;
	}


}
