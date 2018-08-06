package com.cn.run.kpi.index.entity;

/**
 * 告警信息-实体类
 * @author zg
 *
 */
public class WarnMessage {

	/**
	 * id
	 */
	private long id;
	
	/**
	 * 告警时间
	 */
	private String warnTime;
	
	/**
	 * 告警等级
	 */
	private String warnGrade;
	
	/**
	 * 告警内容
	 */
	private String warnContent;
	
	/**
	 * 处理状态
	 */
	private int status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	public String getWarnGrade() {
		return warnGrade;
	}

	public void setWarnGrade(String warnGrade) {
		this.warnGrade = warnGrade;
	}

	public String getWarnContent() {
		return warnContent;
	}

	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
