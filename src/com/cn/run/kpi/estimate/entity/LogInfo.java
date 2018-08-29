package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 入库日志数据-实体类
 * @author chenyan
 *
 */
public class LogInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/**数据集*/
	private String dataSet;
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
	/*大协议入库总条数*/
	private long totalNum;
	/*大协议入库条数*/
	private long inputNum;
	/*大协议入库率*/
	private String inputRate;
	/*字段数*/
	private String fieldNum;
	/*数据准确条数*/
	private String accurateNum;
	/*大协议数据准确率*/
	private Float accuracy;
	/*起始位置*/
	private int start;
	/*长度*/
	private int length;
	/*数据生成时间*/
	private String createTime;
	/*列名*/
	private String colName;
	/*趋势图的日期*/
	private String chkVal;
	/*趋势图的日期对应的数值*/
	private String chkDisplay;
	/*创建时间*/
	private String createDate;
	/*小协议数据总条数*/
	private long dataNum;
	/*关联的字段类型*/
	private List<LogField> logFieldList = new ArrayList<LogField>();
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDataSet() {
		return dataSet;
	}
	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
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
	public long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	public long getInputNum() {
		return inputNum;
	}
	public void setInputNum(long inputNum) {
		this.inputNum = inputNum;
	}
	public String getInputRate() {
		return inputRate;
	}
	public void setInputRate(String inputRate) {
		this.inputRate = inputRate;
	}
	public String getFieldNum() {
		return fieldNum;
	}
	public void setFieldNum(String fieldNum) {
		this.fieldNum = fieldNum;
	}
	public String getAccurateNum() {
		return accurateNum;
	}
	public void setAccurateNum(String accurateNum) {
		this.accurateNum = accurateNum;
	}
	public Float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Float accuracy) {
		this.accuracy = accuracy;
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public long getDataNum() {
		return dataNum;
	}
	public void setDataNum(long dataNum) {
		this.dataNum = dataNum;
	}
	public List<LogField> getLogFieldList() {
		return logFieldList;
	}
	public void setLogFieldList(List<LogField> logFieldList) {
		this.logFieldList = logFieldList;
	}
	
	
	

	
}
