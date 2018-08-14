package com.cn.run.kpi.estimate.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.run.kpi.estimate.common.YCLConstants;
import com.cn.run.kpi.estimate.dao.YCLDataDao;
import com.cn.run.kpi.estimate.entity.TransformData;
import com.cn.run.kpi.estimate.entity.YCLData;
import com.cn.run.kpi.estimate.entity.YCLExampleData;
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
	private YCLDataDao yclDataDao;
	
	/**
	 * 获取预处理数据列表
	 */
	@Override
	public List<YCLData> getList(YCLData yclData) {
		return yclDataDao.getList(yclData);
	}

	/**
	 * 获取预处理数据总条数
	 */
	@Override
	public Integer getTotal(YCLData yclData) {
		return yclDataDao.getTotal(yclData);
	}

	/**
	 * 根据id查询预处理数据信息
	 */
	@Override
	public YCLData selectById(Integer id) {
		return yclDataDao.selectById(id);
	}

	/**
	 * 查询某属性近一周的值
	 */
	@Override
	public List<YCLData> selectDetail(YCLData yclData) {
		return yclDataDao.selectDetail(yclData);
	}

	/**
	 * 获取预处理样例包详情
	 */
	@Override
	public List<YCLExampleData> getExampleList(YCLExampleData yclExampleData) {
		List<YCLExampleData> total = new ArrayList<YCLExampleData>();
		
		//正常数据和异常数据各取指定条数
		yclExampleData.setSourcedesc("1");
		yclExampleData.setSize(YCLConstants.NORMAL_SIZE);
		List<YCLExampleData> normal = yclDataDao.getYCLExample(yclExampleData);
		for (YCLExampleData ycl : normal) {
			total.add(ycl);
		}
		
		yclExampleData.setSourcedesc("0");
		yclExampleData.setSize(YCLConstants.UNNORMAL_SIZE);
		List<YCLExampleData> unNormal = yclDataDao.getYCLExample(yclExampleData);
		for (YCLExampleData ycl : unNormal) {
			total.add(ycl);
		}

		return total;
	}


}
