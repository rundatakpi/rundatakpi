package com.cn.run.kpi.entity;

import java.io.Serializable;

public class ObjDataInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*对象类型*/
	private String objectType;
	/*特征串*/
	private String dataFeatureString;
	/*数据源编号*/
	private String dataSourceCode;
	/*数据源描述*/
	private String dataSourceDescription;
	/*特征串总量(对)*/
	private int dataFeatureStringTotal;
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
	
	
	
	public String getObjectType() {
		return objectType;
	}
	public String getDataFeatureString() {
		return dataFeatureString;
	}
	public String getDataSourceCode() {
		return dataSourceCode;
	}
	public String getDataSourceDescription() {
		return dataSourceDescription;
	}
	public int getDataFeatureStringTotal() {
		return dataFeatureStringTotal;
	}
	public String getDataAccuracy() {
		return dataAccuracy;
	}
	public String getWeeklyExtraction() {
		return weeklyExtraction;
	}
	public String getNetExtractRelations() {
		return netExtractRelations;
	}
	public String getNetExtractRelationRate() {
		return netExtractRelationRate;
	}
	public int getPhoneRelations() {
		return phoneRelations;
	}
	public String getPhoneRelationRate() {
		return phoneRelationRate;
	}
	public int getIDCardRelations() {
		return IDCardRelations;
	}
	public String getIDCardRelationRate() {
		return IDCardRelationRate;
	}
	public int getADSLRelations() {
		return ADSLRelations;
	}
	public String getADSLRelationRate() {
		return ADSLRelationRate;
	}
	public int getIMEIRelatons() {
		return IMEIRelatons;
	}
	public String getIMEIRelationRate() {
		return IMEIRelationRate;
	}
	public int getIMSIRelations() {
		return IMSIRelations;
	}
	public String getIMSIRelationRate() {
		return IMSIRelationRate;
	}
	public int getMACRelations() {
		return MACRelations;
	}
	public String getMACRelationRate() {
		return MACRelationRate;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	public String getField4() {
		return field4;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public void setDataFeatureString(String dataFeatureString) {
		this.dataFeatureString = dataFeatureString;
	}
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	public void setDataSourceDescription(String dataSourceDescription) {
		this.dataSourceDescription = dataSourceDescription;
	}
	public void setDataFeatureStringTotal(int dataFeatureStringTotal) {
		this.dataFeatureStringTotal = dataFeatureStringTotal;
	}
	public void setDataAccuracy(String dataAccuracy) {
		this.dataAccuracy = dataAccuracy;
	}
	public void setWeeklyExtraction(String weeklyExtraction) {
		this.weeklyExtraction = weeklyExtraction;
	}
	public void setNetExtractRelations(String netExtractRelations) {
		this.netExtractRelations = netExtractRelations;
	}
	public void setNetExtractRelationRate(String netExtractRelationRate) {
		this.netExtractRelationRate = netExtractRelationRate;
	}
	public void setPhoneRelations(int phoneRelations) {
		this.phoneRelations = phoneRelations;
	}
	public void setPhoneRelationRate(String phoneRelationRate) {
		this.phoneRelationRate = phoneRelationRate;
	}
	public void setIDCardRelations(int iDCardRelations) {
		IDCardRelations = iDCardRelations;
	}
	public void setIDCardRelationRate(String iDCardRelationRate) {
		IDCardRelationRate = iDCardRelationRate;
	}
	public void setADSLRelations(int aDSLRelations) {
		ADSLRelations = aDSLRelations;
	}
	public void setADSLRelationRate(String aDSLRelationRate) {
		ADSLRelationRate = aDSLRelationRate;
	}
	public void setIMEIRelatons(int iMEIRelatons) {
		IMEIRelatons = iMEIRelatons;
	}
	public void setIMEIRelationRate(String iMEIRelationRate) {
		IMEIRelationRate = iMEIRelationRate;
	}
	public void setIMSIRelations(int iMSIRelations) {
		IMSIRelations = iMSIRelations;
	}
	public void setIMSIRelationRate(String iMSIRelationRate) {
		IMSIRelationRate = iMSIRelationRate;
	}
	public void setMACRelations(int mACRelations) {
		MACRelations = mACRelations;
	}
	public void setMACRelationRate(String mACRelationRate) {
		MACRelationRate = mACRelationRate;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public void setField4(String field4) {
		this.field4 = field4;
	}
	
	
	
	

	
	

}
