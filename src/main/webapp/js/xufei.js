var path = $("#path").val();





    function xufeiKeyWord() {
        var servicetype = $("#servicetype").val();
        var serviceyear = $("#serviceyear").val();
        if (servicetype == "") {
            $("#serviceTip").html("请选择服务类型");
            $("#servicetype").focus();
        } else if (serviceyear == "") {
            $("#yearTip").html("请选择服务年限");
            $("#serviceyear").focus();
        } else {
            //清空提示
            $("#custom").html("");
            $("#serviceTip").html("");
            $("#yearTip").html("");

			//验证余额

			validateBalance(servicetype,serviceyear);




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
                    alert("对不起,您当前的余额不能支付本次申请,请充值后再进行重试");

                } else
                //余额充足,提交
                    submitXufei(servicetype,serviceyear);
            }, 'html');

    }


    //提交申请
    function submitXufei(servicetype,serviceyear) {
        $.post(path + "/agent/submitXufei",
            {
                keywordId: $("#kid").val(),
                servicetype: servicetype,
                serviceyear: serviceyear,
                keyword:$("#keyword").val(),
                price: $("#price").val()
            },
            function (result) {
                if (result != "failed") {
                    alert("恭喜您 ,关键词 [" + $("#keyword").val() + "]续费成功!");
                    top.location=path+"/agent/toKeyWordManage";
                }
            }, 'html');

    }







$("#servicetype").change(function(){
    jisuan();
});
$("#serviceyear").change(function(){
    jisuan();
});




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
                        alert("计算价格时出现异常,请重试 ");
                    } else {
                        $("#price").val(result);// result为返回金额
                    }
                }
            }
        )
    }
}
