//modifypwdbtna
//modifydiv
//oldpwdtext
//newpwd
//newpwd2
//modifypwdbtn
//modifypwdcancel



$().ready(function() {
    var path=$("#path").val();
    mover(1);

    //点击修改密码
    $("#modifypwdbtna").click(function () {
        $("#modifydiv").show();
        $("#oldpwdtext").val('');
        $("#newpwd").val('');
        $("#newpwd2").val('');
    });

    $("#oldpwdtext").blur(function () {
        if ($("#oldpwdtext").val() != "")
            $("#oldpwdtexttip").css("color", "green");
        else
            $("#oldpwdtexttip").css("color", "red");

    });
    $("#newpwd").blur(function () {

        if ($("#newpwd").val() != "")
            $("#newpwdtip").css("color", "green");
        else
            $("#newpwdtip").css("color", "red");
    });
    $("#newpwd2").blur(function () {

        if ($("#newpwd2").val() != "")
            $("#newpwd2tip").css("color", "green");
        else
            $("#newpwd2tip").css("color", "red");
    });

    $("#modifypwdbtn").click(function () {
        var oldpwd = $("#oldpwdtext").val();
        var newpwd = $("#newpwd").val();
        var newpwd2 = $("#newpwd2").val();
        if (oldpwd.length < 5) {
            $("#oldpwdtext").focus();
            alert("请输入原始密码");
        } else if (newpwd.length < 5) {

            $("#newpwd").focus();
            alert("密码长度不能小于6");
        } else if (newpwd2.length < 5) {

            $("#newpwd2").focus();
            alert("密码长度不能小于6");
        } else if (newpwd != newpwd2) {

            alert("两次密码不相同");
        } else {
            // 提交到服务器

            $.post(path+"/user/modifypwd", {
                'newpwd': newpwd
            }, function (result) {//alert(result.length);
                // "success",failed
                if (result == '1') {
                    alert("修改密码成功,请重新登录！");
                    $("#modifydiv").hide();
                    window.location.href=path+"/login.jsp";
                } else
                    alert("修改密码失败 ！");
            }, 'html');
        }

    });
    //点击取消代码
    $("#modifypwdcancel").click(function () {

        $("#modifydiv").hide();
        $("#oldpwdtext").val('');
        $("#newpwd").val('');
        $("#newpwd2").val('');
    });


    //注销
    $("#loginout").click(function () {
        if (confirm("你确定注销吗？")) {
            window.location.href = path+"/user/exit";
        }
    })


    //动态验证旧密码
    $("#oldpwdtext").change(function () {
        var oldpwd = $("#oldpwdtext").val();
        $.ajax({
            type: "POST",
            url: path+"/user/vlidatePassword",
            data: {oldpwd:oldpwd},
            success: function (data) {
                if(data=='1'){
                    $("#oldpwdtexttip").html("  <img src='"+path+"/images/修改密码/y.png' class='yimg'/>");
                }else {
                    $("#oldpwdtexttip").html("  <img src='"+path+"/images/修改密码/n.png' class='yimg' />");
                }
                $(".yimg").css({"width":"15","height":"15"});

            }
        })


    })
})


