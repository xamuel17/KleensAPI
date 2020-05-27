package com.kleens.db.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.kleens.db.Repo.AdminRepository;
import com.kleens.db.Repo.ServicesRepository;


//@CrossOrigin(origins="http://localhost:8100")
@RestController
@RequestMapping(value = "/kleens")
public class servicesResource {
	
	@Autowired
	ServicesRepository servicesRepo;
	
	@Autowired
	AdminRepository adRepo;
	
// Get all services
	@GetMapping(value = "/services")
	public List<services> getAllServices() {

		return servicesRepo.findAll();
	}
	
//Update Service price
	@PutMapping ("/service/{id}")
	public ResponseEntity<Object> updateCustomer(  @RequestBody services serv, @PathVariable int id){
		
		services todo =servicesRepo.findById(id);

		if (todo.getId()==-1 || todo.getId()==0) 
			return ResponseEntity.notFound().build();

		serv.setId(id);
		
		servicesRepo.save(serv);

		return ResponseEntity.noContent().build();
	}
	
	
// Add new Service
	@PostMapping(value = "/service/{id}")
	public services addUser(@Valid @RequestBody services serv, @PathVariable int id) {
		
		
		//check if service Exists
		String serviceName = serv.getService_name();
		services todo = servicesRepo.findByserviceName(serviceName);
		if (todo== null) {
			
			
			
			if(adRepo.findById(id) != null) {
				serv.setAdminID(id);
				servicesRepo.save(serv);
				return serv;
			}
			
		}

		System.out.println("Service not added, Maybe service already exists!");
		return null;
		
		

	}
	
	
	//Delete Service
	@DeleteMapping("/service/{id}")
	public String deleteUser(@PathVariable int id) {
		
		services tempService = servicesRepo.findById(id);
		
		// throw exception if null
		
		if (tempService == null) {
			return "Service id not found - " + id;
		}
		
		servicesRepo.delete(id);
		return null;
		//return "Deleted User id - " + id;
}
	
	
	//Get Single service
	@GetMapping("/service/{id}")
	public services getService(@PathVariable int id) {

		return servicesRepo.findById(id);
	}
}
