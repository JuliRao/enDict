package client.mainUI.functionUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import client.common.Send;
import client.mainUI.loginUI.LoginFrame;

public class UserButton extends FunctionButton {
	
	public UserButton(String path) {
		super(path);
		this.setToolTipText("登录");
		
		addMouseListener(new MouseListener() {
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
				LoginFrame loginFrame = new LoginFrame(send);
			}
		});
	}
}
