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
             [5,10,20,50],
             ['5条','10 条','20条','50条']
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
             { "data": "dsCode","defaultContent":"" },
             { "data": "dsDesc" ,"defaultContent":""},
             { "data": "bProtocolCode" ,"defaultContent":""},
             { "data": "bProtocolDesc","defaultContent":"" },
             { "data": "sProtocolCode","defaultContent":""},
             { "data": "sProtocolDesc" ,"defaultContent":""},
             { "data": "actionType" ,"defaultContent":""},
             { "data": "inputNum" ,"defaultContent":""},
             { "data": "inputSpeed","defaultContent":"" },
             { "data": "inputFieldRate" ,"defaultContent":""},
             { "data": "inputGroupRate" ,"defaultContent":""},
             { "data": "inputFieldAvailRate","defaultContent":"" },
             { "data": "inputGroupAvailRate","defaultContent":"" },
             { "data": "inputAccuracy","defaultContent":"" },
             { "data": "createDate"}
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
	 			"targets": [8,9,10,11,12,13,14], // 输入数据条数
	 	        "render": function(data, type, row, meta){
	 	        	var colIndex = meta.col;
	 	        	return "<a href='#' onclick='showDetail(this,"+colIndex+")'>"+data+"</a>";
	 	           
	 	        }
        	},
        	//隐藏1和15列
        	{
	 			"targets": [0,-1], // 输入数据条数
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
function showDetail(_this,index){
	
	//获取该条数据的数据源，大协议，小协议，数据类型
	
	var dsCode = oTable.row($(_this).closest("tr")).data().dsCode;
	var bProtocolCode = oTable.row($(_this).closest("tr")).data().bProtocolCode;
	var sProtocolCode = oTable.row($(_this).closest("tr")).data().sProtocolCode;
	var actionType = oTable.row($(_this).closest("tr")).data().actionType;
	
	var colnums = ["id","dsCode","dsDesc","bProtocolCode","bProtocolDesc","sProtocolCode","sProtocolDesc","actionType","inputNum",
		"inputSpeed","inputFieldRate","inputGroupRate","inputFieldAvailRate","inputGroupAvailRate","inputAccuracy","createDate"];
	var colName = colnums[index];
	
	//iframe层
	layer.open({
		  type: 2,
		  title: '指标趋势',
		  shadeClose: true,
		  closeBtn: 1, //关闭按钮是否显示 1显示0不显示
		  shade: 0.8,
		  area: ['800px', '600px'],
		  content: rootPath+'/kpi/estimate/trans/transformDetail.html?dsCode='+dsCode+
		  			'&bProtocolCode='+bProtocolCode+'&sProtocolCode='+sProtocolCode+'&actionType='+actionType+
		  			'&colName='+colName, //iframe的url
	});
	
	

	
			
}


