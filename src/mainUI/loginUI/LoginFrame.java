package mainUI.loginUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	private JTextField usrName = new LoginText(130, 35);
	private JPasswordField usrPassword = new LoginPassword(130, 85);

	private JLabel nameLabel = new LoginLabel("用户名", 50, 35);
	private JLabel pswLabel = new LoginLabel("密码", 50, 85);
	
	private JButton loginButton = new LoginButton("登录", 130, 160);
	private JButton signInButton = new LoginButton("注册", 345, 160);
	
	public LoginFrame() {
		this.setLayout(null);
		this.setTitle("萌娆词典 - 登录");
		this.setResizable(false);
		this.setSize(500, 250);
		this.setVisible(true);
		this.setLocationRelativeTo(usrName);
		this.getContentPane().setBackground(Color.WHITE);
		
		this.add(usrName);
		this.add(usrPassword);
		this.add(nameLabel);
		this.add(pswLabel);
		this.add(loginButton);
		this.add(signInButton);
		
		loginButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("Click login");
			}
		});
		
		signInButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("Click sign in");
			}
		});
	}	
}
