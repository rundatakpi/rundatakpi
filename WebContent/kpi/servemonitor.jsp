<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据监控 - 服务监测</title>
<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/ComboBox.css" />
<link rel="stylesheet" type="text/css" href="style/Grid.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/run-min.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.js"></script>
<script type="text/javascript" src="js/charts.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/servemonitor.js"></script>
</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <%@ include file="datamonitornav.jsp"%>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">xx数据统计</h3>
            <!--<span class="right slideWrap"><span class="slideBtn">近7天</span> </span>-->
            <div class="chooseDay right">
            	<a href="#" class="left sevenDays slt">近7天</a>
                <a href="#" class="right thirtyDays">近30天</a>
            </div>
        </div>
        <div class="boxBd">
        	<div id="dataStatistics" class="dataStatistics">
            	
            </div>
        </div>
    </div>
    
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">应用调用协议频次</h3>
            <div class="right failCauseBox">
            	<label class="left">选择应用：</label>
                <div id="chooseApp" class="chooseApp left"></div>
            </div>
        </div>
        <div class="boxBd">
        	<div id="frequencyBar" class="frequencyBar">
            	
            </div>
        </div>
    </div>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">异常返回（<em class="boxHdEm">75</em>）</h3>
            
        </div>
        <div class="boxBd">
        	<div class="unusualBack" id="unusualBack">
            </div>
        </div>
    </div>
    
    
</div>
</body>
</html>
