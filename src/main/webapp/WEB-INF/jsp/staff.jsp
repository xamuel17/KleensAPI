<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this, Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<link href="css/customer.css" rel="stylesheet">
<title>Admin portal</title>


</head>
<body>
	<%@ include file="header.jsp"%>




	<h3 class="job">REGISTERED STAFFS</h3>
	<div style="margin-left: 2%;"> <P><b><i style=" text-transform: uppercase;color:#11113a;"></i></b></p>
		<p><b><b> <i style="color:red;"></i> </p>
	</div>
	<div class="table-responsive">
		<table class="table table-condensed">

			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>UserName</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Address</th>
					<th>Sex</th>
					
					<th>D.O.B</th>
					<th>Address</th>
					<th>Email</th>
					<th>Job title</th>
					<th>Performance</th>
					<th>Phone No.</th>

					<th></th>
					
				</tr>
			<thead>

				<c:forEach var="emp" items="${staff.staff}">
					<tr>

						<td name="id" value="${emp.id}">${emp.id}</td>
						<form action="serveStaff" method="get">
							
						<td>${emp.username}</td>
							
						<td value="${emp.firstname}">${emp.firstname}</td>
						<td>${emp.lastname}</td>
						<td>${emp.address}</td>
						<td>${emp.sex}</td>
						<td>${emp.dateOfBirth}</td>
						<td>${emp.address}</td>
						
						<td>${emp.email}</td>
						<td>${emp.jobTitle}</td>
						<td>${emp.performance}</td>
						<td>${emp.phoneNo}</td>
							<input type="hidden" name="fname" value="${emp.id}">
							<input type="hidden" name="firstname" value="${emp.firstname}">
							<input type="hidden" name="lastname" value="${emp.lastname}">
							<input type="hidden" name="email" value="${emp.email}">
								
					<td><button type="submit" name="updateStaff" class="btn btn-info">Update Info</button></td>
					
						</form>
					</tr>


				</c:forEach>
		</table>
	</div>


</body>
</html>