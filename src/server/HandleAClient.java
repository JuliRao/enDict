package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import common.ThreeMeanings;

public class HandleAClient implements Runnable {

	private Socket socket;
	
	public HandleAClient(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try{
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
			
			while(true) {
				String dstWord = inputStream.readUTF();
				System.out.println(dstWord);
				Search s = new Search();
				ThreeMeanings mean = new ThreeMeanings(s.getJinshanMean(dstWord), s.getYoudaoMean(dstWord), s.getBingMean(dstWord));		
				toClient.writeObject(mean);
			}
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
		finally {
			System.out.println("Close the Server socket and the io.");
            try {
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
