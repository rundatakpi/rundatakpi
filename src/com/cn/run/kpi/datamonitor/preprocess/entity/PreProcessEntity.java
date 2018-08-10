package com.cn.run.kpi.datamonitor.preprocess.entity;

import java.io.Serializable;

/**
 * 数据源预处理数据的封装类
 * @author zg
 *
 */
public class PreProcessEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 数据源
	 */
	private String dataSource;
	
	/**
	 * 输入量
	 */
	private Long inputNum;
	
	/**
	 * 输出量
	 */
	private Long outputNum;
	
	/**
	 * 抛弃量
	 */
	private Long discardNum;

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
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

	public Long getDiscardNum() {
		return discardNum;
	}

	public void setDiscardNum(Long discardNum) {
		this.discardNum = discardNum;
	}
}
