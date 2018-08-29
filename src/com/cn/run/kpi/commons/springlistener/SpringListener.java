package com.cn.run.kpi.commons.springlistener;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.cn.run.kpi.datamonitor.access.service.AccessService;
import com.cn.run.kpi.datamonitor.service.service.ServiceMonitorService;

 
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = Logger.getLogger(SpringListener.class);
	
	@Autowired
	private AccessService accessService;
	
	@Autowired
	private ServiceMonitorService serviceMonitorService;
  
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		 if(arg0.getApplicationContext().getParent()!=null){
			 LOG.debug("springListener");
		 }
		 
		 accessService.initJson();
		 
		 try {
			//serviceMonitorService.getApp(new HashMap<String, Object>());
		} catch (Exception e) {
			LOG.error(">>>>>init app failed", e);
		}
	}
	
}
