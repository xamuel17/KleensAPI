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

<link href="css/customerOrder.css"
        rel="stylesheet">
<title>Customer Order </title>

<script src="js/update.js"></script>
</head>
<body>
<%@ include file = "header.jsp" %>

	 <form class="vehicles" action="updateInfo" method="post" name="myForm"  >
    <h2><b>Customer Vehicles</b></h2>
    <div class="table-responsive">
 <table class="table table-hover table-dark" >
 <thead class="thead-dark">
  <tr>
  <th>Vehicle ID</th>
  <th>Customer ID</th>
    <th> Type</th>
    <th>Brand</th>
     <th>Colour</th>
    <th>License No.</th>
   
    
       
  </tr>
  <c:forEach var="emp" items="${vehicle.vehicles}">
					<tr>

					
						
							
						<td>${emp.id}</td>
						<td>${emp.custID}</td>
						<td>${emp.vehicleType}</td>
						<td>${emp.vehicleBrand}</td>
					
						<td>${emp.vehicleColour}</td>
							<td>${emp.vehiclePlateNo}</td>
							
							
						</tr>
 
  </thead>
  	</c:forEach>
</table> 
  
</div>

    </form>
 


 <form class="tform" action="updateInfo" method="post" name="myForm"  >
   
  
<div class="id-card-tag"></div>
	<div class="id-card-tag-strip"></div>
	<div class="id-card-hook"></div>
	<div class="id-card-holder">
		<div class="id-card">
			<div class="header">
				<img src="images/kleenrims.png">
			</div>
			<div class="photo">
			<c:forEach items="${custpic}" var="picture">
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
			 
			 
			 
			 
			 </div>
			 <br>
			
			<h2><b> ${cust.lastname} ${cust.firstname} </b></h2>
			
			<b>Customer ID:</b><i>${cust.id}</i>
			<br>
			<b>Status:  </b><i>${cust.status}</i>
			<div class="qr-code">
				<img src="https://www.shopify.com/growth-tools-assets/qr-code/shopify-faae7065b7b351d28495b345ed76096c03de28bac346deb1e85db632862fd0e4.png">
			</div>
			<h3>${cust.email }</h3>
			<hr>
			<p><strong>"PENGG"</strong>HOUSE,4th Floor, TC 11/729(4), Division Office Road <p>
			<p>Near PMG Junction, 100 Bode Thomas Road, Nigeria <strong>92934</strong></p>
			<p>Ph: 07062511471 | E-ail: Kleensman8080@gmail.com</p>

		</div>
	</div>

    </form> 
<!--  <h3 class="job">Profile</h3> -->



<div class="registration-page">
 
  <div class="form">
   
    <form class="register-form" action="updateInfo" method="post" name="myForm"  >
  
    
    <table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<center><tr>
   <td><h1><b class="det">Order Details</b></h1></td>
   <p></p>
</tr><center>
 
<table border='0' width='480px' cellpadding='0' cellspacing='0' align='center'>
<tr>
    <td align='center'>OrderID:</td>
    <td><input readonly  type='text' name='OrderID'  value="${order.id}"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>Customer ID:</td>
    <td><input readonly  type='text' name='CustomerID'  value="${order.custID}"></td>
</tr>
<tr>
    <td align='center'>Service ID:</td>
    <td><input readonly  type='text' name='ServiceID'  value="${order.serviceID}"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>Vehicle ID:</td>
    <td><input readonly  type='text' name='VehicleID' value="${order.cvID}"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center'>Plan:</td>
    <td><input readonly  type='text' name='Plan' value="${order.plan}"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center' >Schedule Time:</td>
    <td><input readonly   type='text' name='ScheduleTime' value="${order.scheduleTime}"></td>
</tr>
<tr>
    <td align='center' >Schedule Date:</td>
    <td><input readonly  type='text' name='ScheduleDate' value="${order.scheduleDate}"> </td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center' >Booking Code:</td>
    <td><input  readonly type='text' name='BookingCode' value="${order.bookingCode}"></td>
</tr>
<tr>
    <td align='center' >Payment Type:</td>
    <td><input readonly  type='text' name='PaymentType' value="${order.paymentType}"></td>
</tr>
<tr>
    <td align='center' >Status:</td>
    <td><input readonly  type='text' name='Status' value="${order.status}"></td>
</tr>
<tr>
    <td align='center' >Assigned Staff ID:</td>
    <td><input readonly  type='text' name='StaffID' value="${order.staffID}"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<tr>
    <td align='center' >Location:</td>
    <td><input readonly  type='text' name='Location' value="${order.location}"></td>
</tr>
<tr> <td>&nbsp;</td> </tr>
<table border='0' cellpadding='0' cellspacing='0' width='480px' align='center'>
<tr>

</tr>
</table>
</table>
 
</table>
    
    
    
    
    
    
    
    
    
    
<%--     
 <b>Order ID:</b><input readonly  type="text" placeholder="" name= "OrderID"  value="${order.id}"  />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <b>Customer ID:</b><input readonly  type="text" placeholder="" name= "CustomerID"  value="${order.custID}"  />
   
  <b>Service ID:</b><input readonly  type="text" placeholder="" name= "ServiceID"  value="${order.serviceID}"  />
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <br>
    <br>
  <b>Vehicle ID:</b><input readonly  type="text" placeholder="" name= "CustomerID"  value="${order.cvID}"  />
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <b>Plan:</b><input readonly  type="text" placeholder="" name= "Plan"  value="${order.plan}"  />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <b>Schedule Time:</b><input readonly  type="text" placeholder="" name= "SchedulePlan"  value="${order.scheduleTime}"  />
    <br>
    <br>
   <b>Schedule Plan:</b> <input readonly  type="text" placeholder="" name= "ScheduleTime"  value="${order.scheduleDate}"  />
   &nbsp;&nbsp;&nbsp;&nbsp;
  <b>Booking Code:</b><input readonly  type="text" placeholder="" name= "BookingCode"  value="${order.bookingCode}"  />
      
     <b>Payment Type:</b><input readonly  type="text" placeholder="" name= "PaymentType"  value="${order.paymentType}"  />        
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <br>
      <b>Status:</b> <input readonly  type="text" placeholder="" name= "Status"  value="${order.status}"  />        
    
     <b>Staff ID:</b> <input readonly  type="text" placeholder="" name= "StaffID"  value="${order.staffID}"  />        
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <b>Location:</b> <input readonly  type="text" placeholder="" name= "Location"  value="${order.location}"  />  
   
 --%>
 


  <br>
  <br>
  <br>

   <span  value ="${fail}" > ${fail}</span>


    </form>
    
  </div>
</div> 

</body>
</html>