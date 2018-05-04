<%@include file="../common/head.jsp"%>
<div class="mbxnav">
    <!-- 导航 -->
    代理商管理\ <a href="${pageContext.request.contextPath }/agent/toKeyWordManage">关键词申请管理</a>
</div>
<div class="container">
  <!-- 搜索 -->
  <div>
    <ul>
      <li>

          关键词:<input type="text" name="keywords.keywords"
                     value="${keywords.keywords}" id="keyword"> <input type="button" id="submitkeyword"
                                                          value="查询">
      </li>
    </ul>
  </div>

  <table>
    <thead>
    <tr>
      <th>序号</th>
      <th>关键词</th>
      <th>客户名称</th>
      <th>代理商</th>
      <th>申请年限</th>
      <th>申请日期</th>
      <th>到期日期</th>
      <th>申请到期状态</th>
      <th>审核状态</th>
      <th>使用状态</th>
      <th>APP开通状态</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody id="keywordManage">

    </tbody>
  </table>
  <%--分页--%>
  <div class="pagination pagination-centered">

  </div>

</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/keywordmanage.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/keywordsmanage.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/xufei.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/openapp.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/keywordopr.js"></script>


  </body>
</html>
