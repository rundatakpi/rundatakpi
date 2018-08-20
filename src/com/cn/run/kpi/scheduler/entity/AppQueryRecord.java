package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;

/**
 * 中间件查询数据量表
 * @author q4189
 *
 */
public class AppQueryRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	//查询时间
	private String capturetime;
	//查询sql
	private String sqlstr;
	//协议
	private String protocol;
	//调用系统ID（应用）
	private String system_id;
	//查询成功与否标识，0成功，1失败
	private String status;
	//错误描述
	private String error_desc;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCapturetime() {
		return capturetime;
	}
	public void setCapturetime(String capturetime) {
		this.capturetime = capturetime;
	}
	public String getSqlstr() {
		return sqlstr;
	}
	public void setSqlstr(String sqlstr) {
		this.sqlstr = sqlstr;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getSystem_id() {
		return system_id;
	}
	public void setSystem_id(String system_id) {
		this.system_id = system_id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError_desc() {
		return error_desc;
	}
	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}
	
	

}
