<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 数据质量评估 - 入库日志数据质量评估 - 详情</title>
<link rel="stylesheet" type="text/css" href="style/global.css" />
<link rel="stylesheet" type="text/css" href="style/ComboBox.css" />
<link rel="stylesheet" type="text/css" href="style/Window.css" />
<link rel="stylesheet" type="text/css" href="style/Grid.css" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/media.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.js"></script>
<script type="text/javascript" src="js/run-min.js"></script>
<script type="text/javascript" src="js/logDetailGrid.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/logdetail.js"></script>

</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
    <div class="clearfix title">WA_SOURCE_005质量详情</div>
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">详情列表（<em class="boxHdEm">75</em>）</h3>
            <div class="right search">
                <input type="text" class="left" placeholder="支持模糊搜索" />
                <a href="#" class="left"></a>
            </div>
        </div>
        <div class="boxBd">
        	<div class="logDetail">
            	<table>
                	<colgroup>
                    	<col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                        <col width="" />
                    </colgroup>
                    <thead>
                    	<tr>
                        	<th colspan="2">小协议</th>
                        	<th></th>
                        	<th></th>
                        	<th colspan="2">认证号码</th>
                            <th colspan="3">认证类型</th>
                            <th colspan="2">发送者名称</th>
                            <th colspan="2">接受者名称</th>
                            <th colspan="2">基站</th>
                        </tr>
                        <tr>
                        	<th>小协议号</th>
                        	<th>小协议描述</th>
                            <th>动作描述</th>
                            <th>数据条数</th>
                            <th>填充率</th>
                            <th>准确率</th>
                            <th>填充率</th>
                            <th>准确率</th>
                        	<th>代码符合</th>
                            <th>填充率</th>
                            <th>准确率</th>
                            <th>填充率</th>
                            <th>准确率</th>
                            <th>填充率</th>
                            <th>准确率</th>
                        </tr>
                    </thead>
                    <tbody id="logDetailDataBody">
                    	
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    
</div>
</body>
</html>
