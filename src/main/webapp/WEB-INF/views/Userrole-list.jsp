<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/container-wrapper-form.css"/>"/>
</head>
<html>
<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
	

<div class="container container-wrapper">
	<a href="/iss/Admin/"><h2><i class="fa fa-angle-double-left "></i> Return to admin dashboard</h2></a>
	<h3>Role List page ${fn.length(rolelist)}</h3>
	
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/Admin/Role/create">Add Role</a>
	
	<c:if test="${fn:length(rolelist) gt 0}">

	<table class="table table-striped borderAll">
	<tr>
			<th>Index</th>
			<th>Role Id</th>
			<th>Role Name</th>
			</tr>
		
		<c:forEach var="roles" items="${rolelist}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index+1}</td>
				<td class="nowrap">${roles.roleId}</td>
				<td class="nowrap">${roles.rolename}</td>
			<td align="center">
				<a class="btn btn-success" href="${pageContext.request.contextPath}/Admin/Role/edit/${roles.roleId}.html"> Edit </a></td>
				<td><a
					class="btn btn-warning"
					href="${pageContext.request.contextPath}/Admin/Role/delete/${roles.roleId}.html">
					Delete</a></td>
			</tr>
			</tr>
		</c:forEach>
	</table>
</c:if>

</div>
</body>
</html>