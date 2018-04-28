<%@include file="../common/head.jsp"%>
<div class="mbxnav">
  <!-- 导航 -->
  <a href="/report.action">报表管理</a>
</div>
<div class="container">
  <!-- search box -->
  <div class="searchuserdiv ope">
    <ul>
      <li>
        <form action="/report/queryReportManage" method="post" onsubmit="return searchReportFunc();">
          操作类型:<select name="reportType" id="reporttype">
          <option value="">财务报表</option>
          <option value="1" <c:if test="${reportType==1}">selected="selected"</c:if>>&nbsp;&nbsp;&nbsp;&nbsp;代理商账户余额报表</option>
          <option value="2" <c:if test="${reportType==2}">selected="selected"</c:if>>&nbsp;&nbsp;&nbsp;&nbsp;预付款流水报表</option>
          <option value="3" <c:if test="${reportType==3}">selected="selected"</c:if>>&nbsp;&nbsp;&nbsp;&nbsp;代理商流水报表</option>
          <option value="">产品报表</option>
          <option value="4" <c:if test="${reportType==4}">selected="selected"</c:if>>&nbsp;&nbsp;&nbsp;&nbsp;产品分类数量/金额汇总</option>
        </select>
          <div id="opertime" style="margin-left: 250px;margin-top: -20px">
            操作时间: <input type="text" class="Wdate"
                         size="15" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="starttime" readonly="readonly"
                         name="starttime" value="${starttime}"> 至 <input type="text" class="Wdate" size="15" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="endtime"  readonly="readonly"
                         name="endtime" value="${endtime}">
          </div>
          <div id="butten" style="margin-left: 580px;margin-top: -20px">
            <input type="submit" value="查询" onclick="queryReprot()" />
          </div>

        </form></li>
    </ul>
  </div>
  <!-- 查询结果列表 -->
  <c:if test="${reportType==1}">
    <!-- 代理商余额报表 -->
    <div class="downloadfile">
      <ul>
        <li><img src="/imgs/pdf.png"><a href="javascript:;" onclick="accountPDF('${starttime}','${endtime}')">PDF下载</a></li>
        <li><img src="/imgs/excel.png"><a href="javascript:;" onclick="accountExcel('${starttime}','${endtime}')">Excel下载</a></li>
      </ul>
    </div>
    <h1>代理商余额报表</h1>
    <table>
      <thead>
      <tr>
        <th>序号</th><th>代理商名称</th><th>账户余额</th>
      </tr>
      </thead>
      <tbody style="text-align: center;font-family: 宋体">
        <c:forEach items="${userInfoList}" var="userInfo" varStatus="status">
          <tr>
            <td>${status.count}</td>
            <td>${userInfo.userName}</td>
            <td>${userInfo.balance}</td>
          </tr>
        </c:forEach>
      </tbody>

    </table>
  </c:if>
  <c:if test="${reportType==2}">

    <!-- 预付款流水报表 -->
    <div class="downloadfile">
      <ul>
        <li><img src="/imgs/pdf.png"><a href="javascript:;" onclick="yfPDF('${starttime}','${endtime}')">PDF下载</a></li>
        <li><img src="/imgs/excel.png"><a href="javascript:;" onclick="yfExcel('${starttime}','${endtime}')">Excel下载</a></li>>
      </ul>
    </div>
    <h1>预付款流水报表</h1>
    <table>
      <thead>
      <tr>
        <th>序号</th>
        <th>代理商名称</th>
        <th>预付款</th>
        <th>账户余额</th>
        <th>备注信息</th>
        <th>时间</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${dealDetailList}" var="detail" varStatus="status">
        <tr>
          <td>${status.count}</td>
          <td>${detail.user.userName}</td>
          <td>${detail.financeFund}</td>
          <td>${detail.balance}</td>
          <td>${detail.remark}</td>
          <td><fmt:formatDate value="${detail.createTime}" pattern="yyyy-MM-dd"/></td>
        </tr>
      </c:forEach>

      </tbody>

    </table>
  </c:if>
  <c:if test="${reportType==3}">
    <!-- 代理商流水报表 -->
    <div class="downloadfile">
      <ul>
        <li><img src="/imgs/pdf.png"><a href="javascript:;" onclick="userPDf('${starttime}','${endtime}')">PDF下载</a></li>
        <li><img src="/imgs/excel.png"><a href="javascript:;" onclick="userExcel('${starttime}','${endtime}')">Excel下载</a></li>
      </ul>
    </div>
    <h1>代理商流水报表</h1>
    <table>
      <thead>
      <tr>
        <th>序号</th>
        <th>代理商名称</th>
        <th>预付款</th>
        <th>账户余额</th>
        <th>备注信息</th>
        <th>时间</th>
      </tr>
      </thead>
      <tbody  style="text-align: center;font-family: 宋体">
      <c:forEach items="${dealDetailList}" var="detail" varStatus="status">
        <tr>
          <td>${status.count}</td>
          <td>${detail.user.userName}</td>
          <td>${detail.financeFund}</td>
          <td>${detail.balance}</td>
          <td>${detail.remark}</td>
          <td><fmt:formatDate value="${detail.createTime}" pattern="yyyy-MM-dd"/></td>
        </tr>
      </c:forEach>

      </tbody>

    </table>

  </c:if>
  <c:if test="${reportType==4}">
    <!-- 产品分类数量/金额汇总 -->
    <div class="downloadfile">
      <ul>
        <li><img src="/imgs/pdf.png"><a href="javascript:;" onclick="productPDF()">PDF下载</a></li>
        <li><img src="/imgs/excel.png"><a href="javascript:;" onclick="productExcel()">Excel下载</a></li>
      </ul>
    </div>
    <h1>产品分类数量/金额汇总</h1>
    <table>
      <thead>
      <tr>
        <th>序号</th><th>产品分类名称</th><th>数量</th><th>价格</th>
      </tr>
      </thead>
      <tbody  style="text-align: center;font-family: 宋体">
        <c:forEach items="${typeList}" var="type" varStatus="status">
          <tr>
            <td>${status.count}</td>
            <td>${type.typeName}</td>
            <td>${type.number}</td>
            <td>${type.allocation*type.number}</td>
          </tr>
        </c:forEach>
      </tbody>

    </table>

  </c:if>


</div>
<link rel="stylesheet" type="text/css" href="/css/report.css">
<script type="text/javascript" src="/js/report.js"></script>
<script type="text/javascript" src="/medire/WdatePicker.js"></script>
</body>
</html>
  </body>
</html>
