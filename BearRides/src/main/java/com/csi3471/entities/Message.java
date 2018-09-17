package com.csi3471.entities;

import java.util.Vector;

@SuppressWarnings("unused")
public class Message extends MessageHeader implements Comparable<MessageHeader> {

	public Message(String time, String UUID, String title) {
		super(time, UUID, title);
	}
	
	public String toString() {
		return this.body;
	}
	
	//getters
	public String getCreator() {
		return this.creator;
	}
	
	public Integer getPostTime() {
		return this.postTime;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public Trip getTrip() {
		return trip;
	}
	
	//setters
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	//variables
	private String creator;
	private Integer postTime;
	
	private String body;
	private Trip trip;
}