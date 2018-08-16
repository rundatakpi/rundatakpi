package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 资源库表
 * @author q4189
 *
 */
public class LogCount implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//统计ID
	private String statid;
	//日期
	private Date timekey;
	//数据源
	private String datasource;
	//大协议
	private String dataset;
	//小协议
	private String h010001;
	//指标类型
	private String fieldtype;
	//指标字段
	private String field;
	//数据总条数
	private long totalcnt;
	//满足指标条件的数据条数
	private long datacnt;
	//入库时间
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
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getDataset() {
		return dataset;
	}
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}
	public String getH010001() {
		return h010001;
	}
	public void setH010001(String h010001) {
		this.h010001 = h010001;
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
	public void setDatacnt(Integer datacnt) {
		this.datacnt = datacnt;
	}
	public Date getInput_time() {
		return input_time;
	}
	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}
	
	

}
