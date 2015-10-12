package com.inputHandlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHander {

	public static String readString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int readInt(){
		return Integer.parseInt(readString());
	}
	
	public static float readFloat() {
		return Float.parseFloat(readString());
	}
}
