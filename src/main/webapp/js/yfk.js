
var path=$("#path").val();
function searchyfklistFunc(){
	
	if(comtime($("#starttime").val(),$("#endtime").val()))
	{
		humane.error("开始时间大于结束时间,请检查");
		return false;
	}
	return true;
}

function comtime(s,e){
	var arr1=s.split("-");
	var starttime=new Date(arr1[0],arr1[1],arr1[2]);
	var ss=starttime.getTime();
	
	var arr2=e.split("-");
	var endtime=new Date(arr2[0],arr2[1],arr2[2]);
	var es=endtime.getTime();
	return ss>es;
	
	
}


//加载下拉框
$.ajax({
	type:"post",
	url:path+"/agent/loadType?parentId="+2,
	success:function (data) {
		$("#typeList").html("");
		var typeList="<option value=\"\">--请选择--</option>";
		for (var i=0;i<data.length;i++){
			typeList+="<option value="+data[i].typeId+">"+data[i].typeName+"</option>";
		}
		$("#detailType").append(typeList);
    }
})

$("#searchList").click(function () {
    var starttime = $("#starttime").val();
    var endtime = $("#endtime").val();
    loadDetailList("",starttime,endtime);
    return;
})

loadDetailList();
//加载详情列表
function loadDetailList(pageIndex,starttime,endtime) {
    if (typeof(pageIndex) == "undefined"||typeof(pageIndex) == ""){
        pageIndex="1";
    }
    if (typeof(starttime) == "undefined"){
        starttime=$("#starttime").val();
    }
    if (typeof(endtime) == "undefined"){
        endtime=$("#endtime").val();
    }
    //加载列表
    $.ajax({
		type:"post",
		url:path+"/agent/loadDetailList",
		data:{detailType:$("#detailType").val(),starttime:starttime,endtime:endtime,pageIndex:pageIndex},
		success:function (data) {

			if(data.pageList.length==0){
                $("#accountdetail").html("");
                humane.error("没有搜索到任何关键词的信息!");
                $("#accountdetail").html("<h2 style='font-weight: 400;' align='center'></h2>");
                $(".pagination").html("");
			}else {

                $("#accountdetail").html("");

                var detailList="";
                for (var i=0;i<data.pageList.length;i++){
                    var createTime = new Date(data.pageList[i].createTime);
                    detailList+="<tr>" +
                        "        <td>"+(i+1)+" </td>" +
                        "        <td>"+data.pageList[i].financeType+"</td>" +
                        "        <td>￥"+data.pageList[i].financeFund+"</td>" +
                        "        <td>￥"+data.pageList[i].balance+"</td>" +
                        "        <td>"+data.pageList[i].remark+"</td>" +
                        "        <td>"+createTime.getFullYear()+"-"+(createTime.getMonth()+1)+"-"+createTime.getDate()+"</td>" +
                        "      </tr>";
                }
                $("#accountdetail").append(detailList);

                var page="<ul>\n" +
                    "            <li><a href=\"javascript:;\" onclick=\"loadDetailList(1)\">首页</a> </li>";
                if(data.totalPage>2){
                    for (var i=0;i<data.totalPage-2;i++){
                        page+=" <li><a href=\"javascript:;\" onclick=\"loadDetailList(" +
                            (i+2)+")\">"+(i+2)+"</a></li>";
                    }
                }
                page+="<li><a href=\"javascript:;\" onclick= \"loadDetailList("+data.totalPage+")\">尾页</a></li></ul>";
                $(".pagination").html("");
                $(".pagination").append(page);

        }
        }
	})



	}



