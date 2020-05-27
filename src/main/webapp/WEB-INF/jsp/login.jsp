<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link href="css/login.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
 
</head>
<body >
 

 <div class="login-page">
  <div class="form">
   
    <form class="login-form" action="login" method="post" onsubmit="return validateForm()">
      <input type="text" placeholder="Email" name="email"/>
      <input type="password" placeholder="password" name="password"/>
      <button type="submit">Login</button>
      <p class="message">Not registered? <a href="/register">Create an account<script src="js/login.js"></script></a></p>
    </form>
  </div>
</div> 
</body>
</html>