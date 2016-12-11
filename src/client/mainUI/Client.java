package client.mainUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Dictionary;
import common.ThreeMeanings;
import client.common.Info;
import client.common.SearchableApater;
import client.common.Send;
import client.mainUI.functionUI.FunctionPanel;
import client.mainUI.functionUI.FunctionPanelCreator;
import client.theme.MyTheme;

public class Client extends JFrame implements Send {
	private Socket socket;
	private DataOutputStream toServer;
	private ObjectInputStream input;
	
	private MainPane mainPane = new MainPane();
	private FunctionPanel functionPanel = new FunctionPanelCreator().createFunctionPanel();
	private ImageIcon background = new ImageIcon(MyTheme.Instance().getBackgroundPicture()); 	// 背景图片
	private JLabel label = new JLabel(background);

	public Client() {
		this.setTitle("萌娆词典 - Zhou XinMeng & MaRao");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(740, 600);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
		// 添加组件
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
				connect();
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
				closeConnection();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
        
        
	}
	
	public void connect() {
		try {
			socket = new Socket("localhost", 8000);
			System.out.println("Server connected.");
			toServer = new DataOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void changeBackground() {
		this.remove(label);
		
		label = new JLabel(background);
		label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        this.setVisible(true);
		
		validate();
		repaint();
	}
	
	public void searchWord(String word) {
		try {
			toServer.writeUTF(word);
			ThreeMeanings meanings = (ThreeMeanings)input.readObject();
			Info.setMeanings(new SearchableApater(meanings));
			Info.setWord(word);
			toServer.flush();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		System.out.println("Close the Client socket and the io.");
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}

	@Override
	public void getUserList() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void getCards() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void login(String user, String password) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void signIn(String user, String password) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void sendCard() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void like(Dictionary dictionary) {
		// TODO 自动生成的方法存根
		
	}
}
