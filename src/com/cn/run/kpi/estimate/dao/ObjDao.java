package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.ObjInfo;


/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface ObjDao {
	
	List<ObjInfo> getObjType();

	List<ObjInfo> getFeartureString();

	List<ObjInfo> getDataSource();

	List<ObjInfo> getList(ObjInfo objDataInfo);

	Integer getTotal(ObjInfo objDataInfo);

	List<ObjInfo> getDetail(ObjInfo objDataInfo);

	
}
