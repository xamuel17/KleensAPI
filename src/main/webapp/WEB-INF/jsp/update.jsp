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

<link href="css/update.css"
        rel="stylesheet">
<title>Info Update </title>

<script src="js/update.js"></script>
</head>
<body>
<%@ include file = "header.jsp" %>

	
 


 
<!--  <h3 class="job">Profile</h3> -->

<div class="registration-page">
  <div class="form">
    <form class="register-form" action="updateInfo" method="post" name="myForm" onsubmit="return validateForm()" >
      <input type="text" placeholder="Username" name="username"  value="${admin.username}" class="form-control"  />
        <input type="text" placeholder="FirstName" name="firstname"  value="${admin.firstname}" class="form-control"/>
          <input type="text" placeholder="LastName" name="lastname" value="${admin.lastname}"  class="form-control"/>
             <input readonly  type="text" placeholder="Email Address" name= "email1"  value="${admin.email}"  />
             <input type="text" placeholder="Job Title" name="job"  value="${admin.jobTitle}" class="form-control"/>
      <input type="password" placeholder="Password" id="password" onkeyup='check();'  name="pass1"  value="${admin.password}" class="form-control"/>
      <input type="password" placeholder="Re-type Password" id="confirm_password"  onkeyup='check();' name="pass2" value="${admin.password}" class="form-control"/>
 		<span id='message' ></span>
      
      
       <div class="input-group">
 

  <div class="dd">
 
    </div>
    
      
     
</div>

 


  <br>
  <button  type="submit" class="btn btn-success btn-block" >Update Information</button> 
   <span  value ="${fail}" > ${fail}</span>


    </form>
    
  </div>
</div> 

</body>
</html>