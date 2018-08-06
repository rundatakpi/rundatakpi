package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;
/**
 * 对象化提取数据-实体类
 * @author chenyan
 *
 */
public class ObjectExtractData implements Serializable{


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
	/*起始位置*/
	private int start;
	/*长度*/
	private int length;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public String getFeatureString() {
		return featureString;
	}
	public void setFeatureString(String featureString) {
		this.featureString = featureString;
	}
	public String getDataSourceCode() {
		return dataSourceCode;
	}
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	public String getDataSourceDescription() {
		return dataSourceDescription;
	}
	public void setDataSourceDescription(String dataSourceDescription) {
		this.dataSourceDescription = dataSourceDescription;
	}
	public int getFeatureStringTotal() {
		return featureStringTotal;
	}
	public void setFeatureStringTotal(int featureStringTotal) {
		this.featureStringTotal = featureStringTotal;
	}
	public String getDataAccuracy() {
		return dataAccuracy;
	}
	public void setDataAccuracy(String dataAccuracy) {
		this.dataAccuracy = dataAccuracy;
	}
	public String getWeeklyExtraction() {
		return weeklyExtraction;
	}
	public void setWeeklyExtraction(String weeklyExtraction) {
		this.weeklyExtraction = weeklyExtraction;
	}
	public String getNetExtractRelations() {
		return netExtractRelations;
	}
	public void setNetExtractRelations(String netExtractRelations) {
		this.netExtractRelations = netExtractRelations;
	}
	public String getNetExtractRelationRate() {
		return netExtractRelationRate;
	}
	public void setNetExtractRelationRate(String netExtractRelationRate) {
		this.netExtractRelationRate = netExtractRelationRate;
	}
	public int getPhoneRelations() {
		return phoneRelations;
	}
	public void setPhoneRelations(int phoneRelations) {
		this.phoneRelations = phoneRelations;
	}
	public String getPhoneRelationRate() {
		return phoneRelationRate;
	}
	public void setPhoneRelationRate(String phoneRelationRate) {
		this.phoneRelationRate = phoneRelationRate;
	}
	public int getIDCardRelations() {
		return IDCardRelations;
	}
	public void setIDCardRelations(int iDCardRelations) {
		IDCardRelations = iDCardRelations;
	}
	public String getIDCardRelationRate() {
		return IDCardRelationRate;
	}
	public void setIDCardRelationRate(String iDCardRelationRate) {
		IDCardRelationRate = iDCardRelationRate;
	}
	public int getADSLRelations() {
		return ADSLRelations;
	}
	public void setADSLRelations(int aDSLRelations) {
		ADSLRelations = aDSLRelations;
	}
	public String getADSLRelationRate() {
		return ADSLRelationRate;
	}
	public void setADSLRelationRate(String aDSLRelationRate) {
		ADSLRelationRate = aDSLRelationRate;
	}
	public int getIMEIRelatons() {
		return IMEIRelatons;
	}
	public void setIMEIRelatons(int iMEIRelatons) {
		IMEIRelatons = iMEIRelatons;
	}
	public String getIMEIRelationRate() {
		return IMEIRelationRate;
	}
	public void setIMEIRelationRate(String iMEIRelationRate) {
		IMEIRelationRate = iMEIRelationRate;
	}
	public int getIMSIRelations() {
		return IMSIRelations;
	}
	public void setIMSIRelations(int iMSIRelations) {
		IMSIRelations = iMSIRelations;
	}
	public String getIMSIRelationRate() {
		return IMSIRelationRate;
	}
	public void setIMSIRelationRate(String iMSIRelationRate) {
		IMSIRelationRate = iMSIRelationRate;
	}
	public int getMACRelations() {
		return MACRelations;
	}
	public void setMACRelations(int mACRelations) {
		MACRelations = mACRelations;
	}
	public String getMACRelationRate() {
		return MACRelationRate;
	}
	public void setMACRelationRate(String mACRelationRate) {
		MACRelationRate = mACRelationRate;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public String getField4() {
		return field4;
	}
	public void setField4(String field4) {
		this.field4 = field4;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
	
	
	
	
	

	
	

}
