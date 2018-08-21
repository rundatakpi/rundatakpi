package com.cn.run.kpi.exampledata.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.run.kpi.exampledata.dao.AccountMapper;
import com.cn.run.kpi.exampledata.dao.AlarmDetailMapper;
import com.cn.run.kpi.exampledata.dao.AlarmMapper;
import com.cn.run.kpi.exampledata.dao.ExampleZipItemMapper;
import com.cn.run.kpi.exampledata.dao.ExampleZipMapper;
import com.cn.run.kpi.exampledata.entity.Account;
import com.cn.run.kpi.exampledata.entity.Alarm;
import com.cn.run.kpi.exampledata.entity.AlarmDetail;
import com.cn.run.kpi.exampledata.entity.ExampleZip;
import com.cn.run.kpi.exampledata.entity.ExampleZipItem;
import com.cn.run.kpi.exampledata.service.ExampleZipService;

/**
 * @author libingnan
 * 2018年8月18日
 */
@Service
@Transactional
public class ExampleZipServiceImpl implements ExampleZipService{
	@Autowired
	private ExampleZipMapper exampleZipDao;
	@Autowired
	private ExampleZipItemMapper exampleZipItemDao;
	@Autowired
	private AlarmDetailMapper alarmDetailMapper;
	@Autowired
	private AlarmMapper alarmMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Override
	public List<ExampleZip> getList(ExampleZip example) {
		// TODO Auto-generated method stub
		return exampleZipDao.getList(example);
	}
	
	@Override
	public List<ExampleZipItem> getSubList(ExampleZipItem exampleitem) {
		// TODO Auto-generated method stub
		return exampleZipItemDao.getSubList(exampleitem);
	}

	@Override
	public List<Alarm> getAlarmList(Alarm example) {
		// TODO Auto-generated method stub
		return alarmMapper.getAlarmList(example);
	}

	@Override
	public int save(Account example) {
		try {
			accountMapper.insertSelective(example);
			Alarm alarm = new Alarm();
			alarm.setAccountid(example.getId());
			alarmMapper.insertSelective(alarm);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public void editAlarm(Alarm alarmData) {
		// TODO Auto-generated method stub
		alarmMapper.updateByPrimaryKeySelective(alarmData);
	}

	@Override
	public void delAlarm(Alarm alarmData) {
		// TODO Auto-generated method stub
		alarmMapper.deleteByPrimaryKey(alarmData.getId());
		alarmMapper.deleteSubByPrimaryKey(alarmData.getId());
	}

	@Override
	public List<AlarmDetail> getAlarmDetails(AlarmDetail alarmDetail) {
		// TODO Auto-generated method stub
		return alarmDetailMapper.getAlarmList(alarmDetail);
	}

	@Override
	public void saveExampleData(Map<String, String> map) {
		try {
			/*map.put("data_type", "103");
	    	map.put("capture_time", String.valueOf(System.currentTimeMillis()));
	    	map.put("data_source", "124");
	    	map.put("g020014", "公安部第三研究所检测中心");
	    	map.put("card_type", "111");
	        map.put("card", getIdNo(name_sexb));
	        map.put("name", getChineseName());
	        map.put("f010008", "990000");
	        map.put("im_type", "1030001");
	        map.put("qq", getQQ());
	        map.put("qqqun", getQQqun());
	        map.put("action_type", "01");
	        map.put("phone", getTel());
	        map.put("imsi", getImsi());*/
			ExampleZip example =new ExampleZip();
			example.setDatasource(map.get("data_source"));
			example.setDatatype(map.get("data_type"));
			//大协议中文名
			example.setDatatypechname("即时通讯(IM)");
			example.setProtocol(map.get("im_type"));
			//小协议中文名
			example.setProtocolchname("QQ");
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd HH:mi:ss");
			String date = sf.format(new Date());
			example.setCreatedate(date);
			exampleZipDao.insertSelective(example);
			
			
			String[] str= {"数据类型(大协议ID)","截获时间(上线时间)","数据源","厂商名称","证件类型","证件号码","上网人员姓名","采集地","小协议ID","用户名称","群号码","数据协议动作类型","电话号码","国际移动用户标识号"};
			List<ExampleZipItem> list = new ArrayList<>();
			Iterator<String> iterator = map.keySet().iterator();
			ExampleZipItem exampleZipItem;String next;int i=0;
			while(iterator.hasNext()){
				next = iterator.next();
				exampleZipItem = new ExampleZipItem();
				exampleZipItem.setPid(example.getId());
				exampleZipItem.setKey(next);
				exampleZipItem.setChname(str[i]);
				exampleZipItem.setYsz(map.get(next));
				list.add(exampleZipItem);
				i++;
	    	}
			exampleZipItemDao.insertBatch(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
