package com.csi3471.datastructures;

import com.csi3471.entities.User;
import java.util.Hashtable;

public class UserTable {
	
	public UserTable() {
		// TODO Auto-generated constructor stub
	}

	public Boolean login(String UUID, String password) {
		return UserTable.get(UUID).getPassHash().equals(Hashtable.class.)
	}
	
	public void insert(User newUser) {
		UserTable.putIfAbsent(newUser.getUUID(), newUser);
	}
	
	public void remove(String UUID) {
		
	}
	
	public User find(String UUID) {
		return null;
	}
	
	public Hashtable<String, User> UserTable;
}