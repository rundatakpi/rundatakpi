package com.cn.run.kpi.datamonitor.access.entity;

import java.io.Serializable;

public class AccessDiscardEntiy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8288076681608472855L;

	/**
	 * 原因
	 */
	private String discardReason;
	
	/**
	 * 抛弃数据量
	 */
	private Long discardNum;

	public String getDiscardReason() {
		return discardReason;
	}

	public void setDiscardReason(String discardReason) {
		this.discardReason = discardReason;
	}

	public Long getDiscardNum() {
		return discardNum;
	}

	public void setDiscardNum(Long discardNum) {
		this.discardNum = discardNum;
	}
	
}
