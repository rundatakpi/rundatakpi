$(function(){
	$('.chooseDay').off("click").on('click',"a",function(){
		$(this).addClass("slt").siblings().removeClass("slt");
		return false;
		/*if($(this).hasClass('toggSlideBtn')){
			$(this).removeClass('toggSlideBtn');
			$(this).stop().animate({left:3}).html('近7天');
		}else{
			$(this).addClass('toggSlideBtn');
			$(this).stop().animate({left:24}).html('近30天');
		}*/
	});	
})
