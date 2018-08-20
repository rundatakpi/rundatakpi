package com.cn.run.kpi.exampledata.entity;

public class ExampleZipItem {
    private Integer id;

    private Integer pid;

    private String key;

    private String chname;

    private String ysz;

    private String yclz;

    private String jghz;

    private String dxhz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname == null ? null : chname.trim();
    }

    public String getYsz() {
        return ysz;
    }

    public void setYsz(String ysz) {
        this.ysz = ysz == null ? null : ysz.trim();
    }

    public String getYclz() {
        return yclz;
    }

    public void setYclz(String yclz) {
        this.yclz = yclz == null ? null : yclz.trim();
    }

    public String getJghz() {
        return jghz;
    }

    public void setJghz(String jghz) {
        this.jghz = jghz == null ? null : jghz.trim();
    }

    public String getDxhz() {
        return dxhz;
    }

    public void setDxhz(String dxhz) {
        this.dxhz = dxhz == null ? null : dxhz.trim();
    }
}