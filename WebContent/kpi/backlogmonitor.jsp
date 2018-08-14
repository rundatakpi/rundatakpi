<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据监控 - 积压监测</title>
<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/charts.js"></script>
</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <%@ include file="datamonitornav.jsp"%>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">接口机实时积压数据统计</h3>
        </div>
        <div class="boxBd">
        	<div id="backlogDataStatistic_1" class="backlogDataStatistic_1">
            	
            </div>
        </div>
    </div>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">Kafka实时积压数据统计</h3>
        </div>
        <div class="boxBd">
        	<div id="backlogDataStatistic_2" class="backlogDataStatistic_2">
            	
            </div>
        </div>
    </div>
    
    
</div>
</body>
</html>
