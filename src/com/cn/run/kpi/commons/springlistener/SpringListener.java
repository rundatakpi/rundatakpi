package com.cn.run.kpi.commons.springlistener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

 
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = Logger.getLogger(SpringListener.class);
	
  
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		 if(arg0.getApplicationContext().getParent()!=null){
			 LOG.debug("springListener");
		 }
	}
	
}
