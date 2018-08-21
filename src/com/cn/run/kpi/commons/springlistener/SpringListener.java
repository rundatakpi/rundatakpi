package com.cn.run.kpi.commons.springlistener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.cn.run.kpi.datamonitor.access.service.AccessService;

 
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = Logger.getLogger(SpringListener.class);
	
	@Autowired
	private AccessService accessService;
  
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		 if(arg0.getApplicationContext().getParent()!=null){
			 LOG.debug("springListener");
		 }
		 
		 accessService.initJson();
	}
	
}
