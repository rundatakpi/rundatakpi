package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
/**
 * 对象化数据集实体类
 * @author q4189
 *
 */
public class ObjDataSetBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 数据集名称
	 */
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
