package com.csi3471.entities;

import java.util.Vector;

public class Trip {

	public Trip() {
		// stubbed
	}

	public String toString() {
		return null;
		// stubbed
	}

	// setters
	public Boolean insertRider(String rider) {
		if (this.riders.size() < this.passengerCount) {
			this.riders.addElement(rider);

			return true;
		} else {
			return false;
		}
	}

	public void insertRequirement(String requirement) {
		this.requirements.addElement(requirement);
	}

	public Boolean removeRider(String rider) {
		return this.riders.removeElement(rider);
	}

	public Boolean removeRequirement(String requirement) {
		return this.requirements.removeElement(requirement);
	}

	public void setOriginTime(String originTime) {
		this.originTime = originTime;
	}

	public void setDestinTime(String destinTime) {
		this.destinTime = destinTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public void setOriginLoc(String originLoc) {
		this.originLoc = originLoc;
	}

	public void setDestinLoc(String destinLoc) {
		this.destinLoc = destinLoc;
	}

	public void setReturnLoc(String returnLoc) {
		this.returnLoc = returnLoc;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	// getters
	public Vector<String> getRiders() {
		return this.riders;
	}

	public Vector<String> getRequirements() {
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

	public String getOriginLoc() {
		return this.originLoc;
	}

	public String getDestinLoc() {
		return this.destinLoc;
	}

	public String getReturnLoc() {
		return this.returnLoc;
	}

	public Integer getPassengerCount() {
		return this.passengerCount;
	}

	private Vector<String> riders;
	private Vector<String> requirements;

	private String originTime;
	private String destinTime;
	private String returnTime;

	private String originLoc;
	private String destinLoc;
	private String returnLoc;

	private Integer passengerCount;
}