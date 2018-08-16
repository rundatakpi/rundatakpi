package com.cn.run.kpi.estimate.common;

import java.util.HashMap;
import java.util.Map;

public class YCLConstants {
	
	
	/**预处理正常样例包取值个数*/
	public static final Integer NORMAL_SIZE = 3;
	
	/** 预处理不正常样例包取值个数*/
	public static final Integer UNNORMAL_SIZE = 3;
	
	/**入库日志数据条数*/
	public static final String STORE_NUM="inputNum";
	/**入库日志数据条数sql*/
	public static final String STORE_NUM_SQL="inputNum";
	/**入库日志数据入库率*/
	public static final String STORE_RATE="storageRate";
	/**入库日志数据入库率sql*/
	public static final String STORE_RATE_SQL="inputNum/totalNum";
	/**入库日志数据字段数*/
	public static final String FIELD_NUM="fieldNum";
	/**入库日志数据字段数sql*/
	public static final String FIELD_NUM_SQL="fieldNum";
	/**入库日志数据准确率*/
	public static final String ACCURATE_NUM="accuracy";
	/**入库日志数据准确率sql*/
	public static final String ACCURATE_NUM_SQL="accurateNum/totalNum";
	
	
	/**入库日志数据入库率*/
	public static final String DATA_ACCURACY="dataAccuracy";
	
	/**入库日志数据列和sql的Map*/
	public static final Map<String, String> COLMAP = new HashMap<String, String>();
	
	static {
		COLMAP.put(STORE_NUM,STORE_NUM_SQL);
		COLMAP.put(STORE_RATE,STORE_RATE_SQL);
		COLMAP.put(FIELD_NUM,FIELD_NUM_SQL);
		COLMAP.put(ACCURATE_NUM,ACCURATE_NUM_SQL);
	}
	
	public static String getLogSql(String key) {
		return COLMAP.get(key);
	}
	
	
}
