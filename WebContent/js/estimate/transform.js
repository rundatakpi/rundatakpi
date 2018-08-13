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
             "url": rootPath+"/transform/getList",
             "type": "POST",
             "data": function(d){
            	 d.actionType = $("select#actionType>option:selected").val();
            
             }
         },
         "searching" : false,
         "columns": [
             { "data": "id" },
             { "data": "dataSourceCode","defaultContent":"" },
             { "data": "dataSourceDescription" ,"defaultContent":""},
             { "data": "bProtocolCode" ,"defaultContent":""},
             { "data": "bProtocolDescription","defaultContent":"" },
             { "data": "sProtocolCode","defaultContent":""},
             { "data": "sProtocolDescription" ,"defaultContent":""},
             { "data": "actionType" ,"defaultContent":""},
             { "data": "inputDataNum" ,"defaultContent":""},
             { "data": "inputDataSpeed","defaultContent":"" },
             { "data": "inputFieldFillRate" ,"defaultContent":""},
             { "data": "inputDependGroupFillRate" ,"defaultContent":""},
             { "data": "inputFieldAvailability","defaultContent":"" },
             { "data": "inputDependGroupAvailability","defaultContent":"" },
             { "data": "inputDataAccuracy","defaultContent":"" },
             { "data": "createTime"}
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
        	 //给8-14列添加超链接
        	{
	 			"targets": [8], // 输入数据条数
	 	        "render": function(data, type, full){
	 	        
	 	        	return "<a href='#' onclick='showDetail(this)'>"+data+"</a>";
	 	           
	 	        }
        	},
        	/*{
	 			"targets": [9], // 输入数据条数
	 	        "render": function(data, type, full){
	 	        	 var colName = 'inputDataSpeed';
	 	        	 return "<a href='#' onclick='showDetail(this,'"+colName+"')'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [10], // 输入数据条数
	 	        "render": function(data, type, full){
	 	        	 var colName = 'inputFieldFillRate';
	 	        	 return "<a href='#' onclick='showDetail(this,'"+colName+"')'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [11], // 输入数据条数
	 	        "render": function(data, type, full){
	 	        	 var colName = 'inputDependGroupFillRate';
	 	        	 return "<a href='#' onclick='showDetail(this,'"+colName+"')'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [12], // 输入数据条数
	 	        "render": function(data, type, full){
	 	        	 var colName = 'inputFieldAvailability';
	 	        	 return "<a href='#' onclick='showDetail(this,'"+colName+"')'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [13], // 输入数据条数
	 	        "render": function(data, type, full){
	 	        	 var colName = 'inputDependGroupAvailability';
	 	        	 return "<a href='#' onclick='showDetail(this,'"+colName+"')'>"+data+"</a>";
	 	           
	 	        }
        	},
        	{
	 			"targets": [14], // 输入数据条数
	 	        "render": function(data, type, full){
	 	        	 var colName = 'inputDataAccuracy';
	 	        	 return "<a href='#' onclick='showDetail(this,'"+colName+"')'>"+data+"</a>";
	 	           
	 	        }
        	},*/
        	//隐藏1和15列
        	{
	 			"targets": [0,15], // 输入数据条数
	 			"visible": false,
        	}
        ]
    })
}


/**
 * 展示格转信息详情
 * @param _this
 * @returns
 */
function showDetail(_this){

	console.log(name);
	
	
	//获取该条数据id
	var id = oTable.row($(_this).closest("tr")).data().id;
	
	//iframe层
	layer.open({
		  type: 2,
		  title: '指标趋势',
		  shadeClose: true,
		  shade: 0.8,
		  area: ['600px', '800px'],
		  content: rootPath+'/kpi/estimate/transformDetail.html?id='+id//iframe的url
	});
			
}

