<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="header clearfix">
	<a href="#" class="left logo"><img src="images/logo.png" alt="" /></a>

	<div class="right headerRight">
		<div class="messageBox left">
			<a href="#" class="messageLink">消息</a> <em class="messageSign"></em>
		</div>

		<div class="userBox left">
			<span class="userMain">Admin</span>
		</div>

		<div class="logoutBox left">
			<a href="#" class="logoutMain">退出</a>
		</div>
	</div>

	<div id='navs' class="nav clearfix">
		<a href="#" class="left navLink navLink_1"><span class="left"></span>首页</a>
		<a href="activemonitor.jsp" class="left navLink navLink_2"><span class="left"></span>样例包监测</a> 
		<a href="anticipationmonitor.jsp" class="left navLink navLink_3 "><span class="left"></span>数据监控</a>
		<a href="#" class="left navLink navLink_4"><span class="left"></span>数据质量评估</a>
		<a href="warmingcenter.jsp" class="left navLink navLink_5"><span class="left"></span>预警中心</a>
	</div>

</div>
<script>
	$(function() {
		$('#navs a').each(
			function(){
				if($($(this))[0].href==String(window.location))
					$(this).addClass("slt").attr('href','javascript:void(0);');
			}		
		);
	});
</script>