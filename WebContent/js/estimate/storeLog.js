var oTable;
//获取主机地址之后的目录，如： proj/meun.jsp
var pathName = window.document.location.pathname;
var rootPath = pathName.substring(0, pathName.substr(1).indexOf('/')+1);

$(function() {
	
	refreshData();
    
    $("#searchBtn").on('click',function() {
    	var _this = $(this);
    	_this.prop("disabled",true);

    	oTable.ajax.reload();
    	
    	setTimeout(function(){
    		_this.removeProp("disabled");
        },2000);
 	});

 
})

/**
 * 绘制表格
 * @returns
 */
function refreshData(){
	//初始化表格对象
	oTable =  $('#transTable').DataTable({
    	 "bAutoWidth": true,//自动宽度
    	 "processing": true,//刷新的那个对话框
         "serverSide": true,//服务器端获取数据
         "bStateSave": false, 
         "pagingType": "full_numbers",
         "bPaginate": true, //翻页功能
         "bGoBtn":true,
         "lengthMenu": [ //自定义分页长度
             [10,20,50],
             ['10 条','20条','50条']
         ],
         "ordering":false,
         "ajax": {
             "url": rootPath+"/storeLog/getList",
             "type": "POST",
             "data": function(d){
            	 d.actionType = $("select#actionType>option:selected").val();
            
             }
         },
         "searching" : false,
         "columns": [
        	 { "data": "id","defaultContent":"" },
             { "data": "dataSourceCode","defaultContent":"" },
             { "data": "dataSourceDesc","defaultContent":""},
             { "data": "bProtocolCode","defaultContent":""},
             { "data": "bProtocolDesc","defaultContent":"" },
             { "data": "inputNum","defaultContent":""},
             { "data": "storageRate","defaultContent":"" },
             { "data": "fieldNum","defaultContent":"" },
             { "data": "bAccuracy","defaultContent":"" },
             { "data": ""}
         ],
         "oLanguage" : { // 国际化配置
             "sProcessing" : "正在获取数据，请稍后...",
             "sLengthMenu" : "显示 _MENU_ 页",
             "sZeroRecords" : "没有找到数据",
             "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
             "sInfoEmpty" : "记录数为0",
             "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
             "sInfoPostFix" : "",
             "sSearch" : "查询",
             "sUrl" : "",
             "oPaginate" : {
                 "sFirst" : "首页",
                 "sPrevious" : "上一页",
                 "sNext" : "下一页",
                 "sLast" : "尾页"
             }
         },
         fnDrawCallback: function(table) {
 			$("#transTable_paginate").append("  到第 <input style='height:28px;line-height:28px;width:40px;' class='margin text-center' id='changePage' type='text'> 页  <a class='btn btn-default shiny' style='margin-bottom:5px' href='javascript:void(0);' id='dataTable-btn'>确认</a>");
 			var pTable = $("#transTable").dataTable();
 			$('#dataTable-btn').click(function(e) {
 				if($("#changePage").val() && $("#changePage").val() > 0) {
 					var redirectpage = $("#changePage").val() - 1;
 				} else {
 					var redirectpage = 0;
 				}
 				pTable.fnPageChange(redirectpage);
 			});
 		},
         "columnDefs": [
        	 //给5-8列添加超链接
        	{
	 			"targets": [5], // 入库条数
	 	        "render": function(data, type, full){
	 	        
	 	        	return "<a href='#' onclick='showFieldDetail(this,5)'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [6], // 入库条数
	 	        "render": function(data, type, full){
	 	        
	 	        	return "<a href='#' onclick='showFieldDetail(this,6)'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [7], // 入库条数
	 	        "render": function(data, type, full){
	 	        
	 	        	return "<a href='#' onclick='showFieldDetail(this,7)'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [8], // 入库条数
	 	        "render": function(data, type, full){
	 	        
	 	        	return "<a href='#' onclick='showFieldDetail(this,8)'>"+data+"</a>";
	 	           
	 	        }
        	},
        	//隐藏1列
        	{
	 			"targets": [0], // 输入数据条数
	 			"visible": false,
        	},
        	//最后一列返回详情按钮
        	{
	 			"targets": [-1], // 输入数据条数
	 			"render": function(data, type, full){ 
	 				 return  "<button class='btn btn-success btn-xs' onclick='showProtocolDetail(this)'><i class='fa fa-remove'></i>查看详情</button>"
		 	          
	 	           
	 	        }
        	}
        ]
    })
}


/**
 * 展示入库日志数据某字段详情
 * @param _this
 * @returns
 */
function showFieldDetail(_this,num){
	
	//获取该条数据数据源和大协议
	var dataSourceCode = oTable.row($(_this).closest("tr")).data().dataSourceCode;
	var bProtocolCode = oTable.row($(_this).closest("tr")).data().bProtocolCode;
	
	var colnums = ['inputNum','storageRate','fieldNum','accuracy'];
	var colName = colnums[num-5];
	
	//iframe层
	layer.open({
		  type: 2,
		  title: '指标趋势',
		  shadeClose: true,
		  closeBtn: 1, //关闭按钮是否显示 1显示0不显示
		  shade: 0.8,
		  area: ['800px', '600px'],
		  content: rootPath+'/kpi/estimate/bLogDetail.html?dataSourceCode='+dataSourceCode+"&bProtocolCode="+bProtocolCode+'&colName='+colName//iframe的url
	});
			
}

/**
 * 展示入库日志数据小协议详情
 * @param _this
 * @returns
 */
function showProtocolDetail(_this){
	
	//获取该条数据数据源和大协议
	var dataSourceCode = oTable.row($(_this).closest("tr")).data().dataSourceCode;
	var bProtocolCode = oTable.row($(_this).closest("tr")).data().bProtocolCode;
	
	window.location.href = rootPath+'/kpi/estimate/sProtocolLog.html?dataSourceCode='+dataSourceCode+"&bProtocolCode="+bProtocolCode;
}

