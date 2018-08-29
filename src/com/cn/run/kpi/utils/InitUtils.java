package com.cn.run.kpi.utils;

import java.util.Map;

import com.cn.run.kpi.commons.content.Constants;


/**
 * 静态文件初始化工具类
 * 
 * @author run
 *
 */
public class InitUtils {
	/**
	 * 初始化静态文件
	 */
	public static void init() {
		
		// 加载xml静态文件
		Map<String, String> s003Map = MyXMLUtils.readXML("s003//dataset.xml");
		for (Map.Entry<String, String> entry : s003Map.entrySet()) {
			Constants.PROTOCOLMAP.put(entry.getKey(), entry.getValue());
		}
		
		Map<String, String> obj003Map = MyXMLUtils.readXML("obj003//dataset.xml");
		Constants.PROTOCOLMAP.putAll(obj003Map);
		
	}
}
