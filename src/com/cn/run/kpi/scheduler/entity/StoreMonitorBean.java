package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;

/**
 * 存储数据-实体类
 * @author zjw
 *
 */
public class StoreMonitorBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 数据类型(1:资源库，2:对象库)
	 */
	private int datatype;
	/**
	 * 数据存储大小
	 */
	private Long store;
	/**
	 * 资源名称
	 */
	private String sourcename;
	/**
	 * 时间
	 */
	private String createtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDatatype() {
		return datatype;
	}

	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}

	public Long getStore() {
		return store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	public String getSourcename() {
		return sourcename;
	}

	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	
	
	

}
