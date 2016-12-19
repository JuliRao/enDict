package client.mainUI.wordUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import common.Dictionary;

/**
 * 
 * @author marao
 * 用户选择显示的词典
 *
 */
@SuppressWarnings("serial")
public class WordCheckBoxs extends JPanel {
	private static int width = 80;
	private static int height = 200;
	
	private Map<JCheckBox, Dictionary> checkMap = new HashMap<JCheckBox, Dictionary>();
	public Set<JCheckBox> getBoxs() {
		return checkMap.keySet();
	}

	public WordCheckBoxs(Dictionary []dictionaries) {
		for(int i = 0; i < dictionaries.length; ++ i) {
			JCheckBox checkBox = new JCheckBox(dictionaries[i].getName());
			checkBox.setBackground(Color.WHITE);
			this.add(checkBox);
			checkMap.put(checkBox, dictionaries[i]);
		}

		this.setBackground(Color.WHITE);
		this.setSize(width, height);
		this.setLayout(new GridLayout(6, 1));
	}
	
	public WordCheckBoxs(Dictionary []dictionaries, int x, int y) {
		for(int i = 0; i < dictionaries.length; ++ i) {
			JCheckBox checkBox = new JCheckBox(dictionaries[i].getName());
			checkBox.setBackground(Color.WHITE);
			this.add(checkBox);
			checkMap.put(checkBox, dictionaries[i]);
		}

		this.setBackground(Color.WHITE);
		this.setBounds(x, y, width, height);
		this.setLayout(new GridLayout(4, 1));
	}
	
	ArrayList<Dictionary> getAccessible() {
		ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
		for(JCheckBox checkBox : checkMap.keySet()) {
			if(checkBox.isSelected())
				dictionaries.add(checkMap.get(checkBox));
		}
		return dictionaries;
	}
}
