package com.cn.run.kpi.datamonitor.compress.entity;

import java.io.Serializable;

public class BacklogEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 80375532111876404L;

	private Long id;
	
	private String createDate;
	
	private Long machineBacklogNum;
	
	private Long machineBacklogSize;
	
	private Long kafkaBacklogNum;
	
	private Long kafkaBacklogSize;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getMachineBacklogNum() {
		return machineBacklogNum;
	}

	public void setMachineBacklogNum(Long machineBacklogNum) {
		this.machineBacklogNum = machineBacklogNum;
	}

	public Long getMachineBacklogSize() {
		return machineBacklogSize;
	}

	public void setMachineBacklogSize(Long machineBacklogSize) {
		this.machineBacklogSize = machineBacklogSize;
	}

	public Long getKafkaBacklogNum() {
		return kafkaBacklogNum;
	}

	public void setKafkaBacklogNum(Long kafkaBacklogNum) {
		this.kafkaBacklogNum = kafkaBacklogNum;
	}

	public Long getKafkaBacklogSize() {
		return kafkaBacklogSize;
	}

	public void setKafkaBacklogSize(Long kafkaBacklogSize) {
		this.kafkaBacklogSize = kafkaBacklogSize;
	}
	
}

