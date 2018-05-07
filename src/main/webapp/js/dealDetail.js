var path=$("#path").val();


replace();

function replace(pageIndex) {
    if (typeof(pageIndex) == "undefined"){
        pageIndex="1";
    }
    $("#dealTable").html("");
    $(".pagination").html("");
    $.ajax({
        type: "post",
        url: path + "/deal/accountdetail",
        data: {pageIndex: pageIndex},
        success: function (data) {
            if(data.totalRows==0){
                $.MsgBox.Alert("消息","对不起!暂无数据!");
            }else {
                $("#dealTable").html();
                var table = "";
                for(var i=0;i<data.pageList.length;i++){
                    var createTime = new Date(data.pageList[i].createTime);

                    table+="<tr>"
                        +"<td>"+data.pageList[i].detailId+"</td>"
                        +"<td>"+data.pageList[i].financeType+"</td>"
                        +"<td>"+data.pageList[i].financeFund+"</td>"
                        +"<td>"+data.pageList[i].balance+"</td>"
                        +"<td>"+data.pageList[i].remark+"</td>"
                        +"<td>"+createTime.getFullYear()+"-"+(createTime.getMonth()+1)+"-"+createTime.getDate()+"</td></tr>";
                }
                $("#dealTable").append(table);

                var page="<ul>\n" +
                    "            <li><a href=\"javascript:;\" onclick=\"replace(1)\">首页</a> </li>";
                if(data.totalPage>2){
                    for (var i=0;i<data.totalPage-2;i++){
                        page+=" <li><a href=\"javascript:;\" onclick=\"replace(" +
                            (i+2)+")\">"+(i+2)+"</a></li>";
                    }
                }
                page+="<li><a href=\"javascript:;\" onclick= \"replace("+data.totalPage+")\">尾页</a></li></ul>";


                $(".pagination").append(page);
            }

        }
    })
}



