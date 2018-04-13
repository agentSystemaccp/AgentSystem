
  <%@include file="../common/head.jsp"%>
  <div class="mbxnav">
    代理商管理\当前账户信息
  </div>
  <div class="container">
    <div class="userInfo">
      <ul>
        <li><b>您好, ${userLogin.userName}！</b>
          您上次登录时间
          <%--<s:date name="currentUser.lastLoginTime" format="yyyy-MM-dd HH:mm:ss"/>--%>
        </li>
        <li>
          <!-- 显示Account对象的属性 -->
          您当前账户 余额:
          <c:if test="${userLogin.balance==null}">
            对不起,您没有开户
          </c:if>
          <c:if test="${userLogin.balance!=null}">
            ${userLogin.balance}
          </c:if>
          <a href="${pageContext.request.contextPath }/deal/toAccountDetail" style="color: blue">&nbsp;查看账户明细</a>
        </li>
      </ul>

    </div>

  </div>
  </body>
</html>
