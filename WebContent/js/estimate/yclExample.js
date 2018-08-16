var oTable;
//获取主机地址之后的目录，如： proj/meun.jsp
var pathName = window.document.location.pathname;
var rootPath = pathName.substring(0, pathName.substr(1).indexOf('/')+1);

$(function() {
	var yclData = {};
	yclData.dataSourceCode = args().dataSourceCode;
	yclData.bProtocolCode = args().bProtocolCode;
	
	refreshData(yclData);
    
})

//获取index传参rid args为传递过来的所有参数，类型为OBJDECT，调用为args();
var args = function(params){
    var a = {};
    params = params || location.search;
    if(!params) return {};
    params = decodeURI(params);
    params.replace(/(?:^\?|&)([^=&]+)(?:\=)([^=&]+)(?=&|$)/g,function(m,k,v){  a[k] = v; });
    return a;
};

/**
 * 绘制表格
 * @returns
 */
function refreshData(yclData){
	//初始化表格对象
	oTable =  $('#yclExampleTable').DataTable({
    	 "bAutoWidth": true,//自动宽度
    	 "processing": true,//刷新的那个对话框
         "serverSide": true,//服务器端获取数据
         "bStateSave": false, 
         /*"pagingType": "full_numbers",
         "bPaginate": false, //翻页功能
         "bGoBtn":true,
         "lengthMenu": [ //自定义分页长度
             [5,10,20,50],
             ['5条','10 条','20条','50条']
         ],*/
         "ordering":false,
         "ajax": {
             "url": rootPath+"/ycl/getExampleList",
             "type": "POST",
             "data": yclData
         },
         "searching" : false,
         "columns": [
             { "data": "id" },    //0
             { "data": "sourcedesc","defaultContent":"" },   //1
             { "data": "authentumber","defaultContent":"" },   //2
             { "data": "authentype","defaultContent":"" },   //3
             { "data": "sendername","defaultContent":"" },   //4
             { "data": "receivername","defaultContent":"" },   //5
             { "data": "basestation","defaultContent":"" },   //6
         ],
         "oLanguage" : { // 国际化配置
             "sProcessing" : "正在获取数据，请稍后...",
             "sLengthMenu" : "",
             "sZeroRecords" : "没有找到数据",
             "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
             "sInfoEmpty" : "记录数为0",
             "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
             "sInfoPostFix" : "",
             "sSearch" : "查询",
             "sUrl" : "",
             "oPaginate" : {
                 "sFirst" : "",
                 "sPrevious" : "",
                 "sNext" : "",
                 "sLast" : ""
             }
         },
        fnDrawCallback: function(table) {
        	$(".paginate_button").hide();
        	
 			/*$("#transTable_paginate").append("  到第 <input style='height:28px;line-height:28px;width:40px;' class='margin text-center' id='changePage' type='text'> 页  <a class='btn btn-default shiny' style='margin-bottom:5px' href='javascript:void(0);' id='dataTable-btn'>确认</a>");
 			var pTable = $("#transTable").dataTable();
 			$('#dataTable-btn').click(function(e) {
 				if($("#changePage").val() && $("#changePage").val() > 0) {
 					var redirectpage = $("#changePage").val() - 1;
 				} else {
 					var redirectpage = 0;
 				}
 				pTable.fnPageChange(redirectpage);
 			});*/
 		},
         "columnDefs": [
        	 
        	//隐藏第一列
        	{
	 			"targets": [0], // 输入数据条数
	 			"visible": false,
        	},
        	{
        		"targets": [1], 
        		"render": function(data, type, full){
    	 	        if(data == '1'){
    	 	        	return "正常数据";
    	 	        } else if(data == '0'){
    	 	        	return "异常数据";
    	 	        }
	 	        	
	 	           
	 	        }
        	}
        ]
    })
}


