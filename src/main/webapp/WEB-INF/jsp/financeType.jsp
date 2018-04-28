<%@include file="../common/head.jsp"%>
<div class="mbxnav">
  <!-- 导航 -->
  系统管理配置<a href="/report.action">\财务类型</a>
</div>
<div class="container">
  <div class="addCustomDiv">
    <input id="addFinanceType" value="   添加财务类型">
  </div>

  <table  style="text-align: center;font-family: 宋体" >
    <thead>
    <tr>
      <th>序号</th>
      <th>配置类型</th>
      <th>是否启用</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
      <c:forEach items="${typeList}" var="type" varStatus="statu">
        <tr>
          <td>${statu.count}</td>
          <td>${type.typeName}</td>
          <td style="color: #66F4DF;">${type.typeStatus == 1 ? '启用':'停用'}</td>
          <td>
            <a class="modifyType" href="javascript:;" typeName="${type.typeName}" typeId="${type.typeId}">修改</a>|
            <a class="delType" href="javascript:;" status="${type.typeStatus}" typeName="${type.typeName}" typeId="${type.typeId}">删除</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <div id="addFinanceDiv" style="visibility: hidden;display:none;width: 300px;height: 150px;background-color: #f5f5f5;position: absolute;left: 360px;top: 70px; ">
    <div style="width: 250px;height: 130px;padding: 30px 25px; ">
      <h5 style="text-align: center">正在进行添加操作</h5>
      <hr/>
      <form id="addFinanceTypeFrom" method="post">
        <input type="hidden" name="parentId" value="2"/>
        <div style="margin: 10px 5px">
          <label>类型名称：</label>
          <input id="addFinanceTypeName" type="text" name="typeName">
        </div>
        <div style="margin: 10px 5px">
          <label>是否启用:</label>
          <select name="typeStatus">
            <option selected value="1">启用</option>
            <option value="0">不启用</option>
          </select>
          <input id="addFinanceSave" type="button" value="保存"/>
          <input id="closeFinanceForm" type="button" value="取消">
        </div>
      </form>
    </div>
  </div>
  <div id="modifyFinanceDiv" style="visibility: hidden;display:none;width: 300px;height: 150px;background-color: #f5f5f5;position: absolute;left: 360px;top: 70px; ">
    <div style="width: 250px;height: 130px;padding: 30px 25px; ">
      <h5 style="text-align: center">正在进行修改操作</h5>
      <hr/>
      <form id="modifyFinanceFrom" method="post">
        <input id="modifyFinanceId" type="hidden" name="typeId" value="">
        <div style="margin: 10px 5px">
          <label>类型名称：</label>
          <input id="modifyTypeName" type="text" name="typeName">
        </div>
        <div style="margin: 10px 5px">
          <label>是否启用:</label>
          <select  id="modifyTypeStatus" name="typeStatus">
            <option selected value="1">启用</option>
            <option value="0">不启用</option>
          </select>
          <input id="modifyFinanceSave" type="button" value="保存"/>
          <input id="closeModifyFinanceForm" type="button" value="取消">
        </div>
      </form>
    </div>
  </div>
</div>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/customlist.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/financeType.js"></script>
  </body>
</html>
