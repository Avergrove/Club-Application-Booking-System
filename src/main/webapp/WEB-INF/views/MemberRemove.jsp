<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/container-wrapper-form.css"/>"/>
	
	<script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<title>Change Member Active Status(s)</title>
<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>
	<div class="container container-wrapper">
	<form:form id="deleteform" method="POST" modelAttribute="user"
		action="${pageContext.request.contextPath}/Admin/User/delete/${user.memberid}.html">

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>

				<tr>
					<td><s:message code="label.user.id" /></td>
					<td><form:input path="memberid" readonly="true" />!<form:errors
							path="memberid" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.fname" /></td>
					<td><form:input path="firstname" readonly="true" />!<form:errors
							path="firstname" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.sname" /></td>
					<td><form:input path="secondname" readonly="true" /> <form:errors
							path="secondname" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.surname" /></td>
					<td><form:input path="surname" readonly="true" />!<form:errors path="surname"
							cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.dob" /></td>
					<td><form:input path="dob" readonly="true"/>!<form:errors path="dob"
							cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.email" /></td>
					<td><form:input path="email" readonly="true" />!<form:errors path="email"
							cssStyle="color: red;" /></td>
				</tr>


				<tr>
					<td><s:message code="label.user.phoneno" /></td>
					<td><form:input path="phone" readonly="true"/>!<form:errors path="phone"
							cssStyle="color: red;" /></td>
				</tr>


				<tr>
					<td><s:message code="label.user.userid" /></td>
					<td><form:input path="userid" readonly="true"/>!<form:errors path="userid"
							cssStyle="color: red;" /></td>
				</tr>
				
				<tr>
					<td><s:message code="label.user.password" /></td>
					<td><form:input path="password" readonly="true"/>!<form:errors path="password"
							cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.joindate" /></td>
					<td><form:input path="joindate" readonly="true" />!<form:errors
							path="joindate" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.expirydate" /></td>
					<td><form:input path="expirydate" readonly="true"/>!<form:errors
							path="expirydate" cssStyle="color: red;" /></td>
				</tr>

				<tr>
					<td><s:message code="label.user.status" /></td>
					<td><form:select path="status" required="true">
						<form:option value="Active" label="Active"/>
						<form:option value="InActive" label="InActive"/>
					</form:select>
					 <form:errors path="status"	cssStyle="color: red;" /></td>
				</tr>
				
				<tr>
				<td><s:message code="label.user.role" /></td>
					<td><form:input id="editrole" path="roleid" readonly="true"/>!
					</td>
				
				</tr>

				<tr>
					<td><input type="submit" value="Submit" class="btn btn-primary"></td>
					<td><input type="reset" value="Reset" class="btn btn-warning"></td>
					<td><input type="reset" value="Back" id="dke" class="btn btn-submit"></td>
				</tr>
			</table>
		</center>
	</form:form>
	</div>
	<Label>*required fields</Label><br/>
	<Label>!!read only fields</Label>
	
	<form:form id="deleteroleform">

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">RoleId</th>
					<th width="55%">RoleName</th>
				</tr>
				<tr>
				<c:forEach var="roles" items="${rolelist}">
					<tr>
					<td>${roles.roleId}</td>
					<td>${roles.rolename}</td>
					</tr>
					</c:forEach>
				</tr>
				</table>
				</center>
	</form:form>
	
	<script>		
		document.getElementById("dke").onclick = function()
		{
			window.history.back();
		};
		
		$("#dd").prop('disabled','disabled');
		</script>
</body>
</html>