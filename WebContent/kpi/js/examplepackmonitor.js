$(function(){
	var configs = [{
		id : "exampleCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "exampleCombobox_2",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "exampleCombobox_3",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "exampleCombobox_4",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "exampleCombobox_5",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	
	//加载帐号监测表格
    var colModel = [{                                               //配置表格各列
                display:'数据源',
                name:'col1',
                hidden:false
            },{
                display:'大协议',
                name:'col2',
                hidden:false
            },{
                display:'小协议',
                name:'col3',
                hidden:false
            },{
                display:'样例生成时间',
                name:'col4',
                hidden:false
            },{
                display:'状态',
                name:'col5',
                hidden:false
            },{
                display:'操作',
                name:'col6',
                hidden:false
            /*},{
                display:'对象化提取后字段状态',
                name:'col7',
                hidden:false*/
            }];
    grid("examplepackGrid","json/examplepackGrid.json",colModel);

});