package com.kleens.db.Repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.kleens.db.customer.Users;
import com.kleens.db.password.passwordResetModel;



public interface UsersRepository extends JpaRepository<Users, Integer> {


	
	// find record by id
	  Users findById(int id);
	  
	  //Delete record by id
	  //Users delete(int id);
	  

	
	  
	  @Query("select u from Users u where u.email = ?1")
	  Users findByEmailAddress(String emailAddress);

	Users deleteById(int id);
	
	@Query(value= "select custID from customers_info where username=? and password=?",
			nativeQuery=true)
	Users findCustomer(String username, String password);

	
	
	
	 @Transactional
     @Modifying
	 @Query(value= "UPDATE customers_info u SET status =:status where u.custID=:custID ",
			 nativeQuery = true)
	void updateStatus(@Param("status") String status, @Param("custID") int custID);

	 
	 
	 
	 @Transactional
     @Modifying
	 @Query(value= "UPDATE customers_info u SET password =:password where u.custID=:custID ",
			 nativeQuery = true) 
	void updatePassword(@Param("password") String password, @Param("custID") int custID);

	 
	 
	 
	

	

	 
	 
	

	 
	 


	

	 
	 

	
	 
	 
	
}
