package com.cn.run.kpi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class DateUtil {
	
	private static final Logger LOG = Logger.getLogger(DateUtil.class);
	
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getDate(){
		return getDateBefore(new Date(), 0);
	}
	
	public static List<String> getDate(int day) {
		List<String> date = new ArrayList<>();
		for (int i = day - 1; i >= 0; i--) {
			date.add(getDateBefore(new Date(), i));
		}
		return date;
	}
	
	/**
	 * 获取前X天的日期
	 * @param Date d
	 * @param int day
	 * @return
	 */
	public static String getDateBefore(Date d,int day){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE,now.get(Calendar.DATE) - day);
		
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.format(now.getTime());
	}
	
	/**
	 * 获取前X月的日期
	 * @param Date d
	 * @param int month
	 * @return
	 */
	public static String getMonthBefore(Date d,int month){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.MONTH,now.get(Calendar.MONTH) - month);
		
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM"); 
		return sdf.format(now.getTime());
	}
	
	/**
	 * 将10位long类型的时间格式，转换为指定format类型的字符串格式
	 * @param format 指定的时间格式
	 * @param date 10位long类型的时间
	 * @return
	 */
	public static String getDateFrom(String format, long date){
		SimpleDateFormat sdf =  new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 获取两个时间的时间间隔，时间格式：yyyy-MM-dd
	 * @param date1 指定的时间格式
	 * @param date2 指定的时间格式
	 * @return
	 */
	public static int getDays(String date1, String date2){
		Calendar now = Calendar.getInstance();
		int result = 0;
		try {
			now.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date1));
			int begin = now.get(Calendar.DATE);
			now.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date2));
			int end = now.get(Calendar.DATE);
			result = end-begin;
		} catch (ParseException e) {
			LOG.error(">>>>>getDays error...", e);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getDateBefore(new Date(), 1));
	}
}
