package com.kleens.webApp.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.kleens.WebSpecial.Config;
import com.kleens.WebSpecial.HttpResponse;
import com.kleens.WebSpecial.WebServiceCall;
import com.kleens.db.SpecialMethods.AES;
import com.kleens.db.Staff.Staff;
import com.kleens.webApp.Response.StaffsArrModel;
@Controller
public class StaffWebController {
	final String secretKey = "ssshhhhhhhhhhh!!!!";
	WebServiceCall webserviceCall = new WebServiceCall();
	
//Get all staffs info
	@RequestMapping(value="/staffs", method=RequestMethod.GET)
	public String getStaff(HttpServletRequest request , Model model)throws Exception {
		StaffsArrModel sm = new StaffsArrModel();
		HttpResponse httpResponse = webserviceCall.getMethod(Config.baseUrl + "/staffs");
		Gson gson = new Gson();
		
		sm = gson.fromJson(httpResponse.getResponseBody1(), StaffsArrModel.class);
	model.addAttribute("staff", sm);
		return "staff";
		

		
		
		
	}
	//view Single staff info
	@RequestMapping(value="/serveStaff", method=RequestMethod.GET)
	public String getSingleStaff(HttpServletRequest request , Model model)throws Exception {
		String staffId = request.getParameter("fname");
		HttpResponse httpResponse = webserviceCall.getMethod(Config.baseUrl + "/staff/staffinfo/" + staffId);
		Gson gson = new Gson();
		Staff sm = new Staff(); 
		sm = gson.fromJson(httpResponse.getResponseBody1(), Staff.class);
	System.out.println("Your Address="+sm.getAddress() + "Your dateOfBirth="+sm.getDateOfBirth()+ httpResponse.getResponseBody1());
		model.addAttribute("staff", sm);
	
		return "viewStaff";
	
	
	
}
	//update single staff info
	@RequestMapping (value="/updateStaff", method= RequestMethod.POST)
	public String updateStaff(HttpServletRequest request , Model model, Staff staff) throws Exception{
		
		String staffId = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String sex = request.getParameter("sex");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String perf = request.getParameter("perf");
	
		
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phone");
		String job = request.getParameter("job");
		AES en = new AES();
	
		String encryptedString = en.encrypt(password, secretKey);
		
		
		
		int id =Integer.parseInt(staffId);
		staff.setId(id);
		staff.setFirstname(firstname);
		staff.setUsername(username);
		staff.setPassword(encryptedString);
		staff.setLastname(lastname);
		staff.setAddress(address);
		staff.setDateOfBirth(dob);
		staff.setPerformance(perf);
		staff.setSex(sex);
		staff.setEmail(email);
		staff.setPhoneNo(phoneNo);
		staff.setJobTitle(job);
		

		String requestBody = new Gson().toJson(staff);
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		System.out.println(requestBody);
		HttpResponse httpResponse = webserviceCall.postMethod(Config.baseUrl + "/staff/" + staffId, requestBody , extraHeaders);
		Gson gson = new Gson();
		Staff sm = new Staff();
		sm = gson.fromJson(httpResponse.getResponseBody1(), Staff.class);
	
		if (sm == null) {
			System.out.println(sm.getAddress()+ sm.getFirstname());
			getSingleStaff( request ,  model);
			return "viewStaff";
		}
		return "viewStaff"; 
	}
}
