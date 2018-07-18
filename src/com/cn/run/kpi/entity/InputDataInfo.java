package com.cn.run.kpi.entity;

import java.io.Serializable;

public class InputDataInfo implements Serializable{

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
	/*动作类型*/
	private String actionType;
	/*输入数据条数*/
	private int inputDataNumber;
	/*输入数据速度*/
	private int inputDataSpeed;
	/*输入数据字段填充率*/
	private String inputFieldFillRate;
	/*输入数据依赖字段组填充率*/
	private String inputFieldGroupFillRate;
	/*输入数据字段可用率*/
	private String inputFieldAvailability;
	/*输入数据依赖字段组可用率*/
	private String inputFieldGroupAvailability;
	/*输入数据准确率*/
	private String inputDataAccuracy;
	
	
	
	public String getDataSourceCode() {
		return dataSourceCode;
	}
	public String getDataSourceDescription() {
		return dataSourceDescription;
	}
	public String getBigProtocolCode() {
		return bigProtocolCode;
	}
	public String getBigProtocolDescription() {
		return bigProtocolDescription;
	}
	public String getSmallProtocolCode() {
		return smallProtocolCode;
	}
	public String getSmallProtocolDescription() {
		return smallProtocolDescription;
	}
	public String getActionType() {
		return actionType;
	}
	public int getInputDataNumber() {
		return inputDataNumber;
	}
	public int getInputDataSpeed() {
		return inputDataSpeed;
	}
	public String getInputFieldFillRate() {
		return inputFieldFillRate;
	}
	public String getInputFieldGroupFillRate() {
		return inputFieldGroupFillRate;
	}
	public String getInputFieldAvailability() {
		return inputFieldAvailability;
	}
	public String getInputFieldGroupAvailability() {
		return inputFieldGroupAvailability;
	}
	public String getInputDataAccuracy() {
		return inputDataAccuracy;
	}
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	public void setDataSourceDescription(String dataSourceDescription) {
		this.dataSourceDescription = dataSourceDescription;
	}
	public void setBigProtocolCode(String bigProtocolCode) {
		this.bigProtocolCode = bigProtocolCode;
	}
	public void setBigProtocolDescription(String bigProtocolDescription) {
		this.bigProtocolDescription = bigProtocolDescription;
	}
	public void setSmallProtocolCode(String smallProtocolCode) {
		this.smallProtocolCode = smallProtocolCode;
	}
	public void setSmallProtocolDescription(String smallProtocolDescription) {
		this.smallProtocolDescription = smallProtocolDescription;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public void setInputDataNumber(int inputDataNumber) {
		this.inputDataNumber = inputDataNumber;
	}
	public void setInputDataSpeed(int inputDataSpeed) {
		this.inputDataSpeed = inputDataSpeed;
	}
	public void setInputFieldFillRate(String inputFieldFillRate) {
		this.inputFieldFillRate = inputFieldFillRate;
	}
	public void setInputFieldGroupFillRate(String inputFieldGroupFillRate) {
		this.inputFieldGroupFillRate = inputFieldGroupFillRate;
	}
	public void setInputFieldAvailability(String inputFieldAvailability) {
		this.inputFieldAvailability = inputFieldAvailability;
	}
	public void setInputFieldGroupAvailability(String inputFieldGroupAvailability) {
		this.inputFieldGroupAvailability = inputFieldGroupAvailability;
	}
	public void setInputDataAccuracy(String inputDataAccuracy) {
		this.inputDataAccuracy = inputDataAccuracy;
	}
	
	
}
