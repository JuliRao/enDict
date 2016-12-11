package client.mainUI.momentsUI;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.common.DisPicture;
import client.mainUI.pictureUI.CardCreator;
import client.mainUI.pictureUI.CardFrame;
import client.theme.MyTheme;

public class MomentsDisplay extends JPanel implements DisPicture {
	private int cnt = 0;
	
	public MomentsDisplay() {
		setLayout(null);
		setBackground(MyTheme.Instance().getBackgroundColor());
	}
	
	@Override
	public void addPicture(Vector<String> strings) {
		String path = new CardCreator().createCard(strings.get(1), strings.get(2));
		if(path != null) {
			JLabel label = new JLabel(new ImageIcon(path));
			label.setBounds(this.getX() + 10, this.getY() + 10 + cnt * 390, 380, 380);
			add(label);
			repaint();
			validate();
			
			++ cnt;
			System.out.println(cnt + " " + path);
		}
	}
}