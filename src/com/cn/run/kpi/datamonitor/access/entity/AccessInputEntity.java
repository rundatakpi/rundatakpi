package com.cn.run.kpi.datamonitor.access.entity;

import java.io.Serializable;

/**
 * 接入监测数据实体类
 * @author zg
 *
 */
public class AccessInputEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3372968021081347700L;


	/**
	 * 日期
	 */
	private String date;
	
	
	/**
	 * 输入数据量
	 */
	private Long inputNum;


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Long getInputNum() {
		return inputNum;
	}


	public void setInputNum(Long inputNum) {
		this.inputNum = inputNum;
	}
	
}
