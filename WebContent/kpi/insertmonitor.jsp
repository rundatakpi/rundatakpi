<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据监控 - 接入监测</title>
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
<script type="text/javascript" src="js/insertmonitor.js"></script>
<script type="text/javascript" src="js/datamonitornav.js"></script>
</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <%@ include file="datamonitornav.jsp"%>
    <div>
    <div class="clearfix boxMain siftBox">
    	<div class="left marginR25"><label class="left">数据源：</label><div class="left anticipationComb" id="insertComb_1"></div></div>
    	<div class="left marginR25"><label class="left">大协议：</label><div class="left anticipationComb" id="insertComb_2"></div></div>
    	<div class="left marginR25"><label class="left">小协议：</label><div class="left anticipationComb" id="insertComb_3"></div></div>
    	<div class="left marginR25"><label class="left">动作类型：</label><div class="left anticipationComb" id="insertComb_4"></div></div>
        <a href="#" class="right seeQuality">查看格转接入数据质量</a>
        <a href="#" id="insert_query" onclick="insertQuery();" class="right schBtn_1">查询</a>
    </div>
    
    <div class="clearfix boxMain insertStatistics">
		<div class="left insertStatisticsItem insertStatisticsItem_1">
        	<dl class="insertStaList">
            	<dt class="clearfix"><span id="insert_input" class="left"></span><em class="left">条</em></dt>
                <dd class="clearfix">当前输入数据总量</dd>
            </dl>
        </div>
        <div class="left insertStatisticsItem insertStatisticsItem_2">
        	<dl class="insertStaList">
            	<dt class="clearfix"><span id="insert_average" class="left"></span><em class="left">条/秒</em></dt>
                <dd class="clearfix">当前输入数据平均流量（1h）</dd>
            </dl>
        </div>
        <div class="left insertStatisticsItem insertStatisticsItem_3">
        	<dl class="insertStaList">
            	<dt class="clearfix"><span id="insert_yesterday" class="left"></span><em class="left">条</em></dt>
                <dd class="clearfix">昨日输入数据量</dd>
            </dl>
        </div>
	</div>
    
    <div class="clearfix boxMain">
    	<div class="box left importData">
        	<div class="boxHd clearfix">
                <h3 class="left">接入数据实时输入数据量</h3>
                <div id="input_date" data-id="insertChart_1" url="input" class="chooseDay right">
                    <a href="#" class="left sevenDays slt" value="7">近7天</a>
                    <a href="#" class="right thirtyDays" value="30">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="insertChart_1" class="insertChart_1">
                    
                </div>
            </div>
        </div>
        
    	<div class="box right exportData">
        	<div class="boxHd clearfix">
                <h3 class="left">抛弃数据量</h3>
                <div id="discard_date" path="discard" class="chooseDay right">
                    <a href="#" class="left sevenDays slt" value="7">近7天</a>
                    <a href="#" class="right thirtyDays" value="30">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="insertChart_2" class="insertChart_2">
                    
                </div>
            </div>
        </div>
    </div>
    </div>
    
    
    
</div>
</body>
</html>
