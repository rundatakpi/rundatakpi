$(function(){
	var configs = [{
		id : "objectdataCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "objectdataCombobox_2",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "objectdataCombobox_3",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	
	//加载合并表格数据
	//alert(Run)
	
	globalObj.mergeGrid["objectDataBody"] = Run.create('objectDataGrid',{
		id : 'objectDataBody',
		//query : param,
		url : rootPath+"/obj/getList",
		//checkAllId:'showCardChbAll',
		//checkOneCls:'cardOb_chk',
		cache:true,
		isMultiple:true,
		dataSuccess:function(data){
			$("#objTotal").text(data.total);
			
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
			handleImportDataLink : handleImportDataFnc
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
})

//大协议编码点击
function handleImportDataFnc (ev, row) {
	alert("大协议编码点击");
	//location.href='jobmonitor.html';
}
