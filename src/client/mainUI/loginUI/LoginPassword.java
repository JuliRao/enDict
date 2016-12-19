package client.mainUI.loginUI;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginPassword extends JPasswordField {
	private static int width = 300;
	private static int height = 30;
	
	public LoginPassword() {
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public LoginPassword(int x, int y) {
		this.setBounds(x, y, width, height);
		this.setLayout(null);
	}
}
