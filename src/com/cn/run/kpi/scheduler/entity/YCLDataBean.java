package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 预处理数据实体类
 * @author zjw
 *
 */
public class YCLDataBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 数据源
	 */
	private String dataSource;
	/**
	 * 数据类型
	 */
	private String dataType;
	
	/**
	 * 数据量
	 */
	private Long dataNum;
	/**
	 * 创建时间
	 */
	private String createtime;
	/**
	 * 协议
	 */
	private String protocol;
	/**
	 * 协议id
	 */
	private String protocolId;
	/**
	 * 动作类型
	 */
	private String actionType;
	/**
	 * 采集地
	 */
	private String collectPlace;
	/**
	 * 错误数据类型
	 */
	private Integer errorType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public Long getDataNum() {
		return dataNum;
	}
	public void setDataNum(Long dataNum) {
		this.dataNum = dataNum;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getProtocolId() {
		return protocolId;
	}
	public void setProtocolId(String protocolId) {
		this.protocolId = protocolId;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getCollectPlace() {
		return collectPlace;
	}
	public void setCollectPlace(String collectPlace) {
		this.collectPlace = collectPlace;
	}
	public Integer getErrorType() {
		return errorType;
	}
	public void setErrorType(Integer errorType) {
		this.errorType = errorType;
	}
	
	
	
	
}
