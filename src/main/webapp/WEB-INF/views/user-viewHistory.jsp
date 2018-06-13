<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
<link rel="stylesheet" href="<c:url value="/css/user-viewHistory.css"/>"/>

</head>
<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<h1>User booking history</h1>

<div class="container">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Booking Id</th>
      <th scope="col">Facility Id</th>
      <th scope="col">Date of Booking</th>
      <th scope="col">Booking Start Date</th>
      <th scope="col">Comments</th>
      <th scope="col">Booking Status</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${bookings}" var="booking">
	<tr>
      <th scope="col"><c:out value="${booking.bookingId}"/></th>
      <td scope="col"><c:out value="${booking.fac.facilityId}"/></th>
      <td scope="col"><c:out value="${booking.bookingdate}"/></th>
      <td scope="col"><c:out value="${booking.startdate}"/></th>
      <td scope="col"><c:out value="${booking.comments}"/></th>
      <td scope="col"><c:out value="${booking.bookstatus}"/></th>
	</tr>
	</c:forEach>
  </tbody>
</table>

</div>

</body>
</html>