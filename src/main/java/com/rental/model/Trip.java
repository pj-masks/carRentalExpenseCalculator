package com.rental.model;

public class Trip {

	private VehicleType vehicleType;
	private FuelType fuelType;
	private Boolean isAc;
	private String itenerary;

	public Trip() {
	}

	public Trip(VehicleType vehicleType, FuelType fuelType, Boolean isAc, String itenerary) {

		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		this.isAc = isAc;
		this.itenerary = itenerary;

	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public Boolean isAc() {
		return isAc;
	}

	public void setAc(Boolean isAc) {
		this.isAc = isAc;
	}

	public String getItenerary() {
		return itenerary;
	}

	public void setItenerary(String itenerary) {
		this.itenerary = itenerary;
	}

}
