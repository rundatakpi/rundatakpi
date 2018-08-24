$(function(){
	var configs = [
		{
			id : "chooseApp",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		}
	];
	combobox(configs);
	var queryCondition = {};
	
	$.ajax({
		url:'/rundatakpi/service/get',
		method: 'GET',
		data: queryCondition,
		dataType: 'json',
		success: function(data) {
			console.log(JSON.stringify(data));
			init(data);
		}
	});
})

function init(data) {
	//加载数据统计线图
	// dataStatistics("dataStatistics", data['invokeMiddlewareJson']);
	
	//应用调用协议频次
	// frequencyBar("frequencyBar", data['invokeProtocolJson']);
	
	getServerException();
}

function getServerException() {
	//加载异常返回表格
    var colModel = [{                                               //配置表格各列
                display:'调用时间',
                name:'invokeTime',
                hidden:false
            },{
                display:'调用应用',
                name:'invokeApplication',
                hidden:false
            },{
                display:'调用语句',
                name:'invokeStatement',
                hidden:false
            },{
                display:'异常原因',
                name:'exceptionReason',
                hidden:false
            }];
    var otherConfig = {
		"isMultiple":false
	};
    grid("unusualBack","/rundatakpi/service/serverException",colModel,otherConfig);
}

/**
 * @description 数据统计线图
 */
function dataStatistics(id, data) {
	var app = data['app'];
	var date = data['createDate'];
	
	var seriesData = [];
	var color = ['#8169b1', '#e9816d', '#0689d4', '#00c9b3', '#e95b5b'];
	var length = color.length;
	
	$.each(app, function(index, value) {
		console.log(color[index % length]);
		var sd = {
			name: value,
			type:'line',
			animation: false,
			lineStyle: {
				normal: {
					width: 3,
					color : color[index % length]
				}
			},
			smooth : true,
			symbolSize : 10,
			//data:[900,200,123,400,151,812,100,200,123,400,151,812,100,200,400,123,400,151,812,100,200,123,400,151,812,100,200,123,400,151,812,100,200,123,400,151,812,100,200,123,400,151,812,100,200,123]
		    data: data['data'][value]
		}
		seriesData.push(sd);
	});
	
	
	
	
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
				//data:['某某数据1','某某数据2','某某数据3','某某数据4','某某数据5'],
				data: app,
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
					/*data : [
						'2009/6/12 2:00', '2009/6/12 3:00', '2009/6/12 4:00', '2009/6/12 5:00', '2009/6/12 6:00', '2009/6/12 7:00', '2009/6/12 8:00', '2009/6/12 9:00', '2009/6/12 10:00', '2009/6/12 11:00', '2009/6/12 12:00', '2009/6/12 13:00', '2009/6/12 14:00', '2009/6/12 15:00', '2009/6/12 16:00', '2009/6/12 17:00', '2009/6/12 18:00', '2009/6/12 19:00', '2009/6/12 20:00', '2009/6/12 21:00', '2009/6/12 22:00', '2009/6/12 23:00',
						'2009/6/13 0:00', '2009/6/13 1:00', '2009/6/13 2:00', '2009/6/13 3:00', '2009/6/13 4:00', '2009/6/13 5:00', '2009/6/13 6:00', '2009/6/13 7:00', '2009/6/13 8:00', '2009/6/13 9:00', '2009/6/13 10:00', '2009/6/13 11:00', '2009/6/13 12:00', '2009/6/13 13:00', '2009/6/13 14:00', '2009/6/13 15:00', '2009/6/13 16:00', '2009/6/13 17:00', '2009/6/13 18:00', '2009/6/13 19:00', '2009/6/13 20:00', '2009/6/13 21:00', '2009/6/13 22:00', '2009/6/13 23:00'].map(function (str) {
						return str.replace(' ', '\n')
					})*/
					data: date
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
			/*series: [
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
			]*/
			series: seriesData
		};

		chartObj[id].setOption(option, true);
				
	}
}

/**
 * @description 应用调用协议频次
 */
function frequencyBar(id, data) {
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
					//data: ['真实身份基础档案','对象活动信息','互联网服务单位信息','车辆档案信息','地理位置信息','统一身份关系信息','对象轨迹信息','对象间关系信息','上网终端基础档案'],
					data: data['protocol'],
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
					//data:[69,78,96,72,78,85,78,96,72]
		            data: data['invokeNum']
				}
			]
		};


		chartObj[id].setOption(option, true);
				
		
	}
}
