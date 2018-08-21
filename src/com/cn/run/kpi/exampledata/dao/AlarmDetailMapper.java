package com.cn.run.kpi.exampledata.dao;

import java.util.List;

import com.cn.run.kpi.exampledata.entity.AlarmDetail;

public interface AlarmDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlarmDetail record);

    int insertSelective(AlarmDetail record);

    AlarmDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlarmDetail record);

    int updateByPrimaryKey(AlarmDetail record);

	List<AlarmDetail> getAlarmList(AlarmDetail alarmDetail);
}