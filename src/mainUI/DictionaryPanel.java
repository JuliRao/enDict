package mainUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DictionaryPanel extends JPanel {
	private JTextField translation = new JTextField();
	private JButton button = new HeartButton();
	private String dictionaryName;
	
	public DictionaryPanel() {
		translation.setSize(100, 0);
	}
	
	public DictionaryPanel(String name) {
		dictionaryName = name;
		translation.setSize(100, 0);
		setLayout(null);
		setSize(30, 40);
		setBackground(Color.white);
		
		
		//setLayout(new GridLayout(0, 2));
		
		translation.setText(name);
		translation.setSize(100, 30);
		translation.setBackground(Color.red);
		
		button.setLocation(this.getLocation().x + 200, this.getLocation().y);
		button.setSize(30, 30);
		
		add(button);
		add(translation);
	}
}
