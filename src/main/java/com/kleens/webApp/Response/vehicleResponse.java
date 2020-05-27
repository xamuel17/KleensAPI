package com.kleens.webApp.Response;



public class vehicleResponse {

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

	private int id;

	private int custID;

	private String vehicleType;

	private String VehicleColour;

	private String vehicleBrand;

	private String vehiclePlateNo;
}
