<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/head-include.jsp"/>
	<link rel="stylesheet" href="<c:url value="/css/container-wrapper-form.css"/>"/>
	
</head>
<body>
	<jsp:include page="${request.contextPath}/WEB-INF/includes/nav-bar-include.jsp"/>

<div class="container container-wrapper">
	<a href="/iss/Admin/Role/list"><h2><i class="fa fa-angle-double-left "></i> Return to Role list</h2></a>	
<form:form   name="myForm" method="POST" modelAttribute="userrole" action="${pageContext.request.contextPath}/Admin/Role/create.html" onsubmit="return validate()">
	
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
			
				<tr>
				   <td>Role Name</td>
				   <td><form:input path="rolename" name="fname" required="required" placeholder="Enter a role." 
				   />
				   
				 </tr>
	
				 <td><input type="submit" value="Submit" > </td>
				 <td><input type="reset" value="Back" id="back"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
</div>
</body>

<script>
	
	    document.getElementById("back").onclick = function () 
	    {
		
	    	window.history.back();
	    };
	    
	  
</script>
<script>
 
  </script>

</html>