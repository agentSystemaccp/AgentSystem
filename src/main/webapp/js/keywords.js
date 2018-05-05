/**
 * 关键词申请模块
 * @type {number}
 */


var customID = -1;
var customName = "";
var path = $("#path").val();

window.onload = function () {

    mover(1);

    $("#searchusertext").keyup(function () {

        loadCustoms();
    });
    $("#searchusertext").click(function () {

        loadCustoms();
    });


    //关键词失焦事件
    $("#keyword")
        .blur(
            function () {

                var keyword = $("#keyword").val();
                var servicetype = $("#servicetype")
                    .val();
                var years = $("#serviceyear").val();
                if (keyword == null
                    || keyword.length == 0)
                    $.MsgBox.Alert("消息","对不起,您申请的关键词不能为空.请重新填写!");
                    // humane.error("对不起,您申请的关键词不能为空.请重新填写!");
                else {
                    $("#keywordtip").html("<font color='green'>正在验证关键词是否已被抢占</font>");

                    $.post(path + "/agent/valikey",
                            {
                                "keyword": keyword
                            },
                            function (result) {
                                if (result == "success") {
                                    $("#keywordtip").html(
                                            "<font color='green'>恭喜您 ["
                                            + keyword
                                            + "]可以被注册!</font>");
                                } else
                                    $("#keywordtip").html(
                                        "<font color='red'>对不起,您申请的关键词 ["
                                        + keyword
                                        + "]已被抢占</font>");
                            }, 'html');
                }
            });


    //调用计算方法
    $("#servicetype").change(function () {
        jisuan();
    });
    $("#serviceyear").change(function () {
        jisuan();
    });


//加载服务类别
    $.ajax({
        type: "post",
        url: path + "/agent/loadServiceType",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            if (data != null) {
                var option = "<option value=\"\">----请选择----</option>";
                for (var i = 0; i < data.length; i++) {
                    option += "<option value='" + data[i].typeId + "'>" + data[i].typeName + "</option>"
                }
                $("#servicetype").html("");
                $("#servicetype").append(option);

            }
        }
    })
};


// 根据选择的服务类型及服务年限自动计算价格
function jisuan() {

    var servicetype = $("#servicetype").val();
    var serviceyear = $("#serviceyear").val();
    if (servicetype == "") {
        $("#serviceTip").html("请选择服务类型!");
        $("#servicetype").focus();
    } else if (serviceyear == "") {
        $("#yearTip").html("请选择服务年限!");
        $("#serviceyear").focus();
    } else {
        $("#yearTip").html("");
        $("#serviceTip").html("");


        $.ajax({
                type: "post",
                url: path + "/agent/calculate",
                data: {servicetype: servicetype, serviceyear: serviceyear},
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (result) {
                    if (result == "exception") {
                        $.MsgBox.Alert("消息","计算价格时出现异常,请重试! ");
                        // humane.error("计算价格时出现异常,请重试 ");
                    } else {
                        $("#price").val(result);// result为返回金额
                    }
                }
            }
        )
    }
}




//关键词申请



function submitKeyWord() {
    var servicetype = $("#servicetype").val();
    var serviceyear = $("#serviceyear").val();
    if (customID < 0) {
        humane.error("对不起,请选择客户!");
        $("#searchusertext").focus();
    } else if ($("#keyword").val() == '' || $("#keyword").val().length <= 0) {
        // humane.error("对不起,您申请的关键词不能为空!");
        $.MsgBox.Alert("消息","对不起,您申请的关键词不能为空!");
        $("#keyword").focus();
        } else if (servicetype == "") {
        $.MsgBox.Alert("消息","请选择服务类型!");
        // humane.error("请选择服务类型!");
        $("#servicetype").focus();
    } else if (serviceyear == "") {
        $.MsgBox.Alert("消息","请选择服务年限!");
        // humane.error("请选择服务年限!");
        $("#serviceyear").focus();
    } else {
        //清空提示
        $("#custom").html("");
        $("#serviceTip").html("");
        $("#yearTip").html("");

        //再次验证关键词

        $.post(path + "/agent/valikey",
            {
                "keyword": $("#keyword").val()
            },
            function (result) {
                if (result == "success") {
                    //验证成功开始验证当前用户余额

                     validateBalance(servicetype,serviceyear);

                } else
                    $.MsgBox.Alert("消息","对不起,您申请的关键词 [" + $("#keyword").val() + "]已被抢占!");
                    // humane.error("对不起,您申请的关键词 [" + $("#keyword").val() + "]已被抢占");
            }, 'html');


    }
};


//验证余额
function validateBalance(servicetype,serviceyear) {


    $.post(path + "/agent/valiBalance",
        {
            balance: $("#price").val()
        },
        function (result) {
            if (result == "nomoney") {
                humane.error("对不起,您当前的余额不能支付本次申请,请充值后再进行重试");

            } else
            //余额充足,提交
                submitAdd(servicetype,serviceyear);
        }, 'html');

}


//提交申请
function submitAdd(servicetype,serviceyear) {
    $.post(path + "/agent/submitkeyword",
        {
            keyword: $("#keyword").val(),
            customerId: customID,
            servicetype: servicetype,
            serviceyear: serviceyear,
            price: $("#price").val()
        },
        function (result) {
            if (result != "failed") {
                $.MsgBox.Alert("消息","恭喜您 ,您提交的关键词[" + $("#keyword").val() + "]申请成功!","/agent/toKeyWordManage");
                // window.location.href=path+"/agent/toKeyWordManage";


            }

        }, 'html');


}









// 加载当前代理商所有客户
function loadCustoms() {
    $.ajax({
        type: "post",
        url: path + "/agent/searchcustomer",
        data: {companyName: $("#searchusertext").val()},
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (result) {
            var customList = "<ul>";
            for (var i = 0; i < result.length; i++) {
                customList = customList + "<li onclick=\"confirmCustom('"
                    + result[i].customerId + "','" + result[i].companyName
                    + "')\"><span>客户类型: &nbsp;" + result[i].type.typeName
                    + "</span><br>" + result[i].companyName + "</li>";
            }
            customList += "</ul>";
            $("#serachresult").html(customList);
            $("#serachresult").slideDown();
        }
    })


}

function confirmCustom(id, name) {
    customID = id;
    customName = name;
    $("#searchusertext").val(name);
    $("#serachresult").hide();
    $("#customname").val(name);

}