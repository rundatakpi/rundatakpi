package com.cn.run.kpi.exampledata.dao;

import java.util.List;

import com.cn.run.kpi.exampledata.entity.Alarm;
import com.cn.run.kpi.exampledata.entity.ExampleZip;

public interface AlarmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Alarm record);

    int insertSelective(Alarm record);

    Alarm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Alarm record);

    int updateByPrimaryKey(Alarm record);
    
	List<Alarm> getAlarmList(Alarm example);

	void deleteSubByPrimaryKey(Integer id);
}