package com.csi3471.datastructures;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.Vector;

import com.csi3471.entities.Message;
import com.csi3471.entities.MessageHeader;

import uk.co.omegaprime.btreemap.*;
import com.google.common.collect.Multimap;

//wrapper for BTreeMap
@SuppressWarnings("unused")
public class MessageBoard {

	public MessageBoard() {
		this.messageBoard = BTreeMap.create();
	}

	public Boolean insert(Message message) {
		return messageBoard.putIfAbsent(message, message) == null;
	}

	public Boolean remove(MessageHeader message) {
		// need to make sure the return is not null upon success
		return messageBoard.remove(message) != null;
	}

	public Message get(MessageHeader message) {
		return messageBoard.get(message);
	}

	public Boolean checkFor(MessageHeader message) {
		return messageBoard.containsKey(message);
	}

	public NavigableSet<MessageHeader> getHeaders() {
		return messageBoard.keySet();
	}

	public Collection<MessageHeader> fromUser(String UUID) {
		return null;
		// stubbed
	}
	
	private BTreeMap<MessageHeader, Message> messageBoard;
	private Multimap<String, MessageHeader> userMap;
}