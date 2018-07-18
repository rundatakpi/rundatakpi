//页面初始化
var resultReportTable ; 
var tabId = "resultReportTable";
var url = "/warntest/resultReport/list";
var data = {
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
    data: "warnOption"
},
{
    data: "concreteWarnOption"
},
{
    data: "nodeIp"
},
{
    data: "warnGrade"
},
{
    data: "warnTime"
},
{
    data: "personInCharge"
},
{
    data: "notifyObject"
},
{
    data: "notifyObjectRole"
},
{
    data: "contract"
},
{
    data: "reportStatus"
},
{
    data: "operation"
}
];

var  columnDefs = [
{
   	targets: [7],
	createdCell: function(td, cellData, rowData, row, col) {
		$(td).attr("style", "background:#FF0000");
   	}
}];

$(function() {
	/*if (warnResultTable) {
		warnResultTable.fnClearTable();
		warnResultTable.fnDestroy;
	}*/
	resultReportTable = refreshData(tabId,url,data,columns,columnDefs,true);
});	
 
//模糊查询
function reloadReportResultTable() {
	refreshData(tabId,url,data,columns,columnDefs,true);
}

function resetResultReportTable() {
//	$("#sel_search_warngrade").val('');
//	$("#sel_search_warnsource").val('');
//	$("#cross_startTime").val('');
//	$("#cross_endTime").val('');
	refreshData(tabId,url,data,columns,columnDefs,true);
}

function exportResultReportTable() {
	console.log("exportResultReportTable");
}