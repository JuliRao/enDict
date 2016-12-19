package client.common;

import java.util.Vector;

import common.Dictionary;

/**
 * 
 * @author marao
 * 定义与服务器端交互的函数
 *
 */
public interface Send {
	public void addNote(String word, String meaning);
	public void searchWord(String word);
	public int login(String user, String password);
	public boolean signIn(String user, String password);
	public void sendCard(Vector<String> strings);
	public void like(Dictionary dictionary);
	public void unlike(Dictionary dictionary);
	public void getUserList();
	public void getCards();
	public void logout();
	public void getWordNotes();
	public void getSentence();
	public void getHotWords();
}
