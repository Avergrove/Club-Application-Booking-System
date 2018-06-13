<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	
</head>
<html>
<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

<center>
<h3>Role List page ${fn.length(rolelist)}</h3>
<br/>
<a href="${pageContext.request.contextPath}/Admin/Role/create">Add
	Role</a>
	<br/>


<c:if test="${fn:length(rolelist) gt 0}">
	<br />
	<br />
	<table class="borderAll">
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
			<td align="center"><a
					href="${pageContext.request.contextPath}/Admin/Role/edit/${roles.roleId}.html">
						Edit
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/Admin/Role/delete/${roles.roleId}.html">
					Delete</a></td>
			</tr>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br/>
<br/>
<input type="button" value="Back" id="redirectbutton">
</center>
</body>
<script>
	
	    document.getElementById("redirectbutton").onclick = function () {
			alert("You will be returning to previous page");
	    	window.history.back();
	};
</script>
</html>