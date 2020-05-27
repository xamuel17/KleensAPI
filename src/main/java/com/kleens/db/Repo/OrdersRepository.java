package com.kleens.db.Repo;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.kleens.db.Order.Orders;


public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	Orders findById(int id);

	 @Query("select u from Orders u where u.custID = ?1")
	 List<Orders>  findByCustomerID(int custID);
	 
	 @Transactional
     @Modifying
	 @Query(value= "UPDATE customers_order u SET status =:status where u.custID=:custID and u.orderID=:orderID",
			 nativeQuery = true)
	void updateStatus(@Param("status") String status, @Param("custID") int custID,@Param("orderID") int orderID );

	 
 
	 @Query("select u from Orders u where u.custID = ?1")
	 Orders  findByCustomerID2(int custID);
	 
	 
	 
	 
	 @Query("select u from Orders u where u.status = 'Pending'")
	List<Orders> findPendingOrders();

	@Transactional
     @Modifying
	 @Query(value= "UPDATE customers_order u SET status =:status, staffID =:staffID where u.orderID=:orderID ",
			 nativeQuery = true)
	void updateStatus2(@Param("status") String status,@Param("orderID") int id, @Param("staffID") int staffID );

	
	 @Query("select u from Orders u where u.staffID = ?1")
	List<Orders> findStaffAcceptedOrders(int staffID);
	 
	 
	 
	 
		@Transactional
	     @Modifying
		 @Query(value= "UPDATE customers_order u SET status =:status, staff_remarks =:staff_remarks where u.orderID=:orderID",
				 nativeQuery = true)
	void updateOrderCompleted(@Param("status")String status,@Param("staff_remarks") String remarks, @Param("orderID")int id);

	
		
		
		@Transactional
	     @Modifying
		 @Query(value= "UPDATE customers_order u SET customer_rating =:customer_rating  where u.orderID=:orderID",
				 nativeQuery = true)
		void updateCustomerOrderCompleted( @Param("customer_rating")String remarks,@Param("orderID") int id);

		
		
		
		 @Query("select u from Orders u where u.custID = ?1  and u.status = 'Pending'")
		List<Orders> findCustomerPendingOrders(int custID);
		 
		 
		 
		 @Query("select u from Orders u where u.custID = ?1  and u.status = 'Completed'")
		List<Orders> findCustomerCompletedOrders(int custID);
	
	
	
}
