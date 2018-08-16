$(function(){
	/*var configs = [
		{
			id : "anticipationComb_1",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "anticipationComb_2",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "anticipationComb_3",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "anticipationComb_4",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "anticipationComb_5",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		},{
			id : "anticipationComb_6",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		}
	];
	combobox(configs);*/
	var queryCondition = {};
	$.ajax({
		url: '/rundatakpi/restore/init',
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
	//协议还原数据实时输入数据量
	importDataChart("importDataChart", data['inputJson']);
	
	//协议还原数据实时输出数据量
	exportDataChart("exportDataChart", data['outputJson']);
	
	//当前数据总量饼图
	curTotalDataChart("curTotalDataChart", data['currentDataJson']);
	
	//昨日数据总量饼图
	yestodayTotalDataChart("yestodayTotalDataChart", data['yesterdayDataJson']);
	
	//重复率、错误率、准确率
	ratioDatas_1("ratioDatas_1");
	
	//还原设备负载
	restoreEquipmentChart("restoreEquipmentChart");
	
	$("#restore_total_input").text(data['currentDataJson']['totalInputNum']);
	$("#restore_total_output").text(data['currentDataJson']['totalOutputNum']);
	$("#restore_total_discard").text(data['currentDataJson']['totalDiscardNum']);
	$("#restore_yesterday_input").text(data['yesterdayDataJson']['yesterdayInputNum']);
	$("#restore_yesterday_output").text(data['yesterdayDataJson']['yesterdayOutputNum']);
}

/**
 * @description 协议还原数据实时输入数据量
 */
function importDataChart(id, data) {
	var inputDate = data['inputDate'];
	var inputNum = data['inputNum'];
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
					//data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
					data:inputDate,
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
					//data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				    data: inputNum
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 协议还原数据实时输入数据量
 */
function exportDataChart(id, data) {
	var outputDate = data['outputDate'];
	var outputNum = data['outputNum'];
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
					//data: ['00：00：00','01：00：00','02：00：00','03：00：00','04：00：00','05：00：00','06：00：00','07：00：00','08：00：00','09：00：00','10：00：00','11：00：00','12：00：00','13：00：00','14：00：00','15：00：00','16：00：00','17：00：00','18：00：00','19：00：00','20：00：00','21：00：00','22：00：00','23：00：00','24：00：00'],
					data: outputDate,
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
					//data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				    data: outputNum
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 当前数据总量饼图
 */
function curTotalDataChart(id, data) {
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
							value:data['totalInputNum'],
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
							value:data['totalOutputNum'],
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
							value:data['totalDiscardNum'],
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
function yestodayTotalDataChart(id, data) {
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
				text : "昨日数据总量",
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
							value:data['yesterdayInputNum'],
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
							value:data['yesterdayOutputNum'],
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