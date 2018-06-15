<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/container-wrapper-form.css"/>"/>
<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />
	<script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<title>Booking Page</title>
</head>
<body>

<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
<div class="container container-wrapper">
	<a href="/iss/Facility/list/"><h2><i class="fa fa-angle-double-left "></i> Return to Browse</h2></a>
<h1>Booking</h1>
<br>
<br>
<form:form method="POST" commandName="booking" action="${pageContext.request.contextPath}/Booking/create">
<table>
<!-- <tr>
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
     	<!-- <td>Facility:</td>  --> 
     	<td><s:message code="label.booking.fname" /></td>
       	<td colspan="3">
       	<form:select cols="5" path="facilityId" id="ddfacility" label="Select a facility">
       	<form:option value="-" label="--Select facility--"/>-->
       	<form:options items="${facilitylist}"/>
		</form:select>
		<form:errors path="facilityId" cssStyle="color: red;" /></td>
		
    </tr>
<!--     
    <tr>
     	<td>Facility:</td> 
       	<td colspan="3">
       	<form:select cols="5" path="facilityId" id="ddfacility1" label="Select a facility">
       	<form:option value="-" label="--Select facility--"/>
		</form:select>
		<form:errors path="facilityId" cssStyle="color: red;" /></td>
    </tr>
-->   
    <tr>
    		<td><s:message code="label.booking.sdate" /></td>
			<td><form:input size="16" path="startdate" id="datepicker1"/>	
			<form:errors path="startdate" cssStyle="color: red;" /></td>
				
	</tr>
    <tr>
			<td><s:message code="label.booking.comments" /></td>
			<td colspan="3"><form:textarea cols="64" rows="5"
					path="comments" /></td>
	</tr>
    <tr>
    </tr>
    <tr>
        <td><input class="btn btn-primary" type="submit" value="Submit"></td>
     	<td><input class="btn btn-warning" type="reset" id ="new" value="Reset" alt=""></td>
		<td><input class="btn btn-submit" type="reset" value="Back" id="cdke" alt=""></td>
    </tr>
    <tr><td><form:errors path="usr" cssStyle="color: red;" /></td></tr>
</table>
</form:form>

	<div>
	<!-- <input id ="date picker" type="text">  -->
	</div>
	<script>
	$(document).ready(function(){
		// Create an associated datepicker
		$( "#datepicker1" ).datepicker({
			dateFormat:"dd/mm/yy",
			minDate: '0',
			maxDate: "+1M",
			showAnim: 'clip',
			appendText: "Date should be in DD/MM/YYYY"
		});
		
		document.getElementById("cdke").onclick = function()
		{
			window.history.back();
		};
		
	});	
	
	</script>	
	
	<div>
	<!-- <ajax drop down box>  -->
	</div>
	<script>
	$(document).ready(function(){
		$('#category').on('change',function(){
			var catId = $('#category option:selected').val();
			var random = _.findValue('${categorylist}',1);
			alert(random);
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/Booking/create/loadState' + catId,
				success:function(result){
					alert(result);
				
				}
			})
		});
		
		
	});	
	
	</script>	
</div>
</body>
</html>