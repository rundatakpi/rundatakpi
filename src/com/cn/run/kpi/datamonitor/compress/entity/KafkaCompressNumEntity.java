package com.cn.run.kpi.datamonitor.compress.entity;

import java.io.Serializable;

public class KafkaCompressNumEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7496410503775994713L;

	private String date;
	
	private Long num;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}
