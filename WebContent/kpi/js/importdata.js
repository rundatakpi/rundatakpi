$(function(){
	var configs = [{
		id : "importDataCombobox_1",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "importDataCombobox_2",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	},{
		id : "importDataCombobox_3",
		url : "json/failCause.json",
		onSelect : function(combo,record){}
	}];
	combobox(configs);
	
	//加载合并表格数据
	//alert(Run)
	
	/*globalObj.mergeGrid["importDataBody"] = Run.create('MergeGrid',{
		id : 'importDataBody',
		//query : param,
		url : "json/mergegrid_1.json",
		//checkAllId:'showCardChbAll',
		//checkOneCls:'cardOb_chk',
		cache:true,
		isMultiple:true,
		dataSuccess:function(){
			
			//var $rPageContainer = $('#'+this.id).find('.r-page-container');
//			$('#'+this.id).find('.cardOb_render').remove();
//			if (this.getTotal()==1) {
//				var html = '<div class="cardOb_render">'+
//								'仅为您搜索到<em>1</em>条对象数据，推荐您查看其 <a href="javascript:;" onclick="$(\'#reSidebar .hd1\').eq(1).trigger(\'click\').siblings(\'.bd1\').find(\'.filt2\').eq(0).trigger(\'click\');">日志数据</a>'+ 
//							'</div>';
//				$rPageContainer.addClass('hide');
//				$('#'+this.id).append(html);
//			} else {
//				$rPageContainer.removeClass('hide')
//			}
		},
		usepage : {
			type:'1',
			position : 'bottom',
			align : 'center',
			pageGoAble : false,
			pageSizeAble : false,
			pageDescription : true
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
	});*/

});
