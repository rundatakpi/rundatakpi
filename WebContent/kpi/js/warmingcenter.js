$(function(){
	//切换样式
	$('.nav').find('a').removeClass("slt");
	$('.navLink_5').addClass('slt');
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
	//加载表格
	showTable("/rundatakpi/alarmData/getList")
    
	//加一个监听（筛选功能）
	$('.schBtn_1').click(function(){
		clickSift();
	});
	
	//清空筛选
	$(".emptyBtn_1").click(function(){
		clickEmpty();
	});
	
	//批量导出
	$(".opeBtn_1").click(function(){
		downloadFun();
	});
    
});

function downloadFun(){
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
	var url="/rundatakpi/alarmData/exportExcel?alarmLevel="+warmingLevel+"&processState="+warmingStatus;
	window.location=url;
}

function showTable(url){
	  var colModel = [{                                               //配置表格各列
          display:'id',
          name:'id',
          hidden:true
      },{                                               //配置表格各列
          display:'告警时间',
          name:'alarmTime',
          hidden:false
      },{
          display:'告警级别',
          name:'alarmLevel',
          hidden:false,
			formatter : levelFormatter
      },{
          display:'告警内容',
          name:'alarmContent',
          hidden:false
      },{
          display:'处理状态',
          name:'processState',
          hidden:false,
			formatter : statusFormatter
      },{
          display:'操作',
          name:'col5',
          hidden:false,
		  formatter : opeFormatter
      }];
	  var otherConfig = {
				"isMultiple":false
	};
grid("warmingGrid",url,colModel,otherConfig);
}
//筛选
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
	var url="/rundatakpi/alarmData/getList?alarmLevel="+warmingLevel+"&processState="+warmingStatus;
	showTable(url);
}
//清空
function clickEmpty(){
	$("#warmingCombobox_2").find(".r-combobox-input").val("请选择");
	$("#warmingCombobox_1").find(".r-combobox-input").val("请选择");
	showTable("/rundatakpi/alarmData/getList")
}

//告警级别列回调函数
function levelFormatter(val,row){
	if(val === "1"){
		return "<span class='levelSpan_1'>严重</span>";
	}else if(val === "2"){
		return "<span class='levelSpan_2'>一般</span>";
	}else if(val === "3"){
		return "<span class='levelSpan_3'>轻微</span>";
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
function opeEditFnc(_this){
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
					var id=$(_this).closest("tr").find("td[name='id']").find(".r-grid-omit").text();
					$.ajax({
				        type: 'post',
				        url: "/rundatakpi/alarmData/edit",
				        dataType : 'json',
				        async : false,
				        data:{"id":id,"processState":status},
				        success: function(result){
				        	var flag=result.flag;
				        	if(flag==1){
				        		var processState =$(_this).closest("tr").find("td[name='processState']").find(".r-grid-omit").find("span");
				        		$(processState).text(statusContent);
				        		$(processState).removeClass("statusSpan_1").removeClass("statusSpan_2").removeClass("statusSpan_3");
				        		if(status==1){
				        			$(processState).addClass("statusSpan_1")
				        		}else if(status==2){
				        			$(processState).addClass("statusSpan_2")
				        		}else{
				        			$(processState).addClass("statusSpan_3")
				        		}
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

//点击删除按钮方法
function opeDeleteFnc(_this){
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
				var id=$(_this).closest("tr").find("td[name='id']").find(".r-grid-omit").text();
				$.ajax({
			        type: 'post',
			        url: "/rundatakpi/alarmData/del",
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

