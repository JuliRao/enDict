package client.mainUI.loginUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.common.Info;
import client.common.Send;

public class LoginFrame extends JFrame {
	private JTextField usrName = new LoginText(130, 25);
	private JPasswordField usrPassword = new LoginPassword(130, 75);

	private JLabel nameLabel = new LoginLabel("用户名", 50, 25);
	private JLabel pswLabel = new LoginLabel("密码", 50, 75);
	
	private JButton loginButton = new LoginButton("登录", 130, 170);
	private JButton signInButton = new LoginButton("注册", 345, 170);
	
	private JLabel info = new LoginLabel("", 130, 120);
	
	public LoginFrame(Send send) {
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
		this.add(info);
		
		info.setSize(300, 40);
		info.setForeground(Color.red);
		
		loginButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseExited(MouseEvent e) {

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String password = new String(usrPassword.getPassword());
				boolean success = send.login(usrName.getText(), password);
				if(success == false) {
					info.setText("用户名或密码错误，请重试");
					info.repaint();
				}
				else {
					Info.setUserName(usrName.getText());
					dispose();
				}
			}
		});
		
		signInButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String password = new String(usrPassword.getPassword());
				boolean success = send.signIn(usrName.getText(), password);
				
				if(success == false) {
					info.setText("该用户名已被注册，请重新注册或登录");
					info.repaint();
				}
				else {
					info.setText("注册成功，请登录");
					info.repaint();
				}
			}
		});
	}
	
	public static void main(String []args) {
		new LoginFrame(null);
	}
}
