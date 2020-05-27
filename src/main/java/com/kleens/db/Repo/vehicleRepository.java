package com.kleens.db.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kleens.db.vehicle.vehicle;

public interface vehicleRepository  extends JpaRepository<vehicle, Integer>{

	vehicle findById(int id);
	
	
	@Query("select u from vehicle u where u.custID = ?1")
	List<vehicle> findOne(int id);

	@Query("select u from vehicle u where u.custID = ?1")
	List<vehicle> findByCustomerId(int custID);


	
	
	
//	@Query("select u from vehicle u where u.cvID = ?1")
//	vehicle findSingle(int id);

}
