//定义全局变量
var globalObj = {
		"gridObj":{},
		"comboboxObj":{},
		"windowObj":{}
	};

$(function(){
	$('.chooseDay').off("click").on('click',"a",function(){
		$(this).addClass("slt").siblings().removeClass("slt");
		return false;
	});	
	
})


//创建下拉框组件
function combobox(configs){
	var defaultConfig = {
		width : 115,
	    listHeight : 150,
		isMultiple : false,
		editable : false,
		clearAble : false,
		autoLoad : false,
		siftAble : false,
	};
	
	var settings = null;
	$.each(configs,function(i,n){
		settings = $.extend(true, {}, defaultConfig, n);
		globalObj.comboboxObj[settings.id] = Run.create("ComboBox",settings);
	});
	//console.log(JSON.stringify(globalObj));
}
