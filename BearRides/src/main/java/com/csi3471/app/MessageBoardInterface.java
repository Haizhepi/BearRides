package com.csi3471.methods;

import com.csi3471.datastructures.MessageBoard;
import com.csi3471.entities.MessageHeader;

//define behavior for MessageBoard
public interface MessageBoardInterface {

	public static void drawBoard(MessageBoard board) {
		// stubbed
	}

	public static void drawReview(MessageBoard board, MessageHeader header) {
		// stubbed
	}

	public static void drawReminder(MessageBoard board, MessageHeader header) {
		// stubbed
	}

	public static void drawRequest(MessageBoard board, MessageHeader header) {
		// stubbed
	}

	public static void drawOffer(MessageBoard board, MessageHeader header) {
		// stubbed
	}

	public static void drawService(MessageBoard board, MessageHeader header) {
		// stubbed
	}

	public static Boolean postReview(MessageBoard board) {
		return null;
		// stubbed
	}

	public static Boolean postRequest(MessageBoard board) {
		return false;
		// stubbed
	}

	public static Boolean postOffer(MessageBoard board) {
		return null;
		// stubbed
	}

	public static Boolean postService(MessageBoard board) {
		return null;
		// stubbed
	}

	public static Boolean acceptRequest(MessageBoard board, MessageHeader header) {
		return null;
		// stubbed
	}

	public static Boolean acceptOffer(MessageBoard board, MessageHeader header) {
		return null;
		// stubbed
	}

	public static Boolean acceptService(MessageBoard board, MessageHeader header) {
		return null;
		// stubbed
	}

	public static Boolean pushReminders() {
		return null;
		// stubbed
	}

	public static Boolean filterByUser(MessageBoard board, String UUID) {
		return null;
		// stubbed
	}

	public static void removeFinished() {
		// stubbed
	}
}