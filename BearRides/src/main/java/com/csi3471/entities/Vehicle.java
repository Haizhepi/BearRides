package com.csi3471.entities;

public class Vehicle {
	public Vehicle() {
		
	}
	
	//getters
	public String getCarPicture() {
		return carPicture;
	}
	public void setCarPicture(String carPicture) {
		this.carPicture = carPicture;
	}
	public Integer getPassengerCapacity() {
		return passengerCapacity;
	}
	
	//setters
	public void setPassengerCapacity(Integer passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	public String getStorageSpace() {
		return storageSpace;
	}
	public void setStorageSpace(String storageSpace) {
		this.storageSpace = storageSpace;
	}

	//variables
	protected String carPicture;
	protected Integer passengerCapacity;
	protected String storageSpace;
}