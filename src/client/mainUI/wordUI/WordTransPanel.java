package client.mainUI.wordUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JPanel;

import common.Dictionary;
import client.common.Displayable;
import client.common.Info;
import client.common.Meanings;
import client.common.Refreshable;
import client.theme.MyTheme;

public class WordTransPanel extends JPanel implements Refreshable, Displayable {
	static int width = 450;
	static int height = 305;
	
	private Map<Dictionary, DictionaryPanel> dictMap = new HashMap<Dictionary, DictionaryPanel>();
	
	public WordTransPanel() {
		dictMap.put(Dictionary.YouDao, new DictionaryPanel(Dictionary.YouDao));
		dictMap.put(Dictionary.Baidu, new DictionaryPanel(Dictionary.Baidu));
		dictMap.put(Dictionary.Bing, new DictionaryPanel(Dictionary.Bing));
		
		this.add(dictMap.get(Dictionary.Baidu));
		this.add(dictMap.get(Dictionary.YouDao));
		this.add(dictMap.get(Dictionary.Bing));
		
		setPreferredSize(new Dimension(width, height));
		setLayout(new GridLayout(0, 1));
		setSize(width, height);
		setBackground(MyTheme.Instance().getBackgroundColor());
	}

	public void refresh(ArrayList<Dictionary> accessable) {
		this.removeAll();
		
		ArrayList<Dictionary> sortedDictionaries = Info.getMeanings().getByRank();
		
		if(accessable.size() == 0) {
			for(Dictionary dictionary : sortedDictionaries) {
				this.add(dictMap.get(dictionary));
			}
		}
		
		for(int i = 0; i < sortedDictionaries.size(); ++ i) {
			if(accessable.contains(sortedDictionaries.get(i))){
				this.add(dictMap.get(sortedDictionaries.get(i)));
			}
		}
			
		this.validate();
		this.repaint();
	}

	@Override
	public void displayBing(Vector<String> strings) {
		dictMap.get(Dictionary.Bing).displayMeaning(strings);
	}

	@Override
	public void displayBaidu(Vector<String> strings) {
		dictMap.get(Dictionary.Baidu).displayMeaning(strings);
	}

	@Override
	public void displayYoudao(Vector<String> strings) {
		dictMap.get(Dictionary.YouDao).displayMeaning(strings);
	}
}
