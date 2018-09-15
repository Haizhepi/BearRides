package com.csi3471.datastructures;

import com.csi3471.entities.*;

import uk.co.omegaprime.btreemap.*;

public class MessageBoard <T extends Comparable<T>> {

	public MessageBoard() {
		//this.newMap = BTreeMap.create();
		
	}
	
	BTreeMap<String, Message> newMap;
}