<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<link href="css/confirm.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
 
</head>
<body >
<div class="con">
 Welcome ${user.username}
</div>

 <div class="registration-page">
  <div class="form">
    <form class="register-form" action="create" method="post">
    Congratulations<br>
    Your account has been created successfully ,<br>these are your Registration credentials:<br>
    <h4><b>Fullname:</b><i> ${user.firstname} &nbsp; ${user.lastname} </i> </h4>
      <h4><b>Username:</b><i> ${user.username}</i> </h4>
    <h4><b>Email:</b> <i>${user.email} </i> </h4>
   <h4><b>Job Title:</b> <i>${user.jobTitle}</i></h4>
   
      
      
       
   
   


 
      <p class="message">Click here to go back to <a href="/">Login</a></p>
    </form>
  </div>
</div>
</body>
</html>