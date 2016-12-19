package client.mainUI.wordUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import client.theme.MyTheme;

@SuppressWarnings("serial")
public class HeartButton extends JButton {
	static int width = 50;
	static int height = 50;

	private ImageIcon stroke = new ImageIcon(MyTheme.Instance().getStrokeHeartIcon());
	private ImageIcon fill = new ImageIcon(MyTheme.Instance().getFillHeartIcon());

	public HeartButton() {
		this.setBackground(Color.WHITE);
		Image temp = stroke.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  
		stroke = new ImageIcon(temp);
		this.setIcon(stroke);
		temp = fill.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  
		fill = new ImageIcon(temp);
		this.setRolloverIcon(fill);
		this.setSize(width, height);
		this.setLayout(null);
		this.setBorder(null);
	}
	
	public boolean isFilled() {
		if(this.getIcon().equals(stroke))
			return false;
		else {
			return true;
		}
	}

	public void stroke() {
		setIcon(stroke);
	}

	public void fill() {
		setIcon(fill);
	}
}