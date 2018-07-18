package com.cn.run.kpi.entity;

public class ResultReport {
	
	private Long id;
	
    private String city;
	
	private String warnSource;
	
	private String warnType;
	
	private String warnOption;
	
	private String concreteWarnOption;
	
	private String nodeIp;
	
	private String warnGrade;

	private String warnTime;
	
	private String personInCharge;
	
	private String notifyObject;
	
	private String notifyObjectRole;
	
	private String contract;
	
	private String reportStatus;
	
	private String operation;
	
	public ResultReport() {
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

	public String getNodeIp() {
		return nodeIp;
	}

	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}

	public String getWarnGrade() {
		return warnGrade;
	}

	public void setWarnGrade(String warnGrade) {
		this.warnGrade = warnGrade;
	}

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getNotifyObject() {
		return notifyObject;
	}

	public void setNotifyObject(String notifyObject) {
		this.notifyObject = notifyObject;
	}

	public String getNotifyObjectRole() {
		return notifyObjectRole;
	}

	public void setNotifyObjectRole(String notifyObjectRole) {
		this.notifyObjectRole = notifyObjectRole;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
