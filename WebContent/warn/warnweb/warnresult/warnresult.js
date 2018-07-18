//页面初始化
var warnResultTable ; 
var warnResultTableId = "warnResultTable";
var warnResultUrl = "/rundatakpi/warnResult/list";
var warnResultTableData = {
	"warnGrade":$("#sel_search_warngrade").val(),
	"warnSource":$("#sel_search_warnsource").val(),
	"startTime":$("#cross_startTime").val(),
	"endTime":$("#cross_endTime").val()
};

//定义列名称
var warnResultTableColumns = [
{
    orderable: false,
    className: 'select-checkbox',
    targets:   0
},                              
{
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

var  warnResultTableColumnDefs = [
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
//	console.log("data = " + JSON.stringify(data));
//	console.log("warnResultList");
	warnResultTable = refreshData(warnResultTableId, warnResultUrl, warnResultTableData, warnResultTableColumns, warnResultTableColumnDefs, true);
	
});	
 
//模糊查询
function reloadWarnResultTable() {
	var content = $("#warnresult_search_content").val();
	var grade = $("#sel_search_warngrade").val();
	var startTime = $("#cross_startTime").val();
	var endTime = $("#cross_endTime").val();
	console.log("content = " + content);	console.log("grade = " + grade);
	console.log("startTime = " + startTime);
	console.log("endTime = " + endTime);
	
	var data = {
		"warnGrade":$("#sel_search_warngrade").val(),
		"warnSource":$("#sel_search_warnsource").val(),
		"startTime":$("#cross_startTime").val(),
		"endTime":$("#cross_endTime").val()
	};
	refreshData(warnResultTableId, warnResultUrl, data, warnResultTableColumns, warnResultTableColumnDefs, true);
}

function resetWarnResultTable() {
	$("#sel_search_warngrade").val('');
	$("#sel_search_warnsource").val('');
	$("#cross_startTime").val('');
	$("#cross_endTime").val('');
	refreshData(warnResultTableId, warnResultUrl, data, warnResultTableColumns, warnResultTableColumnDefs, true);
}

function exportWarnResultTable() {
	console.log("exportWarnResultTable");
}