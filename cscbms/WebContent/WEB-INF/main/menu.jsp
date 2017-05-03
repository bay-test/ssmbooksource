<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<ul id="menu"> 
	<c:choose>
		<c:when test="${currentModule==0 }">
			<li><a href="${pageContext.request.contextPath }/login/toIndex.do" class="index_on"></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath }/login/toIndex.do" class="index_off"></a></li>
		</c:otherwise>
	</c:choose>
	
	<c:forEach items="${allModules }" var="module">
		<c:if test="${module.moduleId==1 }">
			<c:choose> 
				<c:when test="${currentModule==1 }">
					<li><a href="${pageContext.request.contextPath }/role/findRole.do?currentPage=1" class="role_on"></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/role/findRole.do?currentPage=1" class="role_off"></a></li>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${module.moduleId==2 }">
			<c:choose>
				<c:when test="${currentModule==2 }">
					<li><a href="${pageContext.request.contextPath }/admin/findAdmin.do?currentPage=1" class="admin_on"></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/admin/findAdmin.do?currentPage=1" class="admin_off"></a></li>
				</c:otherwise>
			</c:choose>	
		</c:if>
		<c:if test="${module.moduleId==3 }">
			<c:choose>
				<c:when test="${currentModule==3 }">
					<li><a href="${pageContext.request.contextPath }/cost/findCost.do?currentPage=1&baseDurationSort=&baseCostSort=" class="fee_on"></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/cost/findCost.do?currentPage=1&baseDurationSort=&baseCostSort=" class="fee_off"></a></li>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${module.moduleId==4 }">
			<c:choose>
				<c:when test="${currentModule==4 }">
					<li><a href="${pageContext.request.contextPath }/account/findAccount.do?currentPage=1" class="account_on"></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/account/findAccount.do?currentPage=1" class="account_off"></a></li>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${module.moduleId==5 }">
			<c:choose>
				<c:when test="${currentModule==5 }">
					<li><a href="${pageContext.request.contextPath }/service/findService.do?currentPage=1" class="service_on"></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/service/findService.do?currentPage=1" class="service_off"></a></li>
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:forEach>
	<li><a href="user/user_info.html" class="information_off"></a></li>
	<li><a href="user/user_modi_pwd.html" class="password_off"></a></li>
</ul>