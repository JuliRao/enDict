package client.common;

import common.Dictionary;

public interface Send {
	public void searchWord(String word);
	public boolean login(String user, String password);
	public boolean signIn(String user, String password);
	public void sendCard();
	public void like(Dictionary dictionary);
	public void unlike(Dictionary dictionary);
	public void getUserList();
	public void getCards();
}
