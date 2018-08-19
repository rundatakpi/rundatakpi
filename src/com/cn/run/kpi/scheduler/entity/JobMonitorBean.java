package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;

/**
 * 存储数据-实体类
 * @author zjw
 *
 */
public class JobMonitorBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 日期
	 */
	private String timekey;
	/**
	 * 任务状态
	 */
	private Integer job_status;
	/**
	 * 任务名称
	 */
	private String job_name;
	/**
	 * 开始时间
	 */
	private String start_time;
	/**
	 * 结束时间
	 */
	private String end_time;
	/**
	 * 入库时间
	 */
	private String input_time;
	/**
	 * 服务器地址
	 */
	private String hostip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimekey() {
		return timekey;
	}

	public void setTimekey(String timekey) {
		this.timekey = timekey;
	}

	public Integer getJob_status() {
		return job_status;
	}

	public void setJob_status(Integer job_status) {
		this.job_status = job_status;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String input_time) {
		this.input_time = input_time;
	}

	public String getHostip() {
		return hostip;
	}

	public void setHostip(String hostip) {
		this.hostip = hostip;
	}
	
	
	
	

}
