//点击添加按钮 出现添加弹框
$("#addFinanceType").on("click",function () {
    $("#addDiv").css({"visibility":"visible","display":"block"});
});

//点击添加文本框去取消按钮  关闭添加弹框
$("#closeForm").on("click",function () {
    $("#addDiv").css({"visibility": "hidden", "display": "none"});
});

//添加类型时验证类型名是否存在
$("#addFinanceTypeName").on("blur",function () {
    var $typeName = $("#addFinanceTypeName").val();
    //验证类型名称是否为空
    if($typeName.length == 0){
        humane.error("类型名称不能为空");
        return;
    }
    $.ajax({
        type:"post",
        data:{typeName:$typeName},
        url:path+"/type/checkType",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("类型名称可用");
            }else{
                humane.error("类型已存在,请重新填写类型");
                return;
            }
        }
    });
});

//添加类型保存按钮点击事件
$("#addSave").on("click",function () {
    //提交数据
    $.ajax({
        type:"post",
        data:$("#addTypeFrom").serialize(),      //序列化成封装的类
        url:path+"/type/addType",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("添加类型成功");
                window.location.href=path+"/type/queryFinanceType";
            }else{
                humane.error("添加类型失败")
            }
        }
    });
})

//删除选中的类型
$(".delType").on("click",function () {
    var obj = $(this);
    if(confirm("你确定要删除["+obj.attr("typeName")+"]配置吗?")){
        $.ajax({
            type:"post",
            data:{typeId:obj.attr("typeId")},
            url:path+"/type/delFinanceTypo",
            dateType:"json",
            success:function (data) {
                if(data == "1"){
                    humane.success("删除["+obj.attr("typeName")+"]配置成功");
                    window.location.href=path+"/type/queryFinanceType";
                }else{
                    humane.error("删除["+obj.attr("typeName")+"]配置失败");
                }
            }
        });
    }
});

//点击修改弹出对应的修改弹框
$(".modifyType").on("click",function () {
    var obj = $(this);
    $("#modifyFinanceId").val(obj.attr("typeId"));
    $("#modifyTypeName").val(obj.attr("typeName"));
    $("#modifyTypeStatus").val(obj.attr("status"));
    $("#modifyDiv").css({"visibility":"visible","display":"block"});
});

//修改类型时验证类型名是否存在和验证类型名是否为空
$("#modifyTypeName").on("blur",function () {
    var $typeName = $("#modifyTypeName").val();
    //验证类型名称是否为空
    if($typeName.length == 0){
        humane.error("类型名称不能为空");
        return false;
    }
});

//点击取消修改时,关闭修改弹框
$("#closeModifyForm").on("click",function () {
    $("#modifyDiv").css({"visibility": "hidden", "display": "none"});
});

//点击修改保存时,提示表单
$("#modifySave").on("click",function () {
   $.ajax({
       type:"post",
       data:$("#modifyFrom").serialize(),      //序列化成封装的类
       url:path+"/type/updateType",
       dataType:"json",
       success:function (data) {
           if(data == "1"){
               humane.success("修改类型成功");
               window.location.href=path+"/type/queryFinanceType";
           }else{
               humane.error("修改类型失败")
           }
       }
   })
});