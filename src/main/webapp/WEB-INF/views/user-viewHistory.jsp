<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!--  BootStrap inclusion -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body>

	<h1>User booking history</h1>

<div class="container">
<table class="table table-inverse">
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