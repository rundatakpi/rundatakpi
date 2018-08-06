package com.cn.run.kpi.datamonitor.restore.entity;

import java.io.Serializable;

/**
 * 协议还原输入数据实体类
 * @author Administrator
 *
 */
public class RestoreInputEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8351904397932824478L;
	
	/**
	 * 时间
	 */
	private String time;
	
	/**
	 * 协议还原实时输入数据量
	 */
	private Long inputNum;
	
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
	
}
