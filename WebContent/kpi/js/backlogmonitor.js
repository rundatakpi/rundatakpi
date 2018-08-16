$(function(){
	
	var queryCondition = {};
	$.ajax({
		url: '/rundatakpi/backlog/init',
		data: queryCondition,
		method: 'GET',
		dataType: 'json',
		success: function(data) {
			console.log(JSON.stringify(data));
			init(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("error");
		}
	});
	
})

function init(data) {
	//接口机实时积压数据统计
	backlogDataStatistic_1("backlogDataStatistic_1", data['machineJson']);
	
	//Kafka实时积压数据统计
	backlogDataStatistic_2("backlogDataStatistic_2", data['kafkaJson']);
}

/**
 * @description 接口机实时积压数据统计
 */
function backlogDataStatistic_1(id, data) {
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
			legend: {
				data:['数据量','数据大小'],
				textStyle : {
					color : "#b7bfda"
				}
			},
			grid : {
				x : 70,
				x2 : 70,
				y : 40,
				y2 : 80,
				//show : true,
				//borderWidth : 20,
				//borderColor: "#f00"
				
			},
			dataZoom: [
				{
					show: true,
					type: 'slider',
					realtime: true,
					start: 0,
					end: 40,
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
					//data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
					data: data['date'],
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
				},
				{
					type: 'value',
					name: '数据大小',
					//min: 0,
					//max: 25,
					//interval: 5,
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
		                   color : "#168370"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					//data:[12010,21014,19841,35412,54711,64712,65421,12457,98654,9741,15973,13469,76431,64828,17847,24457,34451,85241,84512,15489,68741,33548,94102,75321]
				    data: data['machineNum']
				},
				{
					name:'数据大小',
					type:'line',
					yAxisIndex: 1,
					itemStyle: {
		                normal: {
		                   color : "#168370"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					smooth : true,
					//data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				    data: data['machineSize']
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description Kafka实时积压数据统计
 */
function backlogDataStatistic_2(id, data) {
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
			legend: {
				data:['数据量','数据大小'],
				textStyle : {
					color : "#b7bfda"
				}
			},
			grid : {
				x : 70,
				x2 : 70,
				y : 40,
				y2 : 80,
				//show : true,
				//borderWidth : 20,
				//borderColor: "#f00"
				
			},
			dataZoom: [
				{
					show: true,
					type: 'slider',
					realtime: true,
					start: 0,
					end: 40,
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
					//data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
					data: data['date'],
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
				},
				{
					type: 'value',
					name: '数据大小',
					//min: 0,
					//max: 25,
					//interval: 5,
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
		                   color : "#0980c6"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					//data:[12010,21014,19841,35412,54711,64712,65421,12457,98654,9741,15973,13469,76431,64828,17847,24457,34451,85241,84512,15489,68741,33548,94102,75321]
				    data: data['kafkaNum']
				},
				{
					name:'数据大小',
					type:'line',
					yAxisIndex: 1,
					itemStyle: {
		                normal: {
		                   color : "#0980c6"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					smooth : true,
					//data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				    data: data['kafkaSize']
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}