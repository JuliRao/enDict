package mainUI.wordUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WordCheckBoxs extends JPanel {
	private static int width = 80;
	private static int height = 300;
	
	private ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
	
	public ArrayList<JCheckBox> getCheckBoxList() {
		return checkBoxList;
	}

	public void setCheckBoxList(ArrayList<JCheckBox> checkBoxList) {
		this.checkBoxList = checkBoxList;
	}

	public WordCheckBoxs(String[] texts) {
		for(String string : texts) {
			JCheckBox checkBox = new JCheckBox(string);
			checkBox.setBackground(Color.WHITE);
			this.add(checkBox);
			checkBoxList.add(checkBox);
		}
		this.setBackground(Color.WHITE);
		this.setSize(width, height);
		this.setLayout(new GridLayout(6, 1));
	}
	
	public WordCheckBoxs(String[] texts, int x, int y) {
		for(String string : texts) {
			JCheckBox checkBox = new JCheckBox(string);
			checkBox.setBackground(Color.WHITE);
			checkBox.setSelected(true);
			this.add(checkBox);
			checkBoxList.add(checkBox);
		}
		this.setBackground(Color.WHITE);
		this.setBounds(x, y, width, height);
		this.setLayout(new GridLayout(6, 1));
	}
	
	boolean[] isAccessable() {
		boolean accessable[] = new boolean[checkBoxList.size()];
		for(int i = 0; i < checkBoxList.size(); ++ i) {
			if(checkBoxList.get(i).isSelected())
				accessable[i] = true;
			else 
				accessable[i] = false; 
		}
		return accessable;
	}
}
