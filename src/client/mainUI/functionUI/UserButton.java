package client.mainUI.functionUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;

import client.common.Info;
import client.mainUI.loginUI.LoginFrame;

@SuppressWarnings("serial")
public class UserButton extends FunctionButton {
	private LoginMouseListener listener = new LoginMouseListener();
	private LogoutMouseListener listener2 = new LogoutMouseListener();
	
	public UserButton(String path) {
		super(path);
		this.setToolTipText("登录");
		
		addMouseListener(listener);
	}
	
	class LogoutMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			send.logout();
			Info.setUserName(null);

			((JLabel) getParent().getComponent(4)).setText("未登录");
			((JLabel) getParent().getComponent(4)).repaint();
			
			setToolTipText("登录");
			removeMouseListener(listener2);
			addMouseListener(listener);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		
	}
	
	class LoginMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(isEnabled() == true) {
				LoginFrame loginFrame = new LoginFrame(send);
				loginFrame.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {

					}
					
					@Override
					public void windowIconified(WindowEvent e) {
			
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {

					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {

					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						if(Info.getUserName() != null) {
							((JLabel) getParent().getComponent(4)).setText("欢迎登陆：" + Info.getUserName());
							((JLabel) getParent().getComponent(4)).repaint();
							
							setToolTipText("退出登录");
							removeMouseListener(listener);
							addMouseListener(listener2);
						}
					}
					
					@Override
					public void windowActivated(WindowEvent e) {

					}
				});
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		
	}
}
