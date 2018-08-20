package com.cn.run.kpi.datamonitor.preprocess.entity;

import java.io.Serializable;

public class PreProcessRealTimeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6806735079884980423L;

	private Long id;
	
	private Long inputNum;
	
	private Long outputNum;
	
	private String createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInputNum() {
		return inputNum;
	}

	public void setInputNum(Long inputNum) {
		this.inputNum = inputNum;
	}

	public Long getOutputNum() {
		return outputNum;
	}

	public void setOutputNum(Long outputNum) {
		this.outputNum = outputNum;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
