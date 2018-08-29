package com.cn.run.kpi.commons.property;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.cn.run.kpi.commons.content.Constants;
import com.cn.run.kpi.utils.InitUtils;
 
/**
 * 读取配置文件
 * @author Administrator
 *
 */
 
public class PropertyConfigurer extends PropertyPlaceholderConfigurer{

	  // public final static Map sysMap = new HashMap();
	    private Properties props;       // 存取properties配置文件key-value结果
       
	    @SuppressWarnings("unused")
		private static final Logger LOG = Logger.getLogger(PropertyConfigurer.class);
	    
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
	    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
	        super.processProperties(beanFactoryToProcess, props);
	        this.props = props;
 
	        Iterator iterator = props.entrySet().iterator();
	        while(iterator.hasNext()){
	        	Entry entry = (Entry) iterator.next();
	        	String key= (String) entry.getKey();
	        	String value = (String) entry.getValue();
	        	//加载属性文件到内存
	        	Constants.RESOURCES.put(key, value);
	        }
	        Constants.RESOURCES.put("root", System.getProperty("web.root"));
	        InitUtils.init();
	        
	    }

	    public String getProperty(String key){
	        return this.props.getProperty(key);
	    }

	    public String getProperty(String key, String defaultValue) {
	        return this.props.getProperty(key, defaultValue);
	    }

	    public Object setProperty(String key, String value) {
	        return this.props.setProperty(key, value);
	    }
	   
}
