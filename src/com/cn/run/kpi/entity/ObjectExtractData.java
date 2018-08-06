package com.cn.run.kpi.entity;

import java.io.Serializable;
/**
 * 对象化提取数据-实体类
 * @author chenyan
 *
 */
public class ObjDataInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/*对象类型*/
	private String objectType;
	/*特征串*/
	private String featureString;
	/*数据源编号*/
	private String dataSourceCode;
	/*数据源描述*/
	private String dataSourceDescription;
	/*特征串总量(对)*/
	private int featureStringTotal;
	/*准确率*/
	private String dataAccuracy;
	/*近7天提取量*/
	private String weeklyExtraction;
	/*净提取关系个数*/
	private String netExtractRelations;
	/*净提取关系比率*/
	private String netExtractRelationRate;
	/*手机号关联数量*/
	private int phoneRelations;
	/*手机号关联数量占比*/
	private String phoneRelationRate;
	/*身份证关联数量*/
	private int IDCardRelations;
	/*身份证关联数量占比*/
	private String IDCardRelationRate;
	/*ADSL关联数量*/
	private int ADSLRelations;
	/*ADSL关联数量占比*/
	private String ADSLRelationRate;
	/*IMEI关联数量*/
	private int IMEIRelatons;
	/*IMEI关联数量占比*/
	private String IMEIRelationRate;
	/*IMSI关联数量*/
	private int IMSIRelations;
	/*IMSI关联数量占比*/
	private String IMSIRelationRate;
	/*MAC关联数量*/
	private int MACRelations;
	/*MAC关联数量占比*/
	private String MACRelationRate;
	/*属性字段1*/
	private String field1;
	/*属性字段2*/
	private String field2;
	/*属性字段3*/
	private String field3;
	/*属性字段4*/
	private String field4;
	
	
	
	
	
	

	
	

}
