<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/container-wrapper-form.css"/>"/>
</head>

<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
	<div class="container container-wrapper">
<!-- <a href="/iss/Admin/Facility/list"><h2><i class="fa fa-angle-double-left "></i> Return to Facility list</h2></a>	-->	
	<h3>New Facility page</h3>
	<form:form method="POST" modelAttribute="facility"
	action="${pageContext.request.contextPath}/Admin/Facility/create.html">
	<table>
		<tbody>			
			<tr>
				<td><spring:message code="fieldLabel.FacilityName" /></td>
				<td><form:input path="facilityname" /></td>
				<td><form:errors path="facilityname" cssStyle="color: red;" /></td>

			</tr>
			<tr>
				<td><spring:message code="fieldLabel.FacilityDescription" /></td>
				<td><form:input path="facilitydescription" /></td>
				<td><form:errors path="facilitydescription" cssStyle="color: red;" /></td>

			</tr>
			<tr>
				<td><spring:message code="fieldLabel.FacilityLocation" /></td>
				<td><form:input path="location" /></td>
				<td><form:errors path="location" cssStyle="color: red;" /></td>

			</tr>
			<tr>
				<td><spring:message code="fieldLabel.FacilityStatus" /></td>
				<td><form:select path="facilitystatus">
				<form:option value="Active" label="Active"/>
				<form:option value="InActive" label="InActive"/>
				</form:select></td>

			</tr>

			<tr>
				<td><spring:message code="fieldLabel.FacilityCategory" /></td>
				<td><form:select path="categoryid">
						<form:option value="0" label="Please select Category" />
						<form:options items="${categorylist}" itemLabel="categoryname" itemValue="categoryId"/>
					</form:select></td>
			</tr>
			<tr>
			<td><input type="submit" value="Create" /></td>
			<td><input type="reset" value="Back" id="ffbke"></td>
			</tr>
		</tbody>
	</table>
	</form:form>
	</div>
	
	<script>
		document.getElementById("ffbke").onclick = function() {
			window.history.back();
		};
	</script>
</body>

