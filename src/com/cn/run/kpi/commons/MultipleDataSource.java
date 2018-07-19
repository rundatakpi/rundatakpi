package com.cn.run.kpi.commons;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 重写spring 数据远加载类 ，此类相当于 数据源的路由中介。
 * 
 * @author run
 *
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
	/**
	 * 改变当前数据源，spring连接数据源时调用的类。
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		// 返回当前线程存贮的数据源对应的键值，
		return DataSourceContextHolder.getDataSourceType();
	}

}
