package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 入库日志数据-实体类
 * @author chenyan
 *
 */
public class StoreLogData implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/*数据源编号*/
	private String dataSourceCode;
	/*数据源描述*/
	private String dataSourceDesc;
	/*大协议编码*/
	private String bProtocolCode;
	/*大协议描述*/
	private String bProtocolDesc;
	/*大协议入库条数*/
	private long inputNum;
	/*大协议入库率*/
	private String storageRate;
	/*字段数*/
	private String fieldNum;
	/*大协议数据准确率*/
	private Float bAccuracy;
	/*小协议编码*/
	private String sProtocolCode;
	/*小协议描述*/
	private String sProtocolDesc;
	/*动作类型*/
	private String actionType;
	/*动作描述*/
	private String actionTypeDesc;
	/*小协议数据条数*/
	private String dataNum;
	/*字段编码*/
	private String fieldCode;
	/*包含的字段列表*/
	private List<StoreFieldData> storeFieldList;
	/*起始位置*/
	private int start;
	/*长度*/
	private int length;
	/*开始时间*/
	private String startTime;
	/*结束时间*/
	private String endTime;
	/*数据生成时间*/
	private String createTime;
	/*列名*/
	private String colName;
	/*趋势图的日期*/
	private String logKey;
	/*趋势图的日期对应的数值*/
	private String logValue;
	
	
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
	public String getDataSourceDesc() {
		return dataSourceDesc;
	}
	public void setDataSourceDesc(String dataSourceDesc) {
		this.dataSourceDesc = dataSourceDesc;
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
	public long getInputNum() {
		return inputNum;
	}
	public void setInputNum(long inputNum) {
		this.inputNum = inputNum;
	}
	public String getStorageRate() {
		return storageRate;
	}
	public void setStorageRate(String storageRate) {
		this.storageRate = storageRate;
	}
	public String getFieldNum() {
		return fieldNum;
	}
	public void setFieldNum(String fieldNum) {
		this.fieldNum = fieldNum;
	}
	public Float getbAccuracy() {
		return bAccuracy;
	}
	public void setbAccuracy(Float bAccuracy) {
		this.bAccuracy = bAccuracy;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getLogKey() {
		return logKey;
	}
	public void setLogKey(String logKey) {
		this.logKey = logKey;
	}
	public String getLogValue() {
		return logValue;
	}
	public void setLogValue(String logValue) {
		this.logValue = logValue;
	}
	public List<StoreFieldData> getStoreFieldList() {
		return storeFieldList;
	}
	public void setStoreFieldList(List<StoreFieldData> storeFieldList) {
		this.storeFieldList = storeFieldList;
	}
	public String getActionTypeDesc() {
		return actionTypeDesc;
	}
	public void setActionTypeDesc(String actionTypeDesc) {
		this.actionTypeDesc = actionTypeDesc;
	}
	
	
	
	
	
}
