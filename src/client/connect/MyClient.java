package client.connect;

import java.io.IOException;
import java.net.Socket;

public class MyClient {
	private static Client client = null;
	
	public static Client Instance() {
		if(client == null) {
			client = new Client();
		}
		return client;
	}
}
