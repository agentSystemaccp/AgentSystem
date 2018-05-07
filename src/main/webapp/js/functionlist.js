$().ready(function(){
	var path=$("#path").val();
	$("#cball").change(function(){		
		
		var cblist=$(".cb");//获取class=".cb"的checkbox
		
		for(var i=0;i<cblist.length;i++)
		{
			cblist[i].checked=$(this).attr("checked")=='checked'?'checked':'';		
		}
	});
	
	$("#saverolefunc").click(function(){
		var checkList="";//已选
        var dian=",";
		var cblist=$(".cb");
		var roleId=$("#roleid").val();
		for(var i=0;i<cblist.length;i++)
		{
			if(cblist[i].checked)
				checkList+=cblist[i].value + ",";
		}
		
		$.post(path+"/resource/saverolefunc/"+roleId+dian+checkList,
				function(result){
				if(result=="success")
					$.MsgBox.Alert("消息","保存成功");
				else
                    $.MsgBox.Alert("消息","保存失败");
            window.location.href=path+"/resource/resourceList/"+roleId;
		},"html");
		
	});
});