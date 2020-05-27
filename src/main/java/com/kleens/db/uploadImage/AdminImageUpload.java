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

public class AdminImageUpload {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement stmt;
AdminImageModel mmg = new AdminImageModel();
public int AdminUpload(AdminImageModel mm) {
	try {
		DatabaseConnection dc = new DatabaseConnection();
		con = dc.getConnection();

File menuImage = new File( mm.getImage());
	
InputStream inputStream = new FileInputStream(menuImage);
	
        
        
		String sql = "update admin set pic = ? where adminID = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setBinaryStream(1, inputStream, (int) (menuImage.length()));
		stmt.setInt(2,mm.getId() );
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

public AdminImageModel viewAdminPic(int AdminID) {
	List<String> list = new ArrayList<String>();
	AdminImageModel im = new AdminImageModel();
	try {
		DatabaseConnection dc = new DatabaseConnection();
		con = dc.getConnection();
        
		String sql = "SELECT pic FROM admin WHERE  adminID = ?";
		stmt = con.prepareStatement(sql);
		
	
		stmt.setInt(1,AdminID );
		rs = stmt.executeQuery();
		if (rs.next()) {
			 String  pic = rs.getString("pic");
			 
			 im.setId(AdminID);
			im.setImage(pic);
			
			 byte[] imageData = rs.getBytes("pic"); 
			    list.add(org.apache.commons.codec.binary.Base64.encodeBase64String(imageData)); 
			    im.setPiclist(list);
			    return im;	
			
		} else {
			 im.setId(AdminID);
			im.setImage("No Image");
			return im;
		
		}
	
	     
	     
	    }
	    catch (Exception e)
	    {
	    	System.out.println("Connection Error"+ e.getMessage());
	    	 im.setId(AdminID);
	    	im.setImage("Error Fetching image");
	    	return im;
	    }	
	
}
}

	

