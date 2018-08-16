package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 中间件查询数据量表
 * @author q4189
 *
 */
public class QueryRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private long timekey;
	private String sql;
	private String system_id;
	private long capturetime_begin;
	private long capturetime_end;
	private long solrconsume_ttme;
	private long habseconsume_ttme;
	private long status;
	private long result_length;
	private String error_desc;
	private Date input_time;
	public long getTimekey() {
		return timekey;
	}
	public void setTimekey(long timekey) {
		this.timekey = timekey;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getSystem_id() {
		return system_id;
	}
	public void setSystem_id(String system_id) {
		this.system_id = system_id;
	}
	public long getCapturetime_begin() {
		return capturetime_begin;
	}
	public void setCapturetime_begin(long capturetime_begin) {
		this.capturetime_begin = capturetime_begin;
	}
	public long getCapturetime_end() {
		return capturetime_end;
	}
	public void setCapturetime_end(long capturetime_end) {
		this.capturetime_end = capturetime_end;
	}
	public long getSolrconsume_ttme() {
		return solrconsume_ttme;
	}
	public void setSolrconsume_ttme(long solrconsume_ttme) {
		this.solrconsume_ttme = solrconsume_ttme;
	}
	public long getHabseconsume_ttme() {
		return habseconsume_ttme;
	}
	public void setHabseconsume_ttme(long habseconsume_ttme) {
		this.habseconsume_ttme = habseconsume_ttme;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public long getResult_length() {
		return result_length;
	}
	public void setResult_length(long result_length) {
		this.result_length = result_length;
	}
	public String getError_desc() {
		return error_desc;
	}
	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}
	public Date getInput_time() {
		return input_time;
	}
	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}
	
	

}
