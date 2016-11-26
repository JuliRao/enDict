package mainUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class WordTransPanel extends JPanel {
	static int width = 400;
	static int height = 305;
	
	private ArrayList<DictionaryPanel> dictionaryList = new ArrayList<DictionaryPanel>();
	
	public WordTransPanel() {
		dictionaryList.add(new DictionaryPanel("有道词典"));
		dictionaryList.add(new DictionaryPanel("百度词霸"));
		dictionaryList.add(new DictionaryPanel("金山词典"));
		
		setPreferredSize(new Dimension(width, height));
		setLayout(new GridLayout(0, 1));
		setSize(width, height);
		setBackground(Color.white);
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
}
