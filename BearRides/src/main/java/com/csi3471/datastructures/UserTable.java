package com.csi3471.datastructures;

import java.util.Map;
import java.util.HashMap;

import com.csi3471.entities.User;

//wrapper for HashMap
public class UserTable {
	
	public UserTable() {
		userTable = new HashMap<String, User>();
	}
	
	public User login(String UUID, String password) throws Throwable {
		User anon = userTable.get(UUID);
		
		if(anon == null) {
			throw new Exception("No Such User.");
		}else if(anon.getPassHash() != password.hashCode()){
			throw new Exception("Wrong Password.");
		}else {
			return anon;
		}
	}
	
	public Boolean insert(User user) throws Exception {
		Boolean attempt = userTable.putIfAbsent(user.getUUID(), user) == null;
		
		if(!attempt) {
			throw new Exception("User Already Registered.");
		}else {
			return attempt;
		}
	}
	
	public Boolean remove(String UUID) {
		return userTable.remove(UUID) != null;
	}
	
	public User get(String UUID) {
		return userTable.get(UUID);
	}
	
	public Boolean checkFor(String UUID) {
		return userTable.containsKey(UUID);
	}
	
	Map<String, User> userTable;
}