chartObj = {};
$(function(){
	//加载九大资源库实时数据量和昨日数据量柱图
	nineStorage("nineStorage");
	//加载对象库实时数据量和昨日数据量柱图
	objectStroage("objectStroage");
	//加载数据统计线图
	dataStatistics("dataStatistics");
	//接口机实时积压数据统计
	backlogDataStatistic_1("backlogDataStatistic_1");
	//Kafka实时积压数据统计
	backlogDataStatistic_2("backlogDataStatistic_2");
	//协议还原数据实时输入数据量
	importDataChart("importDataChart");
	//协议还原数据实时输出数据量
	exportDataChart("exportDataChart");
	//当前数据总量饼图
	curTotalDataChart("curTotalDataChart");
	//昨日数据总量饼图
	yestodayTotalDataChart("yestodayTotalDataChart");
	//重复率、错误率、准确率
	ratioDatas_1("ratioDatas_1");
	//还原设备负载
	restoreEquipmentChart("restoreEquipmentChart");
	//实时运行任务量
	jobChart_1("jobChart_1");
	//实时已完成任务量
	jobChart_2("jobChart_2");
	//预处理数据实时监控
	anticipationChart_1("anticipationChart_1");
	//输入数据流重复率
	anticipationChart_2("anticipationChart_2");
	//预处理异常数据量
	anticipationChart_3("anticipationChart_3");
	//预处理错误数据量
	anticipationChart_4("anticipationChart_4");
	//接入数据实时输入数据量
	insertChart_1("insertChart_1");
	//抛弃数据量
	insertChart_2("insertChart_2");
	//应用调用协议频次
	frequencyBar("frequencyBar");
	
	
})

/**
 * @description 九大资源库实时数据量和昨日数据量柱图
 */
