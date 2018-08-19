package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 协议还原数据实体类
 * @author zjw
 *
 */
public class RestoreMonitorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 创建时间
	 */
	private String createtime;
	/**
	 * 协议还原输入数据量
	 */
	private Long restoreinput;
	/**
	 * 协议还原输出数据量(bcp)
	 */
	private Long restoreoutputbcp;
	/**
	 * 协议还原输出数据量(zip)
	 */
	private Long restoreoutputzip;
	/**
	 * 协议还原丢弃数据量
	 */
	private Long restorediscard;
	/**
	 * 数据源
	 */
	private String datasource;
	/**
	 * 大协议
	 */
	private String bprotocol;
	/**
	 * 小协议
	 */
	private String sprotocol;
	/**
	 * 动作类型
	 */
	private String action;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Long getRestoreinput() {
		return restoreinput;
	}

	public void setRestoreinput(Long restoreinput) {
		this.restoreinput = restoreinput;
	}

	public Long getRestoreoutputbcp() {
		return restoreoutputbcp;
	}

	public void setRestoreoutputbcp(Long restoreoutputbcp) {
		this.restoreoutputbcp = restoreoutputbcp;
	}

	public Long getRestoreoutputzip() {
		return restoreoutputzip;
	}

	public void setRestoreoutputzip(Long restoreoutputzip) {
		this.restoreoutputzip = restoreoutputzip;
	}

	public Long getRestorediscard() {
		return restorediscard;
	}

	public void setRestorediscard(Long restorediscard) {
		this.restorediscard = restorediscard;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getBprotocol() {
		return bprotocol;
	}

	public void setBprotocol(String bprotocol) {
		this.bprotocol = bprotocol;
	}

	public String getSprotocol() {
		return sprotocol;
	}

	public void setSprotocol(String sprotocol) {
		this.sprotocol = sprotocol;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	
	
	
}
