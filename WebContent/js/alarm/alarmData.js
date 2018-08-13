var oTable;
//获取主机地址之后的目录，如： proj/meun.jsp
var pathName = window.document.location.pathname;
var rootPath = pathName.substring(0, pathName.substr(1).indexOf('/')+1);

$(function() {
	refreshData();
    
    $("#exportExcel").click(function(){
    	$.ajax({
    		url:rootPath+"/alarmData/exportExcel",
    		type:"post",
    		dataType:"json",
    		success:function(data){
    			layer.alert(data.msg);
    		},
    		error:function(){
    			layer.alert("系统错误！");
    		}
    		
    	})
    })
    

    $("#search").click(function(){
    	
        oTable.settings()[0].ajax.data = {"alarmLevel":1,"processState":1};
    	oTable.ajax.reload();

    })

 
})

/**
 * 绘制表格
 * @returns
 */
function refreshData(){
	//初始化表格对象
	oTable =  $('#myTable').DataTable({
    	 "bAutoWidth": true,//自动宽度
    	 "processing": true,//刷新的那个对话框
         "serverSide": true,//服务器端获取数据
         "select":true,
         "bFilter":true,
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
             "url": rootPath+"/alarmData/getList",
             "type": "POST",
             "data": {}
         },
         "searching" : false,
         "columns": [
             { "data": "id" },
             { "data": "alarmTime" },
             { "data": "alarmLevel" },
             { "data": "alarmContent" },
             { "data": "processState" },
             { "data": "" },
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
 			$("#myTable_paginate").append("  到第 <input style='height:28px;line-height:28px;width:40px;' class='margin text-center' id='changePage' type='text'> 页  <a class='btn btn-default shiny' style='margin-bottom:5px' href='javascript:void(0);' id='dataTable-btn'>确认</a>");
 			var pTable = $("#myTable").dataTable();
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
        	 {
	 			"targets": -1,// 操作例的位置
	 	        "render": function(data,type,row,full){
	 	        	//alert(row.processState);
	 	            return  "<button class='btn btn-success btn-xs' onclick='detailAlarms(this)'><i class='fa fa-remove'></i> 查看</button>"
	 	            + "<button class='btn btn-primary btn-xs' onclick='editAlarms(this)'><i class='fa fa-remove'></i>修改</button>"
	 	           + "<button class='btn btn-danger btn-xs' onclick='delAlarms(this)'><i class='fa fa-remove'></i> 删除</button>"
	 	           
	 	        }
        	},
        	{
	 			"targets": 1,// 操作例的位置
	 	        "render": function(data, type, full){
	 	        	 return data.length > 19 ? data.substr(0,19): data;
	 	           
	 	        }
        	}
 	    ],
 	   "rowCallback": function( row, data, index ) {
 		    if ( data.processState == "0" ) {
 		      $('td:eq(4)', row).html( '<b>告警中</b>' );
 		    }else if( data.processState == "1" ) {
 		      $('td:eq(4)', row).html( '<b>处理中</b>' );
 		    }else if ( data.processState == "2" ) {
 		      $('td:eq(4)', row).html( '<b>已处理</b>' );
 		    }else{
 		      $('td:eq(4)', row).html( '<b>其他</b>' );
 		    };
 		    
 		   if ( data.alarmLevel == "0" ) {
  		      $('td:eq(2)', row).html( '<b>轻微</b>' );
  		    }else if( data.alarmLevel == "1" ) {
  		      $('td:eq(2)', row).html( '<b>一般</b>' );
  		    }else if ( data.alarmLevel == "2" ) {
  		      $('td:eq(2)', row).html( '<b>严重</b>' );
  		    }else{
  		      $('td:eq(2)', row).html( '<b>其他</b>' );
  		    };
  		    
  		    
 		}
    })
}

/**
 * 删除一条告警信息
 * @param id
 * @returns
 */
function delAlarms(_this){
	var id = oTable.row($(_this).closest("tr")).data().id;
	
	layer.confirm('确定删除该条数据？', {
		  btn: ['确定','返回'] //按钮
		}, function(){
			$.ajax({
				type: "POST",
			    url: rootPath+"/alarmData/del",
			    data: {"id":id},
			    success: function(data){
			    	layer.msg(data.msg);
			    	oTable.ajax.reload();
			    }
			})
		}, function(){
			
		});
}

/**
 * 编辑一条告警信息
 * @param _this
 * @returns
 */
function editAlarms(_this){
	var id = oTable.row($(_this).closest("tr")).data().id;
	var processStatus = oTable.row($(_this).closest("tr")).data().processState;
	
	//iframe层
	layer.open({
	  type: 2,
	  title: '修改告警信息页',
	  shadeClose: true,
	  shade: 0.8,
	  area: ['300px', '200px'],
	  content: rootPath+'/kpi/alarm/editAlarm.html?id='+id+'&processStatus='+processStatus//iframe的url
	}); 
}


/**
 * 展示告警信息详情
 * @param _this
 * @returns
 */
function detailAlarms(_this){
	var id = oTable.row($(_this).closest("tr")).data().id;
	var name = oTable.row($(_this).closest("tr")).ColumnName;
	alert(name);
}


