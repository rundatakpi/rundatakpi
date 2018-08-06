package com.cn.run.kpi.datamonitor.restore.entity;

import java.io.Serializable;

/**
 * 协议还原输出数据实体类
 * @author Administrator
 *
 */
public class RestoreOutputEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5663752783252581310L;

	private String time;
    
    private Long outputNum;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getOutputNum() {
		return outputNum;
	}

	public void setOutputNum(Long outputNum) {
		this.outputNum = outputNum;
	}
    
}
