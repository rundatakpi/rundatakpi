<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 预警中心</title>
<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/ComboBox.css" />
<link rel="stylesheet" type="text/css" href="style/Window.css" />
<link rel="stylesheet" type="text/css" href="style/Grid.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.js"></script>
<script type="text/javascript" src="js/run-min.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/warmingcenter.js"></script>

</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <div class="warmingSift clearfix">
        <label class="left">告警级别：</label>
        <div id="warmingCombobox_1" class="warmingCombobox_1 left marginR60"></div>
        <label class="left">告警状态：</label>
        <div id="warmingCombobox_2" class="warmingCombobox_2 left marginR60"></div>
<!--         <label class="left">告警时间：</label>
        <input type="text" class="left starttime" />
        <span class="left timeSep">—</span>
        <input type="text" class="left endtime" /> -->
        <a href="#" class="right schBtn_1" id="emptyBtn">清空</a>
        <a href="#" class="right schBtn_1" id="schBtn">查询</a>
    </div>
    
    <div class="box">
        <div class="boxHd clearfix">
            <h3 class="left">异常返回 （<em class="boxHdEm"></em>） </h3>
            <a href="#" class="right opeBtn_1">批量导出</a>
        </div>
        <div class="boxBd">
            <div class="warmingGrid" id="warmingGrid">
                
            </div>
        </div>
    </div>
    
</div>
</body>
</html>
