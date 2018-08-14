package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;
/**
 * 预处理样例信息类
 * @author chenyan
 *
 */
public class YCLExampleData implements Serializable{

	private static final long serialVersionUID = 1L;
	/*主键*/
	private long id;
	/*来源描述*/
	private String sourcedesc;
	/*认证号码*/
	private String authentumber;
	/*认证类型*/
	private String authentype;
	/*发送者名称*/
	private String sendername;
	/*接收者名称*/
	private String receivername;
	/*基站*/
	private String basestation;
	/*预处理质量id*/
	private long qid;
	/*样例包取值个数*/
	private Integer size;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSourcedesc() {
		return sourcedesc;
	}

	public void setSourcedesc(String sourcedesc) {
		this.sourcedesc = sourcedesc;
	}

	public String getAuthentumber() {
		return authentumber;
	}

	public void setAuthentumber(String authentumber) {
		this.authentumber = authentumber;
	}

	public String getAuthentype() {
		return authentype;
	}

	public void setAuthentype(String authentype) {
		this.authentype = authentype;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getBasestation() {
		return basestation;
	}

	public void setBasestation(String basestation) {
		this.basestation = basestation;
	}

	public long getQid() {
		return qid;
	}

	public void setQid(long qid) {
		this.qid = qid;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}


	
	
	

}
