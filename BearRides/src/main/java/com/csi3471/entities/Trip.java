package com.csi3471.entities;

import java.util.Vector;

public class Trip {
	
	public Trip(String time, String UUID, String title) {
	}
	
	//setters
	public void insertRider(String newRider) {
		this.riders.addElement(newRider);
	}
	
	public void removeRider(String oldRider) {
		this.riders.removeElement(oldRider);
	}
	
	public void insertRequirement(String newRequirement) {
		this.requirements.addElement(newRequirement);
	}
	
	public void removeRequirement(String oldRequirement) {
		this.requirements.removeElement(oldRequirement);
	}
	
	public void setOriginTime(String newOriginTime) {
		this.originTime = newOriginTime;
	}
	
	public void setDestinTime(String newDestinTime) {
		this.destinTime = newDestinTime;
	}
	
	public void setReturnTime(String newReturnTime) {
		this.returnTime = newReturnTime;
	}
	
	public void setOriginPlace(String newOriginPlace) {
		this.originPlace = newOriginPlace;
	}
	
	public void setDestinPlace(String newDestinPlace) {
		this.destinPlace = newDestinPlace;
	}
	
	public void setReturnPlace(String newReturnPlace) {
		this.returnPlace = newReturnPlace;
	}
	
	public void setPassengerCount(Integer newPassengerCount) {
		this.passengerCount = newPassengerCount;
	}
	
	//getters
	public Vector<String> getRiders(){
		return this.riders;
	}
	
	public Vector<String> getRequirements(){
		return this.requirements;
	}
	
	public String getOriginTime() {
		return this.originTime;
	}
	
	public String getDestinTime() {
		return this.destinTime;
	}
	
	public String getReturnTime() {
		return this.returnTime;
	}
	
	public String getOriginPlace() {
		return this.originPlace;
	}
	
	public String getDestinPlace() {
		return this.destinPlace;
	}
	
	public String getReturnPlace() {
		return this.returnPlace;
	}
	
	public Integer getPassengerCount() {
		return this.passengerCount;
	}
	
	//UUID
	protected Vector<String> riders;
	//UPID
	protected Vector<String> requirements;
	//UPID
	protected Message post;
	
	protected String originTime;
	protected String destinTime;
	protected String returnTime;
	
	protected String originPlace;
	protected String destinPlace;
	protected String returnPlace;
	
	protected Integer passengerCount;
}