package com.csi3471.entities;

public class MessageHeader implements Comparable<MessageHeader> {
	
	public MessageHeader(String time, String UUID, String title) {
		this.UMID = time + UUID;
		this.title = title;
		
		this.hidden = false;
	}
	
	public int compareTo(MessageHeader that) {
		return this.UMID.compareTo(that.UMID);
	}
	
	//setters
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}
	
	//getters
	public String getTitle() {
		return this.title;
	}
	
	public Boolean isHidden() {
		return this.hidden;
	}
	
	//variables
	protected String UMID;
	protected String title;
	
	public Boolean hidden;
}