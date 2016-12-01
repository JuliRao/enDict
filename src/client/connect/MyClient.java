package client.connect;

public class MyClient {
	private static Client client = null;
	
	public synchronized static Client Instance() {
		if(client == null) {
			client = new Client();
		}
		return client;
	}
	
	private MyClient() {
		
	}
}
