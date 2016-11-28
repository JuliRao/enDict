package client.run;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TstServer {
	public static void main(String []args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			Socket socket = serverSocket.accept();
//			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			
//			System.out.println(inputStream.readDouble());
			
			InetAddress inetAddress = socket.getInetAddress();
			System.out.println(inetAddress.getHostAddress() + " " + inetAddress.getHostName());
			
			while(true) {
				
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
