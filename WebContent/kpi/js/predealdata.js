$(function(){
	var configs = [{
		id : "predealCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "predealCombobox_2",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "predealCombobox_3",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "predealCombobox_4",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	
	//加载合并表格数据
	//alert(Run)
	
	globalObj.mergeGrid["predealDataBody"] = Run.create('predealDataGrid',{
		id : 'predealDataBody',
		//query : param,
		url : "json/mergegrid_2.json",
		//checkAllId:'showCardChbAll',
		//checkOneCls:'cardOb_chk',
		cache:true,
		isMultiple:true,
		dataSuccess:function(){
			
			
		},
		usepage : {
			type:'2',
			position : 'bottom',
			align : 'center',
			pageGoAble : false,
			pageSizeAble : true,
			pageDescription : false
		},
		callBacks:{
			//handleDetail:handleDetailCardOb,
			//handleCollect:handleCollectCardOb,
			//handleMap:handleMapCardOb,
			//handleAnalysis:handleAnalysisCardOb
			handleImportDataLink : handleImportDataFnc,
			handleSeeSampleLink :  handleSeeSampleFnc
		},
		listeners:{
			render:function(){
				//addOpMoreButton(this, {type:'ob',by:'card'});
			},
			reload:function(){
				//addOpMoreButton(this, {type:'ob',by:'card'});
			}
		 }
	});

});

//大协议编码点击
function handleImportDataFnc (ev, row) {
	//alert("大协议编码点击");
	location.href='logdetail.html';
}

//查看样例点击
function handleSeeSampleFnc (ev, row) {
	//alert("大协议编码点击");
	location.href='predealdetail.html';
}










