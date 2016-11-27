package mainUI.functionUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FunctionButton extends JButton {
	private static int width = 30;
	private static int height = 30;
	
	private ImageIcon icon;
	
	public FunctionButton() {
		this.setBackground(Color.WHITE);
		this.setSize(width, height);
	}
	
	public FunctionButton(String path) {
		this.setBackground(Color.WHITE);
		icon = new ImageIcon(path);
		Image temp = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
		this.setIcon(icon);
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
