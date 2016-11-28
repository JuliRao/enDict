package client.mainUI.wordUI;

import javax.swing.JLabel;

public class WordLabel extends JLabel {
	private static int width = 40;
	private static int height = 30;
	
	public WordLabel() {
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public WordLabel(String s, int x, int y) {
		this.setBounds(x, y, width, height);
		this.setText(s);
		this.setLayout(null);
	}
}
