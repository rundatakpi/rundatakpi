package com.cn.run.kpi.datamonitor.store.entity;

import java.io.Serializable;

/**
 * 九大资源数据封装类
 * @author zg
 *
 */
public class NineResourceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2886307290874642072L;
	
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 资源名
	 */
	private String resource;
	
	/**
	 * 数据量
	 */
	private Long dataNum;
	
	/**
	 * 创建时间
	 */
	private String createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public Long getDataNum() {
		return dataNum;
	}

	public void setDataNum(Long dataNum) {
		this.dataNum = dataNum;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
