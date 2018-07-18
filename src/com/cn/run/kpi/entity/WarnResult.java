package com.cn.run.kpi.entity;

public class WarnResult {
	private Long id;

	private String city;
	
	private String warnSource;
	
	private String warnType;
	
	private String cluster;
	
	private String warnOption;
	
	private String concreteWarnOption;
	
	private String nodeName;
	
	private String nodeIp;
	
	private String exceptinResult;
	
	private String warnTime;
	
	private String warnGrade;
	
	private String status;
	
	private String operation;
	
	private String personInCharge;
	
	private String resolveTime;

	public WarnResult() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWarnSource() {
		return warnSource;
	}

	public void setWarnSource(String warnSource) {
		this.warnSource = warnSource;
	}

	public String getWarnType() {
		return warnType;
	}

	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getWarnOption() {
		return warnOption;
	}

	public void setWarnOption(String warnOption) {
		this.warnOption = warnOption;
	}

	public String getConcreteWarnOption() {
		return concreteWarnOption;
	}

	public void setConcreteWarnOption(String concreteWarnOption) {
		this.concreteWarnOption = concreteWarnOption;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeIp() {
		return nodeIp;
	}

	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}

	public String getExceptinResult() {
		return exceptinResult;
	}

	public void setExceptinResult(String exceptinResult) {
		this.exceptinResult = exceptinResult;
	}

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	public String getWarnGrade() {
		return warnGrade;
	}

	public void setWarnGrade(String warnGrade) {
		this.warnGrade = warnGrade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}
}
