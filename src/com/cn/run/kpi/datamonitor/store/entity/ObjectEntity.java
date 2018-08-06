package com.cn.run.kpi.datamonitor.store.entity;

/**
 * 对象化数据实体类
 * @author zg
 *
 */
public class ObjectEntity {
	
	/**
	 * 对象
	 */
	private String objectName;
	
	/**
	 * 数据条数
	 */
	private Long dataNum;
	
	/**
	 * 准确条数
	 */
	private Long accurateNum;
	
	/**
	 * 关联数据量
	 */
	private Long associateNum;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public Long getDataNum() {
		return dataNum;
	}

	public void setDataNum(Long dataNum) {
		this.dataNum = dataNum;
	}

	public Long getAccurateNum() {
		return accurateNum;
	}

	public void setAccurateNum(Long accurateNum) {
		this.accurateNum = accurateNum;
	}

	public Long getAssociateNum() {
		return associateNum;
	}

	public void setAssociateNum(Long associateNum) {
		this.associateNum = associateNum;
	}
}

