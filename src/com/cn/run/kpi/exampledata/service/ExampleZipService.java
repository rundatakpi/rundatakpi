package com.cn.run.kpi.exampledata.service;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.exampledata.entity.Account;
import com.cn.run.kpi.exampledata.entity.Alarm;
import com.cn.run.kpi.exampledata.entity.AlarmDetail;
import com.cn.run.kpi.exampledata.entity.ExampleZip;
import com.cn.run.kpi.exampledata.entity.ExampleZipItem;

/**
 * @author libingnan
 * 2018年8月18日
 */
public interface ExampleZipService {

	List<ExampleZip> getList(ExampleZip example);

	List<ExampleZipItem> getSubList(ExampleZipItem exampleitem);

	List<Alarm> getAlarmList(Alarm example);

	int save(Account example);

	void editAlarm(Alarm alarmData);

	void delAlarm(Alarm alarmData);

	List<AlarmDetail> getAlarmDetails(AlarmDetail alarmDetail);

	void saveExampleData(Map<String, String> map);

}
