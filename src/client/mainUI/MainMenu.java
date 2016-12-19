package client.mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import client.common.Info;
import client.theme.MyTheme;
import common.Dictionary;

/**
 *  
 * @author marao
 * 右键菜单
 *
 */
@SuppressWarnings("serial")
public class MainMenu extends JPopupMenu {
	public MainMenu() {
		JMenu jm1 = new JMenu("默认词典");
		JMenuItem mi = new JMenuItem(Dictionary.Baidu.getName());
		JMenuItem mi2 = new JMenuItem(Dictionary.Bing.getName());
		JMenuItem mi3 = new JMenuItem(Dictionary.YouDao.getName());
		jm1.add(mi);
		jm1.add(mi2);
		jm1.add(mi3);
		add(jm1);
		
		mi.setBackground(MyTheme.Instance().getBackgroundColor());
		mi2.setBackground(MyTheme.Instance().getBackgroundColor());
		mi3.setBackground(MyTheme.Instance().getBackgroundColor());
		
		mi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Info.setDefaultDictionary(Dictionary.Baidu);
			}
		});
		
		mi2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Info.setDefaultDictionary(Dictionary.Bing);
			}
		});
		
		mi3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Info.setDefaultDictionary(Dictionary.YouDao);
			}
		});
		
		setBackground(MyTheme.Instance().getBackgroundColor());
	}
}
