package com.cn.run.kpi.estimate.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 读取动作类型类
 * @author chenyan
 *
 */
public class ActionConfig {
	
	private static final Logger LOGGER = Logger.getLogger(ActionConfig.class);
	
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
			InputStream inputStream = ActionConfig.class.getClassLoader().getResourceAsStream("dom4j/WACODE_0011.xml");
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
	
	/**
	 * 从指定节点开始,递归遍历所有子节点
	 * @author chenleixing
	 */
	public void getNodes(Element node){
		System.out.println("----------解析xml开始----------");
		
		//当前节点的名称、文本内容和属性
		System.out.println("当前节点名称："+node.getName());//当前节点名称
		System.out.println("当前节点的内容："+node.getTextTrim());//当前节点名称
		List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
		for(Attribute attr:listAttr){//遍历当前节点的所有属性
			String name=attr.getName();//属性名称
			String value=attr.getValue();//属性的值
			System.out.println("属性名称："+name+"属性值："+value);
		}
		
		//递归遍历当前节点所有的子节点
		List<Element> listElement=node.elements();//所有一级子节点的list
		for(Element e:listElement){//遍历所有一级子节点
			this.getNodes(e);//递归
		}
	}
	
}
