<%@include file="../common/head.jsp"%>

<div class="mbxnav">
  <!-- 导航 -->
  <a href="">代理商管理</a>\ <a href="${pageContext.request.contextPath }/agent/toYFK">代理商预付款</a>
</div>
<div class="container">
  <!-- search box -->
  <div class="searchuserdiv ope">
    <ul>
      <li>
        <form action="" method="post" onsubmit="return searchyfklistFunc()">

          操作类型:<select name="detailType" id="detailType">

        </select>

          操作时间: <input type="text" class="Wdate"
                       size="15" onClick="WdatePicker()" id="starttime" readonly="readonly"
                       name="startTime" value=""> 至 <input type="text" class="Wdate" size="15" onClick="WdatePicker()" id="endtime"  readonly="readonly" name="endTime" value="">
          <input type="button" id="searchList" value="查询" />

        </form></li>
    </ul>
  </div>
  <!-- accountdetail列表 -->
  <table id="tableList">
    <thead>
    <tr>
      <th>序号</th>
      <th>账务类型</th>
      <th>账务资金</th>
      <th>账户余额</th>
      <th>备注信息</th>
      <th>明细时间</th>
    </tr>
    </thead>
    <tbody id="accountdetail">

    </tbody>
  </table>

  <div class="pagination pagination-centered">

  </div>
</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/yfk.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/yfk.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/medire/WdatePicker.js"></script>
</body>
</html>