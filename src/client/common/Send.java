package client.common;

import common.Dictionary;

public interface Send {
	public void searchWord(String word);
	public void login(String user, String password);
	public void signIn(String user, String password);
	public void sendCard();
	public void like(Dictionary dictionary);
	public void getUserList();
	public void getCards();
}
