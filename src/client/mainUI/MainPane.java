package client.mainUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import client.mainUI.momentsUI.MomentsPanel;
import client.mainUI.wordUI.WordPanel;
import client.theme.MyTheme;

public class MainPane extends JTabbedPane {
	private ImageIcon icon =  new ImageIcon(MyTheme.Instance().getPaneIcon());
	WordPanel wordPanel = new WordPanel();
	MomentsPanel momentsPanel = new MomentsPanel();


	public MainPane() {
		Image temp = icon.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
        addTab("词典", icon, wordPanel);
        addTab("动态", icon, momentsPanel);
	}
}
