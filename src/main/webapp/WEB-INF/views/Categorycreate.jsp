<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
</head>

<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
<h3>New Category page</h3>
<form:form method="POST" modelAttribute="category"
	action="${pageContext.request.contextPath}/Admin/Category/create.html">
	<table>
		<tbody>		
			
			<tr>
				<td><spring:message code="fieldLabel.CategoryName" /></td>
				<td><form:input path="categoryname" /></td>
				<td><form:errors path="categoryname" cssStyle="color: red;" /></td>

			</tr>
			<tr><td><input type="submit" value="Create" /></td></tr>
			
		</tbody>
	</table>
</form:form>
</body>