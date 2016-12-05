package client.common;


public class Info {
	static private String word;
	static private Searchable meanings;
	
	public static Searchable getMeanings() {
		return meanings;
	}
	
	public static void setMeanings(Searchable meanings) {
		Info.meanings = meanings;
	}
	
	public static String getWord() {
		return word;
	}
	
	public static void setWord(String word) {
		Info.word = word;
	}
}
