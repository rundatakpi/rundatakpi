<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据质量KPI监控 - 主动监测</title>
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
<!-- <script type="text/javascript" src="js/activemonitor.js"></script> -->
<style >
.inputs{width:120px; height:24px; line-height:24px; background:none; border:1px solid #4b5881;}
</style>
<script >
$(function(){
	$(".activeTabHd .activeTabLink").each(function(i){
		$(this).click(function(){
			$(this).addClass("slt").siblings().removeClass("slt");
			$(".activeTabBd .activeTabBdBox").eq(i).show().siblings().hide();
			//alert($.trim($(".activeTabBd .activeTabBdBox").eq(i).html()));
			//if($.trim($(".activeTabBd .activeTabBdBox").eq(i).html()) == ""){
				var pageName = i === 0 ? "accountmonitor" : "examplepackmonitor";
				include("include/"+pageName+".jsp",function(text){
					$('.activeTabBd .activeTabBdBox').eq(i).show().html("").append(text);
				});
			//}
			
			return false;
		});
	});
	//$(".activeTabHd .activeTabLink").eq(0).trigger("click")
	
	//页面初始加载第一屏标签页
	include("include/accountmonitor.jsp",function(text){
        $('.activeTabBd .activeTabBdBox').eq(0).show().html("").append(text);
    });
	
});
</script>
</head>

<body>
<div class="container">
	<%@ include file="nav.jsp"%>
    
     <div class="active">
    
    	<div class="activeTabHd">
        	<a href="#" class="left activeTabLink slt">帐号监测</a>
            <a href="#" class="left activeTabLink">样例包监测</a>
        </div>
        
        <div class="activeTabBd">
        	<div class="activeTabBdBox"></div>
            <div class="activeTabBdBox"></div>
        </div>
        
    </div>
    
</div>
</body>
</html>
