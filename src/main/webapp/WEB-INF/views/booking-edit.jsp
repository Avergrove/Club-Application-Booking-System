<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/container-wrapper-form.css"/>"/>
	
</head>

<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<div class="container container-wrapper">
	
	<a href="/iss/Admin/Booking/list"><h2><i class="fa fa-angle-double-left "></i> Return to Booking listing</h2></a>	
	
		<form action="/iss/Admin/Booking/submit" method="POST">
			<input type="hidden" value="${booking.bookingId}" name="bookingId"/>
			<div><span>Booking Id: </span><c:out value="${booking.bookingId}"></c:out></div>
			<div><span>User: </span><c:out value="${booking.usr.firstname} ${booking.usr.surname}"></c:out></div>
			<div><span>Facility: </span><c:out value="${booking.fac.facilityname}"></c:out></div>
			<div><span>Booking Date: </span><c:out value="${booking.bookingdate}"></c:out></div>
			<div><span>Start Date: </span><c:out value="${booking.startdate}"></c:out></div>
			<div><span>Comment: </span><input type="text" value="${booking.comments}" name="comments"/></div>
			<div><span>Booking Status: </span><input type="text" value="${booking.bookstatus}" name="bookstatus"/></div>
			<input class="btn btn-success" type="submit" value="submit"/>
		</form>
		
	</div>
	
	
</body>
</html>