<%@include file="../common/head.jsp"%>

<div class="mbxnav">
  <!-- 导航 -->
  代理商管理\ <a href="${pageContext.request.contextPath }/agent/toCustomerManage">代理商客户管理</a>\ 修改客户信息
</div>
<div class="container">
  <form id="cform" action="" method="post">
    <input type="hidden" name="customerId" value="${protal.customerId}">
    <div class="subtitle">基本信息</div>
    <div class="info1">
      <ul>
        <li>企业名称:<input type="text" name="companyName"
                        id="customname" readonly="readonly" value="${protal.customer.companyName}">
        </li>
        <li>企业类型:<select name="companyType">
          <option value="">请选择</option>
            <c:forEach var="typeList" items="${typeList}">
              <c:if test="${protal.customer.companyType==typeList.typeId}">
                <option value="${typeList.typeId}" selected="selected">${typeList.typeName}</option>
              </c:if>
              <c:if test="${protal.customer.companyType!=typeList.typeId}">
                <option value="${typeList.typeId}">${typeList.typeName}</option>
              </c:if>
            </c:forEach>
        </select>
        </li>
        <li>企业主页:<input type="text" name="companyPages" value="${protal.customer.companyPages}">
        </li>
        <li>状态:<select name="companyStatus">
          <c:if test="${protal.customer.companyStatus==1}">
            <option value="1" selected="selected">启用</option>
            <option value="0">停用</option>
          </c:if>
          <c:if test="${protal.customer.companyStatus!=1}">
            <option value="1">启用</option>
            <option value="0" selected="selected">停用</option>
          </c:if>
        </select>
      </ul>
    </div>

    <div class="subtitle">门户信息</div>
    <div class="info2">
      <ul>
        <input type="hidden" name="protalId" value="${protal.protalId}">
        <li>法人代表:<input type="text" name="legalRepresentative" value="${protal.legalRepresentative}">
        </li>
        <li>注册日期:
          <input type="text" name="createTime" value="<fmt:formatDate value="${protal.createTime}" pattern="yyyy-MM-dd"/>"
                        class="Wdate" onclick="WdatePicker()" id="regdate">
        </li>
        <li>证件类型:   <select name="typeId" id="customcardtype">
            <option value="">请选择</option>
            <c:forEach var="idTypeList" items="${idTypeList}">
              <c:if test="${protal.typeId==idTypeList.typeId}">
                <option value="${idTypeList.typeId}" selected="selected">${idTypeList.typeName}</option>
              </c:if>
              <c:if test="${protal.typeId!=idTypeList.typeId}">
                <option value="${idTypeList.typeId}">${idTypeList.typeName}</option>
              </c:if>
            </c:forEach>
          </select>
        </li>


        <li>证件号码:<input type="text" name="idNumber" id="cardnum" value="${protal.idNumber}">
        </li>
        <li>国家:<input type="text" name="state" value="${protal.state}">
        </li>
        <li>省份:<select id="customprovince" name="province" onchange="loadCity();">
          <option value="">--请选择省份--</option>
        </select>
        </li>
        <li>公司传真:<input type="text" name="companyFax" value="${protal.companyFax}">
        </li>
        <li>城市:
          <select id="customcity" name="city">
            <option value="">--请选择城市--</option>
          </select>
        </li>
        <li>公司电话:<input type="text" name="companyTel" value="${protal.companyTel}">
        </li>
        <li>公司地址:<input type="text" name="companyAddress" value="${protal.companyAddress}">
        </li>
      </ul>
      <div class="clear"></div>
      <div>
        备注:
        <textarea name="remark" rows="2" cols="50" value="">${protal.remark }</textarea>
      </div>
    </div>
    <div class="clear"></div>


    <div class="subtitle">

      <a href="javascript:void(0);" id="addcontact">添加一个联系人</a>

    </div>
    <div class="info3">

      <table>
        <thead>
        <tr>
          <th>姓名</th>
          <th>电话</th>
          <th>传真</th>
          <th>邮箱</th>
          <th>职务</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody id="addtr">
        <c:forEach items="${contactsList}" var="contactsList" varStatus="contact">
          <tr>
            <td><input type='text' name='contacts[${contact.index}].contactsName' value="${contactsList.contactsName }"></td>
            <td><input type='text' name='contacts[${contact.index}].contactsTel'  value="${contactsList.contactsTel}"></td>
            <td><input type='text' name='contacts[${contact.index}].contactsFax'  value="${contactsList.contactsFax}"></td>
            <td><input type='text' name='contacts[${contact.index}].contactsEmail'  value="${contactsList.contactsEmail}"></td>
            <td><input type='text' name='contacts[${contact.index}].contactsPost'  value="${contactsList.contactsPost}"></td>
            <td  onclick='delTr(this)' style="cursor:hand">删除</td></tr>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>

    <div class="goback">
      <input type="button" value="保存" onclick="checksave();"> <input
            type="button" value="返回" onclick="history.go(-1);">
    </div>
  </form>

</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/modifycustom.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/modifycustom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/cascade.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/medire/WdatePicker.js"></script>
</body>
</html>