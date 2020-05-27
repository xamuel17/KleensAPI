package com.kleens.db.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.kleens.db.services.services;

public interface ServicesRepository  extends JpaRepository<services, Integer>{

	services findById(int id);

	
	  @Query("select u from services u where u.service_name = ?1")
	  services findByserviceName(String serviceName);
}
