package com.kleens.webApp.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.kleens.WebSpecial.Config;
import com.kleens.WebSpecial.HttpResponse;
import com.kleens.WebSpecial.WebServiceCall;
import com.kleens.db.Admin.Admin;
import com.kleens.db.Login.LoginModel;
import com.kleens.db.Repo.AdminRepository;
import com.kleens.db.Response.ResponseModel;
import com.kleens.db.uploadImage.AdminImageModel;
import com.kleens.webApp.Response.AdminResponseModel;
import com.kleens.webApp.Response.CustArrModel;

@Controller


public  class AdminWebController implements WebMvcConfigurer {
	
	
	final String secretKey = "ssshhhhhhhhhhh!!!!";
	WebServiceCall webserviceCall = new WebServiceCall();
	 int adminID ;
		int adminId ;
		public static String uname;
		
		public static int picAdminID;
		
		public static int getPicAdminID() {
			return picAdminID;
		}

		public static void setPicAdminID(int picAdminID) {
			AdminWebController.picAdminID = picAdminID;
		}

		String username;
		Admin admin = new Admin();
		
	

	
	public static String getUname() {
		return uname;
	}

	public static void setUname(String uname) {
		AdminWebController.uname = uname;
	}
	
	public static List<String> pic;



	public static List<String> getPic() {
		return pic;
	}

	public static void setPic(List<String> pic2) {
		AdminWebController.pic = pic2;
	}

