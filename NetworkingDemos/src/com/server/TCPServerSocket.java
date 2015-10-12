package com.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ciphers.Substitution;
import com.inputHandlers.InputHander;

public class TCPServerSocket {
	public static void main(String args[]) throws IOException, InterruptedException{
		String msg, tmp;
		String fromClient;
		System.out.println("waiting for clients...");
		ServerSocket server = new ServerSocket(5555);
		Socket connected = server.accept();
		System.out.println("Just connected to client: "+ connected.getRemoteSocketAddress());
		DataInputStream in  = new DataInputStream(connected.getInputStream());
		DataOutputStream out  = new DataOutputStream(connected.getOutputStream()) ;
		System.out.println(in.readUTF());
		out.writeUTF("Thanks for connecting: "+ connected.getLocalAddress());
		out.writeUTF("You could send message now to quit type 'q' ");
		System.out.println("You could send message now to quit type 'q' ");
		System.out.println("from server: "+ in.readUTF());
		while(true){
			System.out.println("========================================");

			fromClient = in.readUTF();
			System.out.println("Received text: "+ fromClient);
			//System.out.println("from client(decrypted):===> "+ fromClient);
			
			System.out.println("Say something You: ");
			msg = InputHander.readString();
			//tmp = Substitution.ceaserEncrypt(msg).toString();
			//System.out.println("Ecrypted text send:"+ tmp);
			out.writeUTF(msg);
			
			if(fromClient.equalsIgnoreCase("q") || msg.equalsIgnoreCase("q")){
				System.out.println("[server] closing from server requested by client...  vise versa");
				server.close();
				break;
			}
		}
		
		
	}
}