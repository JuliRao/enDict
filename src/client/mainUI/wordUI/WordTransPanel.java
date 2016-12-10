package client.mainUI.wordUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

import common.Dictionary;

import client.common.Displayable;
import client.common.Refreshable;
import client.theme.MyTheme;

public class WordTransPanel extends JPanel implements Refreshable, Displayable {
	static int width = 450;
	static int height = 305;
	
	private ArrayList<DictionaryPanel> dictionaryList = new ArrayList<DictionaryPanel>();
	
	public WordTransPanel() {
		dictionaryList.add(new DictionaryPanel(Dictionary.YouDao));
		dictionaryList.add(new DictionaryPanel(Dictionary.Baidu));
		dictionaryList.add(new DictionaryPanel(Dictionary.Bing));
		
		for(DictionaryPanel dictionaryPanel : dictionaryList)
			this.add(dictionaryPanel);
		
		setPreferredSize(new Dimension(width, height));
		setLayout(new GridLayout(0, 1));
		setSize(width, height);
		setBackground(MyTheme.Instance().getBackgroundColor());
	}

	public void refresh(boolean []accessable) {
		this.removeAll();
		
		boolean all = true;
		for(int i = 0; i < accessable.length; ++ i) {
			if(accessable[i]) {
				all = false;
				this.add(dictionaryList.get(i));
			}
		}
		
		// all not selected
		if(all == true) {
			for(DictionaryPanel dictionaryPanel : dictionaryList)
				this.add(dictionaryPanel);
		}
		
		this.validate();
		this.repaint();
	}

	@Override
	public void displayBing(Vector<String> strings) {
		dictionaryList.get(2).displayMeaning(strings);
	}

	@Override
	public void displayBaidu(Vector<String> strings) {
		dictionaryList.get(1).displayMeaning(strings);
	}

	@Override
	public void displayYoudao(Vector<String> strings) {
		dictionaryList.get(0).displayMeaning(strings);
	}
}
