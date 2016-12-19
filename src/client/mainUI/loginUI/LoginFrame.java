package client.mainUI.loginUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.common.Send;

/**
 * 
 * @author marao
 * 用户登录注册界面
 *
 */
@SuppressWarnings("serial")
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
				int flag = send.login(usrName.getText(), password);
				if(flag == 1) {
					info.setText("用户名或密码错误，请重试");
					info.repaint();
				}
				else if(flag == 2) {
					info.setText("该用户已在线，请勿重复登录");
					info.repaint();
				}
				else {
//					System.out.println("sss");
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
				boolean flag = send.signIn(usrName.getText(), password);
				
				if(flag == false) {
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
