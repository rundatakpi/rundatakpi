package com.cn.run.kpi.entity;

/**
 * 样例包监控-实体类
 * @author zg
 *
 */
public class SampleMonitor {

	/**
	 * id
	 */
	private long id;
	
	/**
	 * 数据源
	 */
	private String dataSource;
	
	/**
	 * 大协议
	 */
	private String bProtocol;
	
	/**
	 * 小协议
	 */
	private String sProtocol;

	/**
	 * 原始字段状态
	 */
	private int originalFieldState;
	
	/**
	 * 预处理字段状态
	 */
	private int preprocessingFieldState;
	
	/**
	 * 结构化提取后字段状态
	 */
	private int structExtractFieldState;
	
	/**
	 * 对象化提取后字段状态
	 */
	private int objectExtractFieldState;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	public String getbProtocol() {
		return bProtocol;
	}

	public void setbProtocol(String bProtocol) {
		this.bProtocol = bProtocol;
	}

	public String getsProtocol() {
		return sProtocol;
	}

	public void setsProtocol(String sProtocol) {
		this.sProtocol = sProtocol;
	}

	public int getOriginalFieldState() {
		return originalFieldState;
	}

	public void setOriginalFieldState(int originalFieldState) {
		this.originalFieldState = originalFieldState;
	}

	public int getPreprocessingFieldState() {
		return preprocessingFieldState;
	}

	public void setPreprocessingFieldState(int preprocessingFieldState) {
		this.preprocessingFieldState = preprocessingFieldState;
	}

	public int getStructExtractFieldState() {
		return structExtractFieldState;
	}

	public void setStructExtractFieldState(int structExtractFieldState) {
		this.structExtractFieldState = structExtractFieldState;
	}

	public int getObjectExtractFieldState() {
		return objectExtractFieldState;
	}

	public void setObjectExtractFieldState(int objectExtractFieldState) {
		this.objectExtractFieldState = objectExtractFieldState;
	}
	
}
