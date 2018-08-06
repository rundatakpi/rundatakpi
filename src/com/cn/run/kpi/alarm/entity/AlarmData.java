package com.cn.run.kpi.alarm.entity;

import java.io.Serializable;
/**
 * 告警信息-实体类
 * @author chenyan
 *
 */
public class AlarmData implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/*告警时间*/
	private String alarmTime;
	/*告警级别*/
	private String alarmLevel;
	/*告警内容*/
	private String alarmContent;
	/*处理状态*/
	private String processState;
	/*是否删除*/
	private String is_deleted;
	/*起始位置*/
	private int start;
	/*长度*/
	private int length;
	
	
	public long getId() {
		return id;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public String getAlarmLevel() {
		return alarmLevel;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public String getProcessState() {
		return processState;
	}
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	public void setProcessState(String processState) {
		this.processState = processState;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
}
