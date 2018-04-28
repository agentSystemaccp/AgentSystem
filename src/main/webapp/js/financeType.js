//点击添加按钮 出现添加弹框
$("#addFinanceType").on("click",function () {
    $("#addFinanceDiv").css({"visibility":"visible","display":"block"});
});

//点击添加文本框去取消按钮  关闭添加弹框
$("#closeFinanceForm").on("click",function () {
    $("#addFinanceDiv").css({"visibility": "hidden", "display": "none"});
});

//添加类型时验证类型名是否存在
$("#addFinanceTypeName").on("blur",function () {
    var $typeName = $("#addFinanceTypeName").val();
    //验证类型名称是否为空
    if($typeName.length == 0){
        alert("类型名称不能为空");
        return false;
    }
    $.ajax({
        type:"post",
        data:{typeName:$typeName},
        url:path+"/type/checkType",
        dataType:"json",
        success:function (data) {
            if(data == "1"){

            }else{
                alert("类型已存在,请重新填写类型");
            }
        }
    });
});

//添加类型保存按钮点击事件
$("#addFinanceSave").on("click",function () {
    //提交数据
    $.ajax({
        type:"post",
        data:$("#addFinanceTypeFrom").serialize(),      //序列化成封装的类
        url:path+"/type/addType",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                alert("添加类型成功");
                window.location.href=path+"/type/queryFinanceType";
            }else{
                alert("添加类型失败")
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
                    alert("删除["+obj.attr("typeName")+"]配置成功");
                    window.location.href=path+"/type/queryFinanceType";
                }else{
                    alert("删除["+obj.attr("typeName")+"]配置失败");
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
    $("#modifyFinanceDiv").css({"visibility":"visible","display":"block"});
});

//修改类型时验证类型名是否存在和验证类型名是否为空
$("#modifyTypeName").on("blur",function () {
    var $typeName = $("#modifyTypeName").val();
    //验证类型名称是否为空
    if($typeName.length == 0){
        alert("类型名称不能为空");
        return false;
    }
    $.ajax({
        type:"post",
        data:{typeName:$typeName},
        url:path+"/type/checkType",
        dataType:"json",
        success:function (data) {
            if(data == "1"){

            }else{
                alert("类型已存在,请重新填写类型");
            }
        }
    });
});

//点击取消修改时,关闭修改弹框
$("#closeModifyFinanceForm").on("click",function () {
    $("#modifyFinanceDiv").css({"visibility": "hidden", "display": "none"});
});

//点击修改保存时,提示表单
$("#modifyFinanceSave").on("click",function () {
   $.ajax({
       type:"post",
       data:$("#modifyFinanceFrom").serialize(),      //序列化成封装的类
       url:path+"/type/updateType",
       dataType:"json",
       success:function (data) {
           if(data == "1"){
               alert("修改类型成功");
               window.location.href=path+"/type/queryFinanceType";
           }else{
               alert("修改类型失败")
           }
       }
   })
});