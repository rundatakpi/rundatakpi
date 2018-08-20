package com.cn.run.kpi.estimate.entity;

import java.io.Serializable;
/**
 * 对象化提取数据-实体类
 * @author chenyan
 *
 */
public class ObjInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/*id*/
	private long id;
	/*对象类型*/
	private String objType;
	/*对象类型描述*/
	private String objTypeDesc;
	/*数据源编号*/
	private String dsCode;
	/*数据源描述*/
	private String dsDesc;
	/*特征串编码*/
	private String aspectCode;
	/*特征串中文描述*/
	private String aspectStr;
	/*特征串个数*/
	private long aspectNum;
	/*错误条数*/
	private long errorNum;
	/*准确率*/
	private String accuracy;
	/*提取量*/
	private long extractNum;
	/*净提取关系个数*/
	private long netExtractNum;
	/*净提取关系比例*/
	private String netExtractRate;
	/*手机号关联数量*/
	private long phoneReNum;
	/*手机号关联率*/
	private String phoneReRate;
	/*身份证关联数量*/
	private long idCardReNum;
	/*身份证关联率*/
	private String idCardReRate;
	/*ADSL关联数量*/
	private long adslReNum;
	/*ADSL关联率*/
	private String adslReRate;
	/*IMEI关联数量*/
	private long imeiReNum;
	/*IMEI关联率*/
	private String imeiReRate;
	/*IMSI关联率*/
	private long imsiReNum;
	/*IMSI关联数量*/
	private String imsiReRate;
	/*MAC关联数量*/
	private long macReNum;
	/*MAC关联率*/
	private String macReRate;
	/*数据产生日期*/
	private String createDate;
	/*开始个数*/
	private int start;
	/*结束个数*/
	private int length;
	/*图表展示的key*/
	private String oKey;
	/*图表展示的value*/
	private String oValue;
	/*开始时间*/
	private String startTime;
	/*结束时间*/
	private String endTime;
	/*列名*/
	private String colName;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getObjType() {
		return objType;
	}
	public void setObjType(String objType) {
		this.objType = objType;
	}
	public String getObjTypeDesc() {
		return objTypeDesc;
	}
	public void setObjTypeDesc(String objTypeDesc) {
		this.objTypeDesc = objTypeDesc;
	}
	public String getDsCode() {
		return dsCode;
	}
	public void setDsCode(String dsCode) {
		this.dsCode = dsCode;
	}
	public String getDsDesc() {
		return dsDesc;
	}
	public void setDsDesc(String dsDesc) {
		this.dsDesc = dsDesc;
	}
	public String getAspectCode() {
		return aspectCode;
	}
	public void setAspectCode(String aspectCode) {
		this.aspectCode = aspectCode;
	}
	public String getAspectStr() {
		return aspectStr;
	}
	public void setAspectStr(String aspectStr) {
		this.aspectStr = aspectStr;
	}
	public long getAspectNum() {
		return aspectNum;
	}
	public void setAspectNum(long aspectNum) {
		this.aspectNum = aspectNum;
	}
	public long getErrorNum() {
		return errorNum;
	}
	public void setErrorNum(long errorNum) {
		this.errorNum = errorNum;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public long getExtractNum() {
		return extractNum;
	}
	public void setExtractNum(long extractNum) {
		this.extractNum = extractNum;
	}
	public long getNetExtractNum() {
		return netExtractNum;
	}
	public void setNetExtractNum(long netExtractNum) {
		this.netExtractNum = netExtractNum;
	}
	public String getNetExtractRate() {
		return netExtractRate;
	}
	public void setNetExtractRate(String netExtractRate) {
		this.netExtractRate = netExtractRate;
	}
	public long getPhoneReNum() {
		return phoneReNum;
	}
	public void setPhoneReNum(long phoneReNum) {
		this.phoneReNum = phoneReNum;
	}
	public String getPhoneReRate() {
		return phoneReRate;
	}
	public void setPhoneReRate(String phoneReRate) {
		this.phoneReRate = phoneReRate;
	}
	public long getIdCardReNum() {
		return idCardReNum;
	}
	public void setIdCardReNum(long idCardReNum) {
		this.idCardReNum = idCardReNum;
	}
	public String getIdCardReRate() {
		return idCardReRate;
	}
	public void setIdCardReRate(String idCardReRate) {
		this.idCardReRate = idCardReRate;
	}
	public long getAdslReNum() {
		return adslReNum;
	}
	public void setAdslReNum(long adslReNum) {
		this.adslReNum = adslReNum;
	}
	public String getAdslReRate() {
		return adslReRate;
	}
	public void setAdslReRate(String adslReRate) {
		this.adslReRate = adslReRate;
	}
	public long getImeiReNum() {
		return imeiReNum;
	}
	public void setImeiReNum(long imeiReNum) {
		this.imeiReNum = imeiReNum;
	}
	public String getImeiReRate() {
		return imeiReRate;
	}
	public void setImeiReRate(String imeiReRate) {
		this.imeiReRate = imeiReRate;
	}
	public long getImsiReNum() {
		return imsiReNum;
	}
	public void setImsiReNum(long imsiReNum) {
		this.imsiReNum = imsiReNum;
	}
	public String getImsiReRate() {
		return imsiReRate;
	}
	public void setImsiReRate(String imsiReRate) {
		this.imsiReRate = imsiReRate;
	}
	public long getMacReNum() {
		return macReNum;
	}
	public void setMacReNum(long macReNum) {
		this.macReNum = macReNum;
	}
	public String getMacReRate() {
		return macReRate;
	}
	public void setMacReRate(String macReRate) {
		this.macReRate = macReRate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public String getoKey() {
		return oKey;
	}
	public void setoKey(String oKey) {
		this.oKey = oKey;
	}
	public String getoValue() {
		return oValue;
	}
	public void setoValue(String oValue) {
		this.oValue = oValue;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	
	
}
