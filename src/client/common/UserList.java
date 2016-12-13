package client.common;

import java.util.ArrayList;

public class UserList {
	private static ArrayList<User> list = new ArrayList<User>();
	
	public static ArrayList<User> getList() {
		return list;
	}

	public static void setList(ArrayList<User> list) {
		UserList.list = list;
	}

	public static void clearList() {
		list.clear();
	}
	
	public static void addUser(User user){
		list.add(user);
	}
}