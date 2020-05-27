package com.kleens.db.uploadImage;




import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.kleens.db.Login.DatabaseConnection;

public class StaffImageUpload {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement stmt;
StaffImageModel mmg = new StaffImageModel();
public int staffUpload(StaffImageModel mm) {
	try {
		DatabaseConnection dc = new DatabaseConnection();
		con = dc.getConnection();

File menuImage = new File( mm.getImage());
	
InputStream inputStream = new FileInputStream(menuImage);
	
        
        
		String sql = "update staff_info set pic = ? where staffID = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setBinaryStream(1, inputStream, (int) (menuImage.length()));
		stmt.setInt(2,mm.getStaffID());
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

public StaffImageModel viewStaffPic(int staffID) {
	StaffImageModel im = new StaffImageModel();
	try {
		DatabaseConnection dc = new DatabaseConnection();
		con = dc.getConnection();
        
		String sql = "SELECT pic FROM staff_info WHERE  staffID = ?";
		stmt = con.prepareStatement(sql);
		
	
		stmt.setInt(1,staffID );
		rs = stmt.executeQuery();
		if (rs.next()) {
			 String  pic = rs.getString("pic");
			 
			 im.setStaffID(staffID);
			im.setImage(pic);
			
			
			return im;	
			
		} else {
			im.setStaffID(staffID);
			im.setImage("No Image");
			return im;
		
		}
	
	     
	     
	    }
	    catch (Exception e)
	    {
	    	System.out.println("Connection Error"+ e.getMessage());
	    	im.setStaffID(staffID);
	    	im.setImage("Error Fetching image");
	    	return im;
	    }	
	
}
}

	
