package mainUI.wordUI;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import theme.MyTheme;

public class DictionaryPanel extends JPanel {
	private JTextArea translation = new JTextArea();
	private JButton button = new HeartButton();
	private JScrollPane scrollPane = new JScrollPane(translation);
	private String dictionaryName;
	
	public DictionaryPanel(String name) {
		dictionaryName = name;
		setLayout(null);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		translation.setFont(MyTheme.Instance().getFont());
		translation.setPreferredSize(new Dimension(390, 405));
		translation.setText(name);
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
				System.out.println("Click heart");
			}
		});
	}
	
	public void displayMeaning(Vector<String> meanings) {
		translation.setText(dictionaryName + "\r\n");
		for(String string : meanings) {
			translation.append(string + "\r\n");
		}
		translation.repaint();
	}
}