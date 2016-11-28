package client.mainUI.wordUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class WordButton extends JButton {
	private static int width = 30;
	private static int height = 30;
	
	public WordButton() {
		this.setToolTipText("查询词典");
		this.setBackground(Color.WHITE);
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public WordButton(String s, int x, int y) {
		this.setToolTipText("查询词典");
		this.setBackground(Color.WHITE);
		this.setText(s);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
	}
	
	public WordButton(ImageIcon icon, int x, int y) {
		this.setToolTipText("查询词典");
		this.setBackground(Color.WHITE);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		Image temp = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
        this.setIcon(icon);
	}
}
