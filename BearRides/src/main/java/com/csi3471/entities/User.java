package com.csi3471.entities;

public class User implements Comparable<User>{
	
	public User(String email, Integer passHash) {
		this.email = email;
		this.passHash = passHash;
	}
	
	public int compareTo(User that) {
		return this.email.compareTo(that.email);
	}
	
	//getters
	public String getUUID() {
		return this.email;
	}
	
	public Integer getPassHash() {
		return this.passHash;
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
	
	public Boolean getGender() {
		return this.gender;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public Double getRating() {
		return this.rating;
	}
	
	//setters
	public void setPassHash(Integer newPassHash) {
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
	
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	//variables
	protected String email;
	protected Integer passHash;
	protected Boolean gender;
	
	protected String number;
	protected String name;
	protected Integer age;
	protected String picture;
	
	protected Boolean isDriver;
	protected Vehicle car;
	
	protected Double rating = 1.0;
}