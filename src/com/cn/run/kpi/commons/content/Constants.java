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
	 * 页面大小
	 */
	public static final String PAGE_SIZE = "length";
	
	/**
	 * 起始记录
	 */
	public static final String PAGE_START = "start";
}
