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
		var str="<tr><td><input type='text' name='contactsList["+contactcount+"].contactsName'></td>" +
				"<td><input type='text' name='contactsList["+contactcount+"].contactsTel'></td>" +
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
	var companyType=$("#companyType").val();
	var customcardtype=$("#customcardtype").val();
    var customprovince=$("#customprovince").val();
    var customcity=$("#customcity").val();
    var legalRepresentative =$("#legalRepresentative").val();
    var cardnum = $("#cardnum").val();
    var companyTel = $("#companyTel").val();
	if(customname.length==0)
    {
        alert("客户名称不能为空!");
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
	$.post(path+"/agent/isexitcustomname",{"companyName":customname},function(result){
		if(result=="peat"){
            alert("对不起,该客户名称已存在");
		}else if(result=="nopeat"){
            $("#cform").submit();
            // $("#cform").ajaxSubmit({
            //     type:"post",
            //     url:path+"/agent/addCustomer",
            //     dataType:"josn",
            //     success:function (result) {
            //         if(result=="success"){
            //             alert("添加[ "+customname+" ]成功!")
            //             window.location.href=path+"/agent/customerList";
            //         }else {
            //             alert("添加[ "+customname+" ]失败,请重新添加!")
            //         }
            //     }
            //
            // })
		}
	},'html');



		
}



