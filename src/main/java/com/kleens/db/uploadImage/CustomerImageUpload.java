package com.kleens.db.uploadImage;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kleens.db.Login.DatabaseConnection;

public class CustomerImageUpload {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement stmt;
CustImageModel mmg = new CustImageModel();
public int customerUpload(CustImageModel mm) {
	try {
		DatabaseConnection dc = new DatabaseConnection();
		con = dc.getConnection();

File menuImage = new File( mm.getImage());
	
InputStream inputStream = new FileInputStream(menuImage);
	
        
        
		String sql = "update customers_info set pic = ? where custID = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setBinaryStream(1, inputStream, (int) (menuImage.length()));
		stmt.setInt(2,mm.getCustID() );
		if (stmt.executeUpdate() > 0) {
			System.out.println("Updated");
			return 00;
		
			} else {
				System.out.println("Update Failed");
				 con.close();
			return -1000;
			}
	
	     
	     
	    }
	    catch (Exception e)
	    {
	    	System.out.println("Connection Error"+ e.getMessage());
	    	return -1001;
	    }
	
	  }

public CustImageModel viewCustomerPic(int Custid) {
	List<String> list = new ArrayList<String>();
	CustImageModel im = new CustImageModel();
	try {
		DatabaseConnection dc = new DatabaseConnection();
		con = dc.getConnection();
        
		String sql = "SELECT pic FROM customers_info WHERE  custID = ?";
		stmt = con.prepareStatement(sql);
		
	
		stmt.setInt(1,Custid );
		rs = stmt.executeQuery();
		if (rs.next()) {
			 String  pic = rs.getString("pic");
			 
			 im.setCustID(Custid);
			im.setImage(pic);
			 byte[] imageData = rs.getBytes("pic"); 
			    list.add(org.apache.commons.codec.binary.Base64.encodeBase64String(imageData)); 
			    im.setPiclist(list);
			
			return im;	
			
		} else {
			 im.setCustID(Custid);
			im.setImage("No Image");
			return im;
		
		}
	
	     
	     
	    }
	    catch (Exception e)
	    {
	    	System.out.println("Connection Error"+ e.getMessage());
	    	 im.setCustID(Custid);
	    	im.setImage("Error Fetching image");
	    	return im;
	    }	
	
}
}

	
