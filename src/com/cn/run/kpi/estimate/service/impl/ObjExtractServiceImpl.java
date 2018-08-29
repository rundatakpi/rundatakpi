package com.cn.run.kpi.estimate.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cn.run.kpi.estimate.dao.ObjDao;
import com.cn.run.kpi.estimate.entity.ObjField;
import com.cn.run.kpi.estimate.entity.ObjInfo;
import com.cn.run.kpi.estimate.service.ObjExtractService;


/**
 * 对象化提取数据实现类
 * @author chenyan
 * 2018年8月6日
 *
 */
@Service
@Transactional
public class ObjExtractServiceImpl implements ObjExtractService {
	
	@Autowired
	private ObjDao objectDao;

	/**
	 * 获取对象化信息列表
	 */
	@Override
	public List<ObjInfo> getList(ObjInfo objInfo) {
		List<ObjInfo> list= objectDao.getList(objInfo);
		if(list!=null&&!list.isEmpty()) {
			for (ObjInfo objInfo2 : list) {
				List<ObjField> fields = objectDao.getFieldList(objInfo2);
				objInfo2.setObjFieldList(fields);
			}
		}
		return list;
	}

	/**
	 * 获取对象化信息总个数
	 */
	@Override
	public Integer getTotal(ObjInfo objInfo) {
		return objectDao.getTotal(objInfo);
	}

	

}
