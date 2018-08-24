$(function(){
	globalObj.mergeGrid["predealDetailDataBody"] = Run.create('predealDetailGrid',{
		id : 'predealDetailDataBody',
		//query : param,
		url : "json/mergegrid_6.json",
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