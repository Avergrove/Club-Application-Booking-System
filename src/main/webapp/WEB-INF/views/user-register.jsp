<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	
	<title>User Registration</title>
	<link rel="stylesheet" href="<c:url value="/css/user-register.css"/>"/>
</head>

<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<div class="flexbox">
		<div class="flexbox-item">
			<div class="card">
			
				<div class="card-header">
					<h2>User Registration</h2>
				</div>
			
  				<div class="card-body">
					<form:form action="register-authentication" method="POST" modelAttribute="user">
						<c:if test="${not empty param.errorMessage}">
							<c:out value="${param.errorMessage}"></c:out>
						</c:if>
						
         				<div>First name: </div>
         				<input type = "text" name = "firstName" required/>
         				
         				<div>Second name: </div>
         				<input type = "text" name = "secondName"/>
         				
         				<div>Surname: </div>
         				<input type = "text" name = "surname" required/>
         				
         				<div>Date of Birth </div>
         				<input type = "date" name = "dob" required/>
         				
         				<div>Phone: </div>
         				<input type = "text" name = "phoneNo" required/>
         				
         				<div>Username: </div>
         				<input type = "text" name = "username" required/>
         				
         				<div>Password: </div> 
         				<input type = "password" name = "password"  required/>
         				
         				<div>Email: </div> 
         				<input type = "text" name = "email" required/>         				
         				
         				<div>Already have an account? Click <a href="/iss/login">here!</a></div>
         				<input class="btn btn-submit" type = "submit" value = "Register" />
    				</form:form>    				
  				</div>
  			</div>
		</div>
	</div>
</body>
</html>