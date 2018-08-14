<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据监控 - 还原监测</title>
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
    
    <div class="clearfix boxMain">
    	<div class="box left importData">
        	<div class="boxHd clearfix">
                <h3 class="left">协议还原数据实时输入数据量</h3>
                <div class="chooseDay right">
                    <a href="#" class="left sevenDays slt">近7天</a>
                    <a href="#" class="right thirtyDays">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="importDataChart" class="importDataChart">
                    
                </div>
            </div>
        </div>
        
    	<div class="box right exportData">
        	<div class="boxHd clearfix">
                <h3 class="left">协议还原数据实时输出数据量</h3>
                <div class="chooseDay right">
                    <a href="#" class="left sevenDays slt">近7天</a>
                    <a href="#" class="right thirtyDays">近30天</a>
                </div>
            </div>
            <div class="boxBd">
            	<div id="exportDataChart" class="exportDataChart">
                    
                </div>
            </div>
        </div>
    </div>
    
    <div class="clearfix boxMain">
    	<div class="box left totalDatas">
        
        	<div class="left curTotalData">
            	<div class="curTotalDataChart" id="curTotalDataChart"></div>
                <ul class="curTotalDataList">
                	<li class="clearfix curTotalDataLi_1"><label class="left">当前协议还原输入数据总量：</label><span class="left agencyb">122332156</span><em class="left">条</em></li>
                	<li class="clearfix curTotalDataLi_2"><label class="left">当前协议还原输出数据总量：</label><span class="left agencyb">122330235</span><em class="left">条</em></li>
                	<li class="clearfix curTotalDataLi_3"><label class="left">当前协议还原丢弃数据总量：</label><span class="left agencyb">1921</span><em class="left">条</em></li>
                </ul>
            </div>
            
            <div class="left yestodayTotalData">
            	<div class="yestodayTotalDataChart" id="yestodayTotalDataChart"></div>
                <ul class="curTotalDataList">
                	<li class="clearfix curTotalDataLi_4"><label class="left">昨日协议还原输入数据总量：</label><span class="left agencyb">122332156</span><em class="left">条</em></li>
                	<li class="clearfix curTotalDataLi_5"><label class="left">昨日协议还原输出数据总量：</label><span class="left agencyb">122330235</span><em class="left">条</em></li>
                </ul>
            </div>
            
            <div class="left ratioDatas">
            	<span class="ratioDatasTip_1">重复率</span>
            	<span class="ratioDatasTip_2">错误率</span>
            	<span class="ratioDatasTip_3">准确率</span>
            	<div class="ratioDatas_1" id="ratioDatas_1"></div>
            </div>
            
        </div>
        
    	<div class="box right restoreEquipmentData">
        	<div class="boxHd clearfix">
                <h3 class="left">还原设备负载</h3>
            </div>
            <div class="boxBd">
            	<div id="restoreEquipmentChart" class="restoreEquipmentChart">
                    
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
