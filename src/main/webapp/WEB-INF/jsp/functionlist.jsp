<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/iframehead.jsp"></jsp:include>
<div class="container">
	<h3>功能列表</h3>
	<!-- 操作按钮 -->
	<div class="btndiv">
		<input type="hidden" id="roleid" value="${roleId}">
		<input id="saverolefunc" type="button" value="保存" /> <input
			id="cancel" type="button" value="取消" />
	</div>

	<!-- 功能表格 -->
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" id="cball">全选 /全不选</th>
				<th>功能名称</th>
				<th>功能URL</th>
				<th>创建时间</th>
				<th>是否启用</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resources}" var="resource">
				<tr>
					<td>
						<c:choose>
							<c:when test="${resource.check}">
								<input type="checkbox" class="cb" checked="checked"
									   value="${resource.resourceId}">
							</c:when>
							<c:otherwise>
								<input type="checkbox" class="cb"
									   value="${resource.resourceId}">
							</c:otherwise>
						</c:choose>
					</td>
					<td>${resource.resourceName}
					</td>
					<td>${resource.resourceUrl}
					</td>
					<td>
						<fmt:formatDate value="${resource.createTime}" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						<c:if test="${resource.resourceStatus==1}">启用</c:if>
						<c:if test="${resource.resourceStatus==0}">停用</c:if>
					</td>
				</tr>

			</c:forEach>

		</tbody>
	</table>
</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/functionlist.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/functionlist.js"></script>
</body>
</html>
