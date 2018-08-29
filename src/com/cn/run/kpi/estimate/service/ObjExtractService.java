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
	 * 获取对象化信息列表
	 * @param objInfo
	 * @return
	 */
	List<ObjInfo> getList(ObjInfo objInfo);

	/**
	 * 获取对象化信息总个数
	 * @param objInfo
	 * @return
	 */
	Integer getTotal(ObjInfo objInfo);


}
