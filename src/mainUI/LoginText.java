package mainUI;

import java.awt.LayoutManager;

import javax.swing.JTextField;

public class LoginText extends JTextField {
	private static int width = 300;
	private static int height = 30;
	
	public LoginText() {
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public LoginText(int x, int y) {
		this.setBounds(x, y, width, height);
		this.setLayout(null);
	}
}
