package com.cn.run.kpi.entity;

public class ReportLog {
	
	private Long id;
	
	private String messageType;
	
	private String sendStatus;
	
	private String sendTime;
	
	private String notifyObject;
	
	private String notifyObjectRole;
	
	private String receiveNum;
	
	private String messageContent;
	
	public ReportLog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getNotifyObject() {
		return notifyObject;
	}

	public void setNotifyObject(String notifyObject) {
		this.notifyObject = notifyObject;
	}

	public String getNotifyObjectRole() {
		return notifyObjectRole;
	}

	public void setNotifyObjectRole(String notifyObjectRole) {
		this.notifyObjectRole = notifyObjectRole;
	}

	public String getReceiveNum() {
		return receiveNum;
	}

	public void setReceiveNum(String receiveNum) {
		this.receiveNum = receiveNum;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
}
