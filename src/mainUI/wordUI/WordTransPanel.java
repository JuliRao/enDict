package mainUI.wordUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

import theme.MyTheme;

import common.Displayable;
import common.Refreshable;

public class WordTransPanel extends JPanel implements Refreshable, Displayable {
	static int width = 450;
	static int height = 305;
	
	private ArrayList<DictionaryPanel> dictionaryList = new ArrayList<DictionaryPanel>();
	
	public WordTransPanel() {
		dictionaryList.add(new DictionaryPanel("有道词典"));
		dictionaryList.add(new DictionaryPanel("百度词霸"));
		dictionaryList.add(new DictionaryPanel("必应词典"));
		
		for(DictionaryPanel dictionaryPanel : dictionaryList)
			this.add(dictionaryPanel);
		
		setPreferredSize(new Dimension(width, height));
		setLayout(new GridLayout(0, 1));
		setSize(width, height);
		setBackground(MyTheme.Instance().getBackgroundColor());
	}

	public void refresh(boolean []accessable) {
		this.removeAll();
		for(int i = 0; i < accessable.length; ++ i) {
			if(accessable[i]) {
				this.add(dictionaryList.get(i));
			}
		}
		this.validate();
		this.repaint();
	}

	@Override
	public void displayJinShan(Vector<String> strings) {
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
