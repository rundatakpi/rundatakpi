package com.cn.run.kpi.commons.content;

 
import java.util.HashMap;
import java.util.Map;

public interface Constants {

	@SuppressWarnings("rawtypes")
	public static final Map RESOURCES = new HashMap();
	public static final String ROOT = System.getProperty("web.root");//工程根目录
  
	public static final String TIMESTYLE="yyyyMMdd";//时间格式
	public static final String TIMESTAMPSTYLE="yyyyMMdd HH:mm:ss";//时间格式
	public static final String JSON_SUFFIX = ".json";
	
	
	/**
	 * 协议
	 */
	public static Map<String, String> PROTOCOLMAP = new HashMap<String, String>();
	/**
	 * 页面大小
	 */
	public static final String PAGE_SIZE = "length";
	
	/**
	 * 起始记录
	 */
	public static final String PAGE_START = "start";
	
	/**
	 * 接入监测-抛弃数据量
	 */
	public static final String DISCARD_NUM = "discardNum";
	
	/**
	 * 接入监测-抛弃原因
	 */
	public static final String DISCARD_REASON = "discardReason";
	
	/**
	 * 接入监测-日期
	 */
	public static final String ACCESS_DATE = "accessDate";
	
	/**
	 * 接入监测-输入数据量
	 */
	public static final String ACCESS_INPUT_NUM = "accessInputNum";
	
	/**
	 * 接入监测-输入数据
	 */
	public static final String INPUT_DATA = "inputData";
	
	/**
	 * 接入监测-抛弃数据
	 */
	public static final String DISCARD_DATA = "discardData";
	
	/**
	 * 接入监测-当前接入输入数据总量
	 */
	public static final String TOTAL_INPUT_NUM = "totalInputNum";
	
	/**
	 * 接入监测-当前接入输入数据平均流量
	 */
	public static final String AVERAGE_INPUT_NUM = "averageInputNum";
	
	/**
	 * 接入监测-昨日接入输入数据量
	 */
	public static final String YESTERDAY_INPUT_NUM = "yesterdayInputNum";
	
	/**
	 * 接入监测-昨日接入输入数据量
	 */
	public static final String QUERY_ALL = "全部";
	
	/**
	 * 一个星期
	 */
	public static final int DAY_WEEK = 7;
	
	/**
	 * 一个月
	 */
	public static final int DAY_MONTH = 30;
	
	/**
	 * 24小时
	 */
	public static final int HOUR_ONEDAY = 24;
}
