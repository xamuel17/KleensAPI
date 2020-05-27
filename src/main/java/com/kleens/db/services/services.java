package com.kleens.db.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "services")
public class services {
	@Id
	@GeneratedValue
	@Column(name = "serviceID")
	private int id;
	@NotNull
	@Column(name = "service_name")
	private String service_name;

	@NotNull
	@Column(name = "details")
	private String details;

	@NotNull
	@Column(name = "price")
	private String price;

	@NotNull
	@Column(name = "updatedBy")
	private int adminID;
	
	@NotNull
	@Column(name = "duration")
	private String duration;



	public services() {
		super();	
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
