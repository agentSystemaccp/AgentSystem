
$(document).ready(function () {
    var path=$("#path").val();
    var $info = $(".smenu").empty();
    $(".showChildMenu").click(function () {
        var obj = $(this);
        var son ="";
        $(".smenu").html("");
        $.ajax({
            type: "GET",
            url: path + "/menu/manage/" + obj.attr("menuid"),
            dataType: "json",
            success: function (data) {
                $.MsgBox.Alert("消息",data[1].menu.menu_id);
                son+="<li id=\"s_"+data[1].menu.menu_id+"\" class=\"s_li\">";
                for (var i = 0; i < data.length; i++) {
                    son+= "<a href=\""+path+ data[i].resourceUrl + "\">"+data[i].resourceName+"</a>\n";
                }
                son+="</li>";
                $info.append(son);
            }
        })
    })
})