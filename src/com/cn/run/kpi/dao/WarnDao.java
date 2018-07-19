package com.cn.run.kpi.dao;

import java.util.List;
import java.util.Map;

import com.cn.run.kpi.entity.WarnMessage;

public interface WarnDao {

	public List<WarnMessage> list(Map<String, Object> queryCondition) throws Exception;
}
