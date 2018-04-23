var path = $("#path").val();


$("#openappSubmit").click(function(){
    var appCode=$("#appCode").val();
    var appPassword=$("#appPassword").val();
    if(appCode==""){
        alert("请输入登录账号！");
        $("#appCode").focus();
    }else if(appPassword==""){
        alert("请输入登录密码！");
        $("#appPassword").focus();
    }else{
        //提交
        $.ajax({
            type: "post",
            url:path+"/agent/openappSubmit",
            data:{appCode:appCode,appPassword:appPassword,keywordId:$("#keywordId").val()},
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (data) {
                if(data=='0'){
                    alert("系统错误,请重新开通!");
                }else {
                    //申请成功
                    alert("APP开通成功！");
                    top.location=path+"/agent/toKeyWordManage";
                }
            }
        })

    }
});



