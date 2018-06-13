<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
</head>

<body>

<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
<div class="container">
	<a href="/iss/Admin"><h2><i class="fa fa-angle-double-left "></i> Return to Admin Dashboard</h2></a>
	<c:if test="${fn:length(Booklist) gt 0}">
		<table class="table table-striped table-inverse">
    		<thead>
      			<tr>
        			<th>Booking Id</th>
        			<th>User</th>
        			<th>Facility</th>
        			<th>Booking Date</th>
        			<th>Start Date</th>
        			<th>Comments</th>
        			<th>Booking Status</th>
        			<th>Editting</th>
        			<th>Activity</th>
      			</tr>
    		</thead>
    		
    		<tbody>
				<c:forEach var="booking" items="${Booklist}">
				<tr>
					<td>${booking.bookingId}</td>
					<td>${booking.usr.firstname} ${booking.usr.surname}</td>
					<td>${booking.fac.facilityname}</td>
					<td>${booking.bookingdate}</td>
					<td>${booking.startdate}</td>
					<td>${booking.comments}</td>
					<td>${booking.bookstatus}</td>
					<td><a class="btn btn-primary" href="/iss/Admin/Booking/edit?bookingId=${booking.bookingId}">Edit booking</a></td>
					<c:choose>
						<c:when test="${booking.bookstatus == 'cancelled'}">
						<td><a class="btn btn-success" href="/iss/Admin/Booking/activate?bookingId=${booking.bookingId}">Confirm booking</a></td>
						</c:when>
						
						<c:otherwise>
						<td><a class="btn btn-danger" href="/iss/Admin/Booking/cancel?bookingId=${booking.bookingId}">Cancel booking</a></td>							
						</c:otherwise>
					</c:choose>
					
					
				</tr>
				</c:forEach>
    		</tbody>
  		</table>
	</c:if>
</div>
</body>