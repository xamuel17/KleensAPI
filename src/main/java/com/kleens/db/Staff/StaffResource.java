package com.kleens.db.Staff;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleens.db.Order.Orders;
import com.kleens.db.Repo.OrdersRepository;
import com.kleens.db.Repo.StaffRepository;
import com.kleens.db.SpecialMethods.AES;
import com.kleens.db.customer.Users;
import com.kleens.db.uploadImage.CustomerImageUpload;
import com.kleens.db.uploadImage.StaffImageModel;
import com.kleens.db.uploadImage.StaffImageUpload;
//@CrossOrigin(origins="http://localhost:8100")
@RestController
@RequestMapping(value = "/kleens")
public class StaffResource {
	final String secretKey = "ssshhhhhhhhhhh!!!!";
	@Autowired
	StaffRepository staffRepo;
	
	@Autowired
	OrdersRepository ordersRepo;

	// create new staff
	@PostMapping(value = "/staff")
	public Staff addStaff(@Valid @RequestBody Staff theStaff) {
		String password = theStaff.getPassword();
		AES en = new AES();
		String encryptedString = en.encrypt(password, secretKey);
		theStaff.setPassword(encryptedString);
		// check if email exists
		String email = theStaff.getEmail();
		Staff todo = staffRepo.findByEmailAddress(email);
		if (todo == null) {

			staffRepo.save(theStaff);

			return theStaff;
		}

		System.out.println("Email Already exist");
		return null;

	}
	
	
	
	// update staff info

	@PostMapping ("/staff/{id}")
	public ResponseEntity<Object> updateStaff(  @RequestBody Staff theStaff, @PathVariable int id){
		
		Staff todo =staffRepo.findById(id);

		if (todo.getId()==-1 || todo.getId()==0) 
			return ResponseEntity.notFound().build();

		theStaff.setId(id);
		AES en = new AES();
		String password = theStaff.getPassword();
		String encryptedString = en.encrypt(password, secretKey);
		theStaff.setPassword(encryptedString);
	
		staffRepo.save(theStaff);

		return ResponseEntity.noContent().build();
	}
	
	
	
	// view pending orders

	@GetMapping(value = "/staff/orders")
	public List<Orders> getAllOrders() {
		
		return ordersRepo.findPendingOrders();
	}
	
	// select order to execute
	
	@PutMapping(value="/staff/order/accept/{id}/{staffID}")
	public  List<Orders> updateCustomer(@PathVariable int id,@PathVariable int staffID ){
		
		
		
		ordersRepo.updateStatus2("Accepted", id,staffID);
		
		System.out.println("Order Accepted" + id);
		return null;
	
	}
//Staff View Accepted Orders
	@GetMapping(value = "/staff/accepts/{staffID}")
	public List<Orders> getStaffsAccepts(@PathVariable int staffID ) {
		System.out.println("staffID ==>" + staffID);
	
		
		return ordersRepo.findStaffAcceptedOrders(staffID);
	}
	
	

	
	// View Staff Info 
	@GetMapping("/staff/staffinfo/{id}")
	public Staff getStaffInfo(@PathVariable int id) {
		StaffArr ss = new StaffArr();
		return staffRepo.findById(id);
	}
	
	
	//view all staffs
	@GetMapping("/staffs")
	public Object getStaffs() {
		StaffArr ss = new StaffArr();
		ss.setStaff(staffRepo.findAll());
		return	ss ;
	}
	
	
	
	
	// Staff acknowledge that the order has been executed and add remarks
	@PutMapping(value="/staff/order/finish/{id}/{staffID}/{remarks}")
	public  List<Orders> orderCompleted(@PathVariable int id,@PathVariable int staffID,@PathVariable String remarks  ){
		
		
		
		ordersRepo.updateOrderCompleted("Completed", remarks,id);
		
		System.out.println("remarks" +remarks);
		return null;
	
	}
	
	
	//Upload Staff Profile pic
		@PostMapping("/staff/pic/{id}")
		public ResponseEntity<Object> uploadStaffPic(@RequestBody StaffImageModel img, @PathVariable int id) {
			new StaffImageUpload().staffUpload(img);
			System.out.println("===>"+img.getStaffID()+ img.getImage());
			return new ResponseEntity<>("Upload successfull", HttpStatus.OK);
		}
		
		//View Staff Profile pic
		@GetMapping("/staff/pic/{id}")
		public StaffImageModel viewCustomerPic(@PathVariable int id){
			//ImageModel im = new ImageModel();
			return new StaffImageUpload().viewStaffPic(id);
			
			
		}

}
