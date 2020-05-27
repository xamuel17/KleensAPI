package com.kleens.db.vehicle;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "customers_vehicle")

public class vehicle {


	
	@Id
	@GeneratedValue
	@Column(name = "cvID")
	private int id;

	@Column(name = "custID")
	private int custID;
	
	  public int getCustID() {
		return custID;
	}





	public void setCustID(int custID) {
		this.custID = custID;
	}

	@NotNull(message="Entry cannot be null")
	@Column(name = "vehicle_type")
	private String vehicleType;
	  
	  @NotNull(message="Entry cannot be null")
	@Column(name = "vehicle_color")
	private String VehicleColour;

	  @NotNull(message="Entry cannot be null")
	@Column(name = "vehicle_brand")
	private String vehicleBrand;

	  @NotNull(message="Entry cannot be null")
	@Column(name = "vehicle_plate_no")
	private String vehiclePlateNo;

	public vehicle() {
		super();

	}

	

	

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	





	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleColour() {
		return VehicleColour;
	}

	public void setVehicleColour(String vehicleColour) {
		VehicleColour = vehicleColour;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehiclePlateNo() {
		return vehiclePlateNo;
	}

	public void setVehiclePlateNo(String vehiclePlateNo) {
		this.vehiclePlateNo = vehiclePlateNo;
	}

	
}
