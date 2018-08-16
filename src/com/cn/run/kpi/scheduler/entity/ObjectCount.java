package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 对象库表
 * @author q4189
 *
 */
public class ObjectCount implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String statid;
	private Date timekey;
	private String objecttype;
	private String fieldtype;
	private String field;
	private long totalcnt;
	private long datacnt;
	private Date input_time;
	public String getStatid() {
		return statid;
	}
	public void setStatid(String statid) {
		this.statid = statid;
	}
	public Date getTimekey() {
		return timekey;
	}
	public void setTimekey(Date timekey) {
		this.timekey = timekey;
	}
	public String getObjecttype() {
		return objecttype;
	}
	public void setObjecttype(String objecttype) {
		this.objecttype = objecttype;
	}
	public String getFieldtype() {
		return fieldtype;
	}
	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public long getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(long totalcnt) {
		this.totalcnt = totalcnt;
	}
	public long getDatacnt() {
		return datacnt;
	}
	public void setDatacnt(long datacnt) {
		this.datacnt = datacnt;
	}
	public Date getInput_time() {
		return input_time;
	}
	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}
	
	

}
