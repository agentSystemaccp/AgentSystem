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
				<select id="servicetype">
					<option value="">请选择</option>
					<c:forEach items="${xufei}" var="xufei">
						<option value="${xufei.typeId}">${xufei.typeName}</option>
					</c:forEach>
				</select>
				<span id="serviceTip" style="color: red"></span>
			</li>
			<li>服务年限: <select id="serviceyear">
					<option value="" selected="selected">--请选择--</option>
					<option value="1">1年</option>
					<option value="2">2年</option>
					<option value="3">3年</option>
					<option value="4">4年</option>
					<option value="5">5年</option>
					<option value="6">6年</option>
					<option value="7">7年</option>
					<option value="8">8年</option>
					<option value="9">9年</option>
					<option value="10">10年</option>
			</select><span id="yearTip" style="color: red"></span></li>
			<li>价格: <input class="price" id="price" type="text"
				readonly="readonly"></li>
			<li><input type="button" id="submitkeyword" onclick="xufeiKeyWord();" value="续费提交">
			</li>
			<input type="hidden" id="kid" value="${keyword.keywordId}">
		</ul>
</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/xufei.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/xufei.js"></script>
</body>
</html>
