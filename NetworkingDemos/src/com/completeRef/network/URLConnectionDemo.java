package com.completeRef.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionDemo {
	public static void main(String args[]) throws  IOException{
		int c;
		URL url = new URL("http://yourstory.com/");
		URLConnection urlConn = url.openConnection(); 
		long  d = urlConn.getDate();
		System.out.println("Date: "+ new Date(d));
		System.out.println("Content-type: "+ urlConn.getContentType());
		System.out.println("Expiration date: "+ new Date(urlConn.getExpiration()));
		System.out.println("Last Modified: "+ new Date(urlConn.getLastModified()));
		System.out.println("========Content========");
		InputStream in = urlConn.getInputStream();
		//int i = urlConn.getContentLength();
		while((c = in.read()) != -1){
			System.out.print((char)c);
		}
		in.close();
	}
	
}
