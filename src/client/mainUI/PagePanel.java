package client.mainUI;

import java.awt.Color;
import java.io.File;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import client.common.Info;
import client.config.Config;
import client.theme.MyTheme;

/**
 * 
 * @author marao
 * 首页展示页
 *
 */
@SuppressWarnings("serial")
public class PagePanel extends JPanel {
	JTextArea sentence = new JTextArea();
	JLabel picture;
	JTextArea hotWords = new JTextArea();
	JLabel label = new JLabel("今日最热搜索");
	
	private String getPicture() {
		File directory  = new File(Config.getSentenceFolder());
		if (directory.isDirectory()) {
			File[] array = directory.listFiles();
			Random random = new Random();
	        int s = random.nextInt(array.length);
			return array[s].getPath();
		}
		
		return null;
	}

	public PagePanel() {
		setBackground(MyTheme.Instance().getBackgroundColor());
		setLayout(null);
		
		sentence.setFont(MyTheme.Instance().getFont());
		sentence.setEditable(false);
		sentence.setWrapStyleWord(true);
		sentence.setLineWrap(true);
		sentence.setBounds(25, 20, 600, 50);
		sentence.setLayout(null);
		
		picture = new JLabel(new ImageIcon(getPicture()));
		picture.setBounds(25, 45, 400, 360);
		
		label.setFont(MyTheme.Instance().getFont());
		label.setForeground(Color.red);
		label.setBounds(495, 80, 170, 30);
		
		hotWords.setFont(MyTheme.Instance().getFont());
		hotWords.setBounds(470, 120, 170, 360);
		
		add(label);
		add(sentence);
		add(picture);
		add(hotWords);
	}
	
	void initial() {
		sentence.setText("Today sentence:  " + Info.getSentence());
		sentence.repaint();
		
		int NO = 0;
		String text = "";
		Vector<String> strings = Info.getHotWords();
		for(String string : strings) {
			text += ++NO + ".  " + string + "\r\n";
		}
		
		hotWords.setText(text);
		hotWords.repaint();
	}
}
