package com.kleens.db.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "customers_order")
public class Orders {
	@Id
	@GeneratedValue
	@Column(name = "orderID")
	private int id;
	
	//@NotNull(message="customer id cannot be null")
	@Column(name = "custID")
	private int custID;
	
	@NotNull(message="service id cannot be null")
	@Column(name = "serviceID")
	private int serviceID;
	
	@Column(name ="cvID")
	private int cvID;
	
	@NotNull(message="plan cannot be null")
	@Column(name = "plan")
	private String plan;
	
	@NotNull(message="schedule time cannot be null")
	@Column(name = "schedule_time")
	private String scheduleTime;
	
	@NotNull(message="schedule date cannot be null")
	@Column(name = "schedule_date")
	private String scheduleDate;
	
	
	@Column(name = "booking_code")
	private String bookingCode;
	
	@NotNull(message="payment type cannot be null")
	@Column(name = "payment_type")
	private String paymentType;
	
	
	
	@Column (name = "status")
	private String status;
	

	@Column (name = "staffID")
	private int staffID;
	
	@Column(name = "location")
	private String location;
	
	public String getLocation() {
		return location;
	}


	public int getCvID() {
		return cvID;
	}


	public void setCvID(int cvID) {
		this.cvID = cvID;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Orders() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	
	
	
	

}