	@Autowired
	AdminRepository adminRepo;
	
	
	
	
	
	
	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) {
		Map<String,?> inputFlashMap = RequestContextUtils
		.getInputFlashMap(request);
		if(inputFlashMap !=null) {
			model.addAttribute("message", inputFlashMap.get("submitForm"));
			
		}
				return "login";
	}
	
	
	
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request, Model model) {
		Map<String,?> inputFlashMap = RequestContextUtils
		.getInputFlashMap(request);
		if(inputFlashMap !=null) {
			model.addAttribute("message", inputFlashMap.get("submitForm"));
			
		}
				return "registration";
	}
	
	
	
	@RequestMapping("/confirmation")
	public String confirm(HttpServletRequest request, Model model, Admin ad) throws Exception {
		Map<String,?> inputFlashMap = RequestContextUtils
		.getInputFlashMap(request);
		if(inputFlashMap !=null) {
			model.addAttribute("message", inputFlashMap.get("submitForm"));
			
		}

		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		
		HttpResponse httpResponse =  webserviceCall.getMethod(Config.baseUrl+"/admin/"+adminID);
		Gson gson = new Gson();
		
		System.out.println("httpresponse="+httpResponse.responseBody1);
		
		 ad=gson.fromJson(httpResponse.getResponseBody1(), Admin.class);
			System.out.println("Admin email ="+ ad.getEmail());
		model.addAttribute("user" , ad);
				return "confirmation";
	}
	

	
	
	//Admin Login
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model,LoginModel user)throws Exception {
		
		
		Map<String,?> inputFlashMap = RequestContextUtils
				.getInputFlashMap(request);
				if(inputFlashMap !=null) {
					model.addAttribute("message", inputFlashMap.get("login-form"));
					
				}
		
		
		// Read request param from html form
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		user.setEmail(email);
		user.setPassword(password);
		// adminId = new LoginService().AdminLogin(user);
		//System.out.println("credentials=>"+ user.getEmail() +user.getPassword());
		String requestBody = new Gson().toJson(user);
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		
		HttpResponse httpResponse =  webserviceCall.postMethod(Config.baseUrl+"/admin/login",requestBody , extraHeaders);
		Gson gson = new Gson();
		//System.out.println("Http:"+httpResponse.getResponseBody1());
	
		
		admin=gson.fromJson(httpResponse.getResponseBody1(), Admin.class);
		//custUserName = customer.getUsername();
		if (admin == null ) {
			
			return "login";
		}else {
			
		
			model.addAttribute("admins",admin);
			String _uname = admin.getUsername();
			int id = admin.getId();
			setPicAdminID(id);
			 setUname(_uname);
			model.addAttribute("uname",_uname);
			getProfilePic(request,model);
			return "dashboard";
		}
		
	}
	
	//AdminHome
	@RequestMapping(value="/home")
	public String home(HttpServletRequest request, Model model) throws Exception {
		if(admin == null || uname == null) {
			return "login";
		}
		List<String> p = getPic();
		
		//model.addAttribute("admins",admin);
	model.addAttribute("uname",new AdminResponseModel().getUsername());
//		model.addAttribute("pic", p);
		return getTestSingleAdmin(request,model);
	}
	
	
	
	
	
	//Admin Registration
	@RequestMapping(value="/create" , method = RequestMethod.POST)
	public RedirectView register(HttpServletRequest request, Model model,Admin ad,
		 @ModelAttribute SubmitForm submitform,  RedirectAttributes redirectAttrs)throws Exception {
		
		
		//Read params from Html 
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email1");
		String  job = request.getParameter("job");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		//System.out.println(username + firstname + lastname + email + job + pass1+pass2);
		ad.setFirstname(firstname);
		ad.setUsername(username);
		ad.setEmail(email);
		ad.setJobTitle(job);
		ad.setLastname(lastname);
		if (pass1.equals(pass2)) {
			ad.setPassword(pass1);
		}
		
		String requestBody = new Gson().toJson(ad);
		//System.out.println(requestBody);
		
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		
		HttpResponse httpResponse =  webserviceCall.postMethod(Config.baseUrl+"/admin",requestBody , extraHeaders);
		Gson gson = new Gson();
		ResponseModel rs = new ResponseModel();
		//System.out.println("Http response ===>"+httpResponse.getResponseBody1());
		
		 rs=gson.fromJson(httpResponse.getResponseBody1(), ResponseModel.class);
		
		 //System.out.println("++++>"+rs.getResponseMessage()+"==>" +rs.getResponseCode() + "  Admin ID: "+rs.getAdminID());
		 adminID = rs.getAdminID();
		if (rs.getResponseMessage().equalsIgnoreCase("success") ) {
		
			model.addAttribute("message",rs.getResponseMessage() );
			
			//System.out.println("Aministrator ID: "+adminID);
			 Random random = new Random(10);
			 submitform.setConfirmationNumber(random.nextInt(10));
			 	submitform.setResponseMessage("Successful");
			    redirectAttrs.addFlashAttribute(submitform);

			    return new RedirectView("/confirmation", true);
			    
		}else if(rs.getResponseMessage().equalsIgnoreCase("Failed")) {
			model.addAttribute("message",rs.getResponseMessage() );
		
			 Random random = new Random(10);
			 submitform.setConfirmationNumber(random.nextInt(10));
			 submitform.setResponseMessage("failed");
			    redirectAttrs.addFlashAttribute(submitform);

			    return new RedirectView("/register", true);
			
		}
		
		else {
			
			 
			 return new RedirectView("/register",true);
		}
		
	}

