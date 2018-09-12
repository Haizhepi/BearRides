package com.csi3471.entities;

public class Review extends Message implements Comparable<MessageHeader> {
	
	public Review(String time, String UUID, String title) {
		super(time, UUID, title);
	}
	
	//getters
	public Double getRating() {
		return rating;
	}
	
	//variables
	protected Double rating;
}