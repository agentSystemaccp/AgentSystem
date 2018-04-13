
$(document).ready(function () {
    var path=$("#path").val();
    $("#login").click(function () {

        $("#myLogin").ajaxSubmit({
            type: "post",
            url:path+ "/user/login",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (data) {
                if(data=='0'){
                    alert("账户或密码错误!");
                }else {
                    //空跳至代理商管理页面
                    window.location.href="user/toManage";
                }
            }
        })
    })




})


