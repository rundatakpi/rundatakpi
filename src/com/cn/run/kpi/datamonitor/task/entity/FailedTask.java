package com.cn.run.kpi.datamonitor.task.entity;

import java.io.Serializable;

public class FailedTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1098098098522297632L;

	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 服务器地址
	 */
	private String server;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 失败时间
	 */
	private String failTime;
	
	/**
	 * 失败原因
	 */
	private String reason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFailTime() {
		return failTime;
	}

	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
