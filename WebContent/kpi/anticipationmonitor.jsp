<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据监控 - 预处理监测</title>
<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/ComboBox.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/charts.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.js"></script>
<script type="text/javascript" src="js/run-min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/anticipationmonitor.js"></script>
</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <%@ include file="datamonitornav.jsp"%>
    
    <div class="clearfix boxMain siftBox">
    
    	<div class="left marginR25"><label class="left">分类：</label><div class="left anticipationComb" id="anticipationComb_1"></div></div>
    	<div class="left marginR25"><label class="left">数据源：</label><div class="left anticipationComb" id="anticipationComb_2"></div></div>
    	<div class="left marginR25"><label class="left">大协议：</label><div class="left anticipationComb" id="anticipationComb_3"></div></div>
    	<div class="left marginR25"><label class="left">小协议：</label><div class="left anticipationComb" id="anticipationComb_4"></div></div>
    	<div class="left marginR25"><label class="left">动作类型：</label><div class="left anticipationComb" id="anticipationComb_5"></div></div>
    	<div class="left marginR25"><label class="left">采集地：</label><div class="left anticipationComb" id="anticipationComb_6"></div></div>
        <a href="#" class="right seeQuality">查看格转接入数据质量</a>
        <a href="#" class="right schBtn_1">查询</a>
    </div>
    
    <div class="clearfix boxMain">
    	<div class="box left importData">
        	<div class="boxHd clearfix">
                <h3 class="left">预处理数据实时监控</h3>
                <div class="chooseDay right">
                    <a href="#" class="left sevenDays slt">近7天</a>
                    <a href="#" class="right thirtyDays">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="anticipationChart_1" class="anticipationChart_1">
                    
                </div>
            </div>
        </div>
        
    	<div class="box right exportData">
        	<div class="boxHd clearfix">
                <h3 class="left">输入数据流重复率</h3>
                <div class="chooseDay right">
                    <a href="#" class="left sevenDays slt">近7天</a>
                    <a href="#" class="right thirtyDays">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="anticipationChart_2" class="anticipationChart_2">
                    
                </div>
            </div>
        </div>
    </div>
    
    <div class="clearfix boxMain">
    	<div class="box left importData">
        	<!-- <div class="boxHd clearfix">
                <h3 class="left">预处理异常数据量</h3>
            </div>
            <div class="boxBd">
            	<div id="anticipationChart_3" class="anticipationChart_3">
                    
                </div>
            </div> -->
        </div>
        
    	<div class="box right exportData">
        	<div class="boxHd clearfix">
                <h3 class="left">预处理错误数据量</h3>
            </div>
            <div class="boxBd">
            	<div id="anticipationChart_4" class="anticipationChart_4">
                    
                </div>
            </div>
        </div>
    </div>
    
    
    
    
</div>
</body>
</html>
