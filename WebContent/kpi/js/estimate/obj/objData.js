var oTable;
//获取主机地址之后的目录，如： proj/meun.jsp
var pathName = window.document.location.pathname;
var rootPath = pathName.substring(0, pathName.substr(1).indexOf('/')+1);

$(function() {
	
	//获取对象类型
	$.ajax({
		url:rootPath+"/obj/getObjType",
		type:"post",
		success:function(data){
			$("#objType").html("<option value=''>全部</option>");
			if("error"!=data.json){
				$.each(data.json,function(i,n){
					$("#objType").append("<option value='"+this.objType+"'>"+this.objTypeDesc+"</option>");
				})
			}
		}
	})
	
	//获取所有特征串
		$.ajax({
			url : rootPath + "/obj/getFeartureString",
			type : "post",
			data:{},
			success : function(data) {
				if ("error" != data.json) {
					$("#featureString").html("<option value=''>全部</option>");
					$.each(data.json, function(i, n) {
						$("#featureString").append("<option value='" + this.aspectCode + "'>"+ this.aspectStr+ "</option>");
					})
				}
			}
		})
		
		//获取所有数据源编码
		$.ajax({
			url : rootPath + "/obj/getDataSource",
			type : "post",
			data:{},
			success : function(data) {
				if ("error" != data.json) {
					$("#dataSourceCode").html("<option value=''>全部</option>");
					$.each(data.json, function(i, n) {
						$("#dataSourceCode").append("<option value='" + this.dsCode + "'>"+ this.dsDesc+ "</option>");
					})
				}
			}
		})
	
	//监听对象类型的改变，获取对应的特征串
	$("#objType").change(function(){
		var objType = $("#objType>option:selected").val();
		//如果选中的不是虚拟身份，则隐藏特征串
		if("virtualIdentity" != objType){
			$("#featureId").hide();
		}else{
			$("#featureId").show();
		}
	})

	
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
	oTable =  $('#objTable').DataTable({
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
             "url": rootPath+"/obj/getList",
             "type": "POST",
             "data": function(d){
            	 d.objType = $("#objType>option:selected").val();
            	 d.featureCode = $("#featureString>option:selected").val();
            	 d.dataSourceCode = $("#dataSourceCode>option:selected").val();
             }
         },
         "searching" : false,
         "columns": [
             { "data": "id"},    //id
             { "data": "aspectCode","defaultContent":"" },  //特征串编码
             { "data": "aspectStr","defaultContent":"" },   //特征串中文描述
             { "data": "dsCode","defaultContent":"" },   //数据源编码
             { "data": "dsDesc" ,"defaultContent":"" },   //数据源中文描述
             { "data": "aspectNum" ,"defaultContent":"" },      //特征串总量
             { "data": "accuracy","defaultContent":"" },   //准确率
             { "data": "extractNum","defaultContent":"" },    //总提取量
             { "data": "netExtractNum" ,"defaultContent":""},    //净提取关系个数
             { "data": "netExtractRate" ,"defaultContent":""},       //净提取关系比例
             { "data": "phoneReNum" ,"defaultContent":""},     //手机号关联数量
             { "data": "phoneReRate","defaultContent":"" },    //手机号关联率
             { "data": "idCardReNum" ,"defaultContent":""},     //身份证关联数量
             { "data": "idCardReRate" ,"defaultContent":""},   //身份证关联率 
             { "data": "adslReNum","defaultContent":"" },   //ADSL关联率
             { "data": "adslReRate","defaultContent":"" },    //ADSL关联数量
             { "data": "imeiReNum","defaultContent":"" },    //IMEI关联数量
             { "data": "imeiReRate","defaultContent":"" },     //IMEI关联率
             { "data": "imsiReNum","defaultContent":"" },      //IMSI关联数量
             { "data": "imsiReRate","defaultContent":"" },    //IMSI关联率
             { "data": "macReNum","defaultContent":"" },     //MAC关联数量
             { "data": "macReRate","defaultContent":"" },    //MAC关联率
             { "data": "createDate"},
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
        	//隐藏1列
        	{
	 			"targets": [1,-2], // 输入数据条数
	 			"visible": false,
        	},
        	{
	 			"targets": [5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21], // 输入数据条数
	 			"render": function(data, type, row, meta){ 
	 				var colIndex = meta.col;
	 				return  "<b style='color:blue;cursor:pointer;' onclick='showDetail(this,"+colIndex+")'>"+data+"</b>";
		 	       
	 	        }
        	},
        	//19列返回详情按钮
        	{
	 			"targets": [-1], // 输入数据条数
	 			"render": function(data, type, full){ 
	 				 return  "<button class='btn btn-success btn-xs' onclick='showMore(this)'><i class='fa fa-remove'></i>查看更多</button>"
		 	       
	 	        }
        	}
        ]
 		
    })
}

function showDetail(_this,index){
	var colName = ["id","aspectCode","aspectStr","dsCode","dsDesc","aspectNum","accuracy","extractNum",
		"netExtractNum","netExtractRate","phoneReNum","phoneReRate","idCardReNum","idCardReRate","adslReNum",
		"adslRate","imeiReNum","imeiReRate","imsiReNum","imsiReRate","macReNum","macReRate"];
	
	var colName = colName[index];
	var aspectCode = oTable.row($(_this).closest("tr")).data().aspectCode;
	var dsCode = oTable.row($(_this).closest("tr")).data().dsCode;
	var objType = $("#objType>option:selected").val();
	
	//iframe层--对象化提取数据详情
	layer.open({
		  type: 2,
		  title: '指标趋势',
		  shadeClose: true,
		  closeBtn: 1, //关闭按钮是否显示 1显示0不显示
		  shade: 0.8,
		  area: ['800px', '600px'],
		  content: rootPath+'/kpi/estimate/obj/objDetail.html?dsCode='+dsCode+'&colName='+colName+
		  			'&aspectCode='+aspectCode+"&objType"+objType               //iframe的url
	});
	
	
	
}
