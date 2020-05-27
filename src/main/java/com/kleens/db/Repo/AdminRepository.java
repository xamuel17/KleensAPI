package com.kleens.db.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kleens.db.Admin.Admin;



public interface AdminRepository extends JpaRepository<Admin , Integer>{

	  @Query("select u from Admin u where u.email = ?1")
	  Admin findByEmailAddress(String emailAddress);

	Admin findById(int id);

}
