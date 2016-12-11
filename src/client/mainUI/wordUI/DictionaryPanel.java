package client.mainUI.wordUI;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import common.Dictionary;

import client.common.Send;
import client.theme.MyTheme;

public class DictionaryPanel extends JPanel {
	private JTextArea translation = new JTextArea();
	private JButton button = new HeartButton();
	private JScrollPane scrollPane = new JScrollPane(translation);
	private Dictionary dictionary;
	
	public DictionaryPanel(Dictionary dictionary) {
		this.dictionary = dictionary;
		setLayout(null);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		translation.setFont(MyTheme.Instance().getFont());
		translation.setPreferredSize(new Dimension(390, 405));
		translation.setText(dictionary.getName());
		translation.setBackground(MyTheme.Instance().getBackgroundColor());
		translation.setLineWrap(true);
		translation.setWrapStyleWord(true);
		translation.setEditable(false);
		translation.setLayout(null);
		
		scrollPane.setBounds(this.getLocation().x, this.getLocation().y, 390, 300);
		button.setLocation(this.getLocation().x + 403, this.getLocation().y);
		
		add(scrollPane);
		add(button);
		
		button.addMouseListener(new MouseListener() {
			
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
				Send send = ((WordPanel)getParent().getParent()).getSend();
				send.like(dictionary);
			}
		});
	}
	
	public void displayMeaning(Vector<String> meanings) {
		translation.setText(dictionary.getName() + "\r\n");
		for(String string : meanings) {
			translation.append(string + "\r\n");
		}
		translation.repaint();
		//this.setPreferredSize(new Dimension(300, translation.getWidth()));
	}
}