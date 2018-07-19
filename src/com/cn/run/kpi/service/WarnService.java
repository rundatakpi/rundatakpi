package com.cn.run.kpi.service;


import java.util.List;
import java.util.Map;

import com.cn.run.kpi.entity.WarnMessage;

public interface WarnService {

	public List<WarnMessage> list(Map<String, Object> queryCondition) throws Exception;
}
