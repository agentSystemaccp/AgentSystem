//点击添加类型时弹出添加的div
$("#addServiceType").on("click",function () {
    $("#addDiv").css({"visibility":"visible","display":"block"});
});

//关闭添加div
$("#closeForm"). on("click",function () {
    $("#addDiv").css({"visibility":"hidden","display":"none"});
});

//当失去焦点时验证类型名称是否为空并且验证类型是否存在
$("#addTypeName").on("blur",function () {
   var $typeName = $("#addTypeName").val();
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
           //类型名称不存在
           if(data == "1"){
               humane.success("类型名称可用");
               return;
           }else{
               humane.error("该类型已经存在,请重新填写");
               return;
           }
       }
   })
});


//当失去焦点时验证类型数值是否为空和是否为数值类型
$("#addAllocation").on("blur",function () {
    var $allocation = $("#addAllocation").val();
    if($allocation.length == 0){
        alert("类型数值不能为空");
        return;
    }
    if(isNaN($allocation)){
        humane.error("类型数值请输入数值");
        return;
    }
});

//点击添加类型保存按钮
$("#addSave").on("click",function () {
    $.ajax({
        type:"post",
        data:$("#addFrom").serialize(),
        url:path+"/type/addType",
        dataType:"json",
        success:function (data) {
            if(data == "1"){
                humane.success("添加类型成功");
                window.location.href = path+"/type/queryServiceType";
            }else {
                humane.error("添加类型失败");
            }
        }
    })
});

//点击修改是 弹出修改的div
$(".modifyType").on("click",function () {
    var obj = $(this);
    $("#modifyId").val(obj.attr("typeId"));
    $("#modifyTypeName").val(obj.attr("typeName"));
    $("#modifyAllocation").val(obj.attr("allocation"));
    $("#modifyTypeStatus").val(obj.attr("status"));
    $("#modifyDiv").css({"visibility":"visible","display":"block"});
});

//当失去焦点时验证类型名称是否
$("#modifyTypeName").on("blur",function () {
    var $typeName = $("#modifyTypeName").val();
    if($typeName.length == 0){
        humane.error("类型名称不能为空");
        return;
    }
});


//当失去焦点时验证类型数值是否为空和是否为数值类型
$("#modifyAllocation").on("blur",function () {
    $allocation = $("#modifyAllocation").val();
    if ($allocation.length == 0) {
        humane.error("类型数值不能为空");
        return;
    }
    if (isNaN($allocation)) {
        humane.error("类型数值请输入数值");
        return;
    }
});

//点击修改div取消时关闭修改Dic
$("#closeModifyForm").on("click",function () {
    $("#modifyDiv").css({"visibility":"hidden","display":"none"});
});

//点击修改div的保存按钮
$("#modifySave").on("click",function () {
    $.ajax({
        type:"post",
        data:$("#modifyFrom").serialize(),      //序列化成封装的类
        url:path+"/type/updateType",
        dataType:"json",
        success:function (data) {
            if(data == 1){
                humane.success("修改类型成功");
                window.location.href=path+"/type/queryServiceType";
            }else{
                humane.error("修改类型失败")
            }
        }
    });
});
