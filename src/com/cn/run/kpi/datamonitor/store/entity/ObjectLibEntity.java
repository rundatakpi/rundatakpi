package com.cn.run.kpi.datamonitor.store.entity;

import java.io.Serializable;

/**
 * 对象库数据封装类
 * @author zg
 *
 */
public class ObjectLibEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8314105895580051318L;

	/**
	 * 对象
	 */
	private String object;
	
	/**
	 * 数据量
	 */
	private Long dataNum;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Long getDataNum() {
		return dataNum;
	}

	public void setDataNum(Long dataNum) {
		this.dataNum = dataNum;
	}
	
}
