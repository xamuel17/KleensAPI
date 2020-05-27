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




	<h3 class="job">CUSTOMER ORDERS</h3>
	<div style="margin-left: 2%;"> <P><b>Account Owner- <i style=" text-transform: uppercase;color:#11113a;">${fname }  &nbsp;${lname }</i></b></p>
		<p><b>Email-<b> <i style="color:red;">${email}</i> </p>
	</div>
	<div class="table-responsive">
		<table class="table table-condensed">

			<thead class="thead-dark">
				<tr>
					<th>Order ID</th>
					<th>Customer ID</th>
					<th>Service ID</th>
					<th>Vehicle ID</th>
					<th>Plan</th>
					<th>Schedule Time</th>
					<th>Schedule Date</th>
					<th>Booking Code</th>
					<th>Payment Type</th>
					<th>Status</th>
					<!-- <th> Assigned Staff ID</th> -->
					<th> Location</th>

					<th></th>
					<th></th>
					<th></th>
				</tr>
			<thead>

				<c:forEach var="emp" items="${order.customer}">
					<tr>

						<td name="id" value="${emp.id}">${emp.id}</td>
						<form action="fetchSingleOrder" method="get">
							<input type="hidden" name="fname" value="${emp.id}">
						<td>${emp.custID}</td>
						<td>${emp.serviceID}</td>
						<td>${emp.cvID}</td>
						<td>${emp.plan}</td>
						<td>${emp.scheduleTime}</td>
						<td>${emp.scheduleDate}</td>
						<td>${emp.bookingCode}</td>
						<td>${emp.paymentType}</td>
						<td>${emp.status}</td>
					<%-- 	<td>${emp.staffID}</td> --%>
						<td>${emp.location}</td>
						
	<input type="hidden" name="orderID" value="${emp.id}">
	<input type="hidden" name="custID" value="${emp.custID}">

					<td><button type="submit" name="fetchSingleOrder" class="btn btn-primary" >View </button></td>
						<td><button type="submit" name="staff" class="btn btn-info">Assign Staff</button></td>
						<td><button type="submit" name="cancel" class="btn btn-danger">Cancel</button></td>
						</form>
					</tr>


				</c:forEach>
		</table>
	</div>


</body>
</html>