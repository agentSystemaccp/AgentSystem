<%@include file="../common/head.jsp"%>

<div class="mbxnav">
  <!-- 导航 -->
  代理商管理\ 关键词申请
</div>
<div class="container">
  <div class="searchuserdiv">
    <div>
      搜索账户 :<input type="text" id="searchusertext"> 输入后自动搜索 <font
            color="red">[当前账户余额:￥<span id="accountspan">${userLogin.balance}</span>]</font>

      <div id="serachresult" class="searchresult"></div>
    </div>

  </div>
  <div class="formdiv">

    <ul>
      <li>客户名称: <input type="text" id="customname" class="customname"
                       readonly="readonly">
        <span id="custom" style="color: red"></span>
      </li>
      <li>关键词: <input type="text" id="keyword" class="keyword">
        <span id="keywordtip" class="keywordtip"></span></li>
      <li>服务类别: <select id="servicetype">

      </select>
        <span id="serviceTip" style="color: red"></span>
      </li>
      <li>服务年限: <select id="serviceyear">
        <option value="" selected="selected">--请选择--</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="买二赠一">买二赠一</option>
      </select>
        <span id="yearTip" style="color: red"></span>
      </li>
      <li>价格: <input class="price" id="price" type="text"
                     readonly="readonly"></li>
      <li><input type="button" id="submitkeyword" onclick="submitKeyWord()" value="提交申请">
      </li>
    </ul>
  </div>

</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/keyword.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/keywords.js"></script>
  </body>
</html>
