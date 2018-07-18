//页面初始化
var reportLogTable ; 
var reportLogTabId = "reportLogTable";
var reportLogUrl = "/warntest/reportLog/list";
var reportLogData = {
};

//定义列名称
var reportLogColumns = [{
    data: "id"
},
{
    data: "messageType"
},
{
    data: "sendStatus"
},
{
    data: "sendTime"
},
{
    data: "notifyObject"
},
{
    data: "notifyObjectRole"
},
{
    data: "receiveNum"
},
{
    data: "messageContent"
}];

var reportLogColumnDefs = [
{
   	targets: [2],
	createdCell: function(td, cellData, rowData, row, col) {
		$(td).attr("style", "background:#FF0000");
   	}
}];

$(function() {
	/*if (warnResultTable) {
		warnResultTable.fnClearTable();
		warnResultTable.fnDestroy;
	}*/
	reportLogTable = refreshData(reportLogTabId, reportLogUrl, reportLogData, reportLogColumns, reportLogColumnDefs, true);
	
});	
 
//模糊查询
function reloadReportLogTable() {
	refreshData(reportLogTabId, reportLogUrl, reportLogData, reportLogColumns, reportLogColumnDefs, true);
}

function exportReportLogTable() {
	console.log("exportReportLogTable ");
}

