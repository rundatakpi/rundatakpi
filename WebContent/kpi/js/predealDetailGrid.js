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
	Run.define("predealDetailGrid",(function(){
		

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
                        	+'<td>' + data.sourceDesc + '</td>'
                            +'<td>' + data.authentNumber + '</td>'
                            +'<td>' + data.authenType + '</td>'
                            +'<td>' + data.senderName + '</td>'
                        	+'<td>' + data.receiverName + '</td>'
                            +'<td>' + data.baseStation + '</td>'
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
					
					//卡片：详情
					$container.off('click','tr .importDataLink').on('click','tr .importDataLink',function (ev) {
						var tr = $(this).closest('tr'),
							index = $('#' + that.id).find('tr').index(tr);
						that.callBacks.handleImportDataLink.apply(tr,[ev,that.data.data[index]]);
					});
				}
				
			}
		};

	}()));

}());