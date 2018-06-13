<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Facility Listing</title>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/facility-list.css"/>"/>
</head>



<body>

<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

<div class="container container-wrapper">
<div class="row-container row row-eq-height">
	<div class="col-md-2 filter-section">
		<h2>Filter options</h2>
		<form method="GET" action="list">
			<div>Facility name</div>
			<input type="text" name="searchParam" placeholder="Facility name" class="filter-textbox"></input>
			<input class="btn btn-success" type="submit" value="Search"></input>
		</form>
	</div>

	<div class="col-md-10">
		<div class="container">
	
			<div class="row">
			
				<c:if test="${empty facilities}">
					<h1>No results found!</h1>
				</c:if>
			
				<!-- for each facility.. -->
				<c:forEach items="${facilities}" var="facility">
	
					<!-- Print the facility in neat cards. -->
  					<div class="col-sm-6">
    					<div class="card">
    						<div class="jumbotron card-jumbotron-image">
    						</div>
    				
      						<div class="card-body">
        					<h5 class="card-title"><a href="/iss/Facility/detail?facilityId=<c:out value="${facility.facilityId}"/>"><c:out value="${facility.facilityname}"/></a></h5>
        					<p class="card-text"><c:out value="${facility.facilitydescription}"/></p>
        					<a href="/iss/Facility/detail?facilityId=<c:out value="${facility.facilityId}"/>" class="btn btn-primary">View details</a>
      						</div>
    					</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>