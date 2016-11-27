package mainUI;

import javax.swing.JLabel;

public class LoginLabel extends JLabel {
	private static int width = 40;
	private static int height = 30;
	
	public LoginLabel() {
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public LoginLabel(String s, int x, int y) {
		this.setBounds(x, y, width, height);
		this.setText(s);
		this.setLayout(null);
	}
}