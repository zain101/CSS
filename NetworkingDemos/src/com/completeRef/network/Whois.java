package com.completeRef.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
	public static void main(String args[]) throws IOException{
		int c;
		Socket s = new Socket("internic.net", 43);
		InputStream in = s.getInputStream();
		OutputStream out  = s.getOutputStream();
		String str = "google.com";
		byte[] buff = str.getBytes();
		out.write(buff);
		while((c = in.read()) != -1){
			System.out.println((char) c);
		}
		s.close();
	}
}
