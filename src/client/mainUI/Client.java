package client.mainUI;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Dictionary;
import common.RequestData;
import common.ResponseData;
import common.ThreeMeanings;
import client.common.Info;
import client.common.SearchableApater;
import client.common.Send;
import client.mainUI.functionUI.FunctionButton;
import client.mainUI.functionUI.FunctionPanel;
import client.mainUI.functionUI.FunctionPanelCreator;
import client.theme.MyTheme;

public class Client extends JFrame implements Send {
	private Socket socket;
	ObjectOutputStream toServer;
	ObjectInputStream input;
	
	private ImageIcon background = new ImageIcon(MyTheme.Instance().getBackgroundPicture()); 	// 背景图片
	private ImageIcon background2 = new ImageIcon("data/image/tree.jpg"); 	// 背景图片
	private JLabel label = new JLabel(background);
	
	private MainPane mainPane = new MainPane();
	private FunctionPanel functionPanel = new FunctionPanelCreator().createFunctionPanel();
	
	public Client(Socket socket) {
		System.out.println("Server connected.");
		this.setTitle("萌娆词典 - Zhou XinMeng & MaRao");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(740, 600);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);

        functionPanel.setBounds(40, 500, 650, 37);
        this.add(functionPanel);
        mainPane.setBounds(40, 40, 650, 450);
        this.add(mainPane);
        
        // 把背景图片显示在一个标签里面  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        this.getContentPane().add(label, new Integer(Integer.MIN_VALUE)); 
        
        // 设置相应操作
        mainPane.momentsPanel.setSend(this);
        mainPane.wordPanel.setSend(this);
        ((FunctionButton) functionPanel.getComponent(1)).setSend(this);
        ((FunctionButton) functionPanel.getComponent(2)).setSend(this);
        
        this.socket = socket;
		
		try {
			input = new ObjectInputStream(socket.getInputStream());
			toServer = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void searchWord(String word) {
		try {
			Info.setWord(word);
			toServer.writeUTF(word);
			toServer.flush();

			ThreeMeanings meanings = (ThreeMeanings)input.readObject();
			Info.setMeanings(new SearchableApater(meanings));
			
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
	
	public boolean login(String user, String password) {
		System.out.println("Click login");
		
		RequestData data = new RequestData();
		data.setType(type);
		Vector<String> strings = new Vector<String>(2);
		strings.add(user);
		strings.add(password);
		data.setRequest(strings);
		toServer.writeObject(data);
		toServer.flush();
		
		ResponseData responseData;
		while(responseData.getResponseType() != )
			responseData = (ResponseData) input.readObject();
		strings = responseData.getResponse();
		if(strings.get(0).contains("successfully")) {
			return true;
		}
		return false;	
	}
	
	public boolean signIn(String user, String password) {
		RequestData data = new RequestData();
		data.setType(type);
		Vector<String> strings = new Vector<String>(2);
		strings.add(user);
		strings.add(password);
		data.setRequest(strings);
		toServer.writeObject(data);
		toServer.flush();
		
		ResponseData responseData;
		while(responseData.getResponseType() != )
			responseData = (ResponseData) input.readObject();
		strings = responseData.getResponse();
		if(strings.get(0).contains("successfully")) {
			return true;
		}
		return false;
	}
	
	public void sendCard() {
		System.out.println("Start sending...");
	}

	public void like(Dictionary dictionary) {
		System.out.println("Like " + dictionary.getName());
		
		
	}
	
	public void getUserList() {
		System.out.println("Get all the user");
	}
	
	public void getCard() {
		
	}

	public void getCards() {
		
	}
	
	public static void main(String[] args) {
		try {
			new Client(new Socket("114.212.130.243", 8000));
			//new Client(new Socket("localhost", 8000));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}