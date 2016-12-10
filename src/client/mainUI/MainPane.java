package client.mainUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import client.common.Connection;
import client.mainUI.momentsUI.MomentsPanel;
import client.mainUI.wordUI.WordPanel;
import client.theme.MyTheme;

public class MainPane extends JTabbedPane {
	
	private ImageIcon icon =  new ImageIcon(MyTheme.Instance().getPaneIcon());
	
	private WordPanel wordPanel = new WordPanel();
	private MomentsPanel momentsPanel = new MomentsPanel();

	public MainPane(Connection connection) {
		wordPanel.setConnection(connection);
		
        Image temp = icon.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
        addTab("词典", icon, wordPanel);
        addTab("动态", icon, momentsPanel);
        setBounds(40, 40, 650, 450);
	}
}
