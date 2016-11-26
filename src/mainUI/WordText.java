package mainUI;

import javax.swing.JTextField;

public class WordText extends JTextField {
	
	private static int width = 500;
	private static int height = 30;
	
	public WordText() {
		this.setLayout(null);
		this.setSize(width, height);
	}
	
	public WordText(int x, int y) {
		this.setBounds(x, y, width, height);
		this.setLayout(null);
	}
}
