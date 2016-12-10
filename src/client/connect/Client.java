package client.connect;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import common.ThreeMeanings;
import client.common.Info;
import client.common.SearchableApater;
import client.mainUI.MainFrame;

public class Client implements Runnable {
	private Socket socket;
	DataOutputStream toServer;
	ObjectInputStream input;
	
	Client() {
		try {
			socket = new Socket("localhost", 8000);
			System.out.println("Server connected.");
			toServer = new DataOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
			//socket = new Socket("114.212.130.243", 3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void searchWord(String word) {
		try {
			toServer.writeUTF(word);
			ThreeMeanings meanings = (ThreeMeanings)input.readObject();
			Info.setMeanings(new SearchableApater(meanings));
			Info.setWord(word);
			toServer.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		System.out.println("Close the Client socket and the io.");
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
