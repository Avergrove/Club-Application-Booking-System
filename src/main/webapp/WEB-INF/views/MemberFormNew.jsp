<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<%@page
	import="java.text.DateFormat,java.time.DayOfWeek,java.util.Calendar"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>New Member Creation</title>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	
	<script src="//code.jquery.com/jquery-1.12.4.js"></script>
   <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	
	
</head>
<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<form:form id="createform" method="POST" modelAttribute="user"
		action="${pageContext.request.contextPath}/Admin/User/create.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>

				<tr>
					<td><s:message code="label.user.fname" /></td>
					<td><form:input path="firstname" required="true"/> 
					<form:errors path="firstname" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.sname" /></td>
					<td><form:input path="secondname" /> 
					<form:errors path="secondname"/></td>
				</tr>

				<tr>
					<td><s:message code="label.user.surname" /></td>
					<td><form:input path="surname" required="true"/> <form:errors path="surname"
							cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.dob" /></td>
					<td><input id="BirthDate" type="text" name="dob"/> <form:errors path="dob"
							cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.email" /></td>
					<td><form:input path="email" required="true" /> <form:errors path="email"
							cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.phoneno" /></td>
					<td><form:input path="phone" /> <form:errors path="phone"
							cssStyle="color: red;" /></td>
				</tr>


				<tr>
					<td><s:message code="label.user.userid" /></td>
					<td><form:input path="userid" required="true"/> <form:errors path="userid"
							cssStyle="color: red;" />${userconstraintmessage}</td>
				</tr>

				<tr>
					<td><s:message code="label.user.password" /></td>
					<td><form:input path="password" required="true"/> <form:errors
							path="password" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.joindate" /></td>
					<td><form:input path="joindate" /> <form:errors
							path="joindate" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.expirydate" /></td>
					<td><form:input path="expirydate" /> <form:errors
							path="expirydate" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><form:input type="hidden" path="status" value="Active" />
						<form:errors path="status" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.role" /></td>
					<td><form:select id="rolelist" path="roleid" name="rl" >
							<c:forEach var="roles" items="${rolelist}">
					
							<option value="${roles.roleId}" label="${roles.rolename}" />
							</c:forEach>
							

							
						</form:select>
					<form:errors path="role" cssStyle="color: red;" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="reset" id ="new" value="Reset"></td>
					<td><input type="reset" value="Back" id="cdke"></td>
				</tr>
			</table>
		</center>
	</form:form>
	<Label>*required fields</Label>
	<div>
	<!-- <input id ="BirthDate" type="text">  -->
	</div>
	<script>
	$(document).ready(function(){
		// Create an associated datepicker
		$( "#BirthDate" ).datepicker({
			dateFormat:"yy-mm-dd",
			maxDate: '0', 
			showAnim: 'clip',
			appendText: "Date should be in YYYY-MM-DD"
		});
		
		document.getElementById("cdke").onclick = function()
		{
			window.history.back();
		};
		
	});	
</script>
</body>
</html>
