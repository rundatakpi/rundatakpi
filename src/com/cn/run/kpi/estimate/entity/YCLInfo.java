package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;

/**
 * 预处理数据-实体类
 * @author chenyan
 *
 */
public class YCLInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/*数据源编号*/
	private String dsCode;
	/*数据源描述*/
	private String dsDesc;
	/*大协议编码*/
	private String bProtocolCode;
	/*大协议描述*/
	private String bProtocolDesc;
	/*小协议编码*/
	private String sProtocolCode;
	/*小协议描述*/
	private String sProtocolDesc;
	/*动作类型*/
	private String actionType;
	/*动作类型描述*/
	private String actionTypeDesc;
	/*输入数据条数*/
	private long inputNum;
	/*输入数据字段填充条数*/
	private long inputFieldNum;
	/*输入数据字段填充率*/
	private String inputFieldRate;
	/*输入数据依赖字段组填充条数*/
	private long inputGroupNum;
	/*输入数据依赖字段组填充率*/
	private String inputGroupRate;
	/*输入数据字段可用条数*/
	private long inputFieldAvailNum;
	/*输入数据字段可用率*/
	private String inputFieldAvailRate;
	/*输入数据依赖字段组可用条数*/
	private long inputGroupAvailNum;
	/*输入数据依赖字段组可用率*/
	private String inputGroupAvailRate;
	/*输入数据准确条数*/
	private long inputAccurateNum;
	/*输入数据准确率*/
	private String inputAccuracy;
	/*输出数据条数*/
	private long outputNum;
	/*输出数据速率*/
	private String outputSpeed;
	/*输出数据字段填充条数*/
	private long outputFieldNum;
	/*输出数据字段填充率*/
	private String outputFieldRate;
	/*输出数据依赖字段组填充条数*/
	private long outputGroupNum;
	/*输出数据依赖字段组填充率*/
	private String outputGroupRate;
	/*数据产生时间*/
	private String createDate;
	/*查询开始时间*/
	private String startTime;
	/*查询结束时间*/
	private String endTime;
	/*起始位置*/
	private int start;
	/*长度*/
	private int length;
	/*属性名*/
	private String oKey;
	/*属性值*/
	private String oValue;
	/*列名*/
	private String colName;
	
	
	
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
	public String getDsDesc() {
		return dsDesc;
	}
	public void setDsDesc(String dsDesc) {
		this.dsDesc = dsDesc;
	}
	public String getbProtocolCode() {
		return bProtocolCode;
	}
	public void setbProtocolCode(String bProtocolCode) {
		this.bProtocolCode = bProtocolCode;
	}
	public String getbProtocolDesc() {
		return bProtocolDesc;
	}
	public void setbProtocolDesc(String bProtocolDesc) {
		this.bProtocolDesc = bProtocolDesc;
	}
	public String getsProtocolCode() {
		return sProtocolCode;
	}
	public void setsProtocolCode(String sProtocolCode) {
		this.sProtocolCode = sProtocolCode;
	}
	public String getsProtocolDesc() {
		return sProtocolDesc;
	}
	public void setsProtocolDesc(String sProtocolDesc) {
		this.sProtocolDesc = sProtocolDesc;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public long getInputNum() {
		return inputNum;
	}
	public void setInputNum(long inputNum) {
		this.inputNum = inputNum;
	}
	public long getInputFieldNum() {
		return inputFieldNum;
	}
	public void setInputFieldNum(long inputFieldNum) {
		this.inputFieldNum = inputFieldNum;
	}
	public String getInputFieldRate() {
		return inputFieldRate;
	}
	public void setInputFieldRate(String inputFieldRate) {
		this.inputFieldRate = inputFieldRate;
	}
	public long getInputGroupNum() {
		return inputGroupNum;
	}
	public void setInputGroupNum(long inputGroupNum) {
		this.inputGroupNum = inputGroupNum;
	}
	public String getInputGroupRate() {
		return inputGroupRate;
	}
	public void setInputGroupRate(String inputGroupRate) {
		this.inputGroupRate = inputGroupRate;
	}
	public long getInputFieldAvailNum() {
		return inputFieldAvailNum;
	}
	public void setInputFieldAvailNum(long inputFieldAvailNum) {
		this.inputFieldAvailNum = inputFieldAvailNum;
	}
	public String getInputFieldAvailRate() {
		return inputFieldAvailRate;
	}
	public void setInputFieldAvailRate(String inputFieldAvailRate) {
		this.inputFieldAvailRate = inputFieldAvailRate;
	}
	public long getInputGroupAvailNum() {
		return inputGroupAvailNum;
	}
	public void setInputGroupAvailNum(long inputGroupAvailNum) {
		this.inputGroupAvailNum = inputGroupAvailNum;
	}
	public String getInputGroupAvailRate() {
		return inputGroupAvailRate;
	}
	public void setInputGroupAvailRate(String inputGroupAvailRate) {
		this.inputGroupAvailRate = inputGroupAvailRate;
	}
	public long getInputAccurateNum() {
		return inputAccurateNum;
	}
	public void setInputAccurateNum(long inputAccurateNum) {
		this.inputAccurateNum = inputAccurateNum;
	}
	public String getInputAccuracy() {
		return inputAccuracy;
	}
	public void setInputAccuracy(String inputAccuracy) {
		this.inputAccuracy = inputAccuracy;
	}
	public long getOutputNum() {
		return outputNum;
	}
	public void setOutputNum(long outputNum) {
		this.outputNum = outputNum;
	}
	public String getOutputSpeed() {
		return outputSpeed;
	}
	public void setOutputSpeed(String outputSpeed) {
		this.outputSpeed = outputSpeed;
	}
	public long getOutputFieldNum() {
		return outputFieldNum;
	}
	public void setOutputFieldNum(long outputFieldNum) {
		this.outputFieldNum = outputFieldNum;
	}
	public String getOutputFieldRate() {
		return outputFieldRate;
	}
	public void setOutputFieldRate(String outputFieldRate) {
		this.outputFieldRate = outputFieldRate;
	}
	public long getOutputGroupNum() {
		return outputGroupNum;
	}
	public void setOutputGroupNum(long outputGroupNum) {
		this.outputGroupNum = outputGroupNum;
	}
	public String getOutputGroupRate() {
		return outputGroupRate;
	}
	public void setOutputGroupRate(String outputGroupRate) {
		this.outputGroupRate = outputGroupRate;
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
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getoKey() {
		return oKey;
	}
	public void setoKey(String oKey) {
		this.oKey = oKey;
	}
	public String getoValue() {
		return oValue;
	}
	public void setoValue(String oValue) {
		this.oValue = oValue;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getActionTypeDesc() {
		return actionTypeDesc;
	}
	public void setActionTypeDesc(String actionTypeDesc) {
		this.actionTypeDesc = actionTypeDesc;
	}
	
}
