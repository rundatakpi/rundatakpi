package com.cn.run.kpi.scheduler.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.xmlbeans.impl.util.Base64;

import net.sf.json.JSONObject;

public class HttpUtil {
	
	/**
	 * 从接口中获取数据
	 * @param dateStr
	 * @return
	 */
	public static String getJsonStrByDate(String dateStr) {
		// 配置文件路径。
		String path = "/httpmessage.properties";
    	InputStream inputStream = JDBCUtil.class.getResourceAsStream(path);
    	Properties  pro= new Properties();
    	try {
			pro.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	// http的url
    	String url = pro.getProperty("http.url");
    	// 模块编码
    	String moduleid =pro.getProperty("http.moduleid");
    	// 时间字符串(例：20180818)
    	String dateStr1=dateStr.substring(0, 10);
    	// 小时字符串
    	String hour=dateStr.substring(11, 13);
    	JSONObject json = new JSONObject();
    	json.put("moduleid", moduleid);
    	JSONObject jo = new JSONObject();
    	jo.put("date",dateStr1);
    	jo.put("hour", hour);
    	json.put("data", jo.toString());
    		
    	Base64 base64 = new Base64();
    	PostMethod method = new PostMethod(url);
    	HttpClient httpClient = new HttpClient();
    	try{
    		String value = new String(base64.encode(json.toString().getBytes("UTF-8")),"UTF-8");
    		RequestEntity entity = new StringRequestEntity(value);
    		method.setRequestEntity(entity);
    		httpClient.executeMethod(method);
    		InputStream in = method.getResponseBodyAsStream();
    		StringBuffer sb = new StringBuffer();
    		byte[] b = new byte[4096];
    		int nlets = -1;
    		while((nlets=in.read(b)) != -1){
    			sb.append(new String(b,0,nlets));
    		}
    		
    		String result = new String(base64.decode(sb.toString().getBytes("UTF-8")),"UTF-8");
    		return result;
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		method.releaseConnection();
    	}
    	return null;
	}
}
