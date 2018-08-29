package com.cn.run.kpi.utils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 读取配置xml
 * 
 * @author zg
 *
 */
public class MyXMLUtils {
	private static final Logger LOG = Logger.getLogger(MyXMLUtils.class);
 
	/**
	 * 解析xml
	 * 
	 * @param str
	 */
	public static Map<String,String> readXML(String name) {
		// 将tomcat的路径加载到内存 
		Map<String,String> map = new HashMap<String,String>();
		try {
			String path = "";
			URL url = ClassLoader.getSystemResource(name);
			if (url == null) {
				
				path = System.getProperty("web.root") + "WEB-INF" + File.separator + "classes" + File.separator + name;
			} else {
				path = url.getPath();
			}
			File file = new File(path);
			// 创建DocumentBuilderFactory对象
			SAXReader sReader = new SAXReader();
			Document doc = sReader.read(file);

			Element el = doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> list = el.elements();
			for (Element elment : list) {
				String key = elment.attributeValue("DSID");
				String val = elment.attributeValue("CHName");
//				String key = elment.attributeValue("key");
//				String val = elment.attributeValue("value");
				map.put(key, val);
			}
		} catch (Exception e) {
			LOG.error("read xml is error", e);
		}
		return map;
	}
 
}
