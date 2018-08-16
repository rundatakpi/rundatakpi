chartObj = {};
$(function(){
	//加载九大资源库实时数据量和昨日数据量柱图
	//nineStorage("nineStorage");
	//加载对象库实时数据量和昨日数据量柱图
	//objectStroage("objectStroage");
	//加载数据统计线图
	//dataStatistics("dataStatistics");
	//接口机实时积压数据统计
	//backlogDataStatistic_1("backlogDataStatistic_1");
	//Kafka实时积压数据统计
	//backlogDataStatistic_2("backlogDataStatistic_2");
	//协议还原数据实时输入数据量
	//importDataChart("importDataChart");
	//协议还原数据实时输出数据量
	//exportDataChart("exportDataChart");
	//当前数据总量饼图
	//curTotalDataChart("curTotalDataChart");
	//昨日数据总量饼图
	//yestodayTotalDataChart("yestodayTotalDataChart");
	//重复率、错误率、准确率
	//ratioDatas_1("ratioDatas_1");
	//还原设备负载
	//restoreEquipmentChart("restoreEquipmentChart");
	//实时运行任务量
	//jobChart_1("jobChart_1");
	//实时已完成任务量
	//jobChart_2("jobChart_2");
	//预处理数据实时监控
	anticipationChart_1("anticipationChart_1");
	//输入数据流重复率
	anticipationChart_2("anticipationChart_2");
	//预处理异常数据量
	anticipationChart_3("anticipationChart_3");
	//预处理错误数据量
	anticipationChart_4("anticipationChart_4");
	//接入数据实时输入数据量
	// insertChart_1("insertChart_1");
	//抛弃数据量
	// insertChart_2("insertChart_2");
	//应用调用协议频次
	//frequencyBar("frequencyBar");
	
	
})






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















