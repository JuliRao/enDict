package client.mainUI.wordUI;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import common.Dictionary;
import client.common.Displayable;
import client.common.Info;
import client.common.Meanings;
import client.common.Refreshable;
import client.common.Send;
import client.mainUI.functionUI.FunctionButton;
import client.theme.MyTheme;

/**
 * 
 * @author marao
 * 与搜索相关的模块
 *
 */
@SuppressWarnings("serial")
public class WordPanel extends JPanel {
	private WordLabel wordLabel = new WordLabel("EN ", 20, 20);
	private WordText wordText = new WordText(55, 20);
	private WordButton searchButton = new WordButton(new ImageIcon(MyTheme.Instance().getSearchIcon()), 580, 20);
	private WordCheckBoxs checkBoxs = new WordCheckBoxs(new Dictionary[]{Dictionary.Baidu, Dictionary.YouDao, Dictionary.Bing}, 35, 65);
	private WordTransPanel transPanel = new WordTransPanel();
	private FunctionButton addNoteButton = new FunctionButton(new ImageIcon(MyTheme.Instance().getAddNoteIcon()));
	
	private Refreshable refreshable = transPanel;
	private Displayable displayable = transPanel;
	
	private Send send;
	
	public Send getSend() {
		return send;
	}

	public void setSend(Send send) {
		this.send = send;
	}

	/**
	 * 搜索用户输入的英文单词
	 */
	private void goSearch() {
		String word = wordText.getText();
		send.searchWord(word);
		Meanings threeMeanings = Info.getMeanings();
		displayable.displayBaidu(threeMeanings.getMeanings(Dictionary.Baidu));
		displayable.displayBing(threeMeanings.getMeanings(Dictionary.Bing));
		displayable.displayYoudao(threeMeanings.getMeanings(Dictionary.YouDao));
		
		ArrayList<Dictionary> dictionaries = checkBoxs.getAccessible();
		refreshable.refresh(dictionaries);
	}
	
	public WordPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		add(wordLabel);
		add(wordText);
		add(searchButton);
		add(checkBoxs);
		add(transPanel);
		add(addNoteButton);
		
		addNoteButton.setToolTipText("加入单词本");
		addNoteButton.setBounds(35, 340, 40, 40);
		transPanel.setLocation(170, 75);
		
		for(JCheckBox checkBox : checkBoxs.getBoxs()) {
			checkBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					ArrayList<Dictionary> dictionaries = checkBoxs.getAccessible();
					refreshable.refresh(dictionaries);
				}
			});
		}
		
		// 响应回车操作
		wordText.addKeyListener(new KeyListener() {
			
		    public void keyPressed(KeyEvent e) {
		    	if(wordText.isLegal()) {
			        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
			        	goSearch();
			        }
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
				if(wordText.isLegal()) {
					goSearch();
				}
			}
		});
		
		addNoteButton.addMouseListener(new MouseListener() {
			
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
				Vector<String> meaning = Info.getMeanings().getMeanings(Info.getDefaultDictionary());
				String string = "";
				for(String string2 : meaning)
					string += string2 + "  ";
				send.addNote(Info.getWord(), string);
			}
		});
	}
}
