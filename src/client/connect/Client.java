package client.connect;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import common.ThreeMeanings;
import client.common.Info;
import client.common.Searchable;
import client.common.SearchableApater;

public class Client {
	private Socket socket;
	ObjectOutputStream toServer;
	ObjectInputStream input;
	
	Client() {
		try {
			socket = new Socket("localhost", 8000);
			System.out.println("Server connected.");
			toServer = new ObjectOutputStream(socket.getOutputStream());
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
}
