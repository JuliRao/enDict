package client.mainUI;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.connect.MyClient;
import client.mainUI.functionUI.FunctionPanel;
import client.mainUI.functionUI.FunctionPanelCreator;
import client.mainUI.momentsUI.MomentsPanel;
import client.mainUI.wordUI.WordPanel;
import client.theme.MyTheme;

public class MainFrame extends JFrame {
	private ImageIcon background = new ImageIcon(MyTheme.Instance().getBackgroundPicture()); 	// 背景图片
	private ImageIcon background2 = new ImageIcon("data/image/tree.jpg"); 	// 背景图片
	private ImageIcon icon =  new ImageIcon(MyTheme.Instance().getPaneIcon());
	
	private JLabel label = new JLabel(background);
	
	private WordPanel wordPanel = new WordPanel();
	private MomentsPanel momentsPanel = new MomentsPanel();
	private MainPane mainPane = new MainPane();
	private FunctionPanel functionPanel = new FunctionPanelCreator().createFunctionPanel();
	
	public MainFrame() {
		this.setTitle("萌娆词典 - Zhou XinMeng & MaRao");
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(740, 600);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
        Image temp = icon.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT);  
        icon = new ImageIcon(temp);
        mainPane.addTab("词典", icon, wordPanel);
        mainPane.addTab("动态", icon, momentsPanel);
        mainPane.setBounds(40, 40, 650, 450);
        this.add(mainPane);
        
        functionPanel.setBounds(40, 500, 650, 37);
        this.add(functionPanel);
        
        // 把背景图片显示在一个标签里面  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        this.getContentPane().add(label, new Integer(Integer.MIN_VALUE)); 
        
        // 关闭窗口时关闭连接
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				MyClient.Instance();
			}
			
			@Override
			public void windowIconified(WindowEvent e) {

			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {

			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {

			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				//MyClient.Instance().closeConnection();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
	}
	
	public void changeBackground() {
		this.remove(label);
		
		label = new JLabel(background2);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        this.setVisible(true);
		
		validate();
		repaint();
	}
}
