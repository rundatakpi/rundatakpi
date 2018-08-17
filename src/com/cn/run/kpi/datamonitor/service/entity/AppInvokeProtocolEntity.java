package com.cn.run.kpi.datamonitor.service.entity;

import java.io.Serializable;

/**
 * 应用调用中间件封装类
 * @author zg
 *
 */
public class AppInvokeProtocolEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4413011787554518043L;

	private Long id;
	
	private String protocol;
	
	private Long invokeNum;
	
	private String createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Long getInvokeNum() {
		return invokeNum;
	}

	public void setInvokeNum(Long invokeNum) {
		this.invokeNum = invokeNum;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
