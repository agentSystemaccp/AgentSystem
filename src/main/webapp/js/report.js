function searchReportFunc(){
	
	if(comtime($("#starttime").val(),$("#endtime").val()))
	{
		humane.error("开始时间大于结束时间,请检查");
		return false;
	}
	return true;
}
//
// $("#reporttype").change(function () {
//         if($(this).val()=="4"){
//             $("#opertime").html("");
// 			$("#butten").css({"margin-left":"250px","margin-top":" -20px"});
//         }else{
//             $("#opertime").html("");
//         	var opertime = "操作时间: <input type=\"text\" class=\"Wdate\"\n" +
//                 " size=\"15\" onfocus=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" id=\"starttime\" readonly=\"readonly\"\n" +
//                 "name=\"starttime\"> 至 <input type=\"text\" class=\"Wdate\" size=\"15\" onfocus=\"WdatePicker({dateFmt:'yyyy-MM-dd'})\" " +
// 				"id=\"endtime\"  readonly=\"readonly\"\n" +
//                 "name=\"endtime\">";
//             $("#opertime").append(opertime);
//             $("#butten").css({"margin-left":"580px","margin-top":" -20px"});
// 		}
// });


function comtime(s,e){
	var arr1=s.split("-");
	var starttime=new Date(arr1[0],arr1[1],arr1[2]);
	var ss=starttime.getTime();
	
	var arr2=e.split("-");
	var endtime=new Date(arr2[0],arr2[1],arr2[2]);
	var es=endtime.getTime();
	return ss>es;
	
	
}

//导出代理商余额数据为Excel
function accountExcel(starttime,endtime) {
    $.ajax({
        type: "get",
        data:{starttime:starttime,endtime:endtime},
        url:path + "/report/reportAccountExcel",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载代理商余额报表成功,文件下载到D盘");
            }else{
                humane.error("下载代理商余额报表失败");
            }
        }
    })
}

//导出代理商预付款流水报表为excel
function yfExcel(starttime,endtime) {
    $.ajax({
        type: "get",
        data:{starttime:starttime,endtime:endtime},
        url:path + "/report/reportYFExcel",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载代理商预付款流水报表成功,文件下载到D盘");
            }else{
                humane.error("下载代理商预付款流水报表失败");
            }
        }
    })
}

//导出代理商流水报表为excel
function userExcel(starttime,endtime) {
    $.ajax({
        type: "get",
        data:{starttime:starttime,endtime:endtime},
        url:path + "/report/reportUserExcel",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载代理商流水报表成功,文件下载到D盘");
            }else{
                humane.error("下载代理商流水报表失败");
            }
        }
    })
}

//产品分类数量/金额汇总报表为excel
function productExcel() {
    $.ajax({
        type: "get",
        url:path + "/report/reportProductExcel",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载产品分类数量/金额汇总报表成功,文件下载到D盘");
            }else{
                humane.error("下载产品分类数量/金额汇总报表失败");
            }
        }
    })
}

//导出代理商余额数据PDF
function accountPDF(starttime,endtime) {
    $.ajax({
        type: "get",
        data:{starttime:starttime,endtime:endtime},
        url:path + "/report/reportAccountPDF",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载代理商余额报表成功,文件下载到D盘");
            }else{
                humane.error("下载代理商余额报表失败");
            }
        }
    })
}

//导出代理商预付款流水报表PDF
function yfPDF(starttime,endtime) {
    $.ajax({
        type: "get",
        data:{starttime:starttime,endtime:endtime},
        url:path + "/report/reportYFPDF",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载代理商预付款流水报表成功,文件下载到D盘");
            }else{
                humane.error("下载代理商预付款流水报表失败");
            }
        }
    })
}

//导出代理商预付款流水报表PDF
function userPDf(starttime,endtime) {
    $.ajax({
        type: "get",
        data:{starttime:starttime,endtime:endtime},
        url:path + "/report/reportUserPDF",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载代理商预付款流水报表成功,文件下载到D盘");
            }else{
                humane.error("下载代理商预付款流水报表失败");
            }
        }
    })
}

//导出产品分类数量/金额汇总报表PDF
function productPDF() {
    $.ajax({
        type: "get",
        url:path + "/report/reportProductPDF",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("下载产品分类数量/金额汇总报表成功,文件下载到D盘");
            }else{
                humane.error("下载产品分类数量/金额汇总报表失败");
            }
        }
    })
}

$().ready(function(){
	mover(3);
	$("#reporttype").change(function(){
		if($("#reporttype").val()!=1)
		{
			$("#opertime").css("display","block");
		
		}else
		{
			$("#opertime").css("display","none");
		}
		
		
	});
	
	
});