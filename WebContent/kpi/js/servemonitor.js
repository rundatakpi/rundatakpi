$(function(){
	var configs = [
		{
			id : "chooseApp",
			url : "json/failCause.json",
			onSelect : function(combo,record){}
		}
	];
	combobox(configs);
	
	//加载异常返回表格
    var colModel = [{                                               //配置表格各列
                display:'调用时间',
                name:'col1',
                hidden:false
            },{
                display:'调用应用',
                name:'col2',
                hidden:false
            },{
                display:'调用语句',
                name:'col3',
                hidden:false
            },{
                display:'异常原因',
                name:'col4',
                hidden:false
            }];
    var otherConfig = {
		"isMultiple":false
	};
    grid("unusualBack","json/unusualBack.json",colModel,otherConfig);
})
