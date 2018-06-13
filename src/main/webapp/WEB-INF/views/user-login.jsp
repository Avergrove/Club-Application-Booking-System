<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	
	<title>User Login</title>
	<link rel="stylesheet" href="<c:url value="/css/user-login.css"/>"/>
</head>

<body>

	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

	<div class="flexbox">
		<div class="flexbox-item">
			<div class="card">
			
				<div class="card-header">
					<h2>User Login</h2>
				</div>
			
  				<div class="card-body">
					<form action = "login-authentication" method = "POST">
						<c:if test="${not empty param.valid}">
							<div style="color: red;">Invalid Username or password!</div>
						</c:if>
						
         				<div>Username: </div>
         				<input type = "text" name = "username"/>
         				
         				<div>Password:</div> 
         				<input type = "password" name = "password" />
         				<div>Don't have an account yet? Click <a href="/iss/register">here to register for an account</a></div>
         				<input class="btn btn-submit" type = "submit" value = "Login" />
    				</form>    				
  				</div>
  			</div>
		</div>
	</div>
</body>
</html>