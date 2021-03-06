package client.mainUI.pictureUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import client.theme.MyTheme;

@SuppressWarnings("serial")
public class CardButton extends JButton {
	
	private static int width = 150;
	private static int height = 30;
	
	private Mediator mediator;
	
	public CardButton(Mediator mediator, String s, int x, int y) {
		this.setMediator(mediator);
		
		this.setText(s);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(MyTheme.Instance().getBackgroundColor());
		
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
				if(getText().contains("all")) {
					mediator.startSend(true);
				}
				else {
					mediator.startSend(false);
				}
			}
		});
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}
