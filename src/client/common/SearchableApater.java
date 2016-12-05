package client.common;

import java.util.Vector;

import common.Dictionary;
import common.ThreeMeanings;

public class SearchableApater implements Searchable {
	
	private ThreeMeanings threeMeanings;

	@Override
	public Vector<String> getMeaning(Dictionary dictionary) {
		if(dictionary == Dictionary.Baidu)
			return threeMeanings.getBaidu();
		else if(dictionary == Dictionary.Bing)
			return threeMeanings.getBing();
		else 
			return threeMeanings.getYoudao();
	}

	public SearchableApater(ThreeMeanings meanings) {
		threeMeanings = meanings;
	}
}
