<%@include file="../common/head.jsp"%>

<div class="mbxnav">
    <!-- 导航 -->
    代理商管理\当前账户信息\ <a href="${pageContext.request.contextPath }/deal/accountdetail">查看账户明细</a>
</div>
<div class="container">

    <!-- accountdetail列表 -->
    <table>
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
        <tbody id="dealTable">

        </tbody>
    </table>

    <div class="pagination pagination-centered">

    </div>
</div>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/accountdetail.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dealDetail.js"></script>
  </body>
</html>
