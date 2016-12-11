package client.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import client.mainUI.wordUI.DictionaryPanel;
import common.Dictionary;

class WordValue {
	Dictionary dictionary;
	Vector<String> meanings;
	
	public WordValue(Dictionary dictionary, Vector<String> meanings) {
		this.dictionary = dictionary;
		this.meanings = meanings;
	}
}

public class Meanings {
	Set<WordValue> meaningSet = new LinkedHashSet<WordValue>();
	
	public Vector<String> getMeanings(Dictionary dictionary) {
		for(WordValue value : meaningSet) {
			if(value.dictionary.equals(dictionary))
				return value.meanings;
		}
		
		return new Vector<String>();
	}
	
	public ArrayList<Dictionary> getByRank() {
		ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
		for(WordValue value : meaningSet) {
			dictionaries.add(value.dictionary);
		}
		
		return dictionaries;
	}
	
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
