package com.cn.run.kpi.datamonitor.store.entity;

import java.io.Serializable;

/**
 * 数据存储实体类
 * @author zg
 *
 */
public class StoreEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -221009250421598206L;

	/**
	 * 日期
	 */
	private String time;
	
	/**
	 * 数据存储大小
	 */
	private Long storeNum;
	 
	/**
	 * 对象化数据存储大小
	 */
	private Long objectStoreNum;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(Long storeNum) {
		this.storeNum = storeNum;
	}

	public Long getObjectStoreNum() {
		return objectStoreNum;
	}

	public void setObjectStoreNum(Long objectStoreNum) {
		this.objectStoreNum = objectStoreNum;
	}
}
