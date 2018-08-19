$(function(){
	$(".activeTabHd .activeTabLink").each(function(i){
		$(this).click(function(){
			$(this).addClass("slt").siblings().removeClass("slt");
			
			$(".activeTabBd .activeTabBdBox").eq(i).show().siblings().hide();
			
			/*if($.trim($(".activeTabBd .activeTabBdBox").eq(i).html()) === ""){
				var pageName = i === 0 ? "accountmonitor" : "examplepackmonitor";
				include("include/"+pageName+".html",function(text){
					$('.activeTabBd .activeTabBdBox').eq(i).show().html("").append(text);
				});
			}*/
			
			return false;
		});
	});
	//$(".activeTabHd .activeTabLink").eq(0).trigger("click")
	
	//页面初始加载第一屏标签页
	include("include/importdata.html",function(text){
        $('.activeTabBd .activeTabBdBox').eq(0).show().html("").append(text);
    });
	
	
});