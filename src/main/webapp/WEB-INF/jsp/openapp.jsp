<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="../common/iframehead.jsp"%>
<div class="addAppTitle">
	<h2>开通APP</h2>
</div>
	
<div class="message">

</div>

<div class="formdiv">
	<form action="" method="post">
		<div>
			<ul>
				<input type="hidden" name="keyword.id" value="${keyword.keywordId}">
				<input type="hidden" name="keyword.openApp" value="1">
				<input type="hidden" name="keyword.keyword" value="${keyword.keyword}">
				<input type="hidden" name="keyword.customer.companyName" value="${keyword.customer.companyName}">
				<c:if test="${keyword.typeId=='20'}">
					<input type="hidden" name="price" value="${keyword.term*26000}">
				</c:if>
				<c:if test="${keyword.typeId=='21'}">
					<input type="hidden" name="price" value="${keyword.term*18000}">
				</c:if>
				<%--<input type="hidden" name="systemConfig.configTypeName" value="${systemConfig.configTypeName}">--%>
			
				<li>登录账号:<input type="text" name="appInfo.appCode" value="${appInfo.appCode}"></li>
				<li>登录密码:<input type="text" name="appInfo.appPassword" value="${appInfo.appPassword}"></li>
				<li>关键词:${keyword.keyword}</li>
				<li>企业名称:${keyword.customer.companyName}</li>
				<c:if test="${keyword.typeId=='20'}">
					<li>价格: ￥ ${keyword.term*26000}</li>
				</c:if>
				<c:if test="${keyword.typeId=='21'}">
					<li>价格: ￥ ${keyword.term*26000}</li>
				</c:if>

				<li>服务类型:${keyword.type.typeName}</li>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="submitdiv"> <input type="submit" value="开通APP" ></div>
	</form>
</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/openapp.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/openapp.js"></script>
</body>
</html>
