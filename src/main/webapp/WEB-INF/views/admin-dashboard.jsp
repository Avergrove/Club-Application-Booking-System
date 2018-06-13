<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin's Dashboard</title>


	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/admin-dashboard.css"/>"/>


</head>

<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<div class="container container-wrapper">
		<h1>Admin Dashboard</h1>
		<h2>Dashboard currently a work in progress</h2>
	
		
		<div class="flex-container">
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top" src="https://cdn.aarp.net/content/dam/aarp/money/budgeting_savings/2016/04/1140-yeager-sell-your-used-books.imgcache.rev6feda141288df73e8fd100822bb375ea.jpg" alt="Card image cap">
					<div class="card-body">
    					<h5 class="card-title">Booking Administration</h5>
    					<p class="card-text">An overview of bookings as made by the users.</p>
						<a href="/iss/Admin/Booking/list" class="btn btn-primary">View Listing</a>
  					</div>
				</div>
			</div>
			
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top" src="https://www.360logica.com/blog/wp-content/uploads/2016/02/Role-of-QA-in-Tech-Support-768x594.jpg"/>
					<div class="card-body">
    					<h5 class="card-title">Role Administration</h5>
    					<p class="card-text">Adjust the list of available rows.</p>
						<a href="/iss/Admin/Role/list" class="btn btn-primary">View Listing</a>
  					</div>
				</div>
			</div>
			
						
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top" src="https://www.360logica.com/blog/wp-content/uploads/2016/02/Role-of-QA-in-Tech-Support-768x594.jpg"/>
					<div class="card-body">
    					<h5 class="card-title">Role Administration</h5>
    					<p class="card-text">Adjust the list of available rows.</p>
						<a href="/iss/Admin/Role/list" class="btn btn-primary">View Listing</a>
  					</div>
				</div>
			</div>
			
						
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top" src="https://www.360logica.com/blog/wp-content/uploads/2016/02/Role-of-QA-in-Tech-Support-768x594.jpg"/>
					<div class="card-body">
    					<h5 class="card-title">Role Administration</h5>
    					<p class="card-text">Adjust the list of available rows.</p>
						<a href="/iss/Admin/Role/list" class="btn btn-primary">View Listing</a>
  					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>