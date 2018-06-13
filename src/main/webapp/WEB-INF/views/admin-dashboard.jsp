<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin's Dashboard</title>


	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>

</head>

<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
	<div class="container">
		<h1>Admin Dashboard</h1>
		<h2>Dashboard currently a work in progress</h2>
		<a href="/iss/Admin/Booking/list" class="btn btn-success">Booking Listings</a>
		<a href="/iss/Admin/Booking/list" class="btn btn-primary">Lorem Ipsum</a>
		<a href="/iss/Admin/Booking/list" class="btn btn-submit">Lorem Ipsum?!</a>
		<a href="/iss/Admin/Booking/list" class="btn btn-warning">Lorem Ipsum!</a>
		
	</div>
</body>
</html>