package com.cn.run.kpi.estimate.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 读取动作类型类
 * @author chenyan
 *
 */
public class ActionMapConfig {
	
	private static final Logger LOGGER = Logger.getLogger(ActionMapConfig.class);
	
	public static String getValue(String key) {
		Map<String, String> map = paserXm(key);	
		return map.get(key);
	}

	public static Map<String,String> paserXm(String key){
		Map<String, String> xmlMap = new HashMap<String,String>();
		try {
			//获取解析器
			SAXReader saxReader = new SAXReader();
			//获取文档对象
			InputStream inputStream = ActionMapConfig.class.getClassLoader().getResourceAsStream("dom4j/WACODE_0011.xml");
			Document document = saxReader.read(inputStream);
			 // 通过document对象获取根节点
			Element rootEle = document.getRootElement();
            // 通过element获取CodeSet节点
            Element codeSetEle = rootEle.element("CodeSet");
            List<Element> items = codeSetEle.elements("Item");
            // 遍历迭代器，获取节点中的信息
            for (Element node : items) {
				String code = node.attributeValue("Code");
				String name = node.attributeValue("Name");
				xmlMap.put(code, name);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return xmlMap;
	}
	
}
