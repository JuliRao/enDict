package client.common;

import java.util.ArrayList;

public class UserList {
	ArrayList<User> list = new ArrayList<User>();
	
	public UserList() {
		list.add(new User("zhou", false));
		list.add(new User("what", true));
	}
}

class User {
	String name;
	boolean isOnline;
	
	User(String name, boolean online) {
		this.name = name;
		isOnline = online;
	}
}