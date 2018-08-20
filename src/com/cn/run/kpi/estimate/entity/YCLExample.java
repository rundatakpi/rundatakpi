package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;
/**
 * 预处理样例信息类
 * @author chenyan
 *
 */
public class YCLExample implements Serializable{

	private static final long serialVersionUID = 1L;
	/*主键*/
	private long id;
	/*数据源*/
	private String dsCode;
	/*大协议*/
	private String bProtocolCode;
	/*来源描述*/
	private String sourceDesc;
	/*认证号码*/
	private String authentNumber;
	/*认证类型*/
	private String authenType;
	/*发送者名称*/
	private String senderName;
	/*接收者名称*/
	private String receiverName;
	/*基站*/
	private String baseStation;
	/*样例包取值个数*/
	private Integer size;
	
	
	
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
	public String getbProtocolCode() {
		return bProtocolCode;
	}
	public void setbProtocolCode(String bProtocolCode) {
		this.bProtocolCode = bProtocolCode;
	}
	public String getSourceDesc() {
		return sourceDesc;
	}
	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}
	public String getAuthentNumber() {
		return authentNumber;
	}
	public void setAuthentNumber(String authentNumber) {
		this.authentNumber = authentNumber;
	}
	public String getAuthenType() {
		return authenType;
	}
	public void setAuthenType(String authenType) {
		this.authenType = authenType;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getBaseStation() {
		return baseStation;
	}
	public void setBaseStation(String baseStation) {
		this.baseStation = baseStation;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}

}
