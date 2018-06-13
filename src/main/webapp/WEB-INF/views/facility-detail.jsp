<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Facility details page</title>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/facility-detail.css"/>"/>

</head>

<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<div class="container container-wrapper">
		<div class="jumbotron">

		</div>
		
		<div class="row">
			<div class="col-md-10">
				<div class="container container-details">
					<h1><c:out value="${facility.facilityname}"/></h1>
					<h3><c:out value="${facility.location}"/></h3>
					<!--  <div><c:out value="${facility.facilitydescription}"/></div>  -->
					<div>Make it pop can you make it pop. Mmm, exactly like that, but different anyway, you are the designer, you know what to do, can you use a high definition screenshot. Can you make the font bigger? the website doesn't have the theme i was going for, but I like it, but can the snow look a little warmer. Low resolution? It looks ok on my screen can you make it pop, or I got your invoice...it seems really high, why did you charge so much, and that sandwich needs to be more playful i'll know it when i see it but can you help me out? you will get a lot of free exposure doing this. Make it look like Apple try a more powerful colour this looks perfect. Just Photoshop out the dog, add a baby, and make the curtains blue. I really think this could go viral.</div>
				</div>
			</div>
			
			<div class="col-md-2">
				<a class="btn btn-primary" href="/iss/Booking/create?facilityId=${param.facilityId}">Book now!</a>
			</div>
		
						
	</div>
</body>
</html>