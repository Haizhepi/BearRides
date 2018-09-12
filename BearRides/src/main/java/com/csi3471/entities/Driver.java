package com.csi3471.entities;

public class Driver extends User implements Comparable<User> {
	//constructor
	public Driver(String email, String passHash, Boolean gender) {
		super(email, passHash, gender);
	}
	
	//setters
	public String getCarPicture() {
		return this.carPicture;
	}
	
	public String getAvailability() {
		return this.availability;
	}
	
	public Integer getPassengerCapacity() {
		return this.passengerCapacity;
	}
	
	public String getStorageSpace() {
		return this.storageSpace;
	}
	
	//getters
	public void setCarPicture(String newCarPicture) {
		this.carPicture = newCarPicture;
	}
	
	public void setAvailability(String newAvailability) {
		availability = newAvailability;
	}
	
	public void setPassengerCapacity(Integer newPassengerCapacity) {
		this.passengerCapacity = newPassengerCapacity;
	}
	
	public void setStorageSpace(String newStorageSpace) {
		this.storageSpace = newStorageSpace;
	}
	
	//variables
	protected String carPicture;
	protected String availability;
	protected Integer passengerCapacity;
	protected String storageSpace;
}