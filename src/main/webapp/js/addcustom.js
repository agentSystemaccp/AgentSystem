var contactcount=0;
var path = $("#path").val();
	mover(1);
	//初始化日期	
	$("#regdate").val(new Date().format("yyyy-MM-dd"));
//	var date=new Date();	
//	$("#regdate").val(date.getFullYear()+"-"+date.getMonth()+"-"+date.getDay());

	
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
		var str="<tr><td><input type='text' name='contacts["+contactcount+"].contactsName'  value=''></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsTel' class='contactsTel' value=''></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsFax' class='contactsFax' value=''></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsEmail' class='contactsEmail' value=''></td>" +
				"<td><input type='text' name='contacts["+contactcount+"].contactsPost' value=''></td>" +
				"<td  onclick='delTr(this)'><a href='javascript:void()'>删除</a></td></tr>";
		$("#addtr").append(str);
		contactcount++;
	});
	
	//验证证件号码数字
	$("#cardnum").blur(function(){
		var t=$("#cardnum").val();
		if(!checkValidateNum(t))
			humane.error("证件号码请输入数字!");
	})





function delTr(obj){
	$(obj).parent().remove();
	contactcount--;
}
//验证,提交
function checksave(){
    var customname=$.trim($("#customname").val());
    //数据验证
    validate();

	$.post(path+"/agent/isexitcustomname",{"companyName":customname},function(result){
		if(result=="peat"){
            humane.error("对不起,该客户名称已存在");
		}else if(result=="nopeat"){
            customerSubmit(customname);
		}
	},'html');



}

function customerSubmit(customname) {


    $("#cform").ajaxSubmit({
        type:"post",
        url:path+"/agent/insertCustomer",
        dataType : 'json',
        success :function (result) {
            if(result=="success"){
                humane.success("添加[ "+customname+" ]成功!");
                window.location.href=path+"/agent/toCustomerManage";
            }else {
                humane.error("添加[ "+customname+" ]失败,请重新添加!")
            }
        }

    })
}

