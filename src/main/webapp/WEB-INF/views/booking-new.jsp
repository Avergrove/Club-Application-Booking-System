<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>

<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			minDate:0,
			maxDate: "+1M",
			dateFormat : "dd/mm/yy"
			
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});

</script>




<title>Booking Page</title>
</head>
<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
<h1>Booking</h1>
<br>
<br>
<form:form method="POST" commandName="booking" action="${pageContext.request.contextPath}/Booking/create">
<table>
<!--
 	<tr>
 		<td>Category:</td> 
       	<td colspan="3">
       	<form>
       	<select name="category" id="category">
       		<c:forEach items="${categorylist }" var="cat">
       		<option value="${cat.key}">${cat.value}</option>
       		</c:forEach>
       	</select>
       	</form>	
 	</tr>
-->      
     <tr>
     	<td>Facility:</td> 
       	<td colspan="3"><form:select cols="5" path="facilityId" id="ddfacility">
     	<form:options items="${facilitylist}"/>
		</form:select>
    </tr>
   
    <tr>
			<td>Date: </td>
			<td><form:input type="date" size="16" path="startdate" id="datepicker1" value="Select a date" />		
		</tr>
    <tr>
			<td>Comments: </td>
			<td colspan="3"><form:textarea cols="64" rows="5"
					path="comments" /></td>
		</tr>
    <tr>
        <td colspan="2"><input type="submit" value="Submit"></td>
    </tr>
</table>
</form:form>





</body>
</html>