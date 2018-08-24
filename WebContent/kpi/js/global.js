//定义全局变量
var globalObj = {
		"gridObj":{},
		"comboboxObj":{},
		"windowObj":{},
		"mergeGrid":{}
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

//加载页面
function include (url, fn) {
	$.ajax({
		type:'post',	
		url:url,
		dataType : 'text',
		success:function(text){
			//清空全局变量
			clearGlobalObj();
			fn(text);
		},
		error:function (mess) {
			alert(mess.status+"页面加载失败");
		}
	});
}

//清空全局变量
function clearGlobalObj(){
	//清空全局变量
	globalObj = {
		"gridObj":{},
		"comboboxObj":{},
		"windowObj":{},
		"mergeGrid":{}
	};
}


//创建表格组件
function grid(id,url,colModel,configs){
	var defaultConfig = {
			query : {"username":"grid"},								//调用表格组件传入的参数
			isMultiple : true,										//配置表格组件是否需要复选框
			autoIncrement : true,									//配置表格组件是否有自增序号
			alignWay : "center",									//配置表格组件对齐方式
			//dataProperty : "dataProperty",						//传入数据的名称
			//totalProperty : "totalProperty",						//传入数据的名称
			dragable : false,										//配置表格是否可拖拽
			//endDragFnc : endDrag,									//拖拽结束后的回调函数
			colHover : true,										//配置表格组件是否有鼠标经过行效果
			zebra : true,											//配置表格组件是否有隔行换色效果
			//rowClick : rowClickFnc,									//配置表格组件行点击事件
			//dataSuccess : dataSuccessFnc,							//数据加载完成时的回调函数
			//timeout : 1,											//配置异步请求超时时间
			//onCheck : onCheckFnc,									//点击复选框选中事件
			//onUnCheck : onUnCheckFnc,								//点击复选框取消选中事件
			//onCheckAll : onCheckAllFnc,								//点击复选框选中事件
			//onUnCheckAll : onUnCheckAllFnc,							//点击复选框取消选中事件
			cellEmpty : "-------",									//当个单元格内容检索为undefined时使用临时替代字符
			usepage : {												//配置表格组件分页   
				type : 2,
				position:"bottom",
				align:"right",
				pageGoAble : false,
				pageSizeAble : true,
				pageDescription : false
			},
			listeners:{
				render:function(){
					//alert(this.getTotal());
					//alert(this.getData());
				},
				reloadGrid:function(){
					//alert(this.getTotal());
					//alert(this.getData());
				}
			 }
		};
	if(configs){
		var settings = $.extend(true, {}, defaultConfig, configs);
	}else{
		var settings = defaultConfig;
	}
	//alert(JSON.stringify(settings));
	globalObj.gridObj[id] = Run.create("Grid",{
		id : id,											//调用表格组件需要的ID
		url : url,									//调用表格组件的JSON路径
		//width:1000,											//配置表格组件的宽度
		//height:480,											//配置表格组件的高度
		query : settings.query,								//调用表格组件传入的参数
		isMultiple : settings.isMultiple,										//配置表格组件是否需要复选框
		autoIncrement : settings.autoIncrement,									//配置表格组件是否有自增序号
		alignWay : settings.alignWay,									//配置表格组件对齐方式
		//dataProperty : "dataProperty",						//传入数据的名称
		//totalProperty : "totalProperty",						//传入数据的名称
		dragable : settings.dragable,										//配置表格是否可拖拽
		//endDragFnc : endDrag,									//拖拽结束后的回调函数
		colHover : settings.colHover,										//配置表格组件是否有鼠标经过行效果
		zebra : settings.zebra,											//配置表格组件是否有隔行换色效果
		//rowClick : rowClickFnc,									//配置表格组件行点击事件
		//dataSuccess : dataSuccessFnc,							//数据加载完成时的回调函数
		//timeout : 1,											//配置异步请求超时时间
		//onCheck : onCheckFnc,									//点击复选框选中事件
		//onUnCheck : onUnCheckFnc,								//点击复选框取消选中事件
		//onCheckAll : onCheckAllFnc,								//点击复选框选中事件
		//onUnCheckAll : onUnCheckAllFnc,							//点击复选框取消选中事件
		cellEmpty : settings.cellEmpty,									//当个单元格内容检索为undefined时使用临时替代字符
		usepage : settings.usepage,
		//beforePage : beforePageFnc,
		//afterPage : afterPageFnc,
		colModel:colModel,
		listeners:settings.listeners
	});
		
	//console.log(JSON.stringify(globalObj));
}

//创建弹窗组件
function windowFnc(configs){
	$('body').append('<div id="'+configs.id+'"></div>');
	var defaultConfig = {
		  id:"pop",
		  width:700,
		  height:300,
		  type: 'get',
		  title:'编辑',//窗口标题文本
		  iconCls:'',//窗口标题图标的css类名称
		  //mask:true,//窗口是否显示全屏遮罩层: true(显示，默认)
		  //shadow:false,//窗口是否显示阴影: false(不显示， 默认)
		  //closable:true,//窗口标题左上方是否显示关闭按钮: true(显示，默认)
		  //closeFn:fn,//点击窗口标题左上方关闭按钮 的回调函数
		  //draggable:true,//窗口是否可拖拽: true(可拖拽，默认)
		  //resizable：false,//窗口边和角是否允许拖拽缩放窗口大小: false(不允许，默认)
		  //maximal:false,//窗口标题左上方是否显示最大化按钮: false(不显示，默认)
		  //maxFn:fn,//点击窗口标题左上方最大化按钮后、最大化后点击还原按钮 的回调函数
		  //minimal:false,//窗口标题左上方是否显示最小化按钮: false(不显示，默认)
		  //up:false,//窗口标题左上方是否显示收起窗口内容区按钮: false(不显示，默认)
		 // message:'<h3 style="text-align:center;">弹窗内容</h3>',//弹窗内容
		  url:"test.html",//填充window窗口内容区来源：通过ajax请求方式获得内容
		  animationType:'none',//默认 'fade', 'none'
		  animationDuration: 300,//默认300
		  buttons:[],
		  listeners:{
			render:function(){
	
			},
			reloadGrid:function(){
	
			}
		 }
	};
	var settings = $.extend(true, {}, defaultConfig, configs);

	globalObj.windowObj[settings.id] = Run.create('Window',settings);
	
	//console.log(JSON.stringify(globalObj));
}

function clearCombobox(id){
	$("#"+id).find("input").val("").end().find(".r-combobox-slt").removeClass("r-combobox-slt");
}












