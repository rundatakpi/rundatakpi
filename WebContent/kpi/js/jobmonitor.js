$(function(){
	var configs = [{
		id : "failCause",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	
	//加载正在运行任务表格
    var colModel_1 = [{                                               //配置表格各列
                display:'服务器地址',
                name:'col1',
                hidden:false
            },{
                display:'开始时间',
                name:'col2',
                hidden:false
            },{
                display:'运行时长（S）',
                name:'col3',
                hidden:false
            }];
    var otherConfig = {
		"isMultiple":false
	};
    grid("runningJob","json/unusualBack.json",colModel_1,otherConfig);
	//加载失败任务表格
    var colModel_2 = [{                                               //配置表格各列
                display:'服务器地址',
                name:'col1',
                hidden:false
            },{
                display:'任务开始时间',
                name:'col2',
                hidden:false
            },{
                display:'任务失败时间',
                name:'col3',
                hidden:false
            },{
                display:'失败原因',
                name:'col4',
                hidden:false
            }];
    grid("failJob","json/unusualBack.json",colModel_2,otherConfig);

})