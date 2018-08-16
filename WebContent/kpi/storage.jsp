<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据监控 - 存储量监测</title>
<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/charts.js"></script>
<script type="text/javascript" src="js/storage.js"></script>
</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <%@ include file="datamonitornav.jsp"%>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">九大资源库实时数据量和昨日数据量</h3>
            <a href="#" class="right seeLink">查看资源库数据质量</a>
        </div>
        <div class="boxBd">
        	<div id="nineStorage" class="nineStorage">
            	
            </div>
        </div>
    </div>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">对象库实时数据量和昨日数据量</h3>
            <a href="#" class="right seeLink">查看对象库数据质量</a>
        </div>
        <div class="boxBd">
        	<div id="objectStroage" class="objectStroage">
            	
            </div>
        </div>
    </div>
    
    
</div>
</body>
</html>
