  <%@include file="../common/head.jsp"%>
  <div class="mbxnav">
    <!-- 导航 -->
    系统管理配置<a href="${pageContext.request.contextPath }/type/queryServiceType">\服务类型</a>
  </div>
  <div class="container">
    <div class="addCustomDiv">
      <input id="addServiceType" value="   添加服务类型">
    </div>
    <table style="text-align: center;font-family: 宋体" >
      <thead>
      <tr>
        <th>序号</th>
        <th>配置类型</th>
        <th>配置数值</th>
        <th>是否启用</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
        <c:forEach items="${serviceType}" var="type" varStatus="status">
          <tr>
            <td>${status.count}</td>
            <td>${type.typeName}</td>
            <td>${type.allocation}</td>
            <td style="color: #66F4DF;">${type.typeStatus == 1 ?  '启用' : '停用'}</td>
            <td>
              <a href="javasrcipt:;" class="modifyType" status="${type.typeStatus}" typeId="${type.typeId}" typeName="${type.typeName}" allocation="${type.allocation}">修改</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div id="addDiv" style="visibility: hidden;display:none;width: 300px;height: 180px;background-color: #f5f5f5;position: absolute;left: 360px;top: 70px; ">
      <div style="width: 250px;height: 130px;padding: 30px 25px; ">
        <h5 style="text-align: center">正在进行添加操作</h5>
        <hr/>
        <form id="addFrom" method="post">
          <input type="hidden" name="parentId" value="3"/>
          <div style="margin: 10px 5px">
            <label>类型名称：</label>
            <input id="addTypeName" type="text" name="typeName">
          </div>
          <div style="margin: 10px 5px">
            <label>类型数据：</label>
            <input id="addAllocation" type="text" name="allocation">
          </div>
          <div style="margin: 10px 5px">
            <label>是否启用:</label>
            <select name="typeStatus">
              <option selected value="1">启用</option>
              <option value="0">不启用</option>
            </select>
            <input id="addSave" type="button" value="保存"/>
            <input id="closeForm" type="button" value="取消">
          </div>
        </form>
      </div>
    </div>
    <div id="modifyDiv" style="visibility: hidden;display:none;width: 300px;height: 180px;background-color: #74d2d9;position: absolute;left: 360px;top: 70px; ">
      <div style="width: 250px;height: 130px;padding: 30px 25px; ">
        <h5 style="text-align: center">正在进行修改操作</h5>
        <hr/>
        <form id="modifyFrom" method="post">
          <input id="modifyId" type="hidden" name="typeId" value="">
          <div style="margin: 10px 5px">
            <label>类型名称：</label>
            <input id="modifyTypeName" type="text" name="typeName">
          </div>
          <div style="margin: 10px 5px">
            <label>类型数据：</label>
            <input id="modifyAllocation" type="text" name="allocation">
          </div>
          <div style="margin: 10px 5px">
            <label>是否启用:</label>
            <select  id="modifyTypeStatus" name="typeStatus">
              <option selected value="1">启用</option>
              <option value="0">不启用</option>
            </select>
            <input id="modifySave" type="button" value="保存"/>
            <input id="closeModifyForm" type="button" value="取消">
          </div>
        </form>
      </div>
    </div>
  </div>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/customlist.css">
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/serviceType.js"></script>
  </body>
</html>
