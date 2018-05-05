<%@include file="../common/head.jsp"%>
<div class="mbxnav">
  <!-- 导航 -->
  系统管理配置<a href="${pageContext.request.contextPath }/type/queryLengthService">\服务年限</a>
</div>
<div class="container">
  <div style="border: 1px solid #666666;margin: 20px 10px;width: 98%;text-align: center ">
    <div style="width: 98%;margin: 30px 10px;">
      <h3  style="margin: 20px 0;font-size: 15px;">服务年限管理-填写最大的服务年限</h3>
      <hr/>
      <form id="modifyForm" action="${pageContext.request.contextPath }/type/updateType" method="post">
        <input type="hidden" name="typeId" value="${type.typeId}"/>
        <div style="margin: 20px">
          <label>配置名称：</label>
          <input type="text" name="typeName" value="${type.typeName}" readonly/>
        </div>
        <div style="margin: 20px ">
          <label>配置数值：</label>
          <input id="allocation" type="text" name="allocation" value="${type.allocation}"/>
        </div>
        <input id="save" type="button" value="保存"/>
      </form>
    </div>
  </div>
</div>
<script>
  $("#save").on("click",function () {
      var val = $("#allocation").val();
      if(val.length == 0){
          alert("配置类型不能为空");
          return;
      }
      if(isNaN(val)){
          alert("配置类型必须为数值类型");
          return;
      }
      $.ajax({
          type:"post",
          data:$("#modifyForm").serialize(),      //序列化成封装的类
          url:path+"/type/updateType",
          dataType:"json",
          success:function (data) {
              if(data == "1"){
                  alert("修改类型成功");
                  window.location.href=path+"/type/queryLengthService";
              }else{
                  alert("修改类型失败")
              }
          }
      });
  });
</script>
  </body>
</html>
