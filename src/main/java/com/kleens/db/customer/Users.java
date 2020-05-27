package com.kleens.db.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "customers_info")
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "custID")
	private int id;

	@NotNull(message = "Username cannot be null")
	@Column(name = "username")
	@Size(min = 5, message = "Username must not be less than 5 characters")
	private String username;

	@Column(name = "password")
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 300, message = "Password must be equal or greater than 8 characters and less than 16 characters ")
	private String password;

	@NotNull(message = "Firstname cannot be null")
	@Column(name = "firstname")
	private String firstname;

	@NotNull(message = "Lastname cannot be null")
	@Column(name = "lastname")
	private String lastname;

	@NotNull(message = "Address cannot be null")
	@Column(name = "address")
	private String address;

	@NotNull(message = "Sex cannot be null")
	@Column(name = "sex")
	private String sex;

	@NotNull(message = "Date of birth cannot be null")
	@Column(name = "dob")
	private String dateOfBirth;

	@NotNull(message = "Email cannot be null")
	@Email
	@Column(name = "email")
	private String email;

//    @Column(name = "pic")
//    private String pic;

	@Column(name = "status")
	private String status;

	@Column(name = "date_reg")
	private String date;

	@NotNull(message = "PhoneNo cannot be null")
	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "auth_key")
	private String AuthKey;

	
	
	public Users(int id, String username, String password, String firstname, String lastname, String address,
			String sex, String dateOfBirth, String email, String status, String date, String phoneNo, String authKey) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.status = status;
		this.date = date;
		this.phoneNo = phoneNo;
		AuthKey = authKey;
	}

	public String getAuthKey() {
		return AuthKey;
	}

	public void setAuthKey(String authKey) {
		AuthKey = authKey;
	}

	public Users() {
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getPic() {
//		return pic;
//	}
//
//	public void setPic(String pic) {
//		this.pic = pic;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
