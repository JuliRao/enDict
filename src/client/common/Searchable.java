package client.common;

import java.util.Vector;

import common.Dictionary;

public interface Searchable {
	public Vector<String> getMeaning(Dictionary dictionary);
}