package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;

/**
 * 格转接入数据-实体类
 * @author chenyan
 *
 */
public class TransInfo implements Serializable{

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
	/*动作类型*/
	private String actionTypeDesc;
	/*输入数据条数*/
	private long inputNum;
	/*输入数据速度*/
	private long inputSpeed;
	/*输入数据填充条数*/
	private long inputFieldNum;
	/*输入数据字段填充率*/
	private String inputFieldRate;
	/*输入数据依赖字段组条数*/
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
	/*数据生成时间*/
	private String createDate;
	/*起始位置*/
	private int start;
	/*长度*/
	private int length;
	/*列名*/
	private String colName;
	/*趋势图的日期*/
	private String chkVal;
	/*趋势图的日期对应的数值*/
	private String chkDisplay;
	
	
	
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
	public String getActionTypeDesc() {
		return actionTypeDesc;
	}
	public void setActionTypeDesc(String actionTypeDesc) {
		this.actionTypeDesc = actionTypeDesc;
	}
	public long getInputNum() {
		return inputNum;
	}
	public void setInputNum(long inputNum) {
		this.inputNum = inputNum;
	}
	public long getInputSpeed() {
		return inputSpeed;
	}
	public void setInputSpeed(long inputSpeed) {
		this.inputSpeed = inputSpeed;
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
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
	
	
}
