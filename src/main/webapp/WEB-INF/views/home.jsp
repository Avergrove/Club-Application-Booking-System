<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value="/css/home.css"/>"/>
</head>

<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<div class="flex-container">
			<div class="flex-item inner-flex-container">
				<h1>CABS Booking System</h1>
					<form action = "Facility/list" method = "GET">
         				<input type = "text" name = "searchParam" placeholder="Search for a facility"/>
         				<input class="btn btn-success" type = "submit" value = "Search" />
    				</form>
    				<div>Or browse all the facilities <a href="${request.contextPath}/iss/Facility/list">here</a></div>
    		</div>
	</div>



	</body>
</html>
