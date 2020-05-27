package com.kleens.db.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleens.db.Login.LoginModel;
import com.kleens.db.Login.LoginService;
import com.kleens.db.Notifications.SendConfirmationEmail;
import com.kleens.db.Order.Orders;
import com.kleens.db.Repo.OrdersRepository;
import com.kleens.db.Repo.StaffRepository;
import com.kleens.db.Repo.UsersRepository;
import com.kleens.db.Response.ResponseModel;
import com.kleens.db.SpecialMethods.AES;
import com.kleens.db.SpecialMethods.BookingCode;
import com.kleens.db.Staff.Staff;
import com.kleens.db.password.passwordResetModel;
import com.kleens.db.password.passwordService;
import com.kleens.db.uploadImage.AdminImageUpload;
import com.kleens.db.uploadImage.CustImageModel;
import com.kleens.db.uploadImage.CustomerImageUpload;
@CrossOrigin(origins="http://localhost:8100")
@RestController
@RequestMapping(value = "/kleens")
public class UsersResource {
	final String secretKey = "ssshhhhhhhhhhh!!!!";
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	SendConfirmationEmail sendEmail;
	
	@Autowired
	OrdersRepository ordersRepo;
	
	@Autowired
	StaffRepository staffRepo;
	
	// Get All Customers
	@GetMapping(value = "/customers")
	public Object getAllUsers() {
	
		  usersRepository.findAll();
		  UsersArr us = new UsersArr();
		    us.setUser(usersRepository.findAll());
		    return us;
		
	}

	
	
	// Create New Customers
		@PostMapping(value = "/customer")
		public Object addUser(@Valid @RequestBody Users theUser) {
			String password = theUser.getPassword();
			AES en = new AES();
			 String encryptedString = en.encrypt(password, secretKey) ;
			 theUser.setPassword(encryptedString);
			//check if email exists
			String email = theUser.getEmail();
			Users todo = usersRepository.findByEmailAddress(email);
			if (todo== null) {
				Random rand = new Random();
				String AuthKey = String.format("%04d", rand.nextInt(10000));
				System.out.println(AuthKey);
				
				
				theUser.setAuthKey(AuthKey);
				String username = theUser.getUsername();
				
				usersRepository.save(theUser);
				try{
					sendEmail.sendNotification(email,username,AuthKey);
				
				}catch(MailException e) {
					//catch error
					System.out.println("error="+e);
				}
				return theUser;
			}

			System.out.println("Email Already exist");
			ResponseModel rs = new ResponseModel();
			rs.setResponseMessage("Email ALready Exists");
			rs.setResponseCode(-1000);
			return rs;
			
			

		}

		
	
	

	// Get Single Customer

	@GetMapping("/customer/{id}")
	public Users getUser(@PathVariable int id) {
	
		return usersRepository.findById(id);
	}

	
	
	// Delete Single Customer
	
	@DeleteMapping("/customer/{id}")
	public String deleteUser(@PathVariable int id) {
		
		Users tempUser = usersRepository.findById(id);
		
		// throw exception if null
		
		if (tempUser == null) {
			return "Customer id not found - " + id;
		}
		
		usersRepository.delete(id);
		return null;
		//return "Deleted User id - " + id;
}
	
	
	
	
	
	//Update Single Customer
	@PutMapping ("/customer/{id}")
	public ResponseEntity<Object> updateCustomer(  @RequestBody Users user, @PathVariable int id){
		
		Users todo =usersRepository.findById(id);

		if (todo.getId()==-1 || todo.getId()==0) 
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		usersRepository.save(user);

		return ResponseEntity.noContent().build();
	}
	
	
//Customer Login
	@PostMapping("/customer/login")
	public Users getUser(@RequestBody LoginModel user) {
		int custId = new LoginService().validateLogin(user);
		System.out.println("Customer id = " + custId);
		System.out.println("RequestBody = " + user);
		return usersRepository.findById(custId);
	}
	
