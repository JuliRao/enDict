//package common;
package server;

import common.ThreeMeanings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.Vector;


public class Server {

//	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(3000);
			Socket socket = serverSocket.accept();
			InetAddress inetAddress = socket.getInetAddress();
			System.out.println(inetAddress.getHostAddress() + " " + inetAddress.getHostName());
			
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			
			ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
//			@SuppressWarnings("deprecation")
			String dstWord=inputStream.readUTF();
	//				char a = inputStream.r
			System.out.println(dstWord);
			Search s = new Search();
			ThreeMeanings mean = new ThreeMeanings(s.getBaiduMean(dstWord), s.getYoudaoMean(dstWord), s.getBingMean(dstWord));
//			mean.getMean(s.getBaiduMean(dstWord), s.getYoudaoMean(dstWord), s.getBingMean(dstWord));
			
			toClient.writeObject(mean);
//			System.out.println(inputStream.readDouble());
			
			
			while(true) {
				
			}
		} catch (IOException e) {
			// TODO 鑷姩鐢熸垚鐨� catch 鍧�
			e.printStackTrace();
		}
	}

}
