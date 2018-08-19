package com.cn.run.kpi.scheduler;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.run.kpi.scheduler.entity.RestoreMonitorBean;
import com.cn.run.kpi.scheduler.entity.ScheduleBean;
import com.cn.run.kpi.scheduler.service.ScheduleService;
import com.cn.run.kpi.scheduler.utils.HttpUtil;
import com.cn.run.kpi.scheduler.utils.JDBCUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 协议还原调度任务
 * @author zjw
 */
@Component("protocolToMysqlTask")
public class ProtocolToMysqlTask {
	private static final Logger LOG = Logger.getLogger(ProtocolToMysqlTask.class);
	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * 协议还原调度任务 定时任务每分钟执行一次
	 */
	//@Scheduled(cron = "0 0/1 * * * ? ")
	public void protocolToMysqlTask() {
		LOG.info("start protocolToMysqlTask...");
		//获取资源库表监控配置信息
		ScheduleBean scheduleBean=scheduleService.getScheduleByType(7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		//获取开始时间
		String startTimeStr=scheduleBean.getDatestr();
		//开始时间毫秒数
		long startTime=0;
		//结束时间毫秒数
		long endTime=0;
		try {
			startTime=sdf.parse(startTimeStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//获取数据json字符串
		String jsonStr=HttpUtil.getJsonStrByDate(startTimeStr);
		if(jsonStr==null) {
			return;
		}
		JSONObject resultJson=JSONObject.fromObject(jsonStr);
		int result=(int) resultJson.get("result");
		if(result==1) {
			return;
		}
		JSONObject data=(JSONObject) resultJson.get("data");
		int count=(int)data.get("count");
		if(count<=0) {
			return;
		}
		//解析数据
		JSONArray listArray=(JSONArray)data.get("list");
		for(int i=0;i<listArray.size();i++) {
			JSONObject dataBean=(JSONObject)listArray.get(i);
			String dateStr=dataBean.getString("date");
			int hour=dataBean.getInt("hour");
			if(hour<10) {
				dateStr=dateStr+" 0"+hour;
			}else {
				dateStr=dateStr+" "+hour;
			}
			try {
				if(sdf.parse(dateStr).getTime()>endTime) {
					endTime=sdf.parse(dateStr).getTime();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//数据入库
			//输入量
			Long input=dataBean.getLong("input");
			//输出bcp
			Long bcp_count=dataBean.getLong("bcp_count");
			//输出zip
			Long zip_count=dataBean.getLong("zip_count");
			RestoreMonitorBean restoreMonitorBean=new RestoreMonitorBean();
			restoreMonitorBean.setCreatetime(dateStr);
			restoreMonitorBean.setRestoreinput(input);
			restoreMonitorBean.setRestoreoutputbcp(bcp_count);
			restoreMonitorBean.setRestoreoutputzip(zip_count);
			scheduleService.insertRestore(restoreMonitorBean);
			//告警监测
			
		}
		//设置结束时间
		if(endTime>=startTime) {
			scheduleBean.setDatestr(sdf.format(new Date(endTime+3600000)));
      	  	scheduleService.updateSchedule(scheduleBean);
		}
		LOG.info("end protocolToMysqlTask...");
	}
}