//Admin View All customers
	@RequestMapping(value="/customers" , method = RequestMethod.GET)
	public String getAllCutomers(HttpServletRequest request, Model model ) throws Exception {
		CustArrModel cc = new CustArrModel();
		
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		
		HttpResponse httpResponse =  webserviceCall.getMethod(Config.baseUrl+"/customers");
		Gson gson = new Gson();
		
		//System.out.println("httpresponse="+httpResponse.responseBody1);
	
		//String res = "";
		
		 cc = gson.fromJson(httpResponse.getResponseBody1(), com.kleens.webApp.Response.CustArrModel.class);
	
		 request.setAttribute("cust", cc);	
		//System.out.println("Body++++++))))))" + cc.getUser());
		 
		 String uname2= getUname();
		model.addAttribute("uname",uname2);
				return "customers";
	}
	
	
	
	
	
	//Admin Get Profile Pic 
	@RequestMapping(value="/pic" , method = RequestMethod.GET)
	public String getProfilePic(HttpServletRequest request, Model model ) throws Exception {
		AdminImageModel cc = new AdminImageModel();
		
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		int ad = getPicAdminID();
		HttpResponse httpResponse =  webserviceCall.getMethod(Config.baseUrl+"/admin/pic/" + ad);
		Gson gson = new Gson();
		
		//System.out.println("httpresponse="+httpResponse.responseBody1);
	
		
		
		 cc = gson.fromJson(httpResponse.getResponseBody1(), AdminImageModel.class);
	
		 request.setAttribute("cust", cc);	
		//System.out.println("pic:" + cc.getPiclist());
		 List<String> pic2= cc.getPiclist();
		 setPic(pic2);
		model.addAttribute("pic",pic2);
		return "dashboard";		
	}
	
	//Admin Move to Update page
	@RequestMapping(value="/update" )
	public String  update(HttpServletRequest request, Model model ) throws Exception {
		model.addAttribute("admin",admin);
		 List<String> pic2= getPic();
		 System.out.println("This is my pic Array =" +pic2);
		 model.addAttribute("pic",pic2);
		return "update";
	}
	
	
	//Admin Update Info
	
	@RequestMapping(value="/updateInfo",  method = RequestMethod.POST )
	public String updateInfo(HttpServletRequest request, Model model , Admin ad) throws Exception {
		//Read params from Html 
				String username = request.getParameter("username");
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String email = request.getParameter("email1");
				String  job = request.getParameter("job");
				String pass1 = request.getParameter("pass1");
				String pass2 = request.getParameter("pass2");
				String file = request.getParameter("files");
				
			
				
				ad.setFirstname(firstname);
				ad.setUsername(username);
				ad.setEmail(email);
				ad.setJobTitle(job);
				ad.setLastname(lastname);
				ad.setId(getPicAdminID());
				
				if (pass1.equals(pass2)) {
					ad.setPassword(pass1);
				}
				System.out.println(" URL= "+file);
		
		String requestBody = new Gson().toJson(ad);
		System.out.println("My body---->" +requestBody);
		
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		
		HttpResponse httpResponse =  webserviceCall.postMethod(Config.baseUrl+"/admin/"+getPicAdminID(),requestBody , extraHeaders);
		Gson gson = new Gson();
		System.out.println("HttpResponse:--->"+httpResponse.getResponseBody1());
		 ad=gson.fromJson(httpResponse.getResponseBody1(), Admin.class);
		 
		 if(ad == null) {
			 home(request, model);
			 String failed = "";
				model.addAttribute("fail", failed);
				return getSingleAdmin(request, model);
		 }
		 else {
			String failed = "Update Failed!";
			model.addAttribute("fail", failed);
			return update(request, model);
		 }
		
		
	}
	
	@RequestMapping(value="/getSingle",  method = RequestMethod.GET )
	private String getSingleAdmin(HttpServletRequest request, Model model)throws Exception {
Admin admin = new Admin();
		
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		int ad = getPicAdminID();
		HttpResponse httpResponse =  webserviceCall.getMethod(Config.baseUrl+"/admin/" +ad);
		Gson gson = new Gson();
		
	
		
		
		 admin = gson.fromJson(httpResponse.getResponseBody1(), Admin.class);
	
		
		model.addAttribute("admins",admin);
		return getProfilePic(request,model);
	}
	
	@RequestMapping(value="/getTestSingle",  method = RequestMethod.GET )
	private String getTestSingleAdmin(HttpServletRequest request, Model model)throws Exception {
AdminResponseModel admin = new AdminResponseModel();
		
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("Content-Type", "application/json");
		int ad = getPicAdminID();
		HttpResponse httpResponse =  webserviceCall.getMethod(Config.baseUrl+"/admin/" +ad);
		Gson gson = new Gson();
		
	
		
		
		 admin = gson.fromJson(httpResponse.getResponseBody1(), AdminResponseModel.class);
		 setUname(admin.getUsername());
			model.addAttribute("uname",admin.getUsername());
		model.addAttribute("admins",admin);
		return getProfilePic(request,model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}
}
