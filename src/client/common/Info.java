package client.common;

import common.Dictionary;

public class Info {
	static private Dictionary defaultDictionary = Dictionary.Bing;
	static private String word = "";
	static private Meanings meanings = new Meanings();
	static String userName = null;
	
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
}
