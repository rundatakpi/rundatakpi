package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;

/**
 * 入库日志数据-实体类
 * @author zjw
 *
 */
public class ScheduleBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/*时间字符串*/
	private String datestr;
	/*数据类型*/
	private Integer dadatype;
	/*描述*/
	private String describe;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDatestr() {
		return datestr;
	}
	public void setDatestr(String datestr) {
		this.datestr = datestr;
	}
	public Integer getDadatype() {
		return dadatype;
	}
	public void setDadatype(Integer dadatype) {
		this.dadatype = dadatype;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	
	
	
	
	

}
