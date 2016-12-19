package client.common;

import java.util.Vector;

import common.Dictionary;

/**
 * 
 * @author marao
 * 用于存储全局的数据信息
 *
 */
public class Info {
	static private Dictionary defaultDictionary = Dictionary.Bing;		// 系统默认词典，用户可修改
	static private String word = "";				// 当前被搜索的单词
	static private Meanings meanings = new Meanings();		// 当前单词释义
	static private String userName = null;			// 登录后的用户名
	static private String[][] wordNotes;			// 单词本数据
	static private String sentence = "";			// 每日一句
	static private Vector<String> hotWords ;		// 最热搜索
	
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
