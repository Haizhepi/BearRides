package com.csi3471.datastructures;

import java.util.*;

import com.csi3471.entities.User;

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
	
	public Boolean insert(User newUser) {
		return userTable.putIfAbsent(newUser.getUUID(), newUser) == null;
	}
	
	public Boolean remove(String UUID) {
		return userTable.remove(UUID) != null;
	}
	
	public User find(String UUID) {
		return userTable.get(UUID);
	}
	
	public Boolean checkFor(String UUID) {
		return userTable.containsKey(UUID);
	}
	
	Map<String, User> userTable;
}