<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<head>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	
	<link rel="stylesheet" href="<c:url value="/css/container-wrapper-form.css"/>"/>
</head>

<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

<div class="container container-wrapper">
	<a href="/iss/Admin/"><h2><i class="fa fa-angle-double-left "></i> Return to Admin Dashboard</h2></a>
<h3>Facility List page</h3>

<a href="${pageContext.request.contextPath}/Admin/Facility/create">Add Facility</a>
<c:if test="${fn:length(facilitylist) gt 0}">
	<table class="table table-striped">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.FacilityId" /></th>
				<th><spring:message code="fieldLabel.FacilityName" /></th>
				<th><spring:message code="fieldLabel.FacilityDescription" /></th>
				<th><spring:message code="fieldLabel.FacilityLocation" /></th>
				<th><spring:message code="fieldLabel.FacilityStatus" /></th>
				<th><spring:message code="fieldLabel.FacilityCategory" /></th>
				<th><spring:message code="caption.edit" /></th>
			</tr>
			
		</thead>
		<tbody>
		<c:forEach var="Facility" items="${facilitylist}">
				<tr class="listRecord">
					<td>${Facility.facilityId}</td>
					<td>${Facility.facilityname}</td>
					<td>${Facility.facilitydescription}</td>
					<td>${Facility.location}</td>
					<td>${Facility.facilitystatus}</td>
					<td>${Facility.category.getCategoryname()}</td>

					<td align="center"><a
						href="${pageContext.request.contextPath}/Admin/Facility/edit/${Facility.facilityId}.html"><spring:message
								code="caption.edit" /></a></td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</c:if>
</div>
</body>