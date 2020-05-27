<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<link href="css/registration.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
 <div class="registration-page">
  <div class="form">
    <form class="register-form" action="create" method="post">
      <input type="text" placeholder="Username" name="username"/>
        <input type="text" placeholder="FirstName" name="firstname"/>
          <input type="text" placeholder="LastName" name="lastname"/>
             <input type="text" placeholder="Email Address" name= "email1"/>
             <input type="text" placeholder="Job Title" name="job"/>
      <input type="password" placeholder="Password" name="pass1"/>
      <input type="password" placeholder="Re-type Password" name="pass2"/>
   
      
      <button  type="submit" >create</button>
       
   
   

<c:if test="${not empty message}">

<div class="container">
 <div  id="mes">
    <strong >Registration  ${message.responseMessage}!</strong> 
    </div>
</div>

</c:if>

 
      <p class="message">Already registered? <a href="/">Login</a></p>
    </form>
  </div>
</div> 
</body>
</html>