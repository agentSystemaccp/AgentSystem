<%@include file="../common/head.jsp"%>

<div class="mbxnav">
  <!-- 导航 -->
  代理商管理\ <a href="${pageContext.request.contextPath }/agent/toCustomerManage">代理商客户管理</a>\ 添加客户信息
</div>
<div class="container">
  <form id="cform" action="" method="post">
    <div class="subtitle">基本信息</div>
    <div class="info1">
      <ul>
        <li>企业名称: <input type="text" name="companyName"
                        id="customname" value="">
        </li>

        <li>企业类型: <select name="companyType" id="companyType">
          <option value="">请选择</option>
          <c:forEach var="typeList" items="${typeList}">
              <option value="${typeList.typeId}">${typeList.typeName}</option>
          </c:forEach>
        </select>
        </li>
        <li>企业主页: <input type="text" id="companyPages" name="companyPages" placeholder="http://www.baidu.com" value="">
        </li>
        <li>状态: <select name="companyStatus" id="companyStatus">
            <option value="">请选择</option>
            <option value="1">启用</option>
          <option value="2">停用</option>
        </select></li>
      </ul>
    </div>

    <div class="subtitle">门户信息</div>
    <div class="info2">
      <ul>
        <li>法人代表: <input type="text" id="legalRepresentative" name="legalRepresentative">
        </li>
        <li>注册日期: <input type="text" name="createTime" value=""
                        class="Wdate" onclick="WdatePicker()" id="regdate">
        </li>
        <li>证件类型: <select name="typeId" id="customcardtype">
          <option value="">请选择</option>
          <c:forEach var="idTypeList" items="${idTypeList}">
            <option value="${idTypeList.typeId}">${idTypeList.typeName}</option>
          </c:forEach>
        </select>
        </li>
         <li>证件号码: <input type="text" name="idNumber" id="cardnum" placeholder="请输入数字" value="" title=""></li>
        <li>国家: <input type="text" name="state" value="中国" readonly="readonly">
        </li>
        <li>省份: <select id="customprovince" name="province" onchange="loadCity();">
          <option value="">--请选择省份--</option>
        </select>
        </li>
        <li>公司传真: <input type="text" name="companyFax" id="companyFax" placeholder="0111-1111111" value="">
        </li>
        <li>城市: <select id="customcity" name="city">
          <option value="">--请选择城市--</option>
        </select></li>
        <li>公司电话: <input type="text" id="companyTel" name="companyTel" placeholder="011-1111111" value="">
        </li>
        <li>公司地址: <input type="text" name="companyAddress" id="companyAddress" value="">
        </li>
      </ul>
      <div class="clear"></div>
      <div>
        备注:
        <textarea name="remark" rows="2" cols="50"></textarea>
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

        </tbody>
      </table>

    </div>

    <div class="goback">
      <input type="button" value="保存" onclick="checksave();"> <input
            type="button" value="返回" onclick="history.go(-1);">
    </div>
  </form>

</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/addcustom.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/addcustom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/medire/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/cascade.js"></script>
</body>
</html>
