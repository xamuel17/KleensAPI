package com.kleens.db.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.kleens.db.Repo.AdminRepository;
import com.kleens.db.Repo.StaffRepository;
import com.kleens.db.Repo.UsersRepository;
import com.kleens.db.Response.ResponseModel;
import com.kleens.db.SpecialMethods.AES;
import com.kleens.db.Staff.Staff;
import com.kleens.db.customer.Users;
import com.kleens.db.uploadImage.CustomerImageUpload;
import com.kleens.db.uploadImage.AdminImageModel;
import com.kleens.db.uploadImage.AdminImageUpload;
import com.kleens.db.uploadImage.CustImageModel;

//@CrossOrigin(origins="http://localhost:8100")

@RestController
@RequestMapping(value = "/kleens")
public class AdminResources {
	final String secretKey = "ssshhhhhhhhhhh!!!!";
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	StaffRepository staffRepo;
	
	@Autowired
	UsersRepository userRepo;

	// add Admin
	@PostMapping(value = "/admin")
	public Object addAdmin(@Valid @RequestBody Admin theAdmin) throws Exception {
		ResponseModel rs = new ResponseModel();
		
		String password = theAdmin.getPassword();
		AES en = new AES();
		 String encryptedString = en.encrypt(password, secretKey) ;
		 theAdmin.setPassword(encryptedString);
		// check if email exists
		String email = theAdmin.getEmail();
		Admin todo = adminRepo.findByEmailAddress(email);
		if (todo == null) {
			try {
			adminRepo.save(theAdmin);
			int adminId = theAdmin.getId();
			rs.setAdminID(adminId);
			rs.setResponseMessage("success");
			rs.setResponseCode(00);
			return rs;
			}catch (Exception ex) {
				
				rs.setResponseMessage(ex.getMessage());
				rs.setResponseCode(00);
				return rs;
			}
		}else {

		
	rs.setResponseMessage("Failed");
		rs.setResponseCode(-1001);
		return rs;
		}
		
	}

	// update Admin details
	@PostMapping("/admin/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Admin theAdmin, @PathVariable int id) {

		Admin todo = adminRepo.findById(id);

		if (todo.getId() == -1 || todo.getId() == 0)
			return ResponseEntity.notFound().build();

		theAdmin.setId(id);

		adminRepo.save(theAdmin);

		return ResponseEntity.noContent().build();
	}

	// get All admins
	@GetMapping(value = "/admins")
	public List<Admin> getAllUsers() {
		return adminRepo.findAll();
	}
	
	
	// Get Single admin

		@GetMapping("/admin/{id}")
		public Admin getUser(@PathVariable int id) {

			return adminRepo.findById(id);
		}

	// Login Admin
	@PostMapping("/admin/login")
	public Admin getAdmin(@RequestBody LoginModel user) {
		int adminId = new LoginService().AdminLogin(user);
		System.out.println("Customer id = " + adminId);
		System.out.println("RequestBody = " + user);
		return adminRepo.findById(adminId);
	}
	
	

	//delete staff profile
	@DeleteMapping("/admin/staff/{id}")
	public String deleteStaff(@PathVariable int id){
		staffRepo.delete(id); 
		return "Staff deleted";
	}
	//delete customer profile
	@DeleteMapping("/admin/customer/{id}")
	public String deleteCustomer(@PathVariable int id){
		userRepo.delete(id); 
		return "customer deleted";
	}
	
	//Activate customer account
	@PostMapping ("/admin/activate/{custID}")
	public  String ActivateCustomer(@PathVariable int custID){
		
		
		
		userRepo.updateStatus("Activated", custID);
		
		System.out.println("Account Activated" + custID);
		return null;
	
	}
	
	//block customer account
	
	@PostMapping ("/admin/block/{custID}")
	public  String blockCustomer(@PathVariable int custID){
		
		
		
		userRepo.updateStatus("Pending", custID);
		
		System.out.println("Account Activated" + custID);
		return null;
	
	}
	
	//Upload Customer Profile pic
		@PostMapping("/admin/pic/{id}")
		public ResponseEntity<Object> uploadCustomerPic(@RequestBody AdminImageModel img, @PathVariable int id) {
			new AdminImageUpload().AdminUpload(img);
			System.out.println("===>"+img.getId()+ img.getImage());
			return new ResponseEntity<>("Upload successfull", HttpStatus.OK);
		}
		
		//View Admin Profile pic
		@GetMapping("/admin/pic/{id}")
		public AdminImageModel viewCustomerPic(@PathVariable int id){
			//ImageModel im = new ImageModel();
			return new AdminImageUpload().viewAdminPic(id);
			
			
		}
	
	
	
	
	public class AdminFoundException extends RuntimeException {

	    public AdminFoundException(Long id) {
	        super("Admin : " + id);
	    }

	}
	
	
	
}
