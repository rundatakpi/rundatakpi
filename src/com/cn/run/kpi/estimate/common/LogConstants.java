package com.cn.run.kpi.estimate.common;

import java.util.HashMap;
import java.util.Map;

public class LogConstants {
	
	/*入库日志数据条数*/
	public static final String INPUT_NUM="inputNum";
	/*入库日志数据条数sql*/
	public static final String INPUT_NUM_SQL="inputNum";
	/*入库日志数据入库率*/
	public static final String INPUT_RATE="inputRate";
	/*入库日志数据入库率sql*/
	public static final String INPUT_RATE_SQL="inputNum/totalNum";
	/*入库日志数据字段数*/
	public static final String FIELD_NUM="fieldNum";
	/*入库日志数据字段数sql*/
	public static final String FIELD_NUM_SQL="fieldNum";
	/*大协议入库准确率*/
	public static final String BIG_ACCURACY = "bAccuracy";
	/*大协议入库准确率SQL*/
	public static final String BIG_ACCURACY_SQL = "accurateNum/totalNum";
	/*小协议数据条数*/
	public static final String DATA_NUM = "dataNum";
	/*小协议数据条数sql*/
	public static final String DATA_NUM_SQL = "dataNum";
	/*小协议填充率*/
	public static final String FILL_RATE = "fillRate";
	/*小协议填充率SQL*/
	public static final String FILL_RATE_SQL = "fillNum/dataNum";
	/*小协议数据准确率*/
	public static final String SMALL_ACCURACY = "sAccuracy";
	/*小协议数据准确率SQL*/
	public static final String SMALL_ACCURACY_SQL = "accurateNum/dataNum";
	/*小协议代码符合度*/
	public static final String CODE_MATCH = "codeMatchRate";
	/*小协议代码符合度SQL*/
	public static final String CODE_MATCH_SQL = "codeMatchNum/dataNum";
	
	/*入库日志数据列和sql的Map*/
	public static final Map<String, String> COLMAP = new HashMap<String, String>();
	
	static {
		COLMAP.put(INPUT_NUM,INPUT_NUM_SQL);
		COLMAP.put(INPUT_RATE,INPUT_RATE_SQL);
		COLMAP.put(FIELD_NUM,FIELD_NUM_SQL);
		COLMAP.put(BIG_ACCURACY,BIG_ACCURACY_SQL);
		COLMAP.put(DATA_NUM, DATA_NUM_SQL);
		COLMAP.put(FILL_RATE, FILL_RATE_SQL);
		COLMAP.put(SMALL_ACCURACY, SMALL_ACCURACY_SQL);
		COLMAP.put(CODE_MATCH, CODE_MATCH_SQL);
	}
	
	public static String getLogSql(String key) {
		return COLMAP.get(key);
	}
	
	
}
