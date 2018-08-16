package com.cn.run.kpi.scheduler.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * kafka数据量表
 * @author q4189
 *
 */
public class KafkaData  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date input_time;
	private String topic_name;
	private long partition_id;
	private long unconsume_count;
	public Date getInput_time() {
		return input_time;
	}
	public void setInput_time(Date input_time) {
		this.input_time = input_time;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public long getPartition_id() {
		return partition_id;
	}
	public void setPartition_id(long partition_id) {
		this.partition_id = partition_id;
	}
	public long getUnconsume_count() {
		return unconsume_count;
	}
	public void setUnconsume_count(long unconsume_count) {
		this.unconsume_count = unconsume_count;
	}
	
	
	
}
