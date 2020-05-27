package com.kleens.db.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kleens.db.Staff.Staff;


public interface StaffRepository extends JpaRepository <Staff, Integer>{

	@Query("select u from Staff u where u.email = ?1")
	Staff findByEmailAddress(String emailAddress);

	Staff findById(int id);

	

	

	





}
