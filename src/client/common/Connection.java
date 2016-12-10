package client.common;

public interface Connection {
	public void searchWord(String word);
	public boolean login(String name, String password);
	public boolean signIn(String name, String password);
}
