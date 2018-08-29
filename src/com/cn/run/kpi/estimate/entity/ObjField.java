package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;

public class ObjField implements Serializable{

	private static final long serialVersionUID = 1L;

	/*主键*/
	private long id;
	/*关联id*/
	private long srcId;
	/*字段编码*/
	private String fieldCode;
	/*字段中文描述*/
	private String fieldDesc;
	/*字段数量*/
	private String count;
	/*字段数量占比*/
	private String rate;
	/*日期*/
	private String createDate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSrcId() {
		return srcId;
	}
	public void setSrcId(long srcId) {
		this.srcId = srcId;
	}
	public String getFieldCode() {
		return fieldCode;
	}
	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}
	public String getFieldDesc() {
		return fieldDesc;
	}
	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	
}
