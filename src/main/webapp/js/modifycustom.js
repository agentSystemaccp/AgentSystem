
    var contactcount=0;
    var path=$("#path").val();
    mover(1);
    contactcount=$("#contactcount").val();
    //初始化日期
    $("#regdate").val(new Date().format("yyyy-MM-dd"));



    //初始化customtypename
    $("#customtype").change(function(){
        $("#customtypename").val($("#customtype option:selected").text());
    });
    //初始化customcardtypename
    $("#customcardtype").change(function(){
        $("#customcardtypename").val($("#customcardtype option:selected").text());
    });

    //添加联系人
    $("#addcontact").click(function(){
        var trCount = $("#addtr").children("tr");
        var count=trCount.length;
        var str="<tr><td><input type='text' name='contacts["+count+"].contactsName'></td>" +
            "<td><input type='text' placeholder='13|5|8000000000' name='contacts["+count+"].contactsTel'></td>" +
            "<td><input type='text' placeholder='0111-1111111' name='contacts["+count+"].contactsFax'></td>" +
            "<td><input type='text' placeholder='zhangsan-001@gmail.com' name='contacts["+count+"].contactsEmail'></td>" +
            "<td><input type='text' name='contacts["+count+"].contactsPost'></td>" +
            "<td  onclick='delTr(this)'><a href='javascript:void();'>删除</a></td></tr>";
        $("#addtr").append(str);
        count++;
    });

    //验证证件号码数字
    $("#cardnum").blur(function(){
        var t=$("#cardnum").val();
        if(!checkValidateNum(t))
            $.MsgBox.Alert("消息","证件号码请输入数字!");
    })


    function delTr(obj){
        var contactsId = $(obj).parent().children(":first").val();
        if(contactsId!=0){
            $.ajax({
                type:"post",
                url:path+"/agent/delContacts?contactsId="+contactsId,
                success :function (data) {
                    if(data=="false"){
                        $.MsgBox.Alert("消息","删除联系失败!请联系管理员");
                    }else {
                        $(obj).parent().remove();
                        contactcount--;
                    }
                }

            })
        }else {
            $(obj).parent().remove();
            contactcount--;
        }

    }
//验证,提交
    function checksave(){
        //数据验证
        if(validate()){
            var customname=$("#customname").val();
            $("#cform").ajaxSubmit({
                type:"post",
                url:path+"/agent/updateCustomer",
                async: false,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success :function (data) {
                    if(data=="success"){
                        $.MsgBox.Alert("消息","修改 [ "+customname+" ]成功!","/agent/toCustomerManage");
                    }else {
                        $.MsgBox.Alert("消息","修改[ "+customname+" ]失败,请重新修改!")
                    }
                }

            })
        }

    }



