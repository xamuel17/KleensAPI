package com.kleens.db.Login;
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
	
	
		private static Connection conn;
		public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kleensman", "root", "");
		    conn = con;
		    System.out.println(con);
			
		}catch(Exception e){
			conn=null;
			
		}
		return conn;
		}

		
		
	


}

