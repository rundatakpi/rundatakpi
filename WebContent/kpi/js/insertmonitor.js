$(function(){
	var dataSource = "";
	var configs = [
		{
			id : "insertComb_1",
			url : "json/datasource.json",
			onSelect : function(combo,record){
				$("#insertComb_1").val(record.text);
			}
		},{
			id : "insertComb_2",
			url : "json/bProtocol.json",
			onSelect : function(combo,record){
				$("#insertComb_2").val(record.text);
			}
		},{
			id : "insertComb_3",
			url : "json/sProtocol.json",
			onSelect : function(combo,record){
				$("#insertComb_3").val(record.text);
			}
		},{
			id : "insertComb_4",
			url : "json/action.json",
			onSelect : function(combo,record){
				$("#insertComb_4").val(record.text);
			}
		}
	];
	combobox(configs);
	
	$('.chooseDay').off("click").on('click',"a",function(){
		$(this).addClass("slt").siblings().removeClass("slt");
		var parent = $(this).parent();
		var day = $(this).attr('value');
		var url = parent.attr('url');
		var id = parent.attr('data-id');
		console.log("day = " + day);
		console.log("url = " + url);
		
		refresh(url, day);
		return false;
	});	 
	
	init();
	
	
	
})

function refresh(url, day) {
	var queryCondition = getQueryCondition();
	queryCondition.push("day", day);
	$.ajax({
		url: '/rundatakpi/access' + url,
		method: 'GET',
		data: queryCondition,
		dataType: 'json',
		success: function(data) {
			if (url == 'input') {
				//接入数据实时输入数据量
				insertChart_1("insertChart_1", data);
			} else if (url == 'discard') {
				//抛弃数据量
				insertChart_2("insertChart_2", data);
			}
		},
		error: function(data) {
			console.log("error");
		}
	});
}

function getQueryCondtion() {
	var dataSource = $("#insertComb_1").val()[0];
	var bProtocol = $("#insertComb_2").val()[0];
	var sProtocol = $("#insertComb_3").val()[0];
	var action = $("#insertComb_4").val()[0];
	var queryCondition = {
		"dataSource": dataSource,
		"bProtocol": bProtocol,
		"sProtocol": sProtocol,
		"action": action,
	};
	
	return queryCondition;
}

function insertQuery() {
	var inputDate = $("#input_date a[class$='slt']").attr("value");
	var discardDate = $("#discard_date a[class$='slt']").attr("value");
	console.log("inputDate = " + inputDate);
	console.log("discardDate = " + discardDate);
	var queryCondition = getQueryCondtion();
	init(queryCondition);
}

function init(queryCondition) {
	var data = "";
	console.log(data['test']);
	
	$.ajax({
		url: '/rundatakpi/access/data',
		data: queryCondition,
		method: 'GET',
		dataType: 'json',
		success: function(data) {
			console.log(JSON.stringify(data));
			//接入数据实时输入数据量
			insertChart_1("insertChart_1", data['inputData']);
			//抛弃数据量
			insertChart_2("insertChart_2", data['discardData']);
			$("#insert_input").text(data['totalInputNum']);
			$("#insert_average").text(data['averageInputNum']);
			$("#insert_yesterday").text(data['yesterdayInputNum']);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("error");
		}
	});
}

function insertChart_1(id, inputData) {
	var date = inputData['accessDate'];
	var inputNum = inputData['accessInputNum'];
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
				y : 35,
				y2 : 80,
				//show : true,
				//borderWidth : 20,
				//borderColor: "#f00"
				
			},
			/*legend: {
				data:['输入量','输出量'],
				x: 'right',
				textStyle : {
					color : "#a7b5e0"
				}
			},*/
			dataZoom: [
				{
					show: true,
					type: 'slider',
					realtime: true,
					start: 0,
					end: 40,
					bottom : 15,
					textStyle : {
						color : "#fff"
					}
				}/*,
				{
					type: 'inside',
					realtime: true,
					start: 65,
					end: 85
				}*/
			],
			xAxis: [
				{
					type: 'category',
//					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
					data: date,
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
					name:'当前数据量',
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
					data:inputNum
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 抛弃数据量
 */
function insertChart_2(id, discardData) {
	var reason = discardData.discardReason;
	var discardNum = discardData.discardNum;
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
			/*legend: {
				data:['数据量','数据大小'],
				textStyle : {
					color : "#b7bfda"
				}
			},*/
			grid : {
				x : 70,
				x2 : 70,
				y : 40,
				y2 : 40,
				//show : true,
				//borderWidth : 20,
				//borderColor: "#f00"
				
			},
			xAxis: [
				{
					type: 'category',
//					data: ['原因一','原因二','原因三','原因四','原因五','原因六'],
					data: reason,
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
					name: '数据量',
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
					name:'数据量',
					type:'bar',
					barWidth : 35,
					itemStyle: {
		                normal: {
		                   color : {
							   type : "linear",
							   x : 0,
							   y : 0,
							   x2 : 0,
							   y2 : 1,
							   colorStops : [{
								   offset : 0 , color : "rgba(13,88,188,1)"
							    },{
								   offset : 1 , color : "rgba(13,88,188,0)"
							    }]
							}
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
//					data:[69,78,96,72,78,85]
					data:discardNum
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}