package client.mainUI.momentsUI;

import java.awt.Dimension;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.common.DisPicture;
import client.config.Config;
import client.mainUI.pictureUI.CardCreator;
import client.theme.MyTheme;

/**
 * 
 * @author marao
 * 用户的动态界面
 *
 */
@SuppressWarnings("serial")
public class MomentsDisplay extends JPanel implements DisPicture {
	private int cnt = 0;
	
	public MomentsDisplay() {
		setLayout(null);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		// the buffer folder
		File directory  = new File(Config.getReceiveFolder());
		if (directory.isDirectory()) {
			File[] array = directory.listFiles();
			for(File file : array) {
				if(file.isFile()) {
					file.delete();
		        }
			}
		}
	}
	
	/**
	 * 新生成一张单词卡
	 */
	@Override
	public void addPicture(Vector<String> strings) {
		String path = new CardCreator().createCard(strings.get(1), strings.get(2), strings.get(0));
		if(path != null) {
			
			setPreferredSize(new Dimension(380, (cnt + 1) * 390 + 10));
			
			JLabel label = new JLabel(new ImageIcon(path));
			label.setBounds(10, 10 + cnt * 390, 380, 380);
			add(label);
			
			repaint();
			validate();
			
			++ cnt;
			getParent().repaint();
			getParent().validate();
		}
	}

	/**
	 * 设置当前展示的单词卡的数目
	 * @param i
	 */
	public void setCnt(int i) {
		cnt = i;
	}
}