package com.cn.run.kpi.commons;

import java.lang.annotation.*;

/**
 * 书写注解形式的DataSource名称
 * 
 * @author run
 *
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	/**
	 * 默认连接数据源1
	 * 
	 * @return
	 */
	String name() default DataSource.DATASOURCE1;

	/**
	 * 数据源1
	 */
	public static String DATASOURCE1 = "dataSource1";
	/**
	 * 数据源2
	 */
	public static String DATASOURCE2 = "dataSource2";
	/**
	 * 数据源3
	 */
	public static String DATASOURCE3 = "dataSource3";

}
