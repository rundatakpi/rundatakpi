package com.cn.run.kpi.commons.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

/**
 * 转换器
 * S - source:源
 * T - target:目标
 * @author zj
 *
 */
public class CustomGlobalStrToDateConverter implements Converter<String, Date> {
	
	final static Logger LOGGER = Logger.getLogger(CustomGlobalStrToDateConverter.class);

	@Override
	public Date convert(String source) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			LOGGER.error(">>>>>convert error...", e);
		}
		return null;
	}

}
