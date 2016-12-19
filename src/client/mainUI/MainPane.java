package client.mainUI;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import client.common.Send;
import client.mainUI.momentsUI.MomentsPanel;
import client.mainUI.wordUI.WordPanel;
import client.theme.MyTheme;

public class MainPane extends JTabbedPane {
	private ImageIcon icon =  new ImageIcon(MyTheme.Instance().getPaneIcon());
	WordPanel wordPanel = new WordPanel();
	MomentsPanel momentsPanel = new MomentsPanel();
	PagePanel pagePanel = new PagePanel();

	public MainPane() {
		Image temp = icon.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
        addTab("首页", icon, pagePanel);
        addTab("词典", icon, wordPanel);
        addTab("动态", icon, momentsPanel);
	}
	
	public void setSend(Send send) {
		wordPanel.setSend(send);
		momentsPanel.setSend(send);
	}
	
	public void initial() {
		momentsPanel.initial();
		pagePanel.initial();
	}
}
