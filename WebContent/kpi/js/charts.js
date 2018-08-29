chartObj = {};
$(function(){
	
	//比率折线图
	percentChart("percentChart");
})

/**
 * @description 比率折线图
 */
function percentChart(id) { 
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