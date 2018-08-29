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
	Run.define("objectDataGrid",(function(){
		

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
					console.log(data);
					
					var _html = '<tr>'
                        	+'<td>' + data.aspectDesc + '</td>'
                            +'<td>' + data.dsCode + '</td>'
                            +'<td>' + data.dsDesc + '</td>'
                            +'<td><a href="#" class="percentLink">' + data.aspectNum + '</a></td>'
                        	+'<td><a href="#" class="percentLink">' + data.accuracy + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.weekExtractNum + '</a></td>'
                        	+'<td><a href="#" class="percentLink">' + data.netExtractNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.netExtractRate + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.phoneReNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.phoneReRate + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.idCardReNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.idCardReRate + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.adslReNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.adslReRate + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.imeiReNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.imeiReRate + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.imsiReNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.imsiReRate + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.macReNum + '</a></td>'
                            +'<td><a href="#" class="percentLink">' + data.macReRate + '</a></td>';
                          
        
                    $.each(data.objFieldList,function(si,n){
						
						if(bi==0){
						
							$("colgroup").append("<col width='' />");
							/*$("thead tr:eq(0)").append("<th>"+this.fieldDesc+"填充率</th>");*/
							$("#objectDataGrid tr:eq(0)").append("<th>填充率</th>");
						}
						
						
						_html += '<td>' + this.rate + '</td>';
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