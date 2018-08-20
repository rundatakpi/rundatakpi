package com.cn.run.kpi.exampledata.entity;

import java.util.Date;

public class AlarmDetail extends PageBean{
	private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer alarmid;

    private Date condate;

    private String lx;

    private String mac;

    private String os;

    private String bz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlarmid() {
        return alarmid;
    }

    public void setAlarmid(Integer alarmid) {
        this.alarmid = alarmid;
    }

    public Date getCondate() {
        return condate;
    }

    public void setCondate(Date condate) {
        this.condate = condate;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}