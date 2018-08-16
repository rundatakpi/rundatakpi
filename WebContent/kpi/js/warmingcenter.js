$(function(){
	var configs = [{
		id : "warmingCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "warmingCombobox_2",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	
	//加载帐号监测表格
    var colModel = [{                                               //配置表格各列
                display:'告警时间',
                name:'col1',
                hidden:false
            },{
                display:'告警级别',
                name:'col2',
                hidden:false,
				formatter : levelFormatter
            },{
                display:'告警内容',
                name:'col3',
                hidden:false
            },{
                display:'处理状态',
                name:'col4',
                hidden:false,
				formatter : statusFormatter
            },{
                display:'操作',
                name:'col5',
                hidden:false,
				formatter : opeFormatter
            }];
    grid("warmingGrid","json/warmingGrid.json",colModel);
});

//告警级别列回调函数
function levelFormatter(val,row){
	//alert(JSON.stringify(row));
	//alert(JSON.stringify(val));
	//alert(JSON.stringify($(row).html()));
	if(val === "一般"){
		return "<span class='levelSpan_1'>"+val+"</span>";
	}else if(val === "轻微"){
		return "<span class='levelSpan_2'>"+val+"</span>";
	}else if(val === "严重"){
		return "<span class='levelSpan_3'>"+val+"</span>";
	}
	//var row = JSON.stringify(row);
	//return "<a href='#' class='opeButton' onclick='formatterOpe(this,"+row+")' title='"+val+"'>"+val+"</a>";
}

//状态列回调函数
function statusFormatter(val,row){
	//alert(JSON.stringify(row));
	//alert(JSON.stringify(val));
	//alert(JSON.stringify($(row).html()));
	if(val === "告警中"){
		return "<span class='statusSpan_1'>"+val+"</span>";
	}else if(val === "处理中"){
		return "<span class='statusSpan_2'>"+val+"</span>";
	}else if(val === "已处理"){
		return "<span class='statusSpan_3'>"+val+"</span>";
	}
	//var row = JSON.stringify(row);
	//return "<a href='#' class='opeButton' onclick='formatterOpe(this,"+row+")' title='"+val+"'>"+val+"</a>";
}

//操作列回调函数
function opeFormatter(val,row){
	//alert(JSON.stringify(row));
	//alert(JSON.stringify(val));
	//alert(JSON.stringify($(row).html()));
	
	var row = JSON.stringify(row);
	return "<a href='#' class='opeEditLink' onclick='opeEditFnc(this,"+row+")'>修改</a><a href='#' class='opeDeleteLink' onclick='opeDeleteFnc(this,"+row+")'>删除</a>";
	
	//var row = JSON.stringify(row);
	//return "<a href='#' class='opeButton' onclick='formatterOpe(this,"+row+")' title='"+val+"'>"+val+"</a>";
}

//点击修改按钮方法
function opeEditFnc(){
	windowFnc({
		id:"pop",
		width:300,
		height:220,
		url:"include/editalarminfo_pop.html",
		title: "修改告警信息",
		buttons:[{
			'className':'diaSureBtn',
			'text':'确定',
			'handle': function (api) {//确定
				api.close();
			}
		},{
			'className':'diaCancelBtn',
			'text':'取消',
			'handle': function (api) {//确定
				api.close();
			}
		}],
		listeners:{
			render:function(){
				var configs = [{
					id : "dealStatusCombobox",
					url : "json/dealStatusCombobox.json",
					onSelect : function(combo,record){}
				}];
				combobox(configs);
			}
		}
	});
}

//点击删除按钮方法
function opeDeleteFnc(){
	windowFnc({
		id:"pop",
		width:310,
		height:190,
		url:"include/deletetip_pop.html",
		title: "删除提示",
		buttons:[{
			'className':'diaSureBtn',
			'text':'确定',
			'handle': function (api) {//确定
				api.close();
			}
		},{
			'className':'diaCancelBtn',
			'text':'取消',
			'handle': function (api) {//确定
				api.close();
			}
		}],
		listeners:{
			render:function(){}
		}
	});
}

