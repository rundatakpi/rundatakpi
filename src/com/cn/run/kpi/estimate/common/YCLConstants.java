package com.cn.run.kpi.estimate.common;

import java.util.HashMap;
import java.util.Map;

public class YCLConstants {
	
	/**预处理正常样例包取值个数*/
	public static final Integer NORMAL_SIZE = 3;
	
	/** 预处理不正常样例包取值个数*/
	public static final Integer UNNORMAL_SIZE = 3;
	
	/**预处理样例包正常值*/
	public static final String NORMAL_VAL = "1";
	
	/**预处理样例包非正常值*/
	public static final String UNNORMAL_VAL = "0";
	
	/**预处理样例包正常值描述*/
	public static final String NORMAL_DESC = "正常数据";
	
	/**预处理样例包非正常值描述*/
	public static final String UNNORMAL_DESC = "异常数据";
	
	public static final Map EXMAPLE_MAP = new HashMap<>();
	
	
	static {
		EXMAPLE_MAP.put(NORMAL_VAL,NORMAL_DESC);
		EXMAPLE_MAP.put(UNNORMAL_VAL,UNNORMAL_DESC);
	}
	
	public static String getExample(String key) {
		return (String) EXMAPLE_MAP.get(key);
	}
	
}
