  
/**
 * 数组转json
 * @param o
 * @returns
 */
function arrayToJson(o) {
	var i,jsonstr="[";
	for( i=0;i<o.length;i++)
	{
		jsonstr +="{\'data\':\'"+o[i]+"\'},";
	}
	jsonstr = jsonstr.substring(0,jsonstr.lastIndexOf(','));
	jsonstr += "]";
	var t = eval(jsonstr);
	return t ;
}

 /**
  * 
  * @param tabId table标识
  * @param url 地址
  * @param columns 列
  * @param columnDefs 编辑列属性
  * @returns
  */
function refreshData(tabId,url,data,columns,columnDefs,serverSide) {
	console.log("data = " + JSON.stringify(data));
	var bServerSide = true;
//	var ajax = {
//			url : url,
//			type: "POST",
//			// traditional: true,
//			data : data
//		};
	/*if(serverSide==true){
		bServerSide = false;
		ajax = {
				url : url,
				dataSrc: function(result) {
                    return result.data;
                },
				type: "POST",
				// traditional: true,
				data : data
		};
	}*/
	var example1;
	 
	example1 = $("#"+tabId)
			.DataTable(
					{
						"bProcessing" : true,// 保持加载提示;
//						"bStateSave" : false, // 加载记忆页码
						"select" : true,
						"sPaginationType" : "bootstrap",
						"bFilter" : true,
						"bAutoWidth": false,//自动宽度。
						"bServerSide" : bServerSide,//服务器端进行分页处理的意思
						"bSort" : false,
						"destroy" : true,
						"bGoBtn" : true,
						"ajax" : {
							"url": url,
							"data": data,
							"type": "POST" //请求方式
						},
						"order" : [ [ 0, "asc" ] ],
//						"columns" : arrayToJson(columns),
						"columns" : columns,
						"columnDefs" :columnDefs,
						"select": {
				            style:    'os',
				            selector: 'td:first-child'
				        },
						"oLanguage" : {	
							"goBtn" : {
								flag : true,
								id : tabId+'daTaskTbl-go',
								callback : function(btnId, iptId, total, start,
										len) { 
									 
									var tableObject = example1;
									var info = tableObject.page.info();  
									var totalPage = info.pages;
								   
									var jumpPage = $("#" + iptId).val();
									var numReg = /^\+?[1-9][0-9]*$/;
									 
									if (!numReg.test(jumpPage)) {
										jumpPage = 1;
									}else{
										if(jumpPage<1){
											jumpPage = 1;
										}
										if(jumpPage>totalPage){
											jumpPage = totalPage;
										}
									}
									$("#" + iptId).val(jumpPage);

									tableObject.page(parseInt(jumpPage) - 1)
											.draw("page");
								}
							},

							"sLengthMenu" : "每页 _MENU_ 条记录",
							"sSearch" : "快速查找：",
							"sZeroRecords" : "没有检索到数据",
							"sProcessing" : "正在加载数据中...",
							"sInfoEmpty" : "",
							"sInfoFiltered" : "{筛选自 _MAX_ 条数据}",
							"sInfo" : "显示 _START_ 至  _END_ 条 &nbsp;&nbsp;共 _TOTAL_ 条&nbsp;&nbsp;总共_PAGES_页",
							"oPaginate" : {
								"sFirst" : "首页",
								"sPrevious" : "前一页",
								"sNext" : "后一页",
								"sLast" : "末页"
							}
						}
					});
	return example1;
}

 
function _intoPage(id,url){
	$.ajax({
		type: "POST",
		url: getRootPath()+url,
		data: "",
		dataType: "html",
		success: function(msg){
			$(id).html(msg);
		}
	});
	 
}



//服务器路径
function getRootPath(){
	//获取当前网址
	var curPath = window.document.location.href;
	//获取主机之后的目录
	var pathName = window.document.location.pathname;
	//获取带"/"的项目名 如/app_biglink
	var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return projectName;
}




/**
*  判断时间
*/
function datevalidate(start,end){
	 var d1 = new Date(start).getTime();  
	 var d2 = new Date(end).getTime();  
	 var myDate = new Date().getTime();  
	  
	 if(d1>myDate){
		 layer.alert('开始时间大于当前时间', {
			 icon: 5,
			 title: "提示"
		  });
		 return false;
	 }
	 if(d2>myDate){
		 layer.alert('结束时间大于当前时间', {
			 icon: 5,
			 title: "提示"
		  });
		 return false;
	 }
	 if(d1>d2){
		 layer.alert('开始时间大于结束时间', {
			 icon: 5,
			 title: "提示"
		  });
		 return false;
	 }
	 return true;
}





