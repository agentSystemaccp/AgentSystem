

var path = $("#path").val();

mover(1);



    customerList();



$(".container").on("click","#searchCustomer",function () {
    var cname = $("#cname").val();
    customerList("",cname);
    return;
})
// $("#searchCustomer").click(function () {
//
// })

//客户列表
function customerList(pageIndex,cname) {
    if (typeof(pageIndex) == "undefined"||typeof(pageIndex) == ""){
        pageIndex="1";
    }
    if (typeof(cname) == "undefined"){
        cname=$("#cname").val();
    }

    $.ajax({
        type: "post",
        url: path + "/agent/customerList?cname="+cname,
        data: {pageIndex: pageIndex},
        success: function (data) {
            if(data.totalRows==0){
                humane.error("对不起!暂无数据!");
            }else {
                $("#customerManage").html("");
                $(".pagination").html("");
                var table = "";
                for (var i=0;i<data.pageList.length;i++){
                    var createTime = new Date(data.pageList[i].protal.createTime);
                    table+="<tr align='center' style='width: auto'>"
                        +"<td>"+(i+1)+"</td>"
                        +"<td>"+data.pageList[i].companyName+"</td>"
                        +"<td>"+data.pageList[i].protal.legalRepresentative+"</td>"
                        +"<td>"+createTime.getFullYear()+"-"+(createTime.getMonth()+1)+"-"+createTime.getDate()+"</td>"
                        +"<td>"+data.pageList[i].type.typeName+"</td>"
                        +"<td>"+(data.pageList[i].companyStatus==1 ? "启用":'停用')+"</td>"
                        +"<td class='funcli'><ul>"
                        +"<li><a class='viewCustom' style='color: blue' cid='"+data.pageList[i].customerId+"' >查看 </a> </li>"
                        +"<li><a class='modifyCustom' style='color: blue' cid='"+data.pageList[i].customerId+"'> 修改</a></li>"
                        +"<li><a class='mofifyCustomStatus' cid='"+data.pageList[i].customerId+"' customName='"+data.pageList[i].companyName+"' mStatus='"+data.pageList[i].companyStatus+"'>"
                        +(data.pageList[i].companyStatus==1 ? '停用':'启用')+"</a> </li></ul>"
                        table+="</td></tr>";

                }

                $("#customerManage").append(table);

                var startButton = $(".mofifyCustomStatus").val();
                if(startButton=="停用"){
                    $(".mofifyCustomStatus").css({color:"red"});
                }else {
                    $(".mofifyCustomStatus").css({color:"green"});
                }

                var page="<ul>\n" +
                    "            <li><a href=\"javascript:;\" onclick=\"customerList(1)\">首页</a> </li>";
                if(data.totalPage>2){
                    for (var i=0;i<data.totalPage-2;i++){
                        page+=" <li><a href=\"javascript:;\" onclick=\"customerList(" +
                            (i+2)+")\">"+(i+2)+"</a></li>";
                    }
                }
                page+="<li><a href=\"javascript:;\" onclick= \"customerList("+data.totalPage+")\">尾页</a></li></ul>";

                $(".pagination").append(page);
            }

        }
    })



}


//查看信息
$("#customerManage").on("click",".viewCustom",function () {
    var cid = $(this).attr("cid");
    window.location.href=path+"/protal/queryProtal?protalId="+0+"&cid="+cid+"&type=view";
})


//添加客户
$("#addCustomBtn").click(function () {
    window.location.href=path+"/agent/modifycustom?cid=0&type=add";
})

//修改客户
$("#customerManage").on("click",".modifyCustom",function () {
    var c=$(this);//a标签
    var c_id=c.attr("cid");
    window.location.href=path+"/agent/modifycustom?cid="+c_id+"&type=modify";
});

//修改客户状态
$("#customerManage").on("click",".mofifyCustomStatus",function () {

    var cid = $(this).attr("cid");
    var c_status=$(this).attr("mStatus");   //状态
    var c_customname=$(this).attr("customName");
    var action=c_status=="1"?"停用":"启用";
    var str="您是否确定要"+action+"[ "+c_customname+" ]这个客户?";

    if(confirm(str))
    {
        $.post(path+"/agent/modifycustomstatus",{"cid":cid,
                "customStatus":c_status},
            function(data){

                if(data=="success")
                {
                    humane.error(action+"成功");
                    window.location.reload(true);
                }
                else{
                    humane.error(action+"失败");
                }

            },'html');

    }
});
