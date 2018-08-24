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
	Run.define("predealDataGrid",(function(){
		

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
			    	
				},
				
				/**
				 * 	创建私有方法 创建同一身份、联系人
				 *
				 *	@method _createInfoList
				 *  @private
				 * 
				 */
				_createInfoList: function(data) {
					var _html = '';
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
					var _html = '<tr>'
                        	+'<td>' + data.col_1 + '</td>'
                            +'<td>' + data.col_2 + '</td>'
                        	+'<td><a href="#" class="importDataLink">' + data.col_3 + '</a></td>'
                            +'<td>' + data.col_4 + '</td>'
                        	+'<td>' + data.col_5 + '</td>'
                            +'<td>' + data.col_6 + '</td>'
                        	+'<td>' + data.col_7 + '</td>'
                            +'<td>' + data.col_8 + '</td>'
                        	+'<td>' + data.col_9 + '</td>'
                            +'<td>' + data.col_10 + '</td>'
                        	+'<td>' + data.col_11 + '</td>'
                            +'<td>' + data.col_12 + '</td>'
                        	+'<td>' + data.col_13 + '</td>'
                            +'<td>' + data.col_14 + '</td>'
                            +'<td>' + data.col_15 + '</td>'
                            +'<td>' + data.col_16 + '</td>'
                            +'<td>' + data.col_17 + '</td>'
                            +'<td>' + data.col_18 + '</td>'
                            +'<td><a href="#" class="seeSampleLink">查看样例</a></td>'
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
						//class_card = 'cardOb',
						$container = $('#' + this.id);
					
					//大协议编码
					$container.off('click','tr .importDataLink').on('click','tr .importDataLink',function (ev) {
						var tr = $(this).closest('tr'),
							index = $('#' + that.id).find('tr').index(tr);
						that.callBacks.handleImportDataLink.apply(tr,[ev,that.data.data[index]]);
					});
					
					//查看样例
					$container.off('click','tr .seeSampleLink').on('click','tr .seeSampleLink',function (ev) {
						var tr = $(this).closest('tr'),
							index = $('#' + that.id).find('tr').index(tr);
						that.callBacks.handleSeeSampleLink.apply(tr,[ev,that.data.data[index]]);
					});
				}
				
			}
		};

	}()));

}());