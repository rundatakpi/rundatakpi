package com.cn.run.kpi.entity;

import java.io.Serializable;
/**
 * 预处理数据-实体类
 * @author chenyan
 *
 */
public class YCLDataInfo implements Serializable{


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
	/*动作类型*/
	private String actionType;
	/*输入数据条数*/
	private int inputDataNum;
	/*输入数据字段填充率*/
	private String inputFieldFillRate;
	/*输入数据依赖字段组填充率*/
	private String inputDependGroupFillRate;
	/*输入数据字段可用率*/
	private String inputFieldAvailability;
	/*输入数据依赖字段组可用率*/
	private String inputDependGroupAvailability;
	/*输入数据准确率*/
	private String inputDataAccuracy;
	/*输出数据条数*/
	private int outputNum;
	/*输出数据速率*/
	private int outputDataSpeed;
	/*输出数据字段填充率*/
	private String outputFieldFillRate;
	/*输出数据依赖字段组填充率*/
	private String outputDependGroupFillRate;
	
	
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
	public String getActionType() {
		return actionType;
	}
	public int getInputDataNum() {
		return inputDataNum;
	}
	public String getInputFieldFillRate() {
		return inputFieldFillRate;
	}
	public String getInputDependGroupFillRate() {
		return inputDependGroupFillRate;
	}
	public String getInputFieldAvailability() {
		return inputFieldAvailability;
	}
	public String getInputDependGroupAvailability() {
		return inputDependGroupAvailability;
	}
	public String getInputDataAccuracy() {
		return inputDataAccuracy;
	}
	public int getOutputNum() {
		return outputNum;
	}
	public int getOutputDataSpeed() {
		return outputDataSpeed;
	}
	public String getOutputFieldFillRate() {
		return outputFieldFillRate;
	}
	public String getOutputDependGroupFillRate() {
		return outputDependGroupFillRate;
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
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public void setInputDataNum(int inputDataNum) {
		this.inputDataNum = inputDataNum;
	}
	public void setInputFieldFillRate(String inputFieldFillRate) {
		this.inputFieldFillRate = inputFieldFillRate;
	}
	public void setInputDependGroupFillRate(String inputDependGroupFillRate) {
		this.inputDependGroupFillRate = inputDependGroupFillRate;
	}
	public void setInputFieldAvailability(String inputFieldAvailability) {
		this.inputFieldAvailability = inputFieldAvailability;
	}
	public void setInputDependGroupAvailability(String inputDependGroupAvailability) {
		this.inputDependGroupAvailability = inputDependGroupAvailability;
	}
	public void setInputDataAccuracy(String inputDataAccuracy) {
		this.inputDataAccuracy = inputDataAccuracy;
	}
	public void setOutputNum(int outputNum) {
		this.outputNum = outputNum;
	}
	public void setOutputDataSpeed(int outputDataSpeed) {
		this.outputDataSpeed = outputDataSpeed;
	}
	public void setOutputFieldFillRate(String outputFieldFillRate) {
		this.outputFieldFillRate = outputFieldFillRate;
	}
	public void setOutputDependGroupFillRate(String outputDependGroupFillRate) {
		this.outputDependGroupFillRate = outputDependGroupFillRate;
	}
	

	
}