	//Upload Customer Profile pic
	@PostMapping("/customer/pic/{id}")
	public ResponseEntity<Object> uploadCustomerPic(@RequestBody CustImageModel img, @PathVariable int id) {
		new CustomerImageUpload().customerUpload(img);
		System.out.println("===>"+img.getCustID()+ img.getImage());
		return new ResponseEntity<>("Upload successfull", HttpStatus.OK);
	}
	
	//View Customer Profile pic
	@GetMapping("/customer/pic/{id}")
	public CustImageModel viewCustomerPic(@PathVariable int id){
		//ImageModel im = new ImageModel();
		return new CustomerImageUpload().viewCustomerPic(id);
		
		
	}
	
	//Activate Account
	@PutMapping ("/customer/{custID}/{AuthKey}")
	public  List<Users> updateCustomer(@PathVariable int custID,@PathVariable int AuthKey){
		
		usersRepository.findOne(AuthKey);
		
		usersRepository.updateStatus("Activated", custID);
		
		System.out.println("Account Activated" + custID);
		return null;
	
	}
	
	//Customer remark
	
		@PutMapping(value="/customer/order/finish/{id}/{remarks}")
		public  List<Orders> orderCompleted(@PathVariable int id,@PathVariable String remarks  ){
			
			
			
			ordersRepo.updateCustomerOrderCompleted(remarks,id);
			
			System.out.println("Customer remarks : " +remarks);
			return null;
		
		}
		
		//View Staff info assigned to order with staff id(name, phineNo and pic)
		@GetMapping("/customer/staffinfo/{id}")
		public Staff getStaffInfo(@PathVariable int id) {
			
			
			Staff theStaff = new Staff();
			theStaff = staffRepo.findById(id);
			theStaff.setDateOfBirth("");
			theStaff.setPassword("");
			theStaff.setAddress("");
			
			return theStaff;
		}
		
		
		//AutoGeneratePassword for customer
		@PostMapping ("/customer/genpass/{custID}")
		public passwordResetModel resetPassword(@PathVariable int custID, @RequestBody passwordResetModel prm ) {
			BookingCode bc = new BookingCode();
			//encrypt password
			String Randompassword = bc.getAlphaNumericString(8);
			prm.setAutoPassword(Randompassword);
			prm.setCustID(custID);
			
			
			usersRepository.updatePassword(Randompassword,custID );
			
			//Send password to email address
			try{
				String email = prm.getEmail();
			
				String randomPassword= prm.getAutoPassword();
				sendEmail.AutoGeneratePassword(email,  randomPassword);
			
			}catch(MailException e) {
				//catch error
				System.out.println("error="+e);
				prm.setError("Sending Error");
			}
			prm.setError(null);
			prm.setNewPassword(null);
			return prm;
		}
		
		//Change Password
		@PutMapping ("/customer/changepassword/{custID}")
		public Users changePassword(@PathVariable int custID, @RequestBody passwordResetModel prm ) {
			String password = prm.getNewPassword();
			String autoPassword = prm.getAutoPassword();
			int custID1 = prm.getCustID();
			String email = prm.getEmail();
			//Search for if password exists
			
			passwordService ps = new passwordService();
		String dbPassword = ps.FetchPassword(custID,email);
			System.out.println("dbPassword====>"+dbPassword);
			System.out.println("autoPassword====>"+autoPassword);
			System.out.println("newpassword====>"+password);
			System.out.println("email====>"+email);
			if (dbPassword.equalsIgnoreCase(autoPassword)) {
		
				//encrypt password
				
				AES en = new AES();
				 String encryptedString = en.encrypt(password, secretKey) ;
				
				usersRepository.updatePassword(encryptedString,custID );
				
			}else {
				return null;
			}
			//change password
		
				
			return  usersRepository.findById(custID1);
		}
		
	
	


}
