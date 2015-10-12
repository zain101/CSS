package com.completeRef.network;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
	public static void main(String args[]) throws  MalformedURLException{
		URL url = new URL("https://www.google.com");
		System.out.println("Protocol: " + url.getProtocol());
		System.out.println("host: " + url.getHost());
		System.out.println("port: "+ url.getPort());
	}
}
