package com.cn.run.kpi.estimate.dao;

import java.util.List;

import com.cn.run.kpi.estimate.entity.ObjField;
import com.cn.run.kpi.estimate.entity.ObjInfo;


/**
 * @author chenyan
 * 2018年8月12日
 *
 */
public interface ObjDao {

	List<ObjInfo> getList(ObjInfo objInfo);

	List<ObjField> getFieldList(ObjInfo objInfo2);

	Integer getTotal(ObjInfo objInfo);
	

	
}
