package com.cn.run.kpi.alarm.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.index.entity.WarnMessage;

public interface WarnDao {

	public List<WarnMessage> list(Map<String, Object> queryCondition) throws Exception;
}
