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




	<h3 class="job">Staff Info</h3>
	<div style="margin-left: 2%;">
		<P>
			<b><i style="text-transform: uppercase; color: #11113a;"></i></b>
		</p>
		<p>
			<b><b> <i style="color: red;"></i>
		</p>







		<table>
				<form action="updateStaff" method="post">
			<tr style="border: none;">
				<td style="border: none;"></td>
				<td style="border: none;"><c:forEach items="${pic}"
						var="picture">
						<tr>
							<td style="border: none; background-color: white;"></td>

							<td style="border: none; background-color: white;"><c:if
									test="${picture == null}">
									<img src="images/avatar.png" class="image" />
								</c:if> <c:if test="${picture != null}">
									<img src="data:image/jpg;base64,${picture}" class="image" />
								</c:if></td>
						</tr>
					</c:forEach></td>

			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3" name = "username"  value=" ${staff.username} "></td>

			</tr>
			<tr>
				<td>FirstName</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3" name = "firstname"  value=" ${staff.firstname} ">
				</td>

			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3" name = "lastname"  value="${staff.lastname} "></td>

			</tr>
			<tr>
				<td>Sex</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3" name = "sex"  value="${staff.sex} "></td>

			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3" name = "dob" value="${staff.dateOfBirth} "></td>

			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3"name = "address" value="${staff.address} "></td>

			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3" name = "email" value="${staff.email} "></td>

			</tr>

			<tr>
				<td>Job Title</td>
				<td><input type="text" class="form-control" id="basic-url"
					aria-describedby="basic-addon3" name = "job" value="${staff.jobTitle}"></td>

			</tr>
			<tr>
				<td>Performance</td>
				<td><div class="input-group-prepend">


						<input type="text" class="form-control" id="basic-url"
							aria-describedby="basic-addon3" name = "pref" value="${staff.performance}">
					</div></td>

			</tr>
			<tr>
				<td><span class="input-group-text" id="basic-addon3">PhoneNumber</span></td>
				<td>
					<div class="input-group-prepend">


						<input type="text" class="form-control" id="basic-url"
							aria-describedby="basic-addon3" name = "phone" value="${staff.phoneNo}">
					</div>
				</td>

			</tr>
			<tr>


				<td></td>
			
				<td><button type="submit" class="btn btn-success" >Update Profile </button></td>

			</tr>
			
			<%-- <input type="hidden" name="id" value="${staff.id}">
			<input type="hidden" name="username" value="${staff.username}">
			<input type="hidden" name="password" value="${staff.password}">
			<input type="hidden" name="firstname" value="${staff.firstname}">
			<input type="hidden" name="lastname" value="${staff.lastname}">
			<input type="hidden" name="sex" value="${staff.sex}">
			<input type="hidden" name="dob" value="${staff.dateOfBirth}">
			<input type="hidden" name="address" value="${staff.address}">
			<input type="hidden" name="job" value="${staff.jobTitle}">
			<input type="hidden" name="perf" value="${staff.performance}">
			<input type="hidden" name="phone" value="${staff.phoneNo}">
			<input type="hidden" name="phone" value="${staff.email}"> --%>
			</form>
		</table>
</body>
</html>