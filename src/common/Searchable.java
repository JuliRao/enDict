package common;

import java.util.Vector;

public interface Searchable {
	public Vector<String> getBaiduMean(String word);
	public Vector<String> getYoudaoMean(String word);
	public Vector<String> getBingMean(String word);
}