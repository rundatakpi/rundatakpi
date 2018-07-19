package com.cn.run.kpi.commons;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * spring切面，执行方法前和执行方法后，要执行的方法。
 * 
 * @author run
 *
 */
public class DataSourceAspect implements MethodBeforeAdvice, AfterReturningAdvice {
	/**
	 * 方法之后,释放缓存.
	 */
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		DataSourceContextHolder.clearDataSourceType();
	}

	/**
	 * 默认执行dataSource1数据源，如果标注了DataSource.class 注解， 将当前源切换成DataSource.class 注解中的
	 * name 属性 @DataSource(name="")
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// 判断当前方法注解是什么。
		if (method.isAnnotationPresent(DataSource.class)) {
			DataSource datasource = method.getAnnotation(DataSource.class);
			DataSourceContextHolder.setDataSourceType(datasource.name());
		} else {
			DataSourceContextHolder.setDataSourceType("dataSource1");
		}

	}
}
