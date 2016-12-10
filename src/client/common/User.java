package client.common;

public class User {
	private String name;
	private boolean isOnline;
	
	User(String name, boolean online) {
		this.setName(name);
		setOnline(online);
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