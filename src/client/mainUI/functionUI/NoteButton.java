package client.mainUI.functionUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import client.common.Info;
import client.mainUI.noteUI.NoteFrame;


public class NoteButton extends FunctionButton {
	public NoteButton(String path) {
		super(path);
		this.setToolTipText("生词本");
		
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
				send.getWordNotes();
				if(Info.getUserName() != null) {
					new NoteFrame(send);
				}
			}
		});
	}
}