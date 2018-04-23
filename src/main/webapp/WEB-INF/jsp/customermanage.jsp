<%@include file="../common/head.jsp"%>


<div class="mbxnav">
  <!-- 导航 -->
  代理商管理\ <a href="${pageContext.request.contextPath }/agent/toCustomerManage">代理商客户管理</a>
</div>
<div class="container">
  <form action="" method="post">
    <div>
      <label>客户名称:</label>
      <input type="text" id="cname" name="companyName" value="${companyName}">
      <input type="submit" id="searchCustomer"  value="查询"/>

    </div>
  </form>

  <div class="addCustomDiv">
    <input type="button" id="addCustomBtn" value="添加客户">
  </div>

  <table>
    <thead>
    <tr>
      <th>序号</th>
      <th>客户名称</th>
      <th>法人代表</th>
      <th>注册时间</th>
      <th>类型</th>
      <th>状态</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody id="customerManage">

    </tbody>
  </table>
  <div class="pagination pagination-centered">

  </div>

</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/customlist.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/customermanage.js"></script>
</body>
</html>