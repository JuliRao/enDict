package client.mainUI.wordUI;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import common.ThreeMeanings;
import client.common.Displayable;
import client.common.Refreshable;
import client.common.Searchable;
import client.connect.MyClient;
import client.search.Search;
import client.theme.MyTheme;

public class WordPanel extends JPanel {
	private WordLabel wordLabel = new WordLabel("EN ", 20, 20);
	private WordText wordText = new WordText(55, 20);
	private WordButton searchButton = new WordButton(new ImageIcon(MyTheme.Instance().getSearchIcon()), 580, 20);
	private WordCheckBoxs checkBoxs = new WordCheckBoxs(new String[]{"有道词典", "百度词典", "必应词典"}, 50, 65);
	private WordTransPanel transPanel = new WordTransPanel();
	
	private Refreshable refreshable = transPanel;
	private Displayable displayable = transPanel;
	
	private void goSearch() {
		String word = wordText.getText();
		ThreeMeanings threeMeanings = MyClient.Instance().searchWord(word);
		displayable.displayBaidu(threeMeanings.getBaidu());
		displayable.displayBing(threeMeanings.getBing());
		displayable.displayYoudao(threeMeanings.getYoudao());
	}
	
	public WordPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		add(wordLabel);
		add(wordText);
		add(searchButton);
		add(checkBoxs);
		add(transPanel);
		
		transPanel.setLocation(170, 75);
		
		for(JCheckBox checkBox : checkBoxs.getCheckBoxList()) {
			checkBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					refreshable.refresh(checkBoxs.isAccessable());
				}
			});
		}
		
		// 响应回车操作
		wordText.addKeyListener(new KeyListener() {
			
		    public void keyPressed(KeyEvent e) {  
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
		        	goSearch();
		        }
		    }  
		    public void keyReleased(KeyEvent e) {  

		    }  
		    public void keyTyped(KeyEvent e) {  
		    	
		    }  
		});
		
		searchButton.addMouseListener(new MouseListener(
				) {
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseExited(MouseEvent e) {

			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				goSearch();
			}
		});
	}
}
