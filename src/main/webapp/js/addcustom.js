var contactcount=0;

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
		var str="<tr><td><input type='text' name='contactsList["+contactcount+"].contactsName'></td>" +
				"<td><input type='text' name='contactsList["+contactcount+"].contacsTel'></td>" +
				"<td><input type='text' name='contactsList["+contactcount+"].contactsFax'></td>" +
				"<td><input type='text' name='contactsList["+contactcount+"].contactsEmail'></td>" +
				"<td><input type='text' name='contactsList["+contactcount+"].contactsPost'></td>" +
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
	if(customname.length==0)
	{
		humane.error("客户名称不能空");
		return ;
	}
	if(customtypename.length==0){
		humane.error("客户类型不能为空");
		return ;		
	}
/*	var t=$("#cardnum").val();
	if(!checkValidateNum(t))
		humane.error("证件号码请输入数字!");
	
	*/
	$.post("/isexitcustomname.action",{"custom.customName":customname},function(result){
		if(result=="peat"){
			humane.error("对不起,该客户名称已存在");
		}else if(result=="nopeat"){
			$("#cform").submit();
		}
	},'html');
		
}