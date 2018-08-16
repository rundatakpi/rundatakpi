$(function(){
	var queryCondition = {};
	$.ajax({
		url: '/rundatakpi/store/init',
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
	//加载九大资源库实时数据量和昨日数据量柱图
	nineStorage("nineStorage", data['resourceJson']);
	
	//加载对象库实时数据量和昨日数据量柱图
	objectStroage("objectStroage", data['objectJson']);
}


/**
 * @description 九大资源库实时数据量和昨日数据量柱图
 */
function nineStorage(id, data) {
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
					//data: ['虚拟身份库','终端硬件特征库','监察备案库','接入日志认证库','海量全文库','网络帐号信息库','虚拟身份关联库','网民档案库','九大资源库'],
					data: data['resourceName'],
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
					//data:[15000, 12121, 20000, 23120, 12506, 17627, 13516, 16202, 23226]
		            data: data['resourceNum']
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
					//data:[20000,15000, 12121,  23120, 12506, 23226, 17627, 13516, 16202]
		            data: data['yesterdayNum']
				}
			]
		};
		
		chartObj[id].setOption(option, true);
				
		
	}
}

/**
 * @description 对象库实时数据量和昨日数据量柱图
 */
function objectStroage(id, data) {
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
					//data: ['虚拟身份库','终端硬件特征库','监察备案库','接入日志认证库','海量全文库','网络帐号信息库','虚拟身份关联库','网民档案库','九大资源库'],
					data: data['objectName'],
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
					//data:[15000, 12121, 20000, 23120, 12506, 17627, 13516, 16202, 23226]
		            data: data['objectNum']
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
					//data:[20000,15000, 12121,  23120, 12506, 23226, 17627, 13516, 16202]
		            data: data['yesterdayObjectNum']
				}
			]
		};
		
		chartObj[id].setOption(option, true);
				
		
	}
}