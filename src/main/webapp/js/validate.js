





//正则表达式验证
function checkValidateNum(value,format){
    var reg=new RegExp(format);
    if(reg.test(value))
        return true;
    else
        return false;
}





//数据验证
function validate() {
    var customname=$.trim($("#customname").val());
    var companyType=$("#companyType").val();
    var customcardtype=$("#customcardtype").val();
    var customprovince=$("#customprovince").val();
    var customcity=$("#customcity").val();
    var legalRepresentative =$("#legalRepresentative").val();
    var companyPages = $("#companyPages").val();
    var cardnum = $("#cardnum").val();
    var companyTel = $("#companyTel").val();
    var companyStatus=$("#companyStatus").val();
    var companyFax=$("#companyFax").val();
    var companyAddress=$("#companyAddress").val();


    var url="";
    if(customname.length==0)
    {
        $.MsgBox.Alert("消息","公司名称不能为空!");
        return ;
    }
    if(companyType==''){
        $.MsgBox.Alert("消息","请选择企业类型!");
        return ;
    }
    if(companyPages==''){
        $.MsgBox.Alert("消息","请输入企业主页地址!");
        return ;
    }else {
        url=new RegExp("^(http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$");
        if(checkValidateNum(companyPages,url)==false){
            $.MsgBox.Alert("消息","企业地址格式错误! 正确格式:http://www.baidu.com");
            return;
        }

    }
    if(companyStatus==''){
        $.MsgBox.Alert("消息","请选择启用状态!");
        return ;
    }
    if(legalRepresentative.length==0)
    {
        $.MsgBox.Alert("消息","法人代表不能为空!");
        return ;
    }
    if(cardnum.length==0)
    {
        $.MsgBox.Alert("消息","证件号码不能为空!");
        return ;
    }else {
        url=/^[0-9]*$/;
        if(checkValidateNum(cardnum,url)==false){
            $.MsgBox.Alert("消息","证件号码必须为数字!");
            return;
        }
    }

    if(customcardtype==''){
        $.MsgBox.Alert("消息","请选择证件类型!");
        return ;
    }
    if(customprovince==''){
        $.MsgBox.Alert("消息","请选择省份!");
        return ;
    }
    if(customcity==''){
        $.MsgBox.Alert("消息","请选择城市!");
        return ;
    }

    if(companyFax.length==0){
        $.MsgBox.Alert("消息","公司传真不能为空!");
        return ;
    }else {
        url =new  RegExp("^0\\d{2,3}-?\\d{7,8}$");
        if(checkValidateNum(companyFax,url)==false){
            $.MsgBox.Alert("消息","公司传真格式错误! 正确格式:0111-1111111");
            return;
        }
    }

    if(companyTel.length==0){
        $.MsgBox.Alert("消息","公司电话不能为空!");
        return ;
    }else {
        url=new RegExp("^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$");
        if(checkValidateNum(companyTel,url)==false){
            $.MsgBox.Alert("消息","公司电话格式错误! 正确格式:011-88888888");
            return;
        }
    }
    if(companyAddress.length==0){
        $.MsgBox.Alert("消息","公司地址不能为空!");
        return ;
    }

    var phone = document.getElementsByClassName("contactsTel");
    for (var i=0;i<phone.length;i++){
        url=new RegExp("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
        if(checkValidateNum(phone[i].value,url)==false){
            $.MsgBox.Alert("消息","联系电话格式错误!");
            return;
        }
    }
    var fax = document.getElementsByClassName("contactsFax");
    for (var i=0;i<fax.length;i++){
        url =new  RegExp("^0\\d{2,3}-?\\d{7,8}$");
        if(checkValidateNum(fax[i].value,url)==false){
            $.MsgBox.Alert("消息","传真格式错误! 正确格式:0111-1111111");
            return;
        }
    }
    var email = document.getElementsByClassName("contactsEmail");
    for (var i=0;i<email.length;i++){
        url=new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        if(checkValidateNum(email[i].value,url)==false){
            $.MsgBox.Alert("消息","邮箱格式错误! 正确格式:zhangsan-001@gmail.com");
            return;
        }
    }
}