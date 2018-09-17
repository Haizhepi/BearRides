package com.csi3471.methods;

import com.csi3471.datastructures.UserTable;
import com.csi3471.entities.User;

//define behavior for usertable
public interface UTInterface {
	
	public static User login(UserTable table) {
		inputBuffer in = new inputBuffer();
		String email, password;
		
		System.out.println("Please enter your Baylor email address:");
		email = in.getln();
		
		System.out.println("Please enter your password:");
		password = in.getln();
		
		User attempt = null;
		try {
			attempt = table.login(email, password);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return attempt;
	}
	
	//add escapes
	public static Boolean register(UserTable table) {
		inputBuffer in = new inputBuffer();
		String email, password;
		
		System.out.println("Please enter your Baylor email address:");
		email = in.getln();
		
		System.out.println("Please enter your password:");
		password = in.getln();
		
		//validate email address
		//retry
		
		User newUser = new User(email, password);
		try {
			table.insert(newUser);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		email = password = null;
		String genericIn;
		
		System.out.println("What is your age?");
		try {
			newUser.setAge(Integer.parseInt(in.getln()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You did not enter an integer. Please try again.");
		}
		
		System.out.println("Are you a \"boy\" or a \"girl\"?");
		genericIn = in.getln();
		//if(genericIn == "boy") {
		//	System.out.println("You did not enter \"boy\" or \"girl\". Please try again.");
		//}else {
			newUser.setGender(genericIn == "boy");
		//}
		
		System.out.println("What do you want your username to be?");
		newUser.setName(in.getln());
		
		System.out.println("What's a way people can contact you?");
		newUser.setNumber(in.getln());
		
		//set up profile picture
		
		//please review your settings
		
		System.out.println("Registration Complete! Please login now.");
		return true;
	}
	
	public static void remove() {
		
	}
	
	public static void recoverPassword() {
		
	}
	
	public static void reverifyAll() {
		//stubbed
	}
}
