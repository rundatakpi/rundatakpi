<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script>
$(function() {
    
    console.log(window.document.location.href);
    var url = window.document.location.href;
    var index = url.lastIndexOf('/');
    var id = url.substring(index + 1, url.length - 4);
    
    $("a").removeClass("slt");
    $("#" + id).addClass("slt");
    console.log("id = " + id);
})
</script>
<div id="nav_datamonitor" class="steps clearfix">
	<div class="stepBox left">
        <a id="insertmonitor" href="insertmonitor.jsp" class="left stepItem stepItem_1" title="接入监测">
            <span class="stepIcon"><em></em></span>
            <span class="stepWord"></span>
        </a>
    </div>
	<div class="stepBox left">
    	<span class="stepArrow"></span>
        <a id="restoremonitor" href="restoremonitor.jsp" class="left stepItem stepItem_2" title="还原监测">
            <span class="stepIcon"><em></em></span>
            <span class="stepWord"></span>
        </a>
    </div>
	<div class="stepBox left">
    	<span class="stepArrow"></span>
        <a id="anticipationmonitor" href="anticipationmonitor.jsp" class="left stepItem stepItem_3" title="预处理监测">
            <span class="stepIcon"><em></em></span>
            <span class="stepWord"></span>
        </a>
    </div>
	<div class="stepBox left">
    	<span class="stepArrow"></span>
        <a id="backlogmonitor" href="backlogmonitor.jsp" class="left stepItem stepItem_4" title="积压监测">
            <span class="stepIcon"><em></em></span>
            <span class="stepWord"></span>
        </a>
    </div>
	<div class="stepBox left">
    	<span class="stepArrow"></span>
        <a id="storage" href="storage.jsp" class="left stepItem stepItem_5" title="存储量监测">
            <span class="stepIcon"><em></em></span>
            <span class="stepWord"></span>
        </a>
    </div>
	<div class="stepBox left">
    	<span class="stepArrow"></span>
        <a id="jobmonitor" href="jobmonitor.jsp" class="left stepItem stepItem_6" title="任务监测">
            <span class="stepIcon"><em></em></span>
            <span class="stepWord"></span>
        </a>
    </div>
	<div class="stepBox left">
    	<span class="stepArrow"></span>
        <a id="servemonitor" href="servemonitor.jsp" class="left stepItem stepItem_7" title="服务监测">
            <span class="stepIcon"><em></em></span>
            <span class="stepWord"></span>
        </a>
    </div>
</div>

