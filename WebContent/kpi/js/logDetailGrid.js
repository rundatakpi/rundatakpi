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
	Run.define("logDetailGrid",(function(){
		

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
				_createCard : function (data, bi) {
					
					var _html = '<tr>'
                        	+'<td>' + data.sProtocolCode + '</td>'
                            +'<td>' + data.sProtocolDesc + '</td>'
                            +'<td>' + data.actionTypeDesc + '</td>'
                            +'<td><a href="#" class="percentLink" name="dataNum">' + data.dataNum + '</a></td>';
                       
				    	
					$.each(data.logFieldList,function(si,n){
						
						if(bi==0){
							$("colgroup").append("<col width='' />");
							$("thead tr:eq(0)").append("<th colspan='3'>"+this.fieldDesc+"</th>");
							$("thead tr:eq(1)").append("<th>填充率</th><th>准确率</th><th>代码符合</th>");
						}
						
						
						_html += '<td><a href="#" class="percentLink" name="fillRate" field="'+this.fieldCode+'">' + this.fillRate + '</a></td>';
						_html += '<td><a href="#" class="percentLink" name="accuracy" field="'+this.fieldCode+'">' + this.accuracy + '</a></td>';
						_html += '<td><a href="#" class="percentLink" name="codeMatchRate" field="'+this.fieldCode+'">' + this.codeMatchRate + '</a></td>';
					})
					
					_html += '</tr>';
					
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
						var name = $(this).attr("name");
						var field = $(this).attr("field");
						
						that.callBacks.handlePercentLink.apply(tr,[ev,that.data.data[index],name,field]);
					});
				}
				
			}
		};

	}()));

}());