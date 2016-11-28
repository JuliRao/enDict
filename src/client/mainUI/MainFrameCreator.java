package client.mainUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// abstract???
public class MainFrameCreator {
	public JLabel createBackgroud() {
		ImageIcon background = new ImageIcon("data/image/pheonix.jpg");
		JLabel label = new JLabel(background); 
		return label;
	}
	
	public MainFrame createMainFrame() {
		MainFrame frame = new MainFrame();
		frame.setResizable(false);
		frame.setTitle("Pheonix Dictionary - Zhou XinMeng & MaRao");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(740, 600);
		
		JLabel label = createBackgroud();
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());  
        JPanel imagePanel = (JPanel) frame.getContentPane();  
        imagePanel.setOpaque(false); 
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        frame.setVisible(true);
        
		return frame;
	}
}
