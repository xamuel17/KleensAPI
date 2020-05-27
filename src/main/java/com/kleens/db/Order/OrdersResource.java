package com.kleens.db.Order;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleens.db.Notifications.CheckforAccountActivation;
import com.kleens.db.Repo.OrdersRepository;
import com.kleens.db.Repo.UsersRepository;
import com.kleens.db.SpecialMethods.BookingCode;
import com.kleens.db.customer.Users;
import com.kleens.db.customer.UsersArr;
//@CrossOrigin(origins="http://localhost:8100")
@RestController
@RequestMapping(value = "/kleens")
public class OrdersResource {

	@Autowired
	OrdersRepository ordersRepo;

	@Autowired
	UsersRepository custRepo;

	// Check if account is activated or not

	// Make order
	@PostMapping(value = "/customer/order/{id}")
	public Orders addCustomerOrder(@Valid @RequestBody Orders myOrder, @PathVariable int id) {
		Users custOrder = custRepo.findById(id);
		CheckforAccountActivation check = new CheckforAccountActivation();
		String checkStat = check.checkForActivation(myOrder.getCustID());
		System.out.println("customerID from model:" + myOrder.getCustID());
		System.out.println("status" + checkStat);
		int customerID = custOrder.getId();
		if (checkStat.equals("Activated")) {
			System.out.println("customer details" + custOrder.getId());
			if (customerID != 0) {
				String bookingCode = "";

				bookingCode = new BookingCode().getAlphaNumericString(5);

				myOrder.setBookingCode(bookingCode);
				myOrder.setStatus("Pending");
				ordersRepo.save(myOrder);
				System.out.println("Order added");
				return myOrder;
			} else {
				return null;
			}

		} else {
			System.out.println("Your account is not activated");
			return null;
		}

	}

	//customer cancel order

	@PutMapping("/customer/order/{custID}/{id}")
	public List<Orders> updateCustomer(@PathVariable int custID, @PathVariable int id) {

		ordersRepo.updateStatus("Cancelled", custID, id);
		ordersRepo.findByCustomerID(custID);
		System.out.println("Order Cancelled id " + id);
		return ordersRepo.findByCustomerID(custID);

	}

	//customer view order
	@GetMapping("/customer/order/{custID}")
	public Object getCustomerOrder(@PathVariable int custID) {
		
		 OrdersArr us = new OrdersArr();
		    us.setCustomer(ordersRepo.findByCustomerID(custID));
		    return us;
	}
	
	//Customer view All pending orders
	@GetMapping("/customer/pend/{custID}")
	public List<Orders> getCustomerPendingOrder(@PathVariable int custID){
		return ordersRepo.findCustomerPendingOrders(custID);
		
	}
	
	//customer view completed orders
	@GetMapping("/customer/completed/{custID}")
	public List<Orders> getCustomerCompletedOrder(@PathVariable int custID){
		return ordersRepo.findCustomerCompletedOrders(custID);
		
	}
	//view order by orderid 
	@GetMapping ("/order/{id}")
	public Orders viewOrder(@PathVariable int id) {
		return ordersRepo.findById(id);
	}
	
	
	//Admin View all orders
	@GetMapping("/admin/orders")
	public List<Orders> getCustomerOrder() {
		
		return ordersRepo.findAll();
	}
}
