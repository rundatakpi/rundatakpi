package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;

/**
 * 预处理数据-实体类
 * @author chenyan
 *
 */
public class YCLData implements Serializable{


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
	private Integer inputDataNum;
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
	private Integer outputNum;
	/*输出数据速率*/
	private Integer outputDataSpeed;
	/*输出数据字段填充率*/
	private String outputFieldFillRate;
	/*输出数据依赖字段组填充率*/
	private String outputDependGroupFillRate;
	/*数据产生时间*/
	private String createDate;
	/*查询开始时间*/
	private String startTime;
	/*查询结束时间*/
	private String endTime;
	/*起始位置*/
	private Integer start;
	/*长度*/
	private Integer length;
	/*属性名*/
	private String colKey;
	/*属性值*/
	private String colValue;
	/*列名*/
	private String colName;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getbProtocolCode() {
		return bProtocolCode;
	}
	public void setbProtocolCode(String bProtocolCode) {
		this.bProtocolCode = bProtocolCode;
	}
	public String getbProtocolDescription() {
		return bProtocolDescription;
	}
	public void setbProtocolDescription(String bProtocolDescription) {
		this.bProtocolDescription = bProtocolDescription;
	}
	public String getsProtocolCode() {
		return sProtocolCode;
	}
	public void setsProtocolCode(String sProtocolCode) {
		this.sProtocolCode = sProtocolCode;
	}
	public String getsProtocolDescription() {
		return sProtocolDescription;
	}
	public void setsProtocolDescription(String sProtocolDescription) {
		this.sProtocolDescription = sProtocolDescription;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public Integer getInputDataNum() {
		return inputDataNum;
	}
	public void setInputDataNum(Integer inputDataNum) {
		this.inputDataNum = inputDataNum;
	}
	public String getInputFieldFillRate() {
		return inputFieldFillRate;
	}
	public void setInputFieldFillRate(String inputFieldFillRate) {
		this.inputFieldFillRate = inputFieldFillRate;
	}
	public String getInputDependGroupFillRate() {
		return inputDependGroupFillRate;
	}
	public void setInputDependGroupFillRate(String inputDependGroupFillRate) {
		this.inputDependGroupFillRate = inputDependGroupFillRate;
	}
	public String getInputFieldAvailability() {
		return inputFieldAvailability;
	}
	public void setInputFieldAvailability(String inputFieldAvailability) {
		this.inputFieldAvailability = inputFieldAvailability;
	}
	public String getInputDependGroupAvailability() {
		return inputDependGroupAvailability;
	}
	public void setInputDependGroupAvailability(String inputDependGroupAvailability) {
		this.inputDependGroupAvailability = inputDependGroupAvailability;
	}
	public String getInputDataAccuracy() {
		return inputDataAccuracy;
	}
	public void setInputDataAccuracy(String inputDataAccuracy) {
		this.inputDataAccuracy = inputDataAccuracy;
	}
	public Integer getOutputNum() {
		return outputNum;
	}
	public void setOutputNum(Integer outputNum) {
		this.outputNum = outputNum;
	}
	public Integer getOutputDataSpeed() {
		return outputDataSpeed;
	}
	public void setOutputDataSpeed(Integer outputDataSpeed) {
		this.outputDataSpeed = outputDataSpeed;
	}
	public String getOutputFieldFillRate() {
		return outputFieldFillRate;
	}
	public void setOutputFieldFillRate(String outputFieldFillRate) {
		this.outputFieldFillRate = outputFieldFillRate;
	}
	public String getOutputDependGroupFillRate() {
		return outputDependGroupFillRate;
	}
	public void setOutputDependGroupFillRate(String outputDependGroupFillRate) {
		this.outputDependGroupFillRate = outputDependGroupFillRate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getColKey() {
		return colKey;
	}
	public void setColKey(String colKey) {
		this.colKey = colKey;
	}
	public String getColValue() {
		return colValue;
	}
	public void setColValue(String colValue) {
		this.colValue = colValue;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}

	
}
