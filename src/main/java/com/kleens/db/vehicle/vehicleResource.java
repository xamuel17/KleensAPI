package com.kleens.db.vehicle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleens.db.Repo.vehicleRepository;
import com.kleens.db.customer.Users;
import com.kleens.db.customer.UsersArr;

//@CrossOrigin(origins="http://localhost:8100")
@RestController
@RequestMapping(value = "/kleens")
public class vehicleResource {

	@Autowired
	private vehicleRepository vehicleRepository;

	// Get Vehicle by Customer ID

	@GetMapping("/vehicle/{id}")
	public vehicle getUser(@PathVariable int id) {
		System.out.println(vehicleRepository.findById(id));

		return vehicleRepository.findById(id);
		//return vehicleRepository.findOne(id);
	}

	// Get All Customers Vehicle

	@GetMapping(value = "/vehicles")
	public List<vehicle> getAllUsers() {

		return vehicleRepository.findAll();
	}
	
	//Register Customer Vehicle
	@PostMapping(value = "/vehicle")
	public vehicle addUser(@Valid @RequestBody vehicle theVehicle) {

		
	 vehicleRepository.save(theVehicle);
		
	 return theVehicle;

	}
	
	//Delete Customer Vehicle
	@DeleteMapping("/vehicle/customer/{id}")
	public String deleteUser(@PathVariable int id, vehicle vh ) {
		
		vehicle todo = vehicleRepository.findById(id);
		
		// throw exception if null
		
		if (todo == null) {
			return "Vehicle  not found - " + id;
		}
		
		vehicleRepository.delete(id);
		return null;
		//return "Deleted Vehicle with  id - " + id;
}
	
	//Get Vehicle by custID
	@GetMapping("/vehicle/customer/{custID}")
	public Object getCustomerVehicle(@PathVariable int custID){
		 vehicleRepository.findByCustomerId(custID);
		vehicleArr vs = new vehicleArr();
	    vs.setVehicles(vehicleRepository.findByCustomerId(custID));
	    return vs;
	}
	

	
	
}
