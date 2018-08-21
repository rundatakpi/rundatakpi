<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="accountMain">
<form action="">
    <div class="accountSift clearfix">
        <label class="left">告警级别：</label>
        <div id="warmingCombobox_1" class="warmingCombobox_1 left marginR60"></div>
        <label class="left">告警状态：</label>
        <div id="warmingCombobox_2" class="warmingCombobox_2 left marginR60"></div>
        <!-- <label class="left">告警时间：</label>
        <input type="text" class="left starttime" />
        <span class="left timeSep">—</span>
        <input type="text" class="left endtime" /> -->
        <a href="#" class="right emptyBtn_1" onclick='clickEmpty()'>清空</a>
        <a href="#" class="right schBtn_1" onclick='clickSift()'>查询</a>
    </div>
  </form>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">帐号监测（<em class="boxHdEm">5</em>）</h3>
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
var url;
$(function(){
	var configs = [{
		id : "warmingCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "warmingCombobox_2",
		url : "json/failStatus.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	url="/rundatakpi/exampleZipController/getAlarmList";
	showTable(url);
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

function showTable(url){
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
                hidden:false
            },{
                display:'操作',
                name:'',
                hidden:false,
				formatter : opeFormatter
            }];
	
    grid("accountGrid",url,colModel);
}

function clickSift(){
	//告警级别
	var warmingLevel = $("#warmingCombobox_1").find(".r-combobox-slt").find("span").attr("value");
	if(warmingLevel==undefined||warmingLevel==0){
		warmingLevel="";
	}
	//告警状态
	var warmingStatus= $("#warmingCombobox_2").find(".r-combobox-slt").find("span").attr("value");
	if(warmingStatus==undefined||warmingStatus==0){
		warmingStatus="";
	}
	
	var url1=url+"?level="+warmingLevel+"&zt="+warmingStatus;
	showTable(url1);
}

function clickEmpty(){
	//$('div[name="warmingCombobox_1"]').val("0");
	//$('div[name="warmingCombobox_2"]').val("0");
	//$("#warmingCombobox_2").find(".r-combobox-input").val("请选择");
	//$("#warmingCombobox_1").find(".r-combobox-input").val("请选择");
	$("#warmingCombobox_1").children().remove();
	$("#warmingCombobox_2").children().remove();
	var configs = [{
		id : "warmingCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "warmingCombobox_2",
		url : "json/failStatus.json",
		onSelect : function(combo,record){}
	}];
	//加载下拉框
	combobox(configs);
	showTable(url);
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
					showTable(url);
				}
			},
			error: function(){
				
			}
		}); 
}

//告警级别列回调函数
function levelFormatter(val,row){
	if(val === "1"){
		return "<span class='levelSpan_1'>严重</span>";
	}else if(val === "2"){
		return "<span class='levelSpan_2'>一般</span>";
	}else if(val === "3"){
		return "<span class='levelSpan_3'>轻微</span>";
	}else{
		return '';
	}
	//var row = JSON.stringify(row);
	//return "<a href='#' class='opeButton' onclick='formatterOpe(this,"+row+")' title='"+val+"'>"+val+"</a>";
}

//状态列回调函数
function statusFormatter(val,row){
	if(val === "1"){
		return "<span class='statusSpan_1'>告警中</span>";
	}else if(val === "2"){
		return "<span class='statusSpan_2'>处理中</span>";
	}else if(val === "3"){
		return "<span class='statusSpan_3'>已处理</span>";
	}else{
		return '';
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

//点击删除按钮方法
function opeDeleteFnc(_this,row){
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
				var id=row.id;
				$.ajax({
			        type: 'post',
			        url: "/rundatakpi/exampleZipController/del",
			        dataType : 'json',
			        async : false,
			        data:{"id":id},
			        success: function(result){
			        	location.reload();
			       }
			     });
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

function clickSift1(){
	//设备类型
	var warmingLevel = $("#equipmentType").find(".r-combobox-slt").find("span").attr("value");
	if(warmingLevel==undefined||warmingLevel==0){
		warmingLevel="";
	}
	var url=urll+"&lx="+warmingLevel;
	showTable1(url);
}

function showTable1(url){
	//加载异常返回表格
	var colModel = [{                                               //配置表格各列
				display:'连接时间',
				name:'condate',
				hidden:false
			},{
				display:'设备类型',
				name:'lx',
				formatter : lxFormatter
			},{
				display:'设备MAC',
				name:'mac',
				hidden:false
			},{
				display:'操作系统',
				name:'os',
				hidden:false
			},{
				display:'备注',
				name:'bz',
				hidden:false
			}];
	var otherConfig = {
		"isMultiple":false
	};
	
	//alert(url)
	grid("accountDetailInfoGrid",url,colModel,otherConfig);
}

function lxFormatter(val,row){
	if(val === "1"){
		return "<span >手机</span>";
	}else if(val === "2"){
		return "<span >电脑</span>";
	}else if(val === "3"){
		return "<span >pad</span>";
	}else if(val === "4"){
		return '其他';
	}else {
		return '';
	}
}

var urll;
//点击查看按钮方法
function opeSeeFnc(_this,row){
	windowFnc({
		id:"pop",
		width:900,
		height:490,
		url:"include/accountdetailinfo_pop.jsp",
		title: "详细信息",
		listeners:{
			render:function(){
				var configs = [{
					id : "equipmentType",
					url : "json/lx.json",
					onSelect : function(combo,record){
						
					}
				}];
				combobox(configs);
				urll="/rundatakpi/exampleZipController/getAlarmDetails?alarmid="+row.id;
				showTable1(urll);
			}
		}
	});
}

//点击修改按钮方法
function opeEditFnc(_this,row){
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
				var status=$("#dealStatusCombobox").find(".r-combobox-slt").find("span").attr("value");
				var statusContent=$("#dealStatusCombobox").find(".r-combobox-slt").find("span").text();
				if(status!=undefined&&status!=0){
					var id=row.id;
					$.ajax({
				        type: 'post',
				        url: "/rundatakpi/exampleZipController/edit",
				        dataType : 'json',
				        data:{"id":id,"zt":status},
				        success: function(result){
				        	var flag=result.flag;
				        	if(flag==1){
				        	/* 	var processState =$(_this).closest("tr").find("td[name='zt']").find(".r-grid-omit").find("span");
				        		$(processState).text(statusContent);
				        		console.log(statusContent);
				        		console.log(status);
				        		$(processState).removeClass("statusSpan_1").removeClass("statusSpan_2").removeClass("statusSpan_3");
				        		if(status==1){
				        			$(processState).addClass("statusSpan_1")
				        		}else if(status==2){
				        			$(processState).addClass("statusSpan_2")
				        			console.log(processState);
				        		}else{
				        			$(processState).addClass("statusSpan_3")
				        		} */
				        		alert('修改成功!');
				        		clickSift();
				        	}
				       }
				     });
				}
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