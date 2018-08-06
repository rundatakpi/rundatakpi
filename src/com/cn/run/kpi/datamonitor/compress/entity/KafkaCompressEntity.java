package com.cn.run.kpi.datamonitor.compress.entity;

import java.io.Serializable;

/**
 * 
 * @author zg
 *
 */
public class KafkaCompressEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -69647246400504110L;
	
	/**
	 * 时间
	 */
	private String time;
	
	/**
	 * 数据输入量
	 */
	private Long inputNum;
	
	/**
	 * 数据积压量
	 */
	private Long compressNum;
	
	/**
	 * 数据处理量
	 */
	private Long processNum;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getInputNum() {
		return inputNum;
	}

	public void setInputNum(Long inputNum) {
		this.inputNum = inputNum;
	}

	public Long getCompressNum() {
		return compressNum;
	}

	public void setCompressNum(Long compressNum) {
		this.compressNum = compressNum;
	}

	public Long getProcessNum() {
		return processNum;
	}

	public void setProcessNum(Long processNum) {
		this.processNum = processNum;
	}
}
