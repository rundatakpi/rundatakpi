package com.cn.run.kpi.datamonitor.service.entity;

public class ServiceInvokeException {

	private Long id;
	
	private String invokeTime;
	
	private String invokeApplication;
	
	private String invokeStatement;
	
	private String exceptionReason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvokeTime() {
		return invokeTime;
	}

	public void setInvokeTime(String invokeTime) {
		this.invokeTime = invokeTime;
	}

	public String getInvokeApplication() {
		return invokeApplication;
	}

	public void setInvokeApplication(String invokeApplication) {
		this.invokeApplication = invokeApplication;
	}

	public String getInvokeStatement() {
		return invokeStatement;
	}

	public void setInvokeStatement(String invokeStatement) {
		this.invokeStatement = invokeStatement;
	}

	public String getExceptionReason() {
		return exceptionReason;
	}

	public void setExceptionReason(String exceptionReason) {
		this.exceptionReason = exceptionReason;
	}
	
}
