package com.kleens.db.Admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "adminID")
	private int id;

	@NotNull(message = "username cannot be null")
	@Column(name = "username")
	private String username;
	@NotNull(message = "password cannot be null")
	@Column(name = "password")
	@Size(min=8,max=300, message="Password must be equal or greater than 8 characters and less than 16 characters ")
	private String password;
	@NotNull(message = "firstname cannot be null")
	@Column(name = "firstname")
	private String firstname;

	@NotNull(message = "lastname cannot be null")
	@Column(name = "lastname")
	private String lastname;
	@NotNull(message = "job title cannot be null")
	@Column(name = "job_title")
	private String jobTitle;
	
	@NotNull(message = "Email cannot be null")
	@Column(name = "email")
	private String email;
	
	
//	@Column(name= "pic")
//	private String pic;
	
	

	private String ResponseMessage;
	private int ResponseCode;
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public String getPic() {
//		return pic;
//	}
//
//	public void setPic(String pic) {
//		this.pic = pic;
//	}
	
	public String getResponseMessage() {
		return ResponseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}

	public int getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(int responseCode) {
		ResponseCode = responseCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
