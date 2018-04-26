
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
            "<td><input type='text' name='contacts["+count+"].contactsTel'></td>" +
            "<td><input type='text' name='contacts["+count+"].contactsFax'></td>" +
            "<td><input type='text' name='contacts["+count+"].contactsEmail'></td>" +
            "<td><input type='text' name='contacts["+count+"].contactsPost'></td>" +
            "<td  onclick='delTr(this)'><a href='javascript:void();'>删除</a></td></tr>";
        $("#addtr").append(str);
        count++;
    });

    //验证证件号码数字
    $("#cardnum").blur(function(){
        var t=$("#cardnum").val();
        if(!checkValidateNum(t))
            alert("证件号码请输入数字!");
    })


    function checkValidateNum(value){

        var reg=new RegExp("^[0-9]*$");
        if(reg.test(value))
            return true;
        else
            return false;
    }
    function delTr(obj){
        var contactsId = $(obj).parent().children(":first").val();
        if(contactsId!=0){
            $.ajax({
                type:"post",
                url:path+"/agent/delContacts?contactsId="+contactsId,
                success :function (data) {
                    if(data=="false"){
                        alert("删除联系失败!请联系管理员");
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
        var customname=$.trim($("#customname").val());
        var customcardtype=$("#customcardtype").val();
        var companyType=$("#companyType").val();
        var customprovince=$("#customprovince").val();
        var customcity=$("#customcity").val();
        var legalRepresentative =$("#legalRepresentative").val();
        var cardnum = $("#cardnum").val();
        var companyTel = $("#companyTel").val();


        if(customname=='')
        {
            alert("客户名称不能空");
            return ;
        }
        if(customcardtype==''){
            alert("请选择证件类型");
            return ;
        }

        if(cardnum.length==0)
        {
            alert("证件号码不能为空!");
            return ;
        }
        if(legalRepresentative.length==0)
        {
            alert("法人代表不能为空!");
            return ;
        }
        if(companyType==''){
            alert("请选择企业类型!");
            return ;
        }
        if(customcardtype==''){
            alert("请选择证件类型!");
            return ;
        }
        if(customprovince==''){
            alert("请选择省份!");
            return ;
        }
        if(customcity==''){
            alert("请选择城市!");
            return ;
        }
        if(companyTel.length==0){
            alert("请公司电话不能为空!");
            return ;
        }


        /*	var t=$("#cardnum").val();
            if(!checkValidateNum(t))
                humane.error("证件号码请输入数字!");

            */



        $("#cform").ajaxSubmit({
            type:"post",
            url:path+"/agent/updateCustomer",
            async: false,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success :function (data) {
                if(data=="success"){
                    alert("修改 [ "+customname+" ]成功!");
                    window.location.href=path+"/agent/toCustomerManage";
                }else {
                    alert("修改[ "+customname+" ]失败,请重新修改!")
                }
            }

        })



    }



