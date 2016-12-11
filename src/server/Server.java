//package common;
package server;


//import server.Search;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import server.database.*;

public class Server {
	
	private int clientNo = 0;
	private MyData database;

	public Server() {
		try {
			database = MyData.createConnection();
			ServerSocket serverSocket = new ServerSocket(8000);
//			MyData database = new MyData();
//			database.createConnection();
			
			while(true) {
				Socket socket = serverSocket.accept();
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("Client " + clientNo + "'s host name is " + inetAddress.getHostAddress());
				System.out.println("Client " + clientNo + "'s IP Address is " + inetAddress.getHostName());
				
				// create a new task for the connection
				HandleAClient task = new HandleAClient(socket);
				Thread thread = new Thread(task);
				
				// start the new thread
				thread.start();
				
				// Increment clientNo
				clientNo ++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeClient() {
		-- clientNo;
	}

	public static void main(String[] args) {
		new Server();
	}
}
