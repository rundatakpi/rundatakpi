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
	/*轻微告警情况*/
	private String slightalarm;
	/*一般告警情况*/
	private String commonlyalarm;
	/*严重告警情况*/
	private String seriousalarm;
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
	public String getSlightalarm() {
		return slightalarm;
	}
	public void setSlightalarm(String slightalarm) {
		this.slightalarm = slightalarm;
	}
	public String getCommonlyalarm() {
		return commonlyalarm;
	}
	public void setCommonlyalarm(String commonlyalarm) {
		this.commonlyalarm = commonlyalarm;
	}
	public String getSeriousalarm() {
		return seriousalarm;
	}
	public void setSeriousalarm(String seriousalarm) {
		this.seriousalarm = seriousalarm;
	}
	

}
