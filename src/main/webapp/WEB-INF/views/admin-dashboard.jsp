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
				<div class="card card-item">
					<img class="card-img-top" src="https://cdn.aarp.net/content/dam/aarp/money/budgeting_savings/2016/04/1140-yeager-sell-your-used-books.imgcache.rev6feda141288df73e8fd100822bb375ea.jpg" alt="Card image cap">
					<div class="card-body">
    					<h5 class="card-title">Booking Administration</h5>
    					<p class="card-text">An overview of bookings as made by the users.</p>
						<a href="/iss/Admin/Booking/list" class="btn btn-primary">View Bookings</a>
  					</div>
				</div>
			</div>
			
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top" src="https://www.360logica.com/blog/wp-content/uploads/2016/02/Role-of-QA-in-Tech-Support-768x594.jpg"/>
					<div class="card-body">
    					<h5 class="card-title">Role Administration</h5>
    					<p class="card-text">Adjust the list of available roles.</p>
						<a href="/iss/Admin/Role/list" class="btn btn-primary">View Roles</a>
  					</div>
				</div>
			</div>
			
						
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top" src="http://www.cccul.com/wp-content/uploads/2017/10/member.jpg"/>
					<div class="card-body">
    					<h5 class="card-title">Member Administration</h5>
    					<p class="card-text">View and edit the settings of members</p>
						<a href="/iss/Admin/User/list" class="btn btn-primary">View Members</a>
  					</div>
				</div>
			</div>
			
						
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top card-image" src="https://cdn.planonsoftware.com/static/shared/media/cache/Next-generation%20facility%20management%20software%20%E2%80%93%20time%20to%20get%20strategic.a5a0a44aa04aea1ce5e8abdd99f0d6cf.jpg"/>
					<div class="card-body">
    					<h5 class="card-title">Facility Administration</h5>
    					<p class="card-text">Get an overview of the facilities available.</p>
						<a href="/iss/Admin/Facility/list" class="btn btn-primary">View Facilities</a>
  					</div>
				</div>
			</div>
			
			<div class="flex-item">
				<div class="card">
					<img class="card-img-top card-image" src="https://s3.amazonaws.com/images.seroundtable.com/google-my-business-1403701244.png"/>
					<div class="card-body">
    					<h5 class="card-title">Facility Category Administration</h5>
    					<p class="card-text">Check out the list of facility categories</p>
						<a href="/iss/Admin/Category/list" class="btn btn-primary">View Facility Categories</a>
  					</div>
				</div>
			</div>			
		</div>
	</div>
</body>
</html>