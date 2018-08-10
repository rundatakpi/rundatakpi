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
