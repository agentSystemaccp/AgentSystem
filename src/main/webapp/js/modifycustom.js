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
		var str="<tr><td><input type='text' name='contacts["+contactcount+"].contactsName'></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsTel'></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsFax'></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsEmail'></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsPost'></td>" +
				"<td  onclick='delTr(this)'><a href='javascript:void();'>删除</a></td></tr>";
		$("#addtr").append(str);
		contactcount++;
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
	$(obj).parent().remove();
	contactcount--;
}
//验证,提交
function checksave(){
	var customname=$.trim($("#customname").val());
	var customtypename=$("#customtypename").val();
	var customcardtype=$("#customcardtype").val();
	if(customname=='')
	{
		alert("客户名称不能空");
		return ;
	}
	if(customtypename==''){
		alert("客户类型不能为空");
		return ;		
	}
/*	var t=$("#cardnum").val();
	if(!checkValidateNum(t))
		humane.error("证件号码请输入数字!");
	
	*/
    $("#cform").ajaxSubmit({
        type:"post",
        url:path+"/agent/updateCustomer",
        dataType : 'json',
        async: false,
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



