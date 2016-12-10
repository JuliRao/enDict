package client.mainUI.functionUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import client.mainUI.pictureUI.CardCreator;
import client.mainUI.pictureUI.CardFrame;

public class PicButton extends FunctionButton {
	public PicButton(String path) {
		super(path);
		this.setToolTipText("单词图片");
		
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
				new CardCreator().createCard();
				new CardFrame(send);
			}
		});
	}
}
