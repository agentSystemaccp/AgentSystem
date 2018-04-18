<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<div class="mbxnav">
   系统管理\<a href="${pageContext.request.contextPath }/role/roleList">角色权限管理</a>
</div>
<div class="container">
	<ul>
	
		<!-- 角色列表 -->
		<li class="jslist">
			<ul>
				<c:forEach items="${roleList}" var="role">
					<li>
						<div id="sidebar">
							<a target="funclist" href="/funclist.action?roleId=<s:property value="id"/>">
								${role.roleName}</a>
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
		
			<iframe id="funclist" name="funclist" width="100%" height="99%" src=""></iframe>
		</li>
	</ul>

</div>
</body>
</html>
