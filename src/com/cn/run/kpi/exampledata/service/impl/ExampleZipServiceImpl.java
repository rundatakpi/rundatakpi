package com.cn.run.kpi.exampledata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.run.kpi.exampledata.dao.AccountMapper;
import com.cn.run.kpi.exampledata.dao.AlarmDetailMapper;
import com.cn.run.kpi.exampledata.dao.AlarmMapper;
import com.cn.run.kpi.exampledata.dao.ExampleZipItemMapper;
import com.cn.run.kpi.exampledata.dao.ExampleZipMapper;
import com.cn.run.kpi.exampledata.entity.Account;
import com.cn.run.kpi.exampledata.entity.Alarm;
import com.cn.run.kpi.exampledata.entity.ExampleZip;
import com.cn.run.kpi.exampledata.entity.ExampleZipItem;
import com.cn.run.kpi.exampledata.service.ExampleZipService;

/**
 * @author libingnan
 * 2018年8月18日
 */
@Service
@Transactional
public class ExampleZipServiceImpl implements ExampleZipService{
	@Autowired
	private ExampleZipMapper exampleZipDao;
	@Autowired
	private ExampleZipItemMapper exampleZipItemDao;
	@Autowired
	private AlarmDetailMapper alarmDetailMapper;
	@Autowired
	private AlarmMapper alarmMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Override
	public List<ExampleZip> getList(ExampleZip example) {
		// TODO Auto-generated method stub
		return exampleZipDao.getList(example);
	}
	
	@Override
	public List<ExampleZipItem> getSubList(ExampleZipItem exampleitem) {
		// TODO Auto-generated method stub
		return exampleZipItemDao.getSubList(exampleitem);
	}

	@Override
	public List<Alarm> getAlarmList(Alarm example) {
		// TODO Auto-generated method stub
		return alarmMapper.getAlarmList(example);
	}

	@Override
	public int save(Account example) {
		try {
			accountMapper.insertSelective(example);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
}
