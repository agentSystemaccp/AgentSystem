var path = $("#path").val();

function checksave(){
    $.ajax({
        	type:"post",//请求类型
        	url:path+"/protal/modifyProtal",//请求的url
        	data:$("#cform").serialize(),//请求参数
        	dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function (data) {
                if(data == '1'){
                    alert("修改成功");
                    window.location.href=path+"/protal/queryProtalList";
                }else{
                    alert("修改失败");
                }
            }
    })
}