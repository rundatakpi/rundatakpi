package com.cn.run.kpi.alarm.entity;

import java.io.Serializable;
import java.util.Date;
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
	/*关联id*/
	private long relateId;
	/*起始位置*/
	private Integer start;
	/*长度*/
	private Integer length;
	/*告警开始时间*/
	private Date startTime;
	/*告警结束时间*/
	private Date endTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getProcessState() {
		return processState;
	}
	public void setProcessState(String processState) {
		this.processState = processState;
	}
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	public long getRelateId() {
		return relateId;
	}
	public void setRelateId(long relateId) {
		this.relateId = relateId;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
	
	
}