function nineStorage(id) {
	var ec = echarts;
	/*柱状图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));

		var option = {
			tooltip: {
				trigger: 'axis',
				backgroundColor : 'rgba(61,75,97,0.8)',
				axisPointer: {
					type: 'cross',
					crossStyle: {
						color: '#fff'
					}
				}
			},
			legend: {
				textStyle : {
					color : "#b7bfda"
				},
				data:['实时数据量','昨日数据量']
			},
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
					data: ['虚拟身份库','终端硬件特征库','监察备案库','接入日志认证库','海量全文库','网络帐号信息库','虚拟身份关联库','网民档案库','九大资源库'],
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
					name:'实时数据量',
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
					data:[15000, 12121, 20000, 23120, 12506, 17627, 13516, 16202, 23226]
				},
				{
					name:'昨日数据量',
					type:'bar',
					barWidth : 35,
					itemStyle: {
		                normal: {
		                   color : "#1a626a"
		                }
		            },
					data:[20000,15000, 12121,  23120, 12506, 23226, 17627, 13516, 16202]
				}
			]
		};
		
		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 对象库实时数据量和昨日数据量柱图
 */
function objectStroage(id) {
	var ec = echarts;
	/*柱状图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));

		var option = {
			tooltip: {
				trigger: 'axis',
				backgroundColor : 'rgba(61,75,97,0.8)',
				axisPointer: {
					type: 'cross',
					crossStyle: {
						color: '#fff'
					}
				}
			},
			legend: {
				textStyle : {
					color : "#b7bfda"
				},
				data:['实时数据量','昨日数据量']
			},
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
					data: ['虚拟身份库','终端硬件特征库','监察备案库','接入日志认证库','海量全文库','网络帐号信息库','虚拟身份关联库','网民档案库','九大资源库'],
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
					name:'实时数据量',
					type:'bar',
					barWidth : 35,
					itemStyle: {
		                normal: {
		                   color : "#036ea4"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					data:[15000, 12121, 20000, 23120, 12506, 17627, 13516, 16202, 23226]
				},
				{
					name:'昨日数据量',
					type:'bar',
					barWidth : 35,
					itemStyle: {
		                normal: {
		                   color : "#174c77"
		                }
		            },
					data:[20000,15000, 12121,  23120, 12506, 23226, 17627, 13516, 16202]
				}
			]
		};
		
		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 数据统计线图
 */
function dataStatistics(id) {
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));
		
		var option = {
			grid: {
				bottom: 80,
				left : 80,
				right : 80,
				top : 40
			},
			tooltip : {
				trigger: 'axis',
				axisPointer: {
					type: 'cross',
					animation: false,
					label: {
						backgroundColor: '#505765'
					}
				}
			},
			legend: {
				data:['某某数据1','某某数据2','某某数据3','某某数据4','某某数据5'],
				x: 'right',
				textStyle : {
					color : "#a7b5e0"
				}
			},
			dataZoom: [
				{
					show: true,
					type: 'slider',
					realtime: true,
					start: 65,
					end: 85,
					textStyle : {
						color : "#fff"
					}
				}
			],
			xAxis : [
				{
					type : 'category',
					boundaryGap : false,
					//axisLine: {onZero: false},
					axisLabel : {
						show : true,
						color : "#8d93ab"
					},
					axisLine : {
						lineStyle : {
							color : "#404b6c"
						}
					},
					data : [
						'2009/6/12 2:00', '2009/6/12 3:00', '2009/6/12 4:00', '2009/6/12 5:00', '2009/6/12 6:00', '2009/6/12 7:00', '2009/6/12 8:00', '2009/6/12 9:00', '2009/6/12 10:00', '2009/6/12 11:00', '2009/6/12 12:00', '2009/6/12 13:00', '2009/6/12 14:00', '2009/6/12 15:00', '2009/6/12 16:00', '2009/6/12 17:00', '2009/6/12 18:00', '2009/6/12 19:00', '2009/6/12 20:00', '2009/6/12 21:00', '2009/6/12 22:00', '2009/6/12 23:00',
						'2009/6/13 0:00', '2009/6/13 1:00', '2009/6/13 2:00', '2009/6/13 3:00', '2009/6/13 4:00', '2009/6/13 5:00', '2009/6/13 6:00', '2009/6/13 7:00', '2009/6/13 8:00', '2009/6/13 9:00', '2009/6/13 10:00', '2009/6/13 11:00', '2009/6/13 12:00', '2009/6/13 13:00', '2009/6/13 14:00', '2009/6/13 15:00', '2009/6/13 16:00', '2009/6/13 17:00', '2009/6/13 18:00', '2009/6/13 19:00', '2009/6/13 20:00', '2009/6/13 21:00', '2009/6/13 22:00', '2009/6/13 23:00'].map(function (str) {
						return str.replace(' ', '\n')
					})
				}
			],
			yAxis: [
				{
					type: 'value',
					//name: '数据量',
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
					name:'某某数据1',
					type:'line',
					animation: false,
					lineStyle: {
						normal: {
							width: 3,
							color : "#8169b1"
						}
					},
					smooth : true,
					symbolSize : 10,
					data:[900,200,123,400,151,812,100,200,123,400,151,812,100,200,400,123,400,151,812,100,200,123,400,151,812,100,200,123,400,151,812,100,200,123,400,151,812,100,200,123,400,151,812,100,200,123]
				},
				{
					name:'某某数据2',
					type:'line',
					animation: false,
					lineStyle: {
						normal: {
							width: 3,
							color : "#e9816d"
						}
					},
					smooth : true,
					symbolSize : 10,
					data:[200,123,400,812,100,200,123,400,151,812,100,200,400,123,400,151,812,100,200,100,123,400,151,812,100,200,123,400,151,812,100,200,151,123,400,151,812,100,200,123,400,151,812,100,200,123]
				},
				{
					name:'某某数据3',
					type:'line',
					animation: false,
					lineStyle: {
						normal: {
							width: 3,
							color : "#0689d4"
						}
					},
					smooth : true,
					symbolSize : 10,
					data:[812,123,400,812,100,200,123,400,151,200,100,200,400,123,400,151,812,100,200,100,123,400,151,812,100,200,123,400,151,812,100,200,151,123,400,123,151,812,100,200,123,400,151,812,100,200]
				},
				{
					name:'某某数据4',
					type:'line',
					animation: false,
					lineStyle: {
						normal: {
							width: 3,
							color : "#00c9b3"
						}
					},
					smooth : true,
					symbolSize : 10,
					data:[1012,400,812,123,100,200,123,400,151,200,100,200,400,123,400,151,812,100,200,200,100,123,400,151,812,100,200,123,400,151,812,100,200,151,123,400,123,151,812,100,200,123,400,151,812,100]
				},
				{
					name:'某某数据5',
					type:'line',
					animation: false,
					lineStyle: {
						normal: {
							width: 3,
							color : "#e95b5b"
						}
					},
					smooth : true,
					symbolSize : 10,
					//hoverAnimation : true,
					data:[512,400,812,123,100,200,123,400,451,200,100,200,400,823,400,151,212,100,400,200,600,100,200,123,400,151,812,100,200,123,400,151,812,151,123,400,123,151,812,100,200,123,400,151,812,100]
				}
			]
		};

		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 接口机实时积压数据统计
 */
function backlogDataStatistic_1(id) {
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
					data:[12010,21014,19841,35412,54711,64712,65421,12457,98654,9741,15973,13469,76431,64828,17847,24457,34451,85241,84512,15489,68741,33548,94102,75321]
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
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description Kafka实时积压数据统计
 */
function backlogDataStatistic_2(id) {
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
					data:[12010,21014,19841,35412,54711,64712,65421,12457,98654,9741,15973,13469,76431,64828,17847,24457,34451,85241,84512,15489,68741,33548,94102,75321]
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
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 协议还原数据实时输入数据量
 */
function importDataChart(id) {
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
				y : 20,
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 协议还原数据实时输入数据量
 */
function exportDataChart(id) {
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
				y : 20,
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
		                   color : "#0689d4"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					areaStyle : {
						normal : {
							color : "rgba(6,137,212,0.2)"
						}
					},
					smooth : true,
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 当前数据总量饼图
 */
function curTotalDataChart(id) {
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));

		var option = {
			/*tooltip: {
				trigger: 'item',
				formatter: "{a} <br/>{b}: {c} ({d}%)"
			},
			legend: {
				orient: 'vertical',
				x: 'left',
				data:['当前协议还原输入数据总量','当前协议还原输出数据总量','当前协议还原丢弃数据总量']
			},*/
			title : {
				show : true,
				text : "当前数据总量",
				top : "center",
				left : "center",
				textStyle : {
					color : "#8d93ab",
					fontFamily : "Microsoft YaHei",
					fontSize : 14
				}
			},
			series: [
				{
					name:'访问来源',
					type:'pie',
					radius: ['50%', '70%'],
					avoidLabelOverlap: false,
					label: {
						normal: {
							show: true,
							position: 'outside',
							formatter : '{d}%',
							fontSize : 14,
							fontFamily : "Microsoft YaHei"
						},
						/*emphasis: {
							show: false,
							textStyle: {
								fontSize: '30',
								fontWeight: 'bold'
							}
						}*/
					},
					labelLine: {
						/*normal: {
							show: true
						}*/
						show:true,
						length : 50,
						length2 : 50
					},
					data:[
						{
							value:335,
							name:'当前协议还原输入数据总量',
							itemStyle: {
								normal: {
								   color : "#0c908b",
								   /*shadowColor : "#f00",
								   shadowBlur : 5,
								   shadowOffsetX : -10,
								   shadowOffsetY : -10*/
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:310,
							name:'当前协议还原输出数据总量',
							itemStyle: {
								normal: {
								   color : "#a3516e"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:234,
							name:'当前协议还原丢弃数据总量',
							itemStyle: {
								normal: {
								   color : "#0b75b6"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						}
					]
				}
			]
		};
		


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 昨日数据总量饼图
 */
function yestodayTotalDataChart(id) {
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));

		var option = {
			/*tooltip: {
				trigger: 'item',
				formatter: "{a} <br/>{b}: {c} ({d}%)"
			},
			legend: {
				orient: 'vertical',
				x: 'left',
				data:['当前协议还原输入数据总量','当前协议还原输出数据总量','当前协议还原丢弃数据总量']
			},*/
			title : {
				show : true,
				text : "当前数据总量",
				top : "center",
				left : "center",
				textStyle : {
					color : "#8d93ab",
					fontFamily : "Microsoft YaHei",
					fontSize : 14
				}
			},
			series: [
				{
					name:'访问来源',
					type:'pie',
					radius: ['50%', '70%'],
					avoidLabelOverlap: false,
					label: {
						normal: {
							show: true,
							position: 'outside',
							formatter : '{d}%',
							fontSize : 14,
							fontFamily : "Microsoft YaHei"
						},
						/*emphasis: {
							show: false,
							textStyle: {
								fontSize: '30',
								fontWeight: 'bold'
							}
						}*/
					},
					labelLine: {
						/*normal: {
							show: true
						}*/
						show:true,
						length : 50,
						length2 : 50
					},
					data:[
						{
							value:335,
							name:'当前协议还原输入数据总量',
							itemStyle: {
								normal: {
								   color : "#0c908b",
								   /*shadowColor : "#f00",
								   shadowBlur : 5,
								   shadowOffsetX : -10,
								   shadowOffsetY : -10*/
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:310,
							name:'当前协议还原输出数据总量',
							itemStyle: {
								normal: {
								   color : "#833e90"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						}
					]
				}
			]
		};
		


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 重复率、错误率、准确率
 */
function ratioDatas_1(id) {
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));
		var colors = ['#ed791d','#ff485e','#22ac49'];
		var labelTop = {
                normal: {
                    label: {
                        formatter: function (params) {
                            return  params.value;
                        },
                        show: true,
                        position: 'center',
                        textStyle: {
                            fontFamily : 'Agency FB',
                            fontSize:23,
                            fontWeight:'bolder'
                        }
                    },
                    labelLine: {
                        show: false
                    }
                }
            };
            var labelFromatter = {
                normal: {
                    color:function(param){
                        return colors[param.seriesIndex++];
                    },
                    label: {
                        show: false,
                        formatter: function (params) {
                            return 100 - params.value;
                        },
                        textStyle: {
                            fontFamily:'Arial',
                            fontSize:20
                        }
                    }
                }
            };
            var labelBottom = {
                normal: {
                    color: '#343f5c',
                    label: {
                        show: false,
                        position: 'center'
                    },
                    labelLine: {
                        show: false
                    }
                },
                emphasis: {
                    //color: 'rgba(0,0,0,0)'
                }
            };
            var radius = [28, 35];
            var option = {
                legend: {
                    show:false,
                    x : 'center',
                    y : 'center',
                    data:[
                        '重复率','错误率','准确率 '
                    ]
                },
                series : [
                    {
                        type : 'pie',
                        center : ['36', '36'],
                        radius : radius,
                        itemStyle : labelFromatter,
                        data : [
                            {name:'other', value:80, itemStyle : labelBottom},
                            {name:'重复率', value:20,itemStyle : labelTop}
                        ]
                    },
                    {
                        type : 'pie',
                        center : ['36', '122'],
                        radius : radius,
                        itemStyle : labelFromatter,
                        data : [
                            {name:'other', value:80, itemStyle : labelBottom},
                            {name:'错误率', value:20,itemStyle : labelTop}
                        ]
                    },
                    {
                        type : 'pie',
                        center : ['36', '208'],
                        radius : radius,
                        itemStyle : labelFromatter,
                        data : [
                            {name:'other', value:90, itemStyle : labelBottom},
                            {name:'准确率', value:10,itemStyle : labelTop}
                        ]
                    }
                ]
            };
		


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 还原设备负载
 */
function restoreEquipmentChart(id) {
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));

		var option = {
			/*title : {
				text: '还原设备负载',
				subtext: '还原设备负载',
				x:'center'
			},
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},*/
			legend: {
				x : 'right',
				y : 'center',
				orient : "vertical",
				textStyle : {
					color : "#68789d"
				},
				itemGap : 30,
				data:['已用内存','Category B','Category C','Category D']
			},
			/*toolbox: {
				show : true,
				feature : {
					mark : {show: true},
					dataView : {show: true, readOnly: false},
					magicType : {
						show: true,
						type: ['pie', 'funnel']
					},
					restore : {show: true},
					saveAsImage : {show: true}
				}
			},
			calculable : true,*/
			series : [
				{
					name:'还原设备负载',
					type:'pie',
					radius : [30, 110],
					center : ['50%', '50%'],
					roseType : 'area',
					label : {
						normal : {
							show: true,
							position: 'outside',
							formatter : '{d}%',
							fontSize : 16,
							fontFamily : "Microsoft YaHei"
						}
					},
					data:[
						{
							value:10,
							name:'已用内存',
							itemStyle: {
								normal: {
								   color : "#2c59a7"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:5,
							name:'Category B',
							itemStyle: {
								normal: {
								   color : "#387eae"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:15,
							name:'Category C',
							itemStyle: {
								normal: {
								   color : "#a6682c"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:25,
							name:'Category D',
							itemStyle: {
								normal: {
								   color : "#25755a"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						}
					]
				}
			]
		};

		


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 实时运行任务量
 */
function jobChart_1(id) {
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
				y : 20,
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}


/**
 * @description 实时已完成任务量
 */
function jobChart_2(id) {
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
				y : 20,
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
		                   color : "#0689d4"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					areaStyle : {
						normal : {
							color : "rgba(6,137,212,0.2)"
						}
					},
					smooth : true,
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 预处理数据实时监控
 */
function anticipationChart_1(id) {
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
			legend: {
				data:['输入量','输出量'],
				x: 'right',
				textStyle : {
					color : "#a7b5e0"
				}
			},
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
					name:'输入量',
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
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				},
				{
					name:'输出量',
					type:'line',
					itemStyle: {
		                normal: {
		                   color : "#e86686"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					areaStyle : {
						normal : {
							color : "rgba(232,102,134,0.2)"
						}
					},
					smooth : true,
					data:[65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,75321,12010,19841,35412,21014,54711,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 输入数据流重复率
 */
function anticipationChart_2(id) {
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
				y : 20,
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
		                   color : "#0689d4"
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
						}
		            },
					areaStyle : {
						normal : {
							color : "rgba(6,137,212,0.2)"
						}
					},
					smooth : true,
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 预处理异常数据量
 */
function anticipationChart_3(id) {
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));

		var option = {
			/*title : {
				text: '还原设备负载',
				subtext: '还原设备负载',
				x:'center'
			},
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},*/
			legend: {
				x : 'right',
				y : 'center',
				orient : "vertical",
				textStyle : {
					color : "#68789d"
				},
				itemGap : 30,
				data:['AA异常数据量','BB异常数据量','CC异常数据量','DD异常数据量','EE异常数据量']
			},
			/*toolbox: {
				show : true,
				feature : {
					mark : {show: true},
					dataView : {show: true, readOnly: false},
					magicType : {
						show: true,
						type: ['pie', 'funnel']
					},
					restore : {show: true},
					saveAsImage : {show: true}
				}
			},
			calculable : true,*/
			series : [
				{
					name:'还原设备负载',
					type:'pie',
					radius : [30, 110],
					center : ['50%', '50%'],
					roseType : 'area',
					label : {
						normal : {
							show: true,
							position: 'outside',
							formatter : '{d}%',
							fontSize : 16,
							fontFamily : "Microsoft YaHei"
						}
					},
					data:[
						{
							value:10,
							name:'AA异常数据量',
							itemStyle: {
								normal: {
								   color : "#3069c8"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:5,
							name:'BB异常数据量',
							itemStyle: {
								normal: {
								   color : "#409bd2"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:15,
							name:'CC异常数据量',
							itemStyle: {
								normal: {
								   color : "#d37d24"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:25,
							name:'DD异常数据量',
							itemStyle: {
								normal: {
								   color : "#268f62"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:25,
							name:'EE异常数据量',
							itemStyle: {
								normal: {
								   color : "#972121"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						}
					]
				}
			]
		};

		


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 预处理错误数据量
 */
function anticipationChart_4(id) {
	var ec = echarts;
	/*线图*/
	if (document.getElementById(id)) {
		chartObj[id] = ec.init(document.getElementById(id));

		var option = {
			/*title : {
				text: '还原设备负载',
				subtext: '还原设备负载',
				x:'center'
			},
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},*/
			legend: {
				x : 'right',
				y : 'center',
				orient : "vertical",
				textStyle : {
					color : "#68789d"
				},
				itemGap : 30,
				data:['AA异常数据量','BB异常数据量','CC异常数据量','DD异常数据量','EE异常数据量']
			},
			/*toolbox: {
				show : true,
				feature : {
					mark : {show: true},
					dataView : {show: true, readOnly: false},
					magicType : {
						show: true,
						type: ['pie', 'funnel']
					},
					restore : {show: true},
					saveAsImage : {show: true}
				}
			},
			calculable : true,*/
			series : [
				{
					name:'还原设备负载',
					type:'pie',
					radius : [30, 110],
					center : ['50%', '50%'],
					roseType : 'area',
					label : {
						normal : {
							show: true,
							position: 'outside',
							formatter : '{d}%',
							fontSize : 16,
							fontFamily : "Microsoft YaHei"
						}
					},
					data:[
						{
							value:100,
							name:'AA异常数据量',
							itemStyle: {
								normal: {
								   color : "#3069c8"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:80,
							name:'BB异常数据量',
							itemStyle: {
								normal: {
								   color : "#409bd2"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:60,
							name:'CC异常数据量',
							itemStyle: {
								normal: {
								   color : "#d37d24"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:40,
							name:'DD异常数据量',
							itemStyle: {
								normal: {
								   color : "#268f62"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						},
						{
							value:20,
							name:'EE异常数据量',
							itemStyle: {
								normal: {
								   color : "#972121"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						}
					]
				}
			]
		};

		


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 接入数据实时输入数据量
 */
function insertChart_1(id) {
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
					data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
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
					data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 抛弃数据量
 */
function insertChart_2(id) {
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
					data: ['原因一','原因二','原因三','原因四','原因五','原因六'],
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
					data:[69,78,96,72,78,85]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}


/**
 * @description 应用调用协议频次
 */
function frequencyBar(id) {
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
					data: ['真实身份基础档案','对象活动信息','互联网服务单位信息','车辆档案信息','地理位置信息','统一身份关系信息','对象轨迹信息','对象间关系信息','上网终端基础档案'],
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
					name: '频次',
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
					name:'互联网服务单位信息',
					type:'bar',
					barWidth : 45,
					itemStyle: {
		                normal: {
		                   color : {
							   type : "linear",
							   x : 0,
							   y : 0,
							   x2 : 0,
							   y2 : 1,
							   colorStops : [{
								   offset : 0 , color : "rgba(0,205,190,1)"
							    },{
								   offset : 1 , color : "rgba(0,205,190,0)"
							    }]
							}
		                },
						emphasis : {
							//shadowColor : 'rgba(0,0,0,0.5)'
							color : "#00cdbe"
						}
		            },
					data:[69,78,96,72,78,85,78,96,72,78,85]
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}












