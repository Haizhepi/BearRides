package com.csi3471.entities;

import java.util.Vector;

public class User implements Comparable<User>{
	
	public User(String email, String passHash, Boolean gender) {
		this.email = email;
		this.passHash = passHash;
		this.gender = gender;
	}
	
	public int compareTo(User that) {
		return this.email.compareTo(that.email);
	}
	
	//getters
	public String getUUID() {
		return this.email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPicture() {
		return this.picture;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public Vector<String> getTrips(){
		return this.trips;
	}
	
	public Vector<String> getReviews(){
		return this.reviews;
	}
	
	public Double getRating() {
		return this.rating;
	}
	
	//setters
	public void setPassHash(String newPassHash) {
		this.passHash = newPassHash;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setPicture(String newPath) {
		this.picture = newPath;
	}
	
	public void setAge(Integer newAge) {
		this.age= newAge;
	}
	
	public void setNumber(String newNumber) {
		this.number = newNumber;
	}
	
	public void insertTrip(String UMID) {
		trips.addElement(UMID);
	}
	
	public void removeTrip(String UMID) {
		trips.removeElement(UMID);
	}
	
	public void insertReview(String UMID, Double newRating) {
		reviews.addElement(UMID);
		
		this.rating += newRating;
		this.rating /= 2;
	}
	
	public void removeReview(String UMID, Double oldRating) {
		reviews.removeElement(UMID);
		
		this.rating *= 2;
		this.rating -= oldRating;
	}
	
	//variables
	protected String email;
	protected String passHash;
	protected Boolean gender;
	
	protected String number;
	protected String name;
	protected Integer age;
	protected String picture;
	
	protected Vector<String> trips;
	protected Vector<String> reviews;
	
	protected Double rating = 1.0;
}