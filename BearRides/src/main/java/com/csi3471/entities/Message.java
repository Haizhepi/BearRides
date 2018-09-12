package com.csi3471.entities;

import java.util.Vector;

public class Message extends MessageHeader implements Comparable<MessageHeader> {

	public Message(String time, String UUID, String title) {
		super(time, UUID, title);
	}
	
	//getters
	public String getBody() {
		return this.body;
	}
	
	public String getUUID() {
		return this.UUID;
	}
	
	public String getPostTime() {
		return this.postTime;
	}
	
	public Vector<String> getRecipients(){
		return this.recipients;
	}
	
	//setters
	public void setBody(String newBody) {
		this.body = newBody;
	}
	
	public void insertRecipient(String newRecipient) {
		this.recipients.addElement(newRecipient);
	}
	
	public void removeRecipient(String oldRecipient) {
		this.recipients.removeElement(oldRecipient);
	}
	
	//variables
	protected String UUID;
	protected String postTime;
	
	protected String body;
	protected Vector<String> recipients;
}