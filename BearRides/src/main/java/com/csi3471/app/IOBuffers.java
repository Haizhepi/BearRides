package com.csi3471.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inputBuffer {

	public inputBuffer() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getln() {
		try {
			return in.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return null;
	}

	private BufferedReader in;
}