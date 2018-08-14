package com.cn.run.kpi.datamonitor.service.entity;

import java.io.Serializable;

/**
 * app调用中间件次数封装类
 * @author Administrator
 *
 */
public class AppMiddleWareEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5531761853648514363L;

	private Long id;

	private String createDate;
	
	private String app;
	
	private Long invokeNum;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Long getInvokeNum() {
		return invokeNum;
	}

	public void setInvokeNum(Long invokeNum) {
		this.invokeNum = invokeNum;
	}
	
}
