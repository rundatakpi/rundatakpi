package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;

public class StoreFieldData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*字段编码*/
	private String fieldCode;
	/*字段中文描述*/
	private String fieldDesc;
	/*填充率*/
	private String fillRate;
	/*小协议数据准确率*/
	private String sAccuracy;
	/*代码符合度*/
	private String codeMatch;
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
	public String getFillRate() {
		return fillRate;
	}
	public void setFillRate(String fillRate) {
		this.fillRate = fillRate;
	}
	public String getsAccuracy() {
		return sAccuracy;
	}
	public void setsAccuracy(String sAccuracy) {
		this.sAccuracy = sAccuracy;
	}
	public String getCodeMatch() {
		return codeMatch;
	}
	public void setCodeMatch(String codeMatch) {
		this.codeMatch = codeMatch;
	}
	
	
	
	
	

}
