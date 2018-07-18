package com.cn.run.kpi.entity;

import java.io.Serializable;

public class LogDataInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*数据源编号*/
	private String dataSourceCode;
	/*数据源描述*/
	private String dataSourceDescription;
	/*大协议编码*/
	private String bigProtocolCode;
	/*大协议描述*/
	private String bigProtocolDescription;
	/*小协议编码*/
	private String smallProtocolCode;
	/*小协议描述*/
	private String smallProtocolDescription;
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
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	public String getDataSourceDescription() {
		return dataSourceDescription;
	}
	public void setDataSourceDescription(String dataSourceDescription) {
		this.dataSourceDescription = dataSourceDescription;
	}
	public String getBigProtocolCode() {
		return bigProtocolCode;
	}
	public void setBigProtocolCode(String bigProtocolCode) {
		this.bigProtocolCode = bigProtocolCode;
	}
	public String getBigProtocolDescription() {
		return bigProtocolDescription;
	}
	public void setBigProtocolDescription(String bigProtocolDescription) {
		this.bigProtocolDescription = bigProtocolDescription;
	}
	public String getSmallProtocolCode() {
		return smallProtocolCode;
	}
	public void setSmallProtocolCode(String smallProtocolCode) {
		this.smallProtocolCode = smallProtocolCode;
	}
	public String getSmallProtocolDescription() {
		return smallProtocolDescription;
	}
	public void setSmallProtocolDescription(String smallProtocolDescription) {
		this.smallProtocolDescription = smallProtocolDescription;
	}
	public long getInputDataNumber() {
		return inputDataNumber;
	}
	public void setInputDataNumber(long inputDataNumber) {
		this.inputDataNumber = inputDataNumber;
	}
	public String getStorageRate() {
		return storageRate;
	}
	public void setStorageRate(String storageRate) {
		this.storageRate = storageRate;
	}
	public String getDataFeildNumber() {
		return dataFeildNumber;
	}
	public void setDataFeildNumber(String dataFeildNumber) {
		this.dataFeildNumber = dataFeildNumber;
	}
	public String getDataAccuracy() {
		return dataAccuracy;
	}
	public void setDataAccuracy(String dataAccuracy) {
		this.dataAccuracy = dataAccuracy;
	}
	
	
	

}
