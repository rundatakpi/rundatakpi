package com.cn.run.kpi.entity;

import java.io.Serializable;

public class AlarmInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*告警时间*/
	private String alarmTime;
	/*告警级别*/
	private String alarmLevel;
	/*告警内容*/
	private String alarmContent;
	/*处理状态*/
	private String alarmStatus;
	
	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public String getAlarmContent() {
		return alarmContent;
	}

	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}

	public String getAlarmStatus() {
		return alarmStatus;
	}

	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}
	
	
	
	
	
	
}
