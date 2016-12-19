package client.mainUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import client.common.Send;
import client.mainUI.momentsUI.MomentsPanel;
import client.mainUI.wordUI.WordPanel;
import client.theme.MyTheme;

/**
 * 
 * @author marao
 * 三个tab页
 *
 */
@SuppressWarnings("serial")
public class MainPane extends JTabbedPane {
	private ImageIcon icon =  new ImageIcon(MyTheme.Instance().getPaneIcon());
	private WordPanel wordPanel = new WordPanel();
	MomentsPanel momentsPanel = new MomentsPanel();
	private PagePanel pagePanel = new PagePanel();

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
