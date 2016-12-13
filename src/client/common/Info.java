package client.common;

import java.util.Vector;

import common.Dictionary;

public class Info {
	static private Dictionary defaultDictionary = Dictionary.Bing;
	static private String word = "";
	static private Meanings meanings = new Meanings();
	static private String userName = null;
	static private String[][] wordNotes;
	static private String sentence = "";
	static private Vector<String> hotWords ;
	
	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		Info.userName = userName;
	}

	public static Meanings getMeanings() {
		return meanings;
	}
	
	public static void setMeanings(Meanings meanings) {
		Info.meanings = meanings;
	}
	
	public static String getWord() {
		return word;
	}
	
	public static void setWord(String word) {
		Info.word = word;
	}

	public static Dictionary getDefaultDictionary() {
		return defaultDictionary;
	}

	public static void setDefaultDictionary(Dictionary defaultDictionary) {
		Info.defaultDictionary = defaultDictionary;
	}
	
	public static void setWordNotes(String [][] strings) {
		wordNotes = strings;
	}
	
	public static String[][] getWordNotes() {
		return wordNotes;
	}

	public static String getSentence() {
		return sentence;
	}

	public static void setSentence(String sentence) {
		Info.sentence = sentence;
	}

	public static Vector<String> getHotWords() {
		return hotWords;
	}

	public static void setHotWords(Vector<String> hotWords) {
		Info.hotWords = hotWords;
	}
}
