package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.TransInfo;

/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface TransDao {

	List<TransInfo> getList(TransInfo transformData);

	Integer getTotal(TransInfo transformData);

	List<TransInfo> selectDetail(TransInfo tranformData);

	List<TransInfo> getCondition(String conSql);

	List<TransInfo> getDataSource();

	List<TransInfo> getBProtocol();

	List<TransInfo> getSProtocol();

	List<TransInfo> getActionType();

	TransInfo selectById(long id);

}
