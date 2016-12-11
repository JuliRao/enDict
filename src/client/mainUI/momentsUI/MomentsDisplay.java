package client.mainUI.momentsUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.theme.MyTheme;

public class MomentsDisplay extends JPanel {
	public MomentsDisplay() {
		setLayout(null);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		JLabel label = new JLabel(new ImageIcon("data/image/card/a.png"));
		label.setBounds(this.getX() + 10, this.getY() + 10, 380, 380);
		add(label);
		
		JLabel label2 = new JLabel(new ImageIcon("data/image/card/summer2.jpg"));
		label2.setBounds(this.getX() + 10, this.getY() + 400, 380, 380);
		add(label2);
	}
	
	public void addPicture() {
		
	}
}