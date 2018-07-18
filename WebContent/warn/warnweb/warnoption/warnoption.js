//页面初始化
var warnResultTable ; 
var tabId = "warnResultTable";
var url = "/warntest/warn/listWarnResult";
var data = {
	"warnGrade":$("#sel_search_warngrade").val(),
	"warnSource":$("#sel_search_warnsource").val(),
	"startTime":$("#cross_startTime").val(),
	"endTime":$("#cross_endTime").val()
};

//定义列名称
var columns = [{
    data: "id"
},
{
    data: "city"
},
{
    data: "warnSource"
},
{
    data: "warnType"
},
{
    data: "cluster"
},
{
    data: "warnOption"
},
{
    data: "concreteWarnOption"
},
{
    data: "nodeName"
},
{
    data: "nodeIp"
},
{
    data: "exceptinResult"
},
{
    data: "warnTime"
},
{
    data: "warnGrade"
},
{
    data: "status"
},
{
    data: "operation"
},
{
    data: "personInCharge"
},
{
    data: "resolveTime"
}
];

var  columnDefs = [
{
   	targets: [9],
	createdCell: function(td, cellData, rowData, row, col) {
		$(td).attr("style", "background:#FF0000");
   	}
}];

$(function() {
	/*if (warnResultTable) {
		warnResultTable.fnClearTable();
		warnResultTable.fnDestroy;
	}*/
	console.log("data = " + JSON.stringify(data));
	console.log("warnResultList");
	warnResultTable = refreshData(tabId,url,data,columns,columnDefs,true);
	
});	
 
//模糊查询
function reloadwarnResultTable() {
	// 查询内容
	var content = $("#warnresult_search_content").val();
	var grade = $("#sel_search_warngrade").val();
	var startTime = $("#cross_startTime").val();
	var endTime = $("#cross_endTime").val();
	console.log("content = " + content);
	console.log("grade = " + grade);
	refreshData(tabId,url,data,columns,columnDefs,true);
}