package com.kleens.db.Staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "staff_info")
public class Staff {
	@Id
	@GeneratedValue
	@Column(name = "staffID")
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
	
	@NotNull(message = "sex cannot be null")
	@Column(name = "sex")
	private String sex;
	
	@NotNull(message = "Date of birth cannot be null")
	@Column(name = "dob")
	private String dateOfBirth;



	@NotNull(message = "address cannot be null")
	@Column(name = "address")
	private String address;
	
	
	@NotNull(message = "Email cannot be null")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "job title cannot be null")
	@Column(name = "job_title")
	private String jobTitle;
	
	
	@Column(name = "performance")
	private String performance;
	
	@NotNull(message = "phone number cannot be null")
	@Column(name = "phone_no")
	private String phoneNo;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	


}
