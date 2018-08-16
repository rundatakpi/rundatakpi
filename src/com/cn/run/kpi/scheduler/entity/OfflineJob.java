package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 离线任务表
 * @author q4189
 *
 */
public class OfflineJob  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date timekey;
	private String job_status;
	private String job_name;
	private String start_time;
	private String end_time;
	private Date input_time;
	
	public Date getTimekey() {
		return timekey;
	}
	public void setTimekey(Date timekey) {
		this.timekey = timekey;
	}
	public String getJob_status() {
		return job_status;
	}
	public void setJob_status(String job_status) {
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
	public Date getInput_time() {
		return input_time;
	}
	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}
	
}
