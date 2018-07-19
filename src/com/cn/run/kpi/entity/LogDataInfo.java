package com.cn.run.kpi.entity;

import java.io.Serializable;

public class LogDataInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*数据源编号*/
	private String dataSourceCode;
	/*数据源描述*/
	private String dataSourceDescription;
	/*大协议编码*/
	private String protocolTypeCode;
	/*大协议描述*/
	private String protocolTypeDescription;
	/*小协议编码*/
	private String protocolCode;
	/*小协议描述*/
	private String protocolDescription;
	/*入库条数*/
	private long inputDataNumber;
	/*入库率*/
	private String storageRate;
	/*字段数*/
	private String dataFeildNumber;
	/*数据准确率*/
	private String dataAccuracy;
	
	public String getDataSourceCode() {
		return dataSourceCode;
	}
	public String getDataSourceDescription() {
		return dataSourceDescription;
	}
	public String getProtocolTypeCode() {
		return protocolTypeCode;
	}
	public String getProtocolTypeDescription() {
		return protocolTypeDescription;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public String getProtocolDescription() {
		return protocolDescription;
	}
	public long getInputDataNumber() {
		return inputDataNumber;
	}
	public String getStorageRate() {
		return storageRate;
	}
	public String getDataFeildNumber() {
		return dataFeildNumber;
	}
	public String getDataAccuracy() {
		return dataAccuracy;
	}
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	public void setDataSourceDescription(String dataSourceDescription) {
		this.dataSourceDescription = dataSourceDescription;
	}
	public void setProtocolTypeCode(String protocolTypeCode) {
		this.protocolTypeCode = protocolTypeCode;
	}
	public void setProtocolTypeDescription(String protocolTypeDescription) {
		this.protocolTypeDescription = protocolTypeDescription;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	public void setProtocolDescription(String protocolDescription) {
		this.protocolDescription = protocolDescription;
	}
	public void setInputDataNumber(long inputDataNumber) {
		this.inputDataNumber = inputDataNumber;
	}
	public void setStorageRate(String storageRate) {
		this.storageRate = storageRate;
	}
	public void setDataFeildNumber(String dataFeildNumber) {
		this.dataFeildNumber = dataFeildNumber;
	}
	public void setDataAccuracy(String dataAccuracy) {
		this.dataAccuracy = dataAccuracy;
	}
	
	
	
	
	
	
	

}
