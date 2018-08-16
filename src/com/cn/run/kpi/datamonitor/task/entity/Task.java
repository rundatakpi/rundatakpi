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
	 * 服务器地址
	 */
	private String server;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 运行时间
	 */
	private String runningTime;

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

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	
}
