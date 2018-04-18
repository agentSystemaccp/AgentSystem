<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="../common/iframehead.jsp"%>

<div class="addAppTitle">
	<h2>
	<font size="2"> 为${keyword.keyword }续费</font>
	<font color="red">
		【当前账户余额：￥<span id="accountspan">${userLogin.balance}</span>】
	</font>
	</h2>
</div>
	
<div class="message">

</div>

<div class="formdiv">
	<ul>
			<li>客户名称: <input type="text" id="customname" class="customname"
				readonly="readonly" value="${keyword.customer.companyName}"></li>
			<li>关键词: <input type="text" id="keyword" class="keyword" value="${keyword.keyword}" readonly="readonly">
				</li>
			<li>服务类别:
				<select>
					<option value="">请选择</option>
					<c:forEach items="${xufei}" var="xufei">
						<option value="${xufei.typeName}">${xufei.typeName}</option>
					</c:forEach>
				</select>

			</li>
			<li>服务年限: <select id="serviceyear">
					<option value="" selected="selected">--请选择--</option>
					<option value="1">1年</option>
					<option value="2">2年</option>
					<option value="3">3年</option>
					<option value="2">买二赠一</option>
			</select></li>
			<li>价格: <input class="price" id="price" type="text"
				readonly="readonly"></li>
			<li><input type="button" id="submitkeyword" value="续费提交">
			</li>
			<input type="hidden" id="kid" value="${keywords.id}">
		</ul>
</div>
<link rel="stylesheet" type="text/css" href="/css/xufei.css">
<script type="text/javascript" src="/js/xufei.js"></script>
</body>
</html>
