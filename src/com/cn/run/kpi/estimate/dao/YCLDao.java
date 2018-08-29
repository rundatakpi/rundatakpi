package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.YCLInfo;
import com.cn.run.kpi.estimate.entity.TransInfo;
import com.cn.run.kpi.estimate.entity.YCLExample;


/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface YCLDao {


	List<YCLInfo> getList(YCLInfo yclData);

	Integer getTotal(YCLInfo yclData);

	List<YCLInfo> selectDetail(YCLInfo yclData);

	List<YCLExample> getYCLExample(YCLExample yclExampleData);

	List<YCLInfo> getDataSource();

	List<YCLInfo> getBProtocol();

	List<YCLInfo> getSProtocol();

	List<YCLInfo> getActionType();

	YCLInfo selectById(long id);

	

}
