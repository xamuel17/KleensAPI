package com.kleens.webApp.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.kleens.WebSpecial.Config;
import com.kleens.WebSpecial.HttpResponse;
import com.kleens.WebSpecial.WebServiceCall;
import com.kleens.db.Order.Orders;
import com.kleens.db.customer.Users;


import com.kleens.db.uploadImage.CustImageModel;
import com.kleens.webApp.Response.OrdersArrModel;
import com.kleens.webApp.Response.vehicleArrModel;


@Controller

public class CustomerWebController {



	String uname = new AdminWebController().getUname();
	WebServiceCall webserviceCall = new WebServiceCall();

	// View Customer Orders
	@RequestMapping(value = "/serveCustomer", method = RequestMethod.GET)
	public String serveCustomer(HttpServletRequest request, OrdersArrModel ord, Model model) throws Exception {

		String custid = request.getParameter("fname");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		System.out.println("credentials =>" + firstname + lastname + email);
		if (request.getParameter("orders") != null) {
			System.out.println("Orders was clicked" + custid);

			HttpResponse httpResponse = webserviceCall.getMethod(Config.baseUrl + "/customer/order/" + custid);
			Gson gson = new Gson();
		
			System.out.println("httpresponse=" + httpResponse.responseBody1);

			model.addAttribute("fname", firstname);
			model.addAttribute("lname", lastname);
			model.addAttribute("email", email);

			ord = gson.fromJson(httpResponse.getResponseBody1(), OrdersArrModel.class);

			request.setAttribute("order", ord);
			String uname1 = new AdminWebController().getUname();
			model.addAttribute("uname", uname1);
			return "orders";
		} else if (request.getParameter("activate") != null) {

			model.addAttribute("uname", uname);
			activate(custid);

			new AdminWebController().getAllCutomers(request, model);

		} else if (request.getParameter("block") != null) {
			model.addAttribute("uname", uname);
			block(custid);
			new AdminWebController().getAllCutomers(request, model);

			System.out.println("Block was clicked" + custid);
		}
		return "customers";

	}

//Activate Customer Account
	@RequestMapping(value = "/activate", method = RequestMethod.POST)
	public void activate(String custid) throws Exception {

		String user = null;
		String requestBody = new Gson().toJson(user);
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");

		HttpResponse httpResponse = webserviceCall.postMethod(Config.baseUrl + "/admin/activate/" + custid, requestBody,
				extraHeaders);

		System.out.println("customer id = " + custid + "httpResponse= " + httpResponse.getResponseBody1());

	}

//Block Customer Account
	@RequestMapping(value = "/block", method = RequestMethod.POST)
	public void block(String custid) throws Exception {

		String user = null;
		String requestBody = new Gson().toJson(user);
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");

		HttpResponse httpResponse = webserviceCall.postMethod(Config.baseUrl + "/admin/block/" + custid, requestBody,
				extraHeaders);

		System.out.println("customer id = " + custid + "httpResponse= " + httpResponse.getResponseBody1());

	}
	String custID;
//View Customer Single Order
	@RequestMapping(value = "/fetchSingleOrder", method = RequestMethod.GET)
	public String fetchSingleOrder(HttpServletRequest request, Model model, Orders ord) throws Exception {
		String orderID = request.getParameter("orderID");
		 custID = request.getParameter("custID");
		HttpResponse httpResponse = webserviceCall.getMethod(Config.baseUrl + "/order/" + orderID);
		Gson gson = new Gson();
		System.out.println(Config.baseUrl + "/order/" + orderID);
		System.out.println("Order httpresponse=" + httpResponse.responseBody1);

	

		ord = gson.fromJson(httpResponse.getResponseBody1(), Orders.class);

		request.setAttribute("order", ord);
		fetchVehicles(request,model);
		fetchSingleCustomer(request,model);
		getCustProfilePic(request,model);
		return "customerOrder";
	}
	
	//Get Customer Vehciles with customer ID
	@RequestMapping(value = "/fetchVehicles", method = RequestMethod.GET)
	public void fetchVehicles(HttpServletRequest request, Model model) throws Exception {
		
		HttpResponse httpResponse = webserviceCall.getMethod(Config.baseUrl + "/vehicle/customer/" + custID);
		Gson gson = new Gson();
		

	vehicleArrModel vrd = new vehicleArrModel();

	vrd = gson.fromJson(httpResponse.getResponseBody1(), vehicleArrModel.class);
	System.out.println(httpResponse.getResponseBody1());
	System.out.println("custyomerId=" +vrd.getVehicles());
		request.setAttribute("vehicle", vrd);
		
		
	}
	
	//Get Single Customer details
	@RequestMapping(value = "/fetchSingleCustomer", method = RequestMethod.GET)
	public void fetchSingleCustomer(HttpServletRequest request, Model model) throws Exception {
		
		HttpResponse httpResponse = webserviceCall.getMethod(Config.baseUrl + "/customer/" + custID);
		Gson gson = new Gson();
	
Users us = new Users();
	

		us = gson.fromJson(httpResponse.getResponseBody1(), Users.class);
		System.out.println("Singlke CUtsorf====" +httpResponse.getResponseBody1());
		request.setAttribute("cust", us);
	
		
	}
	
	
	
	
	
	//Get Customer Profile pic 
	
	
	@RequestMapping(value="/custpic" , method = RequestMethod.GET)
	public void getCustProfilePic(HttpServletRequest request, Model model ) throws Exception {
		CustImageModel cc = new CustImageModel();
		
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
	
		HttpResponse httpResponse =  webserviceCall.getMethod(Config.baseUrl+"/customer/pic/" + custID);
		Gson gson = new Gson();
		
		System.out.println("httpresponse="+httpResponse.responseBody1);
	
		
		
		 cc = gson.fromJson(httpResponse.getResponseBody1(), CustImageModel.class);
	
		 //request.setAttribute("cust", cc);	
		System.out.println("pic:" + cc.getPiclist());
		 List<String> custPic2= cc.getPiclist();
		 //setPic(pic2);
		model.addAttribute("custpic",custPic2);
			
	}
	

}
