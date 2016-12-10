package client.connect;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import common.Dictionary;
import common.ThreeMeanings;
import client.common.Info;
import client.common.SearchableApater;
import client.common.Send;

public class ClientSend extends Thread implements Send {
	private Socket socket;
	DataOutputStream toServer;
	ObjectInputStream input;
	
	public ClientSend(Socket socket) {
		try {
			this.socket = socket;
			System.out.println("Server connected.");
			input = new ObjectInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());

			//socket = new Socket("114.212.130.243", 3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void searchWord(String word) {
		try {
			Info.setWord(word);
			toServer.writeUTF(word);
			toServer.flush();

			ThreeMeanings meanings = (ThreeMeanings)input.readObject();
			Info.setMeanings(new SearchableApater(meanings));
			
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
	
	public void login(String user, String password) {
		System.out.println("Click login");
	}
	
	public void signIn(String user, String password) {
		System.out.println("Click sign in");
	}
	
	public void sendCard() {
		System.out.println("Start sending...");
	}

	public void like(Dictionary dictionary) {
		System.out.println("Like " + dictionary.getName());
	}
	
	public void getUserList() {
		System.out.println("Get all the user");
	}
	
	public void getCard() {
		
	}

	public void getCards() {
		
	}
}
