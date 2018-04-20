$().ready(function(){
	
	$("#cball").change(function(){		
		
		var cblist=$(".cb");//获取class=".cb"的checkbox
		
		for(var i=0;i<cblist.length;i++)
		{
			cblist[i].checked=$(this).attr("checked")=='checked'?'checked':'';		
		}
		
	});
	
	$("#saverolefunc").click(function(){
		var checkList="";//已选
		var cblist=$(".cb");
		var roleId=$("#roleid").val();
		for(var i=0;i<cblist.length;i++)
		{
			if(cblist[i].checked)
				checkList+=cblist[i].value + ",";
		}
		
		$.post("/saverolefunc.action",{'roleId':roleId,'checkList':checkList},
				function(result){
				if(result=="success")
					humane.success("保存成功");
				else
					humane.success("保存失败");
		},"html");
		
	});
});