<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<div class="mbxnav">
   系统管理\<a href="${pageContext.request.contextPath }/role/roleList">角色权限管理</a>
</div>
<input type="hidden" id="path" value="${pageContext.request.contextPath}" name="path"/>
<div class="container">
	<ul>
	
		<!-- 角色列表 -->
		<li class="jslist">
			<ul>
				<c:forEach items="${roleList}" var="role">
					<li>
						<div id="sidebar">
							<a target="funclist" href="${pageContext.request.contextPath }/resource/resourceList/${role.roleId}">${role.roleName}</a>
							<input type="hidden" name="roleId" value="${role.roleId}">
							<%--/funclist.action?roleId=<s:property value="id"/>--%>
						</div>
					</li>
				</c:forEach>
				<%--<s:iterator value="roleList">--%>
					<%--<li>--%>
						<%--<div id="sidebar">--%>
							<%--<a target="funclist" href="/funclist.action?roleId=<s:property value="id"/>">--%>
							<%--<s:property value="roleName"/></a>--%>
						<%--</div>--%>
					<%--</li>--%>
				<%--</s:iterator>	--%>
			</ul>
		</li>
		
		<!-- 功能 列表 -->
		<li class="iframeli">
		
			<iframe id="funclist" name="funclist" width="100%" height="99%" src="">

			</iframe>
		</li>
	</ul>

</div>
</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/permission.css"/>
</html>
