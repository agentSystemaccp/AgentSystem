<%@include file="../common/head.jsp"%>
<div class="mbxnav">
  <!-- 导航 -->
  代理商管理\ <a href="${pageContext.request.contextPath }/agent/toCustomerManage">代理商客户管理</a>\ <a href="">查看客户信息</a>
</div>
<div class="container">
  <c:if test="${protal != null}">

    <div class="subtitle">注册的移动云端信息</div>
    <div class="info2">
      <ul>
        <li><label>登录账号 :</label>  ${protal.customer.keyword.appInfo.appCode}</li>
        <li><label>登录密码 :</label>  ${protal.customer.keyword.appInfo.appPassword}</li>
        <li><label>客户端下载地址(IOS) :</label>  ${protal.customer.keyword.appInfo.appIOSUrl}</li>
        <li><label>二维码下载地址(IOS) :</label>  ${protal.customer.keyword.appInfo.appIOSQRCodeUrl}</li>
        <li><label>客户端下载地址(Android) :</label>  ${protal.customer.keyword.appInfo.appAndroidUrl}</li>
        <li><label>二维码下载地址(Android) :</label>  ${protal.customer.keyword.appInfo.appAndroidQRCodeUrl}</li>
        <li><label>关键字 :</label>  ${protal.customer.keyword.keyword}</li>
        <li><label>关键字开始日期 :</label>  <fmt:formatDate value='${protal.customer.keyword.createTime}' pattern='yyyy-MM-dd'/></li>
        <li><label>关键字结束日期 :</label>  <fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/></li>
        <li><label>关键字服务年限 :</label>  ${protal.customer.keyword.term}</li>
      </ul>
      <div class="clear"></div>
    </div>

    <div style="clear: both"></div>

    <div class="subtitle">基本信息</div>
    <div class="info1">
      <ul>
        <li><label>企业名称 :</label> ${protal.customer.companyName}</li>
        <li><label>状态 :</label> <span style="color: lawngreen;">${protal.customer.companyStatus==1?"启用":"停用"}</span></li>
        <li><label>企业类型 :</label> ${protal.customer.type.typeName}</li>
        <li><label>企业主页 :</label> ${protal.customer.companyPages}</li>

      </ul>
      <div class="clear"></div>
    </div>
    <div class="clear"></div>


    <div class="subtitle">门户信息</div>
    <div class="info2">
      <ul>
        <li><label>法人代表:</label>  ${protal.legalRepresentative}</li>
        <li><label>注册日期:</label> <fmt:formatDate value="${protal.createTime}" pattern="yyyy-MM-dd"/>
        </li>
        <li><label>证件类型:</label> ${protal.type.typeName }</li>
        <li><label>证件号码:</label> ${protal.idNumber}</li>
        <li><label>国家:</label> ${protal.state}</li>
        <li><label>省份:</label> ${protal.province }</li>
        <li><label>公司传真:</label> ${protal.companyFax}</li>
        <li><label>城市:</label> ${protal.city}</li>
        <li><label>公司电话:</label> ${protal.companyTel}</li>
        <li><label>公司地址:</label> ${protal.companyAddress}</li>
        <li><label>备注:</label> ${protal.remark }</li>
      </ul>
      <div class="clear"></div>
    </div>



    <div class="subtitle">联系信息</div>
    <div class="info3">

      <table>
        <thead>
        <tr>
          <th>姓名</th>
          <th>电话</th>
          <th>传真</th>
          <th>邮箱</th>
          <th>职务</th>

        </tr>
        </thead>
        <tbody id="addtr">
        <c:forEach items="${protal.customer.contacts}" var="contact">
          <tr>
            <td>${contact.contactsName}</td>
            <td>${contact.contactsTel}</td>
            <td>${contact.contactsFax}</td>
            <td>${contact.contactsEmail}</td>
            <td>${contact.contactsPost}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </c:if>
  <c:if test="${protal == null}">
    <p style="color: red;">没有任何结果</p>
  </c:if>
  <div class="goback">
    <input type="button" onclick="window.history.go(-1)" value="返回"/>
  </div>

</div>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/viewcustom.css">
  </body>
</html>
