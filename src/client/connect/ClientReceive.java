package client.connect;

import java.io.IOException;
import java.net.Socket;

import client.common.Receive;

public class ClientReceive extends Thread implements Receive {
	private Socket socket;

	public ClientReceive(Socket socket) {
		this.socket = socket;
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
        try {
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }	
}
