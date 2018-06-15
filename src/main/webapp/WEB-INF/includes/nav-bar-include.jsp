<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/iss">CABS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/iss">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${request.contextPath}/iss/Facility/list">Browse</a>
      </li>

      <form class="form-inline my-2 my-lg-0" action = "${request.contextPath}/iss/Facility/list" method = "GET">
      	<input class="form-control mr-sm-2" type = "text" name = "searchParam" placeholder="Search for a facility" aria-label="Search">
      	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
   	  </form>
      
    </ul>

    
    <ul class="navbar-nav">
  	  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  	  <c:choose>
      	<c:when test="${empty sessionScope.user}">
      		<a href="${request.contextPath}/iss/login"><button class="btn btn-outline-primary my-2 my-sm-0">Login</button></a>
       		<a href="${request.contextPath}/iss/register"><button class="btn btn-outline-success my-2 my-sm-0">Register</button></a>
  	  	
  	  	</c:when>
 
  	  	
  	  	<c:otherwise>
      		<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          		Welcome, ${user.firstname}!
        		</a>
        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
          		<a class="dropdown-item" href="${request.contextPath}/iss/Booking/viewHistory?memberId=${user.memberid}">View Booking History</a>
        		<c:if test="${user.roleid == 2}">
          			<a class="dropdown-item" href="/iss/Admin"><span class="glyphicon glyphicon-edit"></span>Administrator Settings</a>
          			<div class="dropdown-divider"></div>
        		</c:if>
        		
          		<a class="dropdown-item" href="${request.contextPath}/iss/logout">Logout</a>
        	</div>
      		</li>  	  	
  	  	</c:otherwise>
	  </c:choose>
  	</ul>
  	  
  </div>
</nav>