
/*
* 关键词申请管理模块
* */
var path=$("#path").val();



    loadKeyWordList();

    $("#submitkeyword").click(function () {
        var keyword = $("#keyword").val();
        loadKeyWordList("",keyword);
        return;
    })







function loadKeyWordList(pageIndex,keyword) {
    if (typeof(pageIndex) == "undefined"||typeof(pageIndex) == ""){
        pageIndex="1";
    }
    if (typeof(keyword) == "undefined"){
        keyword=$("#keyword").val();
    }

    $.ajax({
        type: "post",
        url: path + "/agent/keyWordsList",
        data: {keyword:keyword,pageIndex: pageIndex},
        success: function (data) {

            if(data.totalRows==0){
                $.MsgBox.Alert("消息","对不起!暂无数据!");
            }else {
                $("#keywordManage").html("");
                $(".pagination").html("");
                var table = "";
                for (var i=0;i<data.pageList.length;i++){
                    var createTime = new Date(data.pageList[i].createTime);
                    //到期时间
                    var maturity=(createTime.getFullYear()+data.pageList[i].term)+"-"+(createTime.getMonth()+1)+"-"+createTime.getDate();
                    var time = new Date(Date.parse(maturity));
                    var checkStatus = data.pageList[i].checkStatus==1 ? '已申请':data.pageList[i].checkStatus == 2 ? '审核中':data.pageList[i].checkStatus ==  3 ? '已通过':'未通过';

                    table+="<tr align='center' style='width: auto'>"
                    +"<td>"+(i+1)+"</td>"
                    +"<td>"+data.pageList[i].keyword+"</td>"
                    +"<td>"+data.pageList[i].customer.companyName+"</td>"
                    +"<td>"+data.pageList[i].user.userName+"</td>"
                    +"<td>"+data.pageList[i].term+"</td>"
                    +"<td>"+createTime.getFullYear()+"-"+(createTime.getMonth()+1)+"-"+createTime.getDate()+"</td>"
                    +"<td>"+maturity+"</td>"
                    +"<td>"+(time>new Date() ? '未过期':'已过期')+"</td>"
                    +"<td>"+checkStatus+"</td>"
                    +"<td>"+(data.pageList[i].useStatus==1 ? '已使用': '未使用')+"</td>"
                    +"<td>"+(data.pageList[i].appStatus==1 ? '已开通': '未开通')+"</td>"
                    +"<td class='opr'>";

                    if(data.pageList[i].keywordStatus==1){
                        //APP未开通且审核通过
                        if(data.pageList[i].appStatus==2 && data.pageList[i].checkStatus==3){
                            table+="<a href='#' kid='"+data.pageList[i].keywordId+"' keyword='"+data.pageList[i].keyword+"' class=\"openapp\">开通APP</a>&nbsp;&nbsp;";
                        }
                        //已审核且aap已开通
                        if(data.pageList[i].checkStatus==3&&data.pageList[i].appStatus==1){
                            table+="<a href='#' kid='"+data.pageList[i].keywordId+"' keyword='"+data.pageList[i].keyword+"' class=\"xufei\">续费</a>";
                        }

                        if(data.pageList[i].checkStatus!=3){
                            table+="无操作";
                        }
                    }
                    table+="</td></tr>";

                }

                $("#keywordManage").append(table);

                $(".opr").css({"color":"#999"});



                var page="<ul>\n" +
                    "            <li><a href=\"javascript:;\" onclick=\"loadKeyWordList(1)\">首页</a> </li>";
                if(data.totalPage>2){
                    for (var i=0;i<data.totalPage-2;i++){
                        page+=" <li><a href=\"javascript:;\" onclick=\"loadKeyWordList(" +
                            (i+2)+")\">"+(i+2)+"</a></li>";
                    }
                }
                page+="<li><a href=\"javascript:;\" onclick= \"loadKeyWordList("+data.totalPage+")\">尾页</a></li></ul>";

                $(".pagination").append(page);
            }

        }
    })
}


