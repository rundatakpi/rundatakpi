<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="accountMain">
<form action="">
    <div class="accountSift clearfix">
        <label class="left">告警级别：</label>
        <div id="accountCombobox_1" class="accountCombobox_1 left marginR60"></div>
        <label class="left">告警状态：</label>
        <div id="accountCombobox_2" class="accountCombobox_2 left marginR60"></div>
        <!-- <label class="left">告警时间：</label>
        <input type="text" class="left starttime" />
        <span class="left timeSep">—</span>
        <input type="text" class="left endtime" /> -->
        <a href="#" class="right emptyBtn_1">清空</a>
        <a href="#" class="right schBtn_1">查询</a>
    </div>
  </form>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">帐号监测（<em class="boxHdEm">75</em>）</h3>
            <!-- <a href="#" class="right opeBtn_1">批量导出</a> -->
            <a href="#" class="right opeBtn_1 addAccount">新增</a>
        </div>
        <div class="boxBd">
        	<div class="accountGrid" id="accountGrid">
            	
            </div>
        </div>
    </div>
    
</div>
<script>
$.fn.serializeObject = function()  
{  
   var o = {};  
   var a = this.serializeArray();  
   $.each(a, function() {  
       if (o[this.name]) {  
           if (!o[this.name].push) {  
               o[this.name] = [o[this.name]];  
           }  
           o[this.name].push(this.value || '');  
       } else {  
           o[this.name] = this.value || '';  
       }  
   });  
   return o;  
};

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
	showTable();
	$(".addAccount").click(function(){
		windowFnc({
			id:"pop",
			width:564,
			height:430,
			url:"include/addAccount_pop.jsp",
			title: "新增",
			buttons:[{
				'className':'diaSureBtn',
				'text':'确定',
				'handle': function (api) {//确定
					save(api);
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
					//alert("");
				}
			}
		});
	});
});

function showTable(){
	//加载帐号监测表格
    var colModel = [{                                               //配置表格各列
                display:'监测账号',
                name:'account',
                hidden:false
            },{
                display:'告警级别',
                name:'level',
                hidden:false,
				formatter : levelFormatter
            },{
                display:'告警内容',
                name:'alarm',
                hidden:false
            },{
                display:'处理状态',
                name:'zt',
                hidden:false,
				formatter : statusFormatter
            },{
                display:'告警时间',
                name:'date',
                hidden:false,
				formatter : statusFormatter
            },{
                display:'操作',
                name:'',
                hidden:false,
				formatter : opeFormatter
            }];
    grid("accountGrid","/rundatakpi/exampleZipController/getAlarmList",colModel);
}

function save(api){
	//alert($('#form1').serialize());
	var json = $('#form1').serializeObject();
	//alert(JSON.stringify(jsonuserinfo));
	if(json.account==''){
		alert("宽带账号不能为空!");
		return ;
	}
	 $.ajax({
			type:"post",
			url:"/rundatakpi/exampleZipController/save",
			data:json,
			dataType:"text",
			success: function(data){
				if(data==1){
					alert("保存成功！");
					api.close();
					showTable();
				}
			},
			error: function(){
				
			}
		}); 
}

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
	return "<a href='#' class='opeSeeLink' onclick='opeSeeFnc(this,"+row+")'>查看</a><a href='#' class='opeEditLink' onclick='opeEditFnc(this,"+row+")'>修改</a><a href='#' class='opeDeleteLink'>删除</a>";
	
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
				alert($('#from1').serialize());
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

</script>