package com.kleens.db.Login;


import java.sql.*;

import com.kleens.db.SpecialMethods.AES;
public class LoginService {


private Connection  con;
private ResultSet rs;
private PreparedStatement stmt;
LoginModel clm = new  LoginModel();
final String secretKey = "ssshhhhhhhhhhh!!!!";
public int validateLogin(LoginModel clm) {


try {
	DatabaseConnection dc = new DatabaseConnection();
	con = dc.getConnection();
	System.out.println(dc.getConnection());
	
	String sql = "SELECT custid FROM customers_info WHERE password = ? and email = ?";
	stmt = con.prepareStatement(sql);
	String password = clm.getPassword();
	AES en = new AES();
	 String encryptedString = en.encrypt(password, secretKey) ;
	stmt.setString(1,encryptedString );
	stmt.setString(2, clm.getEmail());

	rs = stmt.executeQuery();
	if (rs.next()) {
		 int custid = rs.getInt("custID");
		
		return custid;	
		
	} else {

		return -1000;
	
	}
	
}catch(Exception e) {	

	return -1001;	
}
}




//For Admin
public int AdminLogin(LoginModel clm) {


try {
	DatabaseConnection dc = new DatabaseConnection();
	con = dc.getConnection();
	System.out.println(dc.getConnection());
	
	String sql = "SELECT adminID FROM admin WHERE password = ? and email = ?";
	stmt = con.prepareStatement(sql);
	String password = clm.getPassword();
	AES en = new AES();
	 String encryptedString = en.encrypt(password, secretKey) ;
	stmt.setString(1,encryptedString );

	stmt.setString(2, clm.getEmail());
System.out.println(clm.getEmail() + clm.getPassword());
	rs = stmt.executeQuery();
	if (rs.next()) {
		 int adminID = rs.getInt("adminID");
		
		return adminID;	
		
	} else {

		return -1000;
	
	}
	
}catch(Exception e) {	

	return -1001;	
}
}




}