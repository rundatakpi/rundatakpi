/**
 *	@class Run.Widget.Card
 *	@extends Run.Cards
 *	@xtype cardExample
 *
 *	锐安前端组件库  具体卡片组件
 *
 *	@author mahonglu
 *	@new
 */


(function(){
	Run.define("MergeGrid",(function(){
		

		return {
			/**
			 * 	该类继承的父类名称，类定义时使用
			 *
			 *	@property {String} extend
			 *	@readonly
			 */
			extend : Run.DefaultCardsSuperClass,
			
			privates : {
				/**
				 * 	创建私有方法 创建类型item
				 *
				 *	@method _createItem
				 *  @private
				 * 
				 */
				_createItem: function(tmp) {
			    	/*var _mtheme = tmp.theme?tmp.theme:'';
			    	var _mval = tmp.val;
			    	if (_mtheme == 'keyword') {
			    		_mtheme = '';
			    		_mval = _mval.replace(tmp.keyword,'<em class="'+tmp.theme+'">'+tmp.keyword+'</em>');
			    	}
			    	return  '<li class="item left"><span class="labTxt left">【'+tmp.lab+'】</span><span class="'+_mtheme+' left labTxtVal" title="'+tmp.val+'">'+_mval+'</span>'+(tmp.axis?'<a href="javascript:;" class="opMap left" data-axis ="'+tmp.axis+'"></a>':'')+'</li>';*/
				},
				
				/**
				 * 	创建私有方法 创建同一身份、联系人
				 *
				 *	@method _createInfoList
				 *  @private
				 * 
				 */
				_createInfoList: function(data) {
					console.log(JSON.stringify(data));
					var _html = '<tr>'
                        	+'<td>144</td>'
                            +'<td>4G</td>'
                        	+'<td><a href="#" class="importDataLink">WA_SOUR</a></td>'
                            +'<td>即时通讯</td>'
                        	+'<td></td>'
                            +'<td></td>'
                        	+'<td>上线</td>'
                            +'<td>1221条</td>'
                        	+'<td>321条/秒</td>'
                            +'<td>82%</td>'
                        	+'<td>82%</td>'
                            +'<td>82%</td>'
                        	+'<td>82%</td>'
                            +'<td>82%</td>'
                        +'</tr>';
					/*
					var that = this,
						_html = '',
						_infos = '';
					$.each(data.list, function(i,tmp) {
				    	if ($.type(tmp.val)=="array") {
				    		var _infosB = '';
				    		 $.each(tmp.val, function (j, val) {
				    		 	var sTheme = '',
				    		 		sItem = val.item;
				    		 	if (val.theme) {
				    		 		sTheme = val.theme;
				    		 		if (val.keyword) {
				    		 			sItem = sItem.replace(val.keyword,'<em class="'+val.theme+'">'+val.keyword+'</em>');
				    		 		} else{
				    		 			sItem = '<em class="'+val.theme+'">'+sItem+'</em>'
				    		 		}
				    		 	} 
				    		 	if (j !== 0) {
				    		 		_infosB += '<em class="left">、</em>';
				    		 	}
				    		 	_infosB += '<span class="valItem left"><em class="left">'+sItem+'</em></span>';
				    		 	if (j >= 2) {
				    		 		return false;
				    		 	}
				    		 });
				    		 if (tmp.tot > 3) {
				    		 	_infosB += '<em class="left">.....</em>';
				    		 }
				    		 _infosB += '<em class="tot">（共'+tmp.tot+'个）</em>';
			    		 	_infos += '<li class="item left">'+
										'<span class="labTxt left">【'+tmp.lab+'】</span>'+
										'<div class="valItemWrap left">'+
											_infosB+
										'</div>'+
									'</li>';
				    	} else {
				    		_infos += that._createItem(tmp);
				    	}
				    });
				    if (_infos!='') {
					    _html = '<div class="infos">'+
									'<span class="infos_tit">'+data.tit+'：</span>'+
									'<ul class="clearfix">'+
										_infos+
									'</ul>'+	
							   '</div>';
					}*/
				    return _html;
				},
				
				/**
				 * 	创建私有方法 创建类型1卡片
				 *
				 *	@method _createCard
				 *  @private
				 * 
				 */
				_createCard : function (data, i) {
					/*var that = this,
						_minfos = '',
					    _infos = '',
					    _num = 0,
					     _collectClass = '',
					    _read = '',
					     _val = data.val;
					if (data.read) {
				    	_read = '<em class="iRead"></em>';
				    }
				    if (data.collect) {
				    	_collectClass = 'yes';
				    } 
				    if (data.valKeyword) {
				    	_val = _val.replace(data.valKeyword,'<em class="keyword">'+data.valKeyword+'</em>');
				    }
					$.each(data.minfos, function(i,tmp) {
				    	_minfos += that._createItem(tmp);
				    });     
			    	$.each(data.infos, function(i,tmp) {
			    		_num++;
				    	_infos += that._createInfoList(tmp);
				    	if (i==1) {
				    		return false;
				    	}
				    }); 
				    
				    //分析详情操作
				    var anas = '';
				    if (data.analysis && data.analysis.length>0) {
				    	var anaTitleMap = {
				    		"family": "家庭成员",
				    		"relative": "关系图谱",
				    		"gis": "轨迹图",
				    		"activity": "活动信息"
				    	};
				    	anas += '<div class="anas clearfix">';
					    $.each(data.analysis, function (i, tmp) {
					    	anas += '<a class="ana'+tmp+' left" title="'+anaTitleMap[tmp]+'" data-type="'+tmp+'"></a>';
				   		 });
				   		 anas += '</div>';
				    }
				    
					var _html = '<dl class="cardOb '+data.type+' animateCard ord'+(i%11+1)+'">'+
								'<dt class="clearfix">'+
									'<input type="checkbox" class="cardOb_chk left" value="'+data.id+'" />'+
									'<em class="cardOb_icon left"></em>'+
									'<div class="pWrap">'+
										'<p title="'+data.lab+'">'+data.lab+':</p>'+
										'<p title="'+data.val+'">'+_val+'</p>'+
										anas+
									'</div>'+
								'</dt>'+
								'<dd>'+
									'<div class="hd">'+
										'<ul class="clearfix '+(data.lastTime?'pl':'')+'">'+
											_minfos+
										'</ul>'+
										'<div class="opWrap clearfix">'+
											'<span class="lastTime left" title="最近出现时间">'+(data.lastTime?data.lastTime:'')+'</span>'+
											'<a href="javascript:;" class="opDetail left animateColorBtn">详情</a>'+
//											'<a href="javascript:;" class="opCollect '+_collectClass+' left animateColorBtn">收藏</a>'+
										'</div>'+
									'</div>'+
									'<div class="bd '+(_num>=2?'twoType':'')+'">'+
										_infos+
									'</div>'+
									_read+
								'</dd>'+
							'</dl>';*/
							
					var _html = '<tr>'
                        	+'<td>144</td>'
                            +'<td>4G</td>'
                        	+'<td><a href="#" class="importDataLink">WA_SOUR</a></td>'
                            +'<td>即时通讯</td>'
                        	+'<td></td>'
                            +'<td></td>'
                        	+'<td>上线</td>'
                            +'<td>1221条</td>'
                        	+'<td>321条/秒</td>'
                            +'<td>82%</td>'
                        	+'<td>82%</td>'
                            +'<td>82%</td>'
                        	+'<td>82%</td>'
                            +'<td>82%</td>'
                        +'</tr>';
				    
				    return _html;
				},
				/**
                 *	绑定回调函数
                 *
                 *	@method _bindCallBacks
                 * 	@private
                 *
                 */
				_bindCallBacks:function(){
					var that = this,
						class_card = 'cardOb',
						$container = $('#' + this.id);
					
					//卡片：详情
					$container.off('click','.'+class_card+' .opDetail').on('click','.'+class_card+' .opDetail',function (ev) {
						var card = $(this).closest('.'+class_card),
							index = $('#' + that.id).find('.'+class_card).index(card);
						that.callBacks.handleDetail.apply(card,[ev,that.data.data[index]]);
					});
					
					//卡片：收藏
					$container.off('click','.'+class_card+' .opCollect').on('click','.'+class_card+' .opCollect',function (ev) {
						var card = $(this).closest('.'+class_card),
							index = $('#' + that.id).find('.'+class_card).index(card);
						that.callBacks.handleCollect.apply(card,[ev,that.data.data[index]]);
					});
					
					//卡片：地图
					$container.off('click','.'+class_card+' .opMap').on('click','.'+class_card+' .opMap',function (ev) {
							var card = $(this).closest('.'+class_card),
							index = $('#' + that.id).find('.'+class_card).index(card),
							index_infos = $(this).closest('li').index();
						that.callBacks.handleMap.apply(card,[ev,that.data.data[index],that.data.data[index].infos[index_infos]]);					});
					
					//卡片：更多
					$container.off('mouseover','.'+class_card+' .opMore').on('mouseover','.'+class_card+' .opMore',function (ev) {
						var $opMore = $(this),
							w_hook = $opMore.width(),
							h_hook = $opMore.height(),
							offs_hook = $opMore.offset(),
							l_hook = offs_hook.left,
							t_hook = offs_hook.top,
							$container = $('#'+that.id),
							w_container = $container.width(),
							offs_container = $container.offset(),
							l_container = offs_container.left,
							t_container = offs_container.top,
							w_show = 342,
							h_show = 20,
							l = l_hook - l_container,
							t = t_hook - t_container + h_hook,
							posClass = 'posR';
						if (l+w_show>w_container) {
							posClass = 'posL';
							l -= w_show;
						} 
						$opMore.find('.moreTip').addClass(posClass)
					});
					///卡片：家庭成员
					$container.off('click','.'+class_card+' .anas a').on('click','.'+class_card+' .anas a',function (ev) {
						var card = $(this).closest('.'+class_card),
							index = $('#' + that.id).find('.'+class_card).index(card);
						if ($.isFunction(that.callBacks.handleAnalysis)) {
							var type = $(this).attr('data-type');
							that.callBacks.handleAnalysis.apply(card,[ev,that.data.data[index], type]);
						}	
					});
				}
				
			}
		};

	}()));

}());