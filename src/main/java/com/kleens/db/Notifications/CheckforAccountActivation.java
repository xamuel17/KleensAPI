package com.kleens.db.Notifications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kleens.db.Login.DatabaseConnection;
import com.kleens.db.Login.LoginModel;
import com.kleens.db.customer.Users;

public class CheckforAccountActivation {
	private Connection  con;
	private ResultSet rs;
	private PreparedStatement stmt;
//	Users clm2 = new  Users();
	String stat ="";
	public String checkForActivation(int  id) {
		try {
			
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			String sql = "SELECT status FROM customers_info WHERE custID=?";
			stmt = con.prepareStatement(sql);
			int custID = id;
		
			stmt.setInt(1, custID);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				 String status = rs.getString("status");
				 System.out.println("Method fucntion: "+status);
					System.out.println(status);
					System.out.println(custID);
				stat = status;
						return stat;
				
			} else {
					stat = "Account Doesn't Exist";
				return stat;
						
			
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			stat = "Connection Error";
			return stat;
		}
		
		
		
		
	}
}
