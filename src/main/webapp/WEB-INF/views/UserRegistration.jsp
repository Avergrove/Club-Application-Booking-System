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
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/user-registration.css"/>"/>
	<script src="//code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
</head>
<title>New Member Creation</title>

<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<div class="container container-wrapper">
	<h1>New Member Creation Form</h1>
	<form:form id="createform" method="POST" modelAttribute="user"
		action="${pageContext.request.contextPath}/register">
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
					<td><form:input path="email" required="true" id="mail" onChange="ValidateEmail(email)" /> <form:errors path="email"
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
					<td><form:input path="password" required="true" type="password"/> <form:errors
							path="password" cssStyle="color: red;" /></td>
				</tr>

				<tr>
<!--  					<td><s:message code="label.user.joindate" /></td> -->
					<td><form:input path="joindate" id="jd" readonly="true" type="hidden"/><form:errors
							path="joindate" cssStyle="color: red;" /></td>
				</tr>

				<tr>
		<!--  		<td><s:message code="label.user.expirydate" /></td> -->	
					<td><form:input path="expirydate" id="jed" readonly="true" type="hidden"/><form:errors
							path="expirydate" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><form:input path="status" required="true" value="Active" type="hidden"/>
					 <form:errors path="status"	cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><form:input path="roleid" value="1" type="hidden"/>
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
	<br/>
	<Label>! read only fields </Label>
	<div>
	<!-- <input id ="BirthDate" type="text">  -->
	</div>
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
	
	<script>
	$(document).ready(function()
			{
		var fullDate = new Date();
		var twoDigitMonth = ((fullDate.getMonth().length+1) === 1)? (fullDate.getMonth()+1) : '0' + (fullDate.getMonth()+1);
		var y = fullDate.getFullYear();
		var yep = y + "-" + twoDigitMonth + "-" + fullDate.getDate();
		$("#jd").val(yep);
	});
	
	</script>
	<script>
	$(document).ready(function()
			{
		var fullDate = new Date();
		var twoDigitMonth = ((fullDate.getMonth().length+1) === 1)? (fullDate.getMonth()+1) : '0' + (fullDate.getMonth()+1);
		var y = fullDate.getFullYear()+1;
		var yep = y + "-" + twoDigitMonth + "-" + fullDate.getDate();
		$("#jed").val(yep);
	});
	</script>
	
	<script>
	function ValidateEmail(inputText)
	{
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(inputText.value.match(mailformat))
	{
	document.form1.text1.focus();
	return true;
	}
	else
	{
	alert("You have entered an invalid email address!");
	document.form1.text1.focus();
	return false;
	}
	}
	</script>
	
	
	
</body>
</html>
