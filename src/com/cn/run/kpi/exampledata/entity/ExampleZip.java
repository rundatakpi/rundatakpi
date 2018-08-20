package com.cn.run.kpi.exampledata.entity;


public class ExampleZip extends PageBean{
	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private String datasource;

    private String datatype;

    private String datatypechname;

    private String protocol;

    private String protocolchname;

    private String createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getDatatypechname() {
        return datatypechname;
    }

    public void setDatatypechname(String datatypechname) {
        this.datatypechname = datatypechname == null ? null : datatypechname.trim();
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getProtocolchname() {
        return protocolchname;
    }

    public void setProtocolchname(String protocolchname) {
        this.protocolchname = protocolchname == null ? null : protocolchname.trim();
    }

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}