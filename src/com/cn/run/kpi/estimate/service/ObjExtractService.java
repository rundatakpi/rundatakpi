package com.cn.run.kpi.estimate.service;

import java.util.List;

import com.cn.run.kpi.estimate.entity.ObjInfo;




/**
 * 对象化提取数据Service
 * @author chenyan
 * 2018年8月6日
 *
 */
public interface ObjExtractService {

	/**
	 * 查询条件下对象化提取数据
	 * @param ObjInfo
	 * @return List<ObjDataInfo>
	 */
	List<ObjInfo> getList(ObjInfo objDataInfo);

	/**
	 * 查询所有对象化提取数据条数
	 * @param ObjInfo
	 * @return Integer 
	 */
	Integer getTotal(ObjInfo objDataInfo);

	/**
	 * 查询对象类型
	 * @return
	 */
	List<ObjInfo> getObjType();

	/**
	 * 查询特征串类型
	 * @param objDataInfo
	 * @return
	 */
	List<ObjInfo> getFeartureString();

	/**
	 * 查询数据源类型
	 * @param objDataInfo
	 * @return
	 */
	List<ObjInfo> getDataSource();
	
	/**
	 * 获取数据详情
	 * @param objDataInfo
	 * @return
	 */
	List<ObjInfo> getDetail(ObjInfo objDataInfo);

}
