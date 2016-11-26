package mainUI;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class WordPanel extends JPanel {
	private WordLabel wordLabel = new WordLabel("EN ", 20, 20);
	private WordText wordText = new WordText(55, 20);
	private WordButton searchButton = new WordButton("GO", 580, 20);
	private WordCheckBoxs checkBoxs = new WordCheckBoxs(new String[]{"有道词典", "百度词典", "金山词霸"}, 50, 65);
	private WordTransPanel transPanel = new WordTransPanel();
	
	public WordPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		add(wordLabel);
		add(wordText);
		add(searchButton);
		add(checkBoxs);
		JScrollPane scrollPane = new JScrollPane(transPanel);
		scrollPane.setBounds(170, 75, 450, 310);
		//add(transPanel);
		add(scrollPane);
		
		wordText.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				System.out.println(wordText.getText());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		for(JCheckBox checkBox : checkBoxs.getCheckBoxList()) {
			checkBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					transPanel.refresh(checkBoxs.isAccessable());
				}
			});
		}
		
		searchButton.addMouseListener(new MouseListener(
				) {
			
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
				// TODO 自动生成的方法存根
				System.out.println("Click Search");
			}
		});
	}
}
