package com.cn.run.kpi.index.entity;

import java.io.Serializable;

/**
 * 入库日志数据-实体类
 * @author chenyan
 *
 */
public class LogDataInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/*数据源编号*/
	private String dataSourceCode;
	/*数据源描述*/
	private String dataSourceDescription;
	/*大协议编码*/
	private String bProtocolCode;
	/*大协议描述*/
	private String bProtocolDescription;
	/*小协议编码*/
	private String sProtocolCode;
	/*小协议描述*/
	private String sProtocolDescription;
	/*入库条数*/
	private long inputDataNum;
	/*入库率*/
	private String storageRate;
	/*字段数*/
	private String FeildNum;
	/*数据准确率*/
	private String dataAccuracy;
	
	
	public long getId() {
		return id;
	}
	public String getDataSourceCode() {
		return dataSourceCode;
	}
	public String getDataSourceDescription() {
		return dataSourceDescription;
	}
	public String getbProtocolCode() {
		return bProtocolCode;
	}
	public String getbProtocolDescription() {
		return bProtocolDescription;
	}
	public String getsProtocolCode() {
		return sProtocolCode;
	}
	public String getsProtocolDescription() {
		return sProtocolDescription;
	}
	public long getInputDataNum() {
		return inputDataNum;
	}
	public String getStorageRate() {
		return storageRate;
	}
	public String getFeildNum() {
		return FeildNum;
	}
	public String getDataAccuracy() {
		return dataAccuracy;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	public void setDataSourceDescription(String dataSourceDescription) {
		this.dataSourceDescription = dataSourceDescription;
	}
	public void setbProtocolCode(String bProtocolCode) {
		this.bProtocolCode = bProtocolCode;
	}
	public void setbProtocolDescription(String bProtocolDescription) {
		this.bProtocolDescription = bProtocolDescription;
	}
	public void setsProtocolCode(String sProtocolCode) {
		this.sProtocolCode = sProtocolCode;
	}
	public void setsProtocolDescription(String sProtocolDescription) {
		this.sProtocolDescription = sProtocolDescription;
	}
	public void setInputDataNum(long inputDataNum) {
		this.inputDataNum = inputDataNum;
	}
	public void setStorageRate(String storageRate) {
		this.storageRate = storageRate;
	}
	public void setFeildNum(String feildNum) {
		FeildNum = feildNum;
	}
	public void setDataAccuracy(String dataAccuracy) {
		this.dataAccuracy = dataAccuracy;
	}
	
	
	
	
	
	
	
	

}
