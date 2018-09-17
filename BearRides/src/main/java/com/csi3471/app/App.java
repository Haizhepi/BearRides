package com.csi3471.app;

import com.csi3471.datastructures.MessageBoard;
import com.csi3471.datastructures.UserTable;
import com.csi3471.entities.User;
import com.csi3471.methods.UTInterface;
import com.csi3471.methods.inputBuffer;

@SuppressWarnings("unused")
public class App {
	public static void main(String[] args) {
		UserTable testTable = new UserTable();
		User testUser;
		inputBuffer in = new inputBuffer();

		System.out.println("Welcome to BearRides, would you like to \"login\" or \"register\"");
		switch (in.getln()) {
		case ("register"):
			UTInterface.register(testTable);
		case ("login"):
			testUser = UTInterface.login(testTable);
			break;
		default:
			System.out.println("Wow aren't you quite the rebel....");
		}

		MessageBoard testBoard = new MessageBoard();

	}
}