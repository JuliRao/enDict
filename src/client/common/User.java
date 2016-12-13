package client.common;

public class User {
	private String name;
	private boolean isOnline;
	
	public User(String name, boolean online) {
		this.setName(name);
		setOnline(online);
	}
	
	public User(String name, String online) {
		this.setName(name);
		isOnline = online.equals("Online");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
}