package mainUI.loginUI;

import java.awt.Color;

import javax.swing.JButton;

public class LoginButton extends JButton {
	private static int width = 80;
	private static int height = 30;
	
	public LoginButton() {
		this.setSize(width, height);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
	}
	
	public LoginButton(String s, int x, int y) {
		this.setText(s);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
	}
}
