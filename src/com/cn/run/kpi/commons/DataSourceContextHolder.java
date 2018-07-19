package com.cn.run.kpi.commons;

/**
 * 存放工具
 * 
 * @author run
 *
 */
public class DataSourceContextHolder {
	/**
	 *  存放变量。之所以用ThreadLocal ，是为了保证每一个进程 都有一份自己的变量，可以同时访问，互不干扰。
	 */
	private static final ThreadLocal<String> CONTEXTHOLDER = new ThreadLocal<String>();

	/**
	 * @Description: 设置数据源类型 @param dataSourceType 数据库类型 @return void @throws
	 */
	public static void setDataSourceType(String dataSourceType) {
		CONTEXTHOLDER.set(dataSourceType); // 存放数据源名称
	}

	/**
	 * @Description: 获取数据源类型 @param @return String @throws
	 */
	public static String getDataSourceType() {
		return CONTEXTHOLDER.get(); // 获取数据源名称
	}

	/**
	 * @Description: 清除数据源类型 @param @return void @throws
	 */
	public static void clearDataSourceType() {
		CONTEXTHOLDER.remove(); // 清空数据源类型
	}
}
