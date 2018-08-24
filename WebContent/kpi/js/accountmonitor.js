$(function(){
	var configs = [{
		id : "accountCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "accountCombobox_2",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	
	//加载帐号监测表格
    var colModel = [{                                               //配置表格各列
                display:'监测账号',
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
    grid("accountGrid","json/accountGrid.json",colModel);
	
	$(".addAccount").click(function(){
		windowFnc({
			id:"pop",
			width:564,
			height:430,
			url:"include/addAccount_pop.html",
			title: "新增",
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
					
				}
			}
		});
	});

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
	return "<a href='#' class='opeSeeLink' onclick='opeSeeFnc(this,"+row+")'>查看</a><a href='#' class='opeEditLink' onclick='opeEditFnc(this,"+row+")'>修改</a><a href='#' class='opeDeleteLink' onclick='opeDeleteFnc(this,"+row+")'>删除</a>";
	
	//var row = JSON.stringify(row);
	//return "<a href='#' class='opeButton' onclick='formatterOpe(this,"+row+")' title='"+val+"'>"+val+"</a>";
}

//点击查看按钮方法
function opeSeeFnc(){
	windowFnc({
		id:"pop",
		width:900,
		height:490,
		url:"include/accountdetailinfo_pop.html",
		title: "详细信息",
		listeners:{
			render:function(){
				var configs = [{
					id : "equipmentType",
					url : "json/dealStatusCombobox.json",
					onSelect : function(combo,record){}
				}];
				combobox(configs);
				
					
				//加载异常返回表格
				var colModel = [{                                               //配置表格各列
							display:'连接时间',
							name:'col1',
							hidden:false
						},{
							display:'设备类型',
							name:'col2',
							hidden:false
						},{
							display:'设备MAC',
							name:'col3',
							hidden:false
						},{
							display:'操作系统',
							name:'col4',
							hidden:false
						},{
							display:'备注',
							name:'col5',
							hidden:false
						}];
				var otherConfig = {
					"isMultiple":false
				};
				grid("accountDetailInfoGrid","json/examplepackGrid.json",colModel,otherConfig);

				
			}
		}
	});
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

//点击修改按钮方法
function opeDeleteFnc(){
	windowFnc({
		id:"pop",
		width:300,
		height:150,
		//url:"include/editalarminfo_pop.html",
		title: "删除提示框",
		message : "<p class='popTip'>是否确定删除整行数据？</p>",
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
			}
		}
	});
}



