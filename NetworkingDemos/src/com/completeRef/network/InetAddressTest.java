package com.completeRef.network;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddressTest {

	public static void main(String args[]) throws UnknownHostException{
		Inet4Address address = (Inet4Address) Inet4Address.getLocalHost();
		System.out.println(address);
		address  = (Inet4Address) Inet4Address.getByName("aiktc.org");
		System.out.println(address);
		InetAddress add[] = Inet4Address.getAllByName("google.com");
		for (InetAddress inetAddress : add) {
			System.out.println(inetAddress);
		}
	}
	
}
