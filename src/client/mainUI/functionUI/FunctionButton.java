package client.mainUI.functionUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import client.theme.MyTheme;

public class FunctionButton extends JButton {
	private static int width = 33;
	private static int height = 33;
	
	private ImageIcon icon;
	private ImageIcon reverseIcon;
	
	public FunctionButton() {
		this.setBackground(Color.WHITE);
		this.setSize(width, height);
	}
	
	public FunctionButton(String path) {
		//this.setBorder(null);
		this.setBackground(Color.WHITE);
		icon = new ImageIcon(path);
		Image temp = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
		this.setIcon(icon);
		
		reverseIcon = new ImageIcon(MyTheme.Instance().getReverseIcon());
		temp = reverseIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  
		reverseIcon = new ImageIcon(temp);
		this.setRolloverIcon(reverseIcon);
		
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public FunctionButton(ImageIcon icon) {
		this.setBackground(Color.WHITE);
		this.setSize(width, height);
		this.icon = icon;
		Image temp = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
        this.setIcon(icon);
	}
}
