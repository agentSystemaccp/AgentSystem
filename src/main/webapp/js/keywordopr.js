var path=$("#path").val();
	mover(1);
	//开通app
	$("#keywordManage").on("click",".openapp",function () {
		var obj=$(this);
		var kid=obj.attr("kid");
		var keyword=obj.attr("keyword");
		
		//json方式传参数  JSON.parse(jsonStr)  =>  javascriptobjct
		//注意与普通传参方式的区别
		ymPrompt.win({
			message:path+"/agent/openapp?kid="+kid,
			width:600,
			height:400,
			title:'开通【'+keyword+'】app',
			handler:callback,
			iframe:true
		});
		
	});
	//续费
    $("#keywordManage").on("click",".xufei",function () {
		var obj=$(this);
		var kid=obj.attr("kid");
		var keyword=obj.attr("keyword");
		ymPrompt.win({
			message:path+"/agent/xufei?kid="+kid,
			width:600,
			height:400,
			title:'当前为【'+keyword+'】进行续费操作',
			handler:callback,
			iframe:true
			
		});
	});


function callback(){
	window.location.reload(true);
}