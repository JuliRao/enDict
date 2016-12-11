package client.common;

import java.util.Vector;

import common.Dictionary;

public interface Send {
	public void searchWord(String word);
	public boolean login(String user, String password);
	public boolean signIn(String user, String password);
	public void sendCard(Vector<String> strings);
	public void like(Dictionary dictionary);
	public void unlike(Dictionary dictionary);
	public void getUserList();
	public void getCards();
}
