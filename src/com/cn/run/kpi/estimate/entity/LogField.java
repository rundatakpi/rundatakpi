package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;

public class LogField implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	/*数据集编码*/
	private String dsCode;
	/*大协议编码*/
	private String bProtocolCode;
	/*小协议类型*/
	private String sProtocolCode;
	/*动作类型*/
	private String actionType;
	/*数据条数*/
	private String dataNum;
	/*字段编码*/
	private String fieldCode;
	/*字段中文描述*/
	private String fieldDesc;
	/*填充条数*/
	private long fillNum;
	/*填充率*/
	private String fillRate;
	/*准确条数*/
	private long accurateNum;
	/*准确率*/
	private String accuracy;
	/*代码符合条数*/
	private long codeMatchNum;
	/*代码符合率*/
	private String codeMatchRate;
	/*趋势图的日期*/
	private String chkVal;
	/*趋势图的日期对应的数值*/
	private String chkDisplay;
	/*列名*/
	private String colName;
	/*数据生成时间*/
	private String createDate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDsCode() {
		return dsCode;
	}
	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}
	public String getbProtocolCode() {
		return bProtocolCode;
	}
	public void setbProtocolCode(String bProtocolCode) {
		this.bProtocolCode = bProtocolCode;
	}
	public String getsProtocolCode() {
		return sProtocolCode;
	}
	public void setsProtocolCode(String sProtocolCode) {
		this.sProtocolCode = sProtocolCode;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getDataNum() {
		return dataNum;
	}
	public void setDataNum(String dataNum) {
		this.dataNum = dataNum;
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
	public long getFillNum() {
		return fillNum;
	}
	public void setFillNum(long fillNum) {
		this.fillNum = fillNum;
	}
	public String getFillRate() {
		return fillRate;
	}
	public void setFillRate(String fillRate) {
		this.fillRate = fillRate;
	}
	public long getAccurateNum() {
		return accurateNum;
	}
	public void setAccurateNum(long accurateNum) {
		this.accurateNum = accurateNum;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public long getCodeMatchNum() {
		return codeMatchNum;
	}
	public void setCodeMatchNum(long codeMatchNum) {
		this.codeMatchNum = codeMatchNum;
	}
	public String getCodeMatchRate() {
		return codeMatchRate;
	}
	public void setCodeMatchRate(String codeMatchRate) {
		this.codeMatchRate = codeMatchRate;
	}
	public String getChkVal() {
		return chkVal;
	}
	public void setChkVal(String chkVal) {
		this.chkVal = chkVal;
	}
	public String getChkDisplay() {
		return chkDisplay;
	}
	public void setChkDisplay(String chkDisplay) {
		this.chkDisplay = chkDisplay;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	

}
