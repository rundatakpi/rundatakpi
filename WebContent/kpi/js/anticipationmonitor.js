$(function(){
	var configs = [
		{
			id : "anticipationComb_1",
			url : "json/failCause.json",
			onSelect : function(combo,record){
				$("#anticipationComb_1").val(record.text);
			}
		},{
			id : "anticipationComb_2",
			url : "json/datasource.json",
			onSelect : function(combo,record){
				$("#anticipationComb_2").val(record.text);
			}
		},{
			id : "anticipationComb_3",
			url : "json/bProtocol.json",
			onSelect : function(combo,record){
				$("#anticipationComb_3").val(record.text);
			}
		},{
			id : "anticipationComb_4",
			url : "json/sProtocol.json",
			onSelect : function(combo,record){
				$("#anticipationComb_4").val(record.text);
			}
		},{
			id : "anticipationComb_5",
			url : "json/action.json",
			onSelect : function(combo,record){
				$("#anticipationComb_5").val(record.text);
			}
		},{
			id : "anticipationComb_6",
			url : "json/collectPlace.json",
			onSelect : function(combo,record){
				$("#anticipationComb_6").val(record.text);
			}
		}
	];
	combobox(configs);
	
	$('.chooseDay').off("click").on('click',"a",function(){
		$(this).addClass("slt").siblings().removeClass("slt");
		var parent = $(this).parent();
		var day = $(this).attr('value');
		var url = parent.attr('url');
		console.log("day = " + day);
		console.log("url = " + url);
		
		refresh(url, day);
		return false;
	});
	
	init();
})


function query() {
	var queryCondition = getQueryCondtion();
	console.log(JSON.stringify(queryCondition));
	init(queryCondition);
}

function getQueryCondtion() {
	var classfication = $("#anticipationComb_1").val()[0];
	var dataSource = $("#anticipationComb_2").val()[0];
	var bProtocol = $("#anticipationComb_3").val()[0];
	var sProtocol = $("#anticipationComb_4").val()[0];
	var action = $("#anticipationComb_5").val()[0];
	var collectPlace = $("#anticipationComb_6").val()[0];
	
	var realDay = $("#real_day a[class$='slt']").attr("value");
	var repeatDay = $("#repeat_day a[class$='slt']").attr("value");
	
	console.log("realDay = " + realDay);
	console.log("repeatDay = " + repeatDay);
		
	var queryCondition = {
		"classfication": classfication,
		"dataSource": dataSource,
		"bProtocol": bProtocol,
		"sProtocol": sProtocol,
		"action": action,
		"collectPlace": collectPlace,
		"realDay": realDay,
		"repeatDay": repeatDay
	};
	
	return queryCondition;
}

function refresh(url, day) {
	var queryCondition = getQueryCondtion();
	console.log(JSON.stringify(queryCondition));
	
	if (url == 'realtime') {
		queryCondition['realDay'] = day;
	} else if (url == 'repeat') {
		queryCondition['repeatDay'] = day;
	}
	$.ajax({
		url: '/rundatakpi/preprocess/' + url,
		method: 'GET',
		data: queryCondition,
		dataType: 'json',
		success: function(data) {
			if (url == 'realtime') {
				//接入数据实时输入数据量
				anticipationChart_1("anticipationChart_1", data);
			} else if (url == 'repeat') {
				//数据重复率
				anticipationChart_2("anticipationChart_2", data['repeatJson']);
			}
		},
		error: function(data) {
			console.log("error");
		}
	});
}

function init(queryCondition) {
	$.ajax({
		url:'/rundatakpi/preprocess/init',
		method: 'GET',
		data: queryCondition,
		dataType: 'json',
		success: function(data) {
			console.log(JSON.stringify(data));
			
			//预处理数据实时监控
			anticipationChart_1("anticipationChart_1", data);
			//输入数据流重复率
			anticipationChart_2("anticipationChart_2", data['repeatJson']);
			//预处理异常数据量
			//anticipationChart_3("anticipationChart_3");
			//预处理错误数据量
			anticipationChart_4("anticipationChart_4", data['errorJson']);
		}
	});
	
}


/**
 * @description 预处理数据实时监控
 */
function anticipationChart_1(id, data) {
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
					//data:[75321,12010,19841,35412,21014,54711,65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,85241,84512,15489,33548,94102,64712]
				    data: data['inputNum']
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
					//data:[65421,12457,98654,9741,15973,13469,76431,64828,68741,24457,34451,17847,75321,12010,19841,35412,21014,54711,85241,84512,15489,33548,94102,64712]
				    data: data['outputNum']
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 输入数据流重复率
 */
function anticipationChart_2(id, data) {
	var date, data;
	if (data == undefined) {
		date = ['无数据'];
		data = [0];
	} else {
		date = data['date'];
		data = data['repeatNum'];
	}
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
					data:data
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
function anticipationChart_4(id, data) {
	var color = ['#3069c8', '#409bd2', '#d37d24', '#972121', '#268f62'];
	var legend = data['errorType'];
	var seriesData = [];
	$.each(data['errorNum'], function(index, value) {
		var yData = {
			value:value,
			name:legend[index],
			itemStyle: {
				normal: {
				   color : color[index % color.length]
				},
				emphasis : {
					//shadowColor : 'rgba(0,0,0,0.5)'
				}
			}
		}
		seriesData.push(yData);
	});
	console.log(JSON.stringify(seriesData));
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
				data:legend
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
					data:seriesData
						/*
						[
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
								   color : "#972121#268f62"
								},
								emphasis : {
									//shadowColor : 'rgba(0,0,0,0.5)'
								}
							}
						}
					
					]*/
				}
			]
		};

		


		chartObj[id].setOption(option, true);
				
		
	}
}