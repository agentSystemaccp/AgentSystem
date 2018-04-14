$().ready(function(){
	mover(1);
	//开通app
	$(".openapp").click(function(){
		var obj=$(this);
		var kid=obj.attr("kid");
		var keyword=obj.attr("keyword");
		
		//json方式传参数  JSON.parse(jsonStr)  =>  javascriptobjct
		//注意与普通传参方式的区别
		ymPrompt.win({
			message:"/openapp.action?keywords.id="+kid,
			width:600,
			height:400,
			title:'开通['+keyword+']app',
			handler:callback,
			iframe:true
		});
		
	});
	//续费
	$(".xufei").click(function(){
		var obj=$(this);
		var kid=obj.attr("kid");
		var keyword=obj.attr("keyword");
		ymPrompt.win({
			message:"/xufei.action?keywords.id="+kid,
			width:600,
			height:400,
			title:'当前为['+keyword+']进行续费操作',
			handler:callback,
			iframe:true
			
		});
	});
	//删除
	$(".deletekeyword").click(function(){
		var obj=$(this);
		var kid=obj.attr("kid");
		var keyword=obj.attr("keyword");
		if(confirm("为了数据安全,需要您两次确认才能删除,您确定要删除关键词["+keyword+"]吗?(一次)"))
			if(confirm("为了数据安全,需要您两次确认才能删除,您确定要删除关键词["+keyword+"]吗?(两次)"))
			{
				$.post("/deletekeyword.action",{"keywords.id":kid},function(result){
					
					if(result=="success")
						{
							humane.success("删除成功!");
							window.location.reload(true);
						}else
							{
							humane.success("删除失败!");
							}
					
				},"html");
				
			}
	});
});

function callback(){
	window.location.reload(true);
}