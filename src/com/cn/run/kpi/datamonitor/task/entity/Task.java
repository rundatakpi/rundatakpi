package com.cn.run.kpi.datamonitor.task.entity;

import java.io.Serializable;

/**
 * 任务类
 * @author zg
 *
 */
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -917984501635498059L;

	/**
	 * 序号
	 */
	private Long id;
	
	/**
	 * 任务状态
	 */
	private int status;
	
	/**
	 * 服务器地址
	 */
	private String serverAddress;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 运行时间
	 */
	private String runningTime;
	
	/**
	 * 失败时间
	 */
	private String failedTime;
	
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
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getFailedTime() {
		return failedTime;
	}

	public void setFailedTime(String failedTime) {
		this.failedTime = failedTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
