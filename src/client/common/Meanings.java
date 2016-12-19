package client.common;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

import common.Dictionary;

class WordValue {
	Dictionary dictionary;
	Vector<String> meanings;
	
	public WordValue(Dictionary dictionary, Vector<String> meanings) {
		this.dictionary = dictionary;
		this.meanings = meanings;
	}
}

/**
 * 使用LinkedHashSet存储单词的释义
 * @author marao
 *
 */
public class Meanings {
	Set<WordValue> meaningSet = new LinkedHashSet<WordValue>();
	
	/**
	 * 获得某个词典的单词释义
	 * @param dictionary
	 * @return
	 */
	public Vector<String> getMeanings(Dictionary dictionary) {
		for(WordValue value : meaningSet) {
			if(value.dictionary.equals(dictionary))
				return value.meanings;
		}
		
		return new Vector<String>();
	}
	
	/**
	 * 根据点赞排序得到词典顺序
	 * @return
	 */
	public ArrayList<Dictionary> getByRank() {
		ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
		for(WordValue value : meaningSet) {
			dictionaries.add(value.dictionary);
		}
		
		if(!dictionaries.contains(Dictionary.Baidu))
			dictionaries.add(Dictionary.Baidu);
		if(!dictionaries.contains(Dictionary.Bing))
			dictionaries.add(Dictionary.Bing);
		if(!dictionaries.contains(Dictionary.YouDao))
			dictionaries.add(Dictionary.YouDao);
		
		return dictionaries;
	}
	
	/**
	 * 增加某个词典的释义
	 * @param dictionary
	 * @param strings
	 */
	public void addMeaning(Dictionary dictionary, Vector<String> strings) {
		WordValue value = new WordValue(dictionary, strings);
		meaningSet.add(value);
	}
	
	public Meanings(Vector<String> strings) {
		Vector<String> meanings = new Vector<String>();
		Dictionary dictionary = null;
		for(String string : strings) {
			
			if(Dictionary.getDictionary(string) != null) {
				if(dictionary != null) {
					addMeaning(dictionary, meanings);
				}
				dictionary = Dictionary.getDictionary(string);
				meanings = new Vector<String>();
			}
			else
				meanings.add(string);
		}
		
		if(dictionary != null) {
			addMeaning(dictionary, meanings);
		}
	}
	
	public Meanings() {
		
	}
}
