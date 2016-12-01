package client.connect;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import common.ThreeMeanings;

public class Client {
	private Socket socket;
	DataOutputStream toServer;
	ObjectInputStream input;
	
	Client() {
		try {
			socket = new Socket("localhost", 3000);
			System.out.println("server connected.");
			toServer = new DataOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
			//socket = new Socket("114.212.130.243", 3000);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public ThreeMeanings searchWord(String word) {
		ThreeMeanings meanings = null;
		try {
//			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
//			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			
			toServer.writeUTF(word);
			meanings = (ThreeMeanings)input.readObject();
			toServer.flush();
//			toServer.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return meanings;
	}
}
