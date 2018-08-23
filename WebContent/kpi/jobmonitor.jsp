<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据监控 - 任务监测</title>

<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/ComboBox.css" />
<link rel="stylesheet" type="text/css" href="style/Grid.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/charts.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.js"></script>
<script type="text/javascript" src="js/run-min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jobmonitor.js"></script>
</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <%@ include file="datamonitornav.jsp"%>
    
    <div class="clearfix boxMain">
    	<div class="box left importData">
        	<div class="boxHd clearfix">
                <h3 class="left">实时运行任务量</h3>
                <div id="job_run" data-id="jobChart_1" url="running" class="chooseDay right">
                    <a href="#" value="7" class="left sevenDays slt">近7天</a>
                    <a href="#" value="30" class="right thirtyDays">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="jobChart_1" class=" jobChart_1">
                    
                </div>
            </div>
        </div>
        
    	<div class="box right exportData">
        	<div class="boxHd clearfix">
                <h3 class="left">实时已完成任务量</h3>
                <div id="job_complete" url="complete" class="chooseDay right">
                    <a href="#" value="7" class="left sevenDays slt">近7天</a>
                    <a href="#" value="30" class="right thirtyDays">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="jobChart_2" class="jobChart_2">
                    
                </div>
            </div>
        </div>
    </div>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">正在运行任务（<em class="boxHdEm">75</em>）</h3>
            
        </div>
        <div class="boxBd">
        	<div class="unusualBack" id="runningJob">
            </div>
        </div>
    </div>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">失败任务（<em class="boxHdEm">75</em>）</h3>
            <div class="right failCauseBox">
            	<label class="left">失败原因：</label>
                <div id="failCause" class="failCause left"></div>
            </div>
        </div>
        <div class="boxBd">
        	<div class="unusualBack" id="failJob">
            </div>
        </div>
    </div>
    
    <div class="boxMain"></div>
    
    
    
    
    
    
</div>
</body>
</html>
