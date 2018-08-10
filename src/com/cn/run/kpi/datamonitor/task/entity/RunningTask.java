package com.cn.run.kpi.datamonitor.task.entity;

import java.io.Serializable;

/**
 * 实时运行任务量封装类
 * @author zg
 *
 */
public class RunningTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 349060400009785536L;

	/**
	 * 时间
	 */
	private String time;
	
	/**
	 * 任务量
	 */
	private Long taskNum;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(Long taskNum) {
		this.taskNum = taskNum;
	}
	
}
