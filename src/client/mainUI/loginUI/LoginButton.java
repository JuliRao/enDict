package client.mainUI.loginUI;

import javax.swing.JButton;

import client.theme.MyTheme;

public class LoginButton extends JButton {
	private static int width = 80;
	private static int height = 30;
	
	public LoginButton() {
		this.setBackground(MyTheme.Instance().getBackgroundColor());
		this.setSize(width, height);
	}
	
	public LoginButton(String s, int x, int y) {
		this.setText(s);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(MyTheme.Instance().getBackgroundColor());
	}
}