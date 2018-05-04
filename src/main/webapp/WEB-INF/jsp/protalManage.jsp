
<%@include file="../common/head.jsp"%>
<div class="mbxnav">
  <!-- 导航 -->
  门户管理\
</div>
<div class="container">
  <form id="protalForm" action="${pageContext.request.contextPath }/protal/queryProtalList" method="post">
    <input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}">
    <div>
      <label>关键字:</label>
      <input type="text" id="keyword" name="keyword" value="${keyword}">
      <label>客户名称:</label>
      <input type="text" id="cname" name="companyName" value="${companyName}">
      <input type="submit" value="查询"/>
    </div>
  </form>
  <table style="text-align: center;font-family: 宋体">
    <thead>
    <tr>
      <th>序号</th>
      <th>门户名称</th>
      <th>客户名称</th>
      <th>法人代表</th>
      <th>代理商</th>
      <th>注册时间</th>
      <th>类型</th>
      <th>状态</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty page.pageList}">
      <c:forEach items="${page.pageList}" var="protal" varStatus="status">
        <tr>
          <td>${status.count}</td>
          <td>${protal.customer.keyword.keyword}</td>
          <td>${protal.customer.companyName}</td>
          <td>${protal.legalRepresentative}</td>
          <td>${protal.customer.user.userName}</td>
          <td><fmt:formatDate value="${protal.customer.keyword.createTime}" pattern="yyyy-MM-dd"/></td>
          <td>${protal.customer.type.typeName}</td>
          <td style="color: #66F4DF;">${protal.customer.keyword.keywordStatus==1?'启用':'停用'}</td>
          <td>
            <a class="viewprotal" href="javascript:;" protalId="${protal.protalId}">查看</a>
            <c:if test="${not empty protal.customer.keyword.appInfo}">
              |<a class="modifprotal" href="javascript:;" protalId="${protal.protalId}">修改</a>
            </c:if>
          </td>
        </tr>
      </c:forEach>
    </c:if>
    <c:if test="${empty page.pageList}">
      <tr>
        <td colspan="10">没有查询结果</td>
      </tr>
    </c:if>
    </tbody>
  </table>
  <div class="pagination pagination-centered">
    <ul>
      <li>
        <a href="javascript:;" onclick="getProtalList(1);">首页</a>
      </li>
      <%--<s:if test="pager.prevPages!=null">--%>
      <%--<s:iterator value="pager.prevPages"  var="num">--%>
      <%--<li><a href="/customlist.action?pager.page=<s:property value="#num"/>&custom.customName=<s:property value="custom.customName" />"><s:property value="#num"/></a></li>--%>
      <%--</s:iterator>--%>
      <%--</s:if>--%>
      <c:if test="${page.totalPage>0}">
        <c:forEach var="s" begin="1" end="${page.totalPage}">
          <li>
            <a href="javascript:;" onclick="getProtalList(${s})">${s}</a>
          </li>
        </c:forEach>
      </c:if>


      <%--<s:if test="pager.nextPages!=null">--%>
      <%--<s:iterator value="pager.nextPages" var="num">--%>
      <%--<li><a href="/customlist.action?pager.page=<s:property value="#num"/>&custom.customName=<s:property value="custom.customName" />"><s:property value="#num"/></a></li>&ndash;%&gt;--%>

      <%--</s:iterator>--%>
      <%--</s:if>--%>
      <%--<s:if test="pager.prevPages!=null">--%>
      <%--<s:iterator value="pager.prevPages"  var="num">--%>
      <%--<li><a href="/customlist.action?pager.page=<s:property value="#num"/>&custom.customName=<s:property value="custom.customName" />"><s:property value="#num"/></a></li>--%>
      <%--</s:iterator>--%>
      <%--</s:if>--%>
      <%--<s:if test="pager.nextPages!=null">--%>
      <%--<s:iterator value="pager.nextPages" var="num">--%>
      <%--<li><a href="/customlist.action?pager.page=<s:property value="#num"/>&custom.customName=<s:property value="custom.customName" />"><s:property value="#num"/></a></li>&ndash;%&gt;--%>

      <%--</s:iterator>--%>
      <%--</s:if>--%>
      <li>
        <a href="javascript:;" onclick="getProtalList(${page.totalPage})">尾页</a>
      </li>
    </ul>
  </div>
</div>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/customlist.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/protalManage.js"></script>
  </body>
</html>
