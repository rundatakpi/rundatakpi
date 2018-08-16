var oTable;
//获取主机地址之后的目录，如： proj/meun.jsp
var pathName = window.document.location.pathname;
var rootPath = pathName.substring(0, pathName.substr(1).indexOf('/')+1);
//获取index传参rid args为传递过来的所有参数，类型为OBJDECT，调用为args();
var args = function(params){
    var a = {};
    params = params || location.search;
    if(!params) return {};
    params = decodeURI(params);
    params.replace(/(?:^\?|&)([^=&]+)(?:\=)([^=&]+)(?=&|$)/g,function(m,k,v){  a[k] = v; });
    return a;
};

var outArr = [];
var numArr = [];
$(function(){
	var dataSourceCode =args().dataSourceCode;
	var bProtocolCode =args().bProtocolCode;

	$("#dataSource").html("<h3>"+dataSourceCode+"</h3>");
	$("#bProtocol").html("<h4>"+bProtocolCode+"</h4>");
	
	$.ajax({
		url:rootPath+"/storeLog/getTableInfo",
		type:'post',
		data:{
			"dataSourceCode" : dataSourceCode,
			"bProtocolCode" : bProtocolCode
		},
		success:function(data){
			
			$.each(data.logs, function(i, n){
				var innerArr = [];
				
				//将小协议号，小协议描述，动作描述，数据条数放入innerArr
				innerArr.push(this.sProtocolCode);
				innerArr.push(this.sProtocolDesc);
				innerArr.push(this.actionType);
				innerArr.push(this.dataNum);
					
				$.each(this.storeFieldList,function(i,n){
					$("thead>tr").eq(0).append("<th colspan='3'>"+this.fieldDesc+"</th>");   //thead上面拼字段中文名
					$("thead>tr").eq(1).append("<th>填充率</th><th>准确率</th><th class='codeMatch'>代码符合度</th>");
					
					//将其余的数据放入innerArr中
					innerArr.push(this.fillRate);
					innerArr.push(this.sAccuracy);
					innerArr.push(this.codeMatch);
					
					numArr.push(3+i);
				})
				
				
				
				outArr.push(innerArr);
			});
			
			refreshData(outArr);
			
			//再遍历每一列，给每一列的数据设置class，className就是其英文字段名
			$.each(data.logs, function(i, n){
				
				$("tr td:eq(3)").attr("title","dataNum");
				
				$.each(this.storeFieldList,function(i,n){
					
					
					//添加字段属性
					if(i%3==0){
						$("td").eq(4+i).attr('field','fillRate');
					}else if(i%3==1){
						$("td").eq(4+i).attr('field','sAccuracy');
					}else if(i%3==2){
						$("td").eq(4+i).attr('field','codeMatch');
					}
					
				})
				
			});
		}
		
		
		
	})
	
	
})



/**
 * 绘制表格
 * @returns
 */
function refreshData(colNameArr){
	//初始化表格对象
	oTable =  $('#logDetailTable').DataTable({
    	 "bAutoWidth": true,//自动宽度
    	 "processing": true,//刷新的那个对话框
         "serverSide": false,//服务器端获取数据
         "bStateSave": false, 
         "pagingType": "full_numbers",
         "bPaginate": true, //翻页功能
         "bGoBtn":true,
         "lengthMenu": [ //自定义分页长度
             [5,10,20,50],
             ['5条','10 条','20条','50条']
         ],
         "ordering":false,
         "searching" : false,
         "data": colNameArr,
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
        	 //从第4列开始添加超链接
        	{
	 			"targets": numArr, // 入库条数
	 	        "render": function(data, type, full){
	 	        	return "<font style='color:blue' onclick='showFeildDetail(this)'>"+data+"</font>";
	 	           
	 	        }
        	}

        ]
    })
}

/**
 * 展示详情
 * @returns
 */
function showFeildDetail(_this){
	//var aaa = oTable.row($(_this).closest("tr")).data()[0];
	var aaa = $(_this).closest("td").attr("title");
	alert(aaa);
}

