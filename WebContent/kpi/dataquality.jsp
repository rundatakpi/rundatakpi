<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据质量评估</title>
<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/ComboBox.css" />
<link rel="stylesheet" type="text/css" href="style/Window.css" />
<link rel="stylesheet" type="text/css" href="style/Grid.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.js"></script>
<script type="text/javascript" src="js/run-min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/charts.js"></script>
<script type="text/javascript" src="js/importDataGrid.js"></script>
<script type="text/javascript" src="js/predealDataGrid.js"></script>
<script type="text/javascript" src="js/logDataGrid.js"></script>
<script type="text/javascript" src="js/objectDataGrid.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/dataquality.js"></script>


</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <div class="active">
    
    	<div class="activeTabHd">
        	<a href="#" class="left activeTabLink slt">格转接入数据质量评估</a>
            <a href="#" class="left activeTabLink">预处理数据质量评估</a>
            <a href="#" class="left activeTabLink">入库日志数据质量评估</a>
            <a href="#" class="left activeTabLink">对象化提取数据质量评估</a>
        </div>
        
        <div class="activeTabBd">
        	<div class="activeTabBdBox"></div>
            <div class="activeTabBdBox"></div>
            <div class="activeTabBdBox"></div>
            <div class="activeTabBdBox"></div>
        </div>
        
    </div>
    
</div>
</body>
</html>
