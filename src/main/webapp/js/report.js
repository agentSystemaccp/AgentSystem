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