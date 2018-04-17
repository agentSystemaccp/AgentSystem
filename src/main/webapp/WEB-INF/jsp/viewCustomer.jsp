<%@include file="../common/head.jsp"%>
<div class="mbxnav">
  <!-- 导航 -->
  代理商管理\ <a href="/customlist.action">代理商客户管理</a>\ <a href="/viewcustom.action?custom.id=${custom.id}">查看客户信息</a>
</div>
<div class="container">

  <div class="subtitle">注册的移动云端信息</div>
  <div class="info2">
    <ul>
      <li>登录账号 : </li>
      <li>登录密码 : </li>
      <li>关键字 : ${protal.customer.keyword.keyword}</li>
      <li>登录地址 : </li>
      <li>客户端下载地址(IOS) : </li>
      <li>二维码下载地址(IOS) : </li>
      <li>客户端下载地址(Android) : </li>
      <li>二维码下载地址(Android) : </li>
      <li>关键字开始日期 : <fmt:formatDate value='${protal.customer.keyword.createTime}' pattern='yyyy-MM-dd'/></li>
      <li>关键字结束日期 : <fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/></li>
      <li>关键字服务年限 : ${protal.customer.keyword.term}</li>
    </ul>
    <div class="clear"></div>
  </div>

  <div style="clear: both"></div>

  <div class="subtitle">基本信息</div>
  <div class="info1">
    <ul>
      <li>企业名称 : ${protal.customer.companyName}</li>
      <li>状态 : ${protal.customer.companyStatus==1?"启用":"停用"}</li>
      <li>企业类型 : ${protal.customer.type.typeName}</li>
      <li>企业主页 : ${protal.customer.companyPages}</li>

    </ul>
    <div class="clear"></div>
  </div>
  <div class="clear"></div>


  <div class="subtitle">门户信息</div>
  <div class="info2">
    <ul>
      <li>法人代表: ${protal.legalRepresentative}</li>
      <li>注册日期:<fmt:formatDate value="${protal.createTime}" pattern="yyyy-MM-dd"/>
      </li>
      <li>证件类型: ${protal.type.typeName }</li>
      <li>证件号码:${protal.idNumber}</li>
      <li>国家:${protal.state}</li>
      <li>省份: ${protal.province }</li>
      <li>公司传真:${protal.companyFax}</li>
      <li>城市: ${protal.city}</li>
      <li>公司电话:${protal.companyTel}</li>
      <li>区:${protal.district}</li>
      <li>公司地址:${protal.companyAddress}</li>
      <li>备注:${protal.remark }</li>
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
  <div class="goback">
    <input type="button" onclick="window.history.go(-1)" value="返回"/>
  </div>

</div>

<link rel="stylesheet" type="text/css" href="/css/viewcustom.css">
  </body>
</html>
