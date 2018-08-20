<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="accountMain">
    <div class="accountSift clearfix">
        <label class="left">数据源：</label>
        <div id="exampleCombobox_1" class="exampleCombobox_1 left marginR60"></div>
        <label class="left">大协议：</label>
        <div id="exampleCombobox_2" class="exampleCombobox_2 left marginR60"></div>
        <label class="left">小协议：</label>
        <div id="exampleCombobox_3" class="exampleCombobox_3 left marginR60"></div>
        <label class="left">字段：</label>
        <div id="exampleCombobox_4" class="exampleCombobox_4 left marginR60"></div>
        <label class="left">特定值：</label> 
        <input type="text" class="left inputs"/>
        <a href="#" class="right emptyBtn_1">清空</a>
        <a href="#" class="right schBtn_1">查询</a>
    </div>
    
    <div class="box">
    	<div class="boxHd clearfix">
        	<h3 class="left">样例包（<em class="boxHdEm">75</em>）</h3>
        </div>
        <div class="boxBd">
        	<div class="examplepackGrid" id="examplepackGrid">
            	
            </div>
        </div>
    </div>
    
</div>
<script type="text/javascript">
	$(function(){
		var configs = [{
			id : "exampleCombobox_1",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "exampleCombobox_2",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "exampleCombobox_3",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "exampleCombobox_4",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "exampleCombobox_5",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		}];
		combobox(configs);
		
		//加载样例监测表格
	    var colModel = [{                                               //配置表格各列
	                display:'数据源',
	                name:'datasource',
	                hidden:false
	            },{
	                display:'大协议',
	                name:'datatype',
	                hidden:false
	            },{
	                display:'大协议名称',
	                name:'datatypechname',
	                hidden:false
	            },{
	                display:'小协议',
	                name:'protocol',
	                hidden:false
	            },{
	                display:'小协议名称',
	                name:'protocolchname',
	                hidden:false
	            },{
	                display:'样例生成时间',
	                name:'createdate',
	                hidden:false
	            },{
	                display:'操作',
	                name:'col5',
	                hidden:false,
					formatter : opeFormatter
	            }];
	    	var otherConfig = {
				"isMultiple":false
			};
	    grid("examplepackGrid","/rundatakpi/exampleZipController/getList",colModel,otherConfig);
	
	});

	//操作列回调函数
	function opeFormatter(val,row){
		//alert(JSON.stringify(row));
		//alert(JSON.stringify(val));
		//alert(JSON.stringify($(row).html()));
		var row = JSON.stringify(row);
		return "<a href='#' class='opeSeeLink' onclick='opeSeeFnc(this,"+row+")'>查看</a>";
		//var row = JSON.stringify(row);
		//return "<a href='#' class='opeButton' onclick='formatterOpe(this,"+row+")' title='"+val+"'>"+val+"</a>";
	}
	
	//点击查看按钮方法
	function opeSeeFnc(_this,row){
		
		windowFnc({
			id:"pop",
			width:900,
			height:520,
			url:"include/exampledetailinfo_pop.jsp",
			title: "详细信息",
			listeners:{
				render:function(){
				/* 	var configs = [{
						id : "equipmentType",
						url : "json/dealStatusCombobox.json",
						onSelect : function(combo,record){}
					}];
					combobox(configs); */
					
						
					//加载异常返回表格
					var colModel = [{                                               //配置表格各列
								display:'字段',
								name:'key',
								hidden:false
							},{
								display:'字段名称',
								name:'chname',
								hidden:false
							},{
								display:'原始字段值',
								name:'ysz',
								hidden:false
							},{
								display:'预处理字段值',
								name:'yclz',
								hidden:false
							},{
								display:'结构化字段值',
								name:'jghz',
								hidden:false
							},{
								display:'对象化字段值',
								name:'dxhz',
								hidden:false
							}];
					var otherConfig = {
						"isMultiple":false,
						 usepage:false
					};
					var url='/rundatakpi/exampleZipController/getSubList?id='+row.id;
					grid("exampleDetailInfoGrid",url,colModel,otherConfig);
					
				}
			}
		});
	}
	
</script>