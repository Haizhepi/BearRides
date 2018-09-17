package com.csi3471.entities;

import java.util.Vector;

@SuppressWarnings("unused")
public class User implements Comparable<User> {

	public User(String email, String password) {
		this.email = email;
		this.passHash = password.hashCode();
	}

	public int compareTo(User that) {
		return this.email.compareTo(that.email);
	}

	// getters
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

	public String getContact() {
		return this.contact;
	}

	public Integer getRating() {
		return this.rating;
	}

	// setters
	public void setPassHash(Integer passHash) {
		this.passHash = passHash;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPicture(String path) {
		this.picture = path;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public void insertRating(Integer rating) {
		this.rating = (this.rating * this.ratingCount++ + rating) / ratingCount;
	}

	// variables
	private String email;
	private Integer passHash;
	private Boolean gender;

	private String contact;
	private String name;
	private Integer age;
	private String picture;

	private Boolean isDriver = false;
	private Vehicle car;

	private Integer rating = 100;
	private Integer ratingCount;
}