package client.mainUI.loginUI;

import javax.swing.JTextField;

import client.theme.MyTheme;

@SuppressWarnings("serial")
public class LoginText extends JTextField {
	private static int width = 300;
	private static int height = 30;
	
	public LoginText() {
		this.setSize(width, height);
		this.setLayout(null);
		this.setFont(MyTheme.Instance().getFont());
	}
	
	public LoginText(int x, int y) {
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setFont(MyTheme.Instance().getFont());
	}
}
