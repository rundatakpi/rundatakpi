var param = {};
$(function(){
	var configs = [{
		id : "logdataCombobox_1",
		url : rootPath+"/log/getDataSource",
		onSelect : function(combo,record){
			param.dsCode = record.value[0];
		}
	},{
		id : "logdataCombobox_2",
		url : rootPath+"/log/getBProtocol",
		onSelect : function(combo,record){
			param.bProtocolCode = record.value[0];  
		}
	}];
	combobox(configs);
	
	//加载合并表格数据
	//alert(Run)
	
	globalObj.mergeGrid["logDataBody"] = Run.create('logDataGrid',{
		id : 'logDataBody',
		//query : param,
		url : rootPath+"/log/getList",
		//checkAllId:'showCardChbAll',
		//checkOneCls:'cardOb_chk',
		cache:true,
		isMultiple:true,
		dataSuccess:function(data){
			$("#logNum").text(data.total);
			
		},
		usepage : {
			type:'2',
			position : 'bottom',
			align : 'center',
			pageGoAble : false,
			pageSizeAble : true,
			pageDescription : false
		},
		callBacks:{
			//handleDetail:handleDetailCardOb,
			//handleCollect:handleCollectCardOb,
			//handleMap:handleMapCardOb,
			//handleAnalysis:handleAnalysisCardOb
			handleImportDataLink : handleImportDataFnc,
			handlePercentLink : handlePercentFnc
		},
		listeners:{
			render:function(){
				//addOpMoreButton(this, {type:'ob',by:'card'});
			},
			reload:function(){
				//addOpMoreButton(this, {type:'ob',by:'card'});
			}
		 }
	});
	
	
	//点击查询按钮
	$(".schBtn_1").on("click",function(){
		globalObj.mergeGrid["logDataBody"].reloadCards(rootPath+"/log/getList",param);
	})
	
	//点击清空按钮
	$(".emptyBtn_1").on("click",function(){
		clearCombobox("logdataCombobox_1");
		clearCombobox("logdataCombobox_2");
		param = {};
	})
})

//大协议详情
function handleImportDataFnc (ev, row) {
	location.href='logdetail.jsp?id='+row.id;
}


//比率
function handlePercentFnc (ev,row,colName) {
	
	windowFnc({
		id:"pop",
		width:900,
		height:490,
		url:"include/percent_pop.html",
		title: "字段填充趋势率",
		listeners:{
			render:function(){
				drawChart("percentChart",row.id,colName);
			}
		}
	});

}


/**
 * 指标趋势图
 * @param id
 * @param rid
 * @returns
 */
function drawChart(id,rid,cname) { 
	var time = [];
	var data = [];
	
	$.ajax({
		url:rootPath+"/log/getOutDetail",
		type:"post",
		data:{"id":rid,"colName":cname},
		success:function(d){
			$.each(d.data,function(){
				time.unshift(this.chkVal);
				data.unshift(this.chkDisplay);
			})
			
			showCharts(id,time,data);
		},
		error:function(){
			layer.msg("系统错误！");
		}
	});
	
	

}


function showCharts(id,time,data){
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));
		
		var option = {
			tooltip: {
				trigger: 'axis',
				axisPointer: {
					type: 'cross',
					crossStyle: {
						color: '#999'
					}
				}
			},
			grid : {
				x : 70,
				x2 : 70,
				y : 30,
				y2 : 40,
				//show : true,
				//borderWidth : 20,
				//borderColor: "#f00"
				
			},
			xAxis: [
				{
					type: 'category',
					data: time,
					axisPointer: {
						type: 'shadow'
					},
					axisPointer: {
						type: 'shadow'
					},
					axisLabel : {
						show : true,
						color : "#8d93ab"
					},
					axisLine : {
						lineStyle : {
							color : "#404b6c"
						}
					}
				}
			],
			yAxis: [
				{
					type: 'value',
					//name: '数据量',
					//min: 0,
					//max: 250,
					//interval: 50,
					axisLabel: {
						//formatter: '{value} ml'
						color : "#8d93ab"
					},
					axisLine : {
						lineStyle : {
							color : "#404b6c"
						}
					},
					splitLine : {
						show:true,
						lineStyle : {
							color : "#46547d"
						}
					}
				}
			],
			series: [
				{
					name:'数据大小',
					type:'line',
					itemStyle: {
		                normal: {
		                   color : "#168370"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					areaStyle : {
						normal : {
							color : "rgba(0,201,179,0.2)"
						}
					},
					smooth : true,
					data:data
				}
			]
		};
		chartObj[id].setOption(option, true);		
		
	}
}
