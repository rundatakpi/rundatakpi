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
	Run.define("logDataGrid",(function(){
		

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
                        	+'<td>' + data.dsCode + '</td>'
                            +'<td>' + data.dsDesc + '</td>'
                            +'<td>' + data.bProtocolCode + '</td>'
                            +'<td>' + data.bProtocolDesc + '</td>'
                        	+'<td><a href="#" class="percentLink">' + data.inputNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.inputRate + '</a></td>'
                        	+'<td><a href="#" class="percentLink">' + data.fieldNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.accuracy + '</a></td>'
                            +'<td><a href="#" class="importDataLink">查看详情</a></td>'
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
					
					//数据详情页面
					$container.off('click','tr .percentLink').on('click','tr .percentLink',function (ev) {
						var tr = $(this).closest('tr'),
						index = $('#' + that.id).find('tr').index(tr);
						//获取列对应的字段名
						var thisIndex = $(this).parent("td").index();
						var thIndex = $("#"+that.id).prev("thead").find("tr:hidden").find("th").eq(thisIndex);
						var colName = $(thIndex).html();
						
						that.callBacks.handlePercentLink.apply(tr,[ev,that.data.data[index],colName]);
					});
					
					//大协议详情
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