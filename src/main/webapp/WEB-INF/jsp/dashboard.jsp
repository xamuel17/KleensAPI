<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html lang ="en">
<head>
 
<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<link href="css/dashboard.css"
        rel="stylesheet">
<title>Admin portal</title>


</head>
<body>
<%@ include file = "header.jsp" %>

	
 


 
<!--  <h3 class="job">Profile</h3> -->

<table>
  <tr style="border:none;">
  <td style="border:none;" >
  
 </td>
 <td style="border:none;">
 
      
    
      <c:forEach items="${pic}" var="picture">
        <tr>
        <td style="border:none;background-color:white;"></td>
       
            <td style="border:none;background-color:white;">
            
             <c:if test = "${picture == null}">
        <img src="images/avatar.png" class="image"/>
      </c:if>
      
          <c:if test = "${picture != null}">
       <img src="data:image/jpg;base64,${picture}" class="image"/>
      </c:if>
      
            </td>
        </tr>
    </c:forEach>

 </td>
  
  </tr>
  <tr>
    <td>UserName</td>
    <td> ${admins.username}</td>
  
  </tr>
  <tr>
    <td>FirstName</td>
    <td> ${admins.firstname}</td>
    
  </tr>
  <tr>
    <td>LastName</td>
    <td>${admins.lastname}</td>
    
  </tr>
  <tr>
    <td>Job Title</td>
    <td>${admins.jobTitle}</td>
  
  </tr>
  <tr>
    <td>Email</td>
    <td>${admins.email}</td>

  </tr>
   <tr>
    
    <td></td>
    <td><a href="/update" class="btn btn-success" role="button">Update Profile</a></td>

  </tr>

</table>


</body>
</html>