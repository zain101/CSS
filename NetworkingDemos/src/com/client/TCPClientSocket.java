package com.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ciphers.Substitution;
import com.inputHandlers.InputHander;

public class TCPClientSocket {
	public static void main(String args[]) throws UnknownHostException, IOException{
		Socket client = new Socket("localhost", 5555);
		String msg, tmp;
		String fromServer = null;
		
		System.out.println("just connected to server: "+ client.getLocalSocketAddress());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		out.writeUTF("Message from client "+ client.getLocalSocketAddress());
		DataInputStream in  = new DataInputStream(client.getInputStream());
		System.out.println("Server says: "+ in.readUTF());
		out.writeUTF("You could send message now to quit type 'q' ");
		System.out.println("You could send message now to quit type 'q' ");
		System.out.println("from server: "+  in.readUTF());
		while(true){
			System.out.println("========================================");

			System.out.println("Say something You: ");
			msg = InputHander.readString();
			//tmp = Substitution.ceaserEncrypt(msg).toString();
			System.out.println("message send to server: "+msg);
			out.writeUTF(msg);
			
			fromServer  = in.readUTF();
			
			System.out.println("from server:===> "+ fromServer);
			//System.out.println("from server(Decreypted):===> "+ fromServer);
			
			if(fromServer.equalsIgnoreCase("q") || msg.equalsIgnoreCase("q")){
				System.out.println("[client] closing from server requested by client...  vise versa");
				client.close();
				break;
			}
		}
	}
}
