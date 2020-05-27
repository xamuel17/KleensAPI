package com.kleens.db.password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kleens.db.Login.DatabaseConnection;


public class passwordService {
	private Connection  con;
	private ResultSet rs;
	private PreparedStatement stmt;
	//Select Password
	public String FetchPassword(int custID , String email) {

		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			System.out.println(dc.getConnection());
			
			String sql = "SELECT * FROM customers_info WHERE custID = ? and email = ?";
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1,custID );

			stmt.setString(2, email);
		
			rs = stmt.executeQuery();
		
			

			while (rs.next()) {
				
				String pass = rs.getString("password");
				return pass;	
				
			} 
		
				return null;
			
			
			
		}catch(Exception e) {	

			return null;	
		}
		}

}
