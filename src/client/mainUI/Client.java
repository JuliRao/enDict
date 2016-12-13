package client.mainUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import common.Dictionary;
import common.RequestData;
import common.ResponseData;
import common.dataType;
import client.common.DisPicture;
import client.common.Info;
import client.common.Meanings;
import client.common.Send;
import client.common.User;
import client.common.UserList;
import client.mainUI.functionUI.FunctionButton;
import client.mainUI.functionUI.FunctionPanel;
import client.mainUI.functionUI.FunctionPanelCreator;
import client.theme.MyTheme;

@SuppressWarnings("serial")
public class Client extends JFrame implements Send {
	private Socket socket;
	ObjectOutputStream toServer;
	ObjectInputStream input;
	
	private ImageIcon background = new ImageIcon(MyTheme.Instance().getBackgroundPicture()); 	// 背景图片
	private ImageIcon background2 = new ImageIcon("data/image/tree.jpg"); 	// 背景图片
	private JLabel label = new JLabel(background);
	
	private MainPane mainPane = new MainPane();
	private FunctionPanel functionPanel = new FunctionPanelCreator().createFunctionPanel();
	private DisPicture disPicture = mainPane.momentsPanel.getMomentsDisplay();

	public Client(Socket socket) {
		System.out.println("Server connected.");
		this.setTitle("萌娆词典 - Zhou XinMeng & MaRao");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(740, 600);
		this.setLayout(null);
		this.setResizable(false);
		

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
        ((FunctionButton) functionPanel.getComponent(3)).setSend(this);
        
        this.socket = socket;
		
		try {
			toServer = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		getHotWords();
		getSentence();
		getUserList();
		mainPane.pagePanel.initial();
		mainPane.momentsPanel.initial();
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
	
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
				closeConnection();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {

			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
		
		this.setVisible(true);
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
		System.out.println("Search " + word);
		
		if(!word.equals("")) {
			RequestData requestData = new RequestData();
			requestData.setType(dataType.search);
			Vector<String> strings = new Vector<String>();
			strings.add(word);
			requestData.setRequest(strings);
	
			ResponseData responseData = null;
			try {
				toServer.writeObject(requestData);
				toServer.flush();
				
				responseData = (ResponseData) input.readObject();
				while(responseData.getResponseType() != dataType.search)
					responseData = (ResponseData) input.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			strings = responseData.getResponse();
			Info.setWord(word);
			Info.setMeanings(new Meanings(strings));
		}
	}
	
	public void closeConnection() {
		System.out.println("Close the Client socket and the io.");
		try {
			RequestData data = new RequestData();
			data.setType(dataType.logout);
			toServer.writeObject(data);
			toServer.flush();
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int login(String user, String password) {
		System.out.println("Click login");
		
		RequestData data = new RequestData();
		data.setType(dataType.login);
		Vector<String> strings = new Vector<String>(2);
		strings.add(user);
		strings.add(password);
		data.setRequest(strings);
		
		ResponseData responseData = null;
		try {
			toServer.writeObject(data);
			toServer.flush();
			
			responseData = (ResponseData) input.readObject();
			while(responseData.getResponseType() != dataType.login)
				responseData = (ResponseData) input.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		strings = responseData.getResponse();
		if(strings.get(0).contains("successfully")) {
			Info.setUserName(user);
			mainPane.momentsPanel.refresh();
			return 0;
		}
		else if(strings.get(0).contains("repeatedly")) {
			return 2;
		}
		return 1;
	}
	
	public boolean signIn(String user, String password) {
		System.out.println("Click sign up");
		
		RequestData data = new RequestData();
		data.setType(dataType.signUp);
		Vector<String> strings = new Vector<String>(2);
		strings.add(user);
		strings.add(password);
		data.setRequest(strings);
		
		ResponseData responseData = null;
		try {
			toServer.writeObject(data);
			toServer.flush();
			
			responseData = (ResponseData) input.readObject();
			while(responseData.getResponseType() != dataType.signUp)
				responseData = (ResponseData) input.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		strings = responseData.getResponse();
		if(strings.get(0).contains("successfully")) {
			return true;
		}
		return false;	
	}
	
	public void sendCard(Vector<String> strings) {
		System.out.println("Start sending...");
		
		if(Info.getUserName() == null) {
			JOptionPane.showMessageDialog(null, "请先登录", "提示", JOptionPane.PLAIN_MESSAGE, new ImageIcon(MyTheme.Instance().getDialogIcon()));
		}
		else {
			RequestData requestData = new RequestData();
			requestData.setType(dataType.sendMail);
			requestData.setRequest(strings);
			
			try {
				toServer.writeObject(requestData);
				toServer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addNote(String word, String meaning) {
		System.out.println("Add word...");

		if(Info.getUserName() != null) {
			if(!word.equals("")) {
				RequestData requestData = new RequestData();
				requestData.setType(dataType.addwordbook);
				Vector<String> strings = new Vector<String>();
				strings.add(word);
				strings.add(meaning);
				requestData.setRequest(strings);
				
				try {
					toServer.writeObject(requestData);
					toServer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "请先登录", "提示", JOptionPane.PLAIN_MESSAGE, new ImageIcon(MyTheme.Instance().getDialogIcon()));
		}
	}

	public void like(Dictionary dictionary) {
		System.out.println("Like " + dictionary.getName());
		
		RequestData requestData = new RequestData();
		requestData.setType(dataType.thumbUp);
		Vector<String> strings = new Vector<String>();
		strings.add(Info.getWord());
		strings.add(dictionary.getEnglishName());
		requestData.setRequest(strings);
		
		try {
			toServer.writeObject(requestData);
			toServer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void unlike(Dictionary dictionary) {
		System.out.println("Unlike " + dictionary.getName());
		
		RequestData requestData = new RequestData();
		requestData.setType(dataType.thumbDown);
		Vector<String> strings = new Vector<String>();
		strings.add(Info.getWord());
		strings.add(dictionary.getEnglishName());
		requestData.setRequest(strings);
		
		try {
			toServer.writeObject(requestData);
			toServer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getUserList() {
		System.out.println("Get all the user");
		RequestData requestData = new RequestData();
		requestData.setType(dataType.online);
		
		ResponseData responseData = null;
		try {
			toServer.writeObject(requestData);
			toServer.flush();
			responseData = (ResponseData) input.readObject();
			while(responseData.getResponseType() != dataType.online)
				responseData = (ResponseData) input.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		UserList.clearList();
		Vector<String> strings = responseData.getResponse();
		for(int i = 0; i < strings.size() / 2; ++ i) {
			User user = new User(strings.get(i * 2 + 1), strings.get(i * 2));
			UserList.addUser(user);
		}
	}
	
	public void getCards() {
		System.out.println("Get all the cards");
		
		if(Info.getUserName() != null) {
			RequestData requestData = new RequestData();
			requestData.setType(dataType.receiveMail);
			
			ResponseData responseData = null;
			try {
				toServer.writeObject(requestData);
				toServer.flush();
				responseData = (ResponseData) input.readObject();
				while(responseData.getResponseType() != dataType.receiveMail)
					responseData = (ResponseData) input.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Vector<String> strings = responseData.getResponse();
			if(strings == null)
				return;
			
			for(int i = 0; i < strings.size() / 3; ++ i) {
				Vector<String> word = new Vector<String>();
				word.add(strings.get(i * 3));
				word.add(strings.get(i * 3 + 1));
				word.add(strings.get(i * 3 + 2));
				disPicture.addPicture(word);
			}
		}
	}
	
	@Override
	public void logout() {
		System.out.println("Log out");
		try {
			RequestData data = new RequestData();
			data.setType(dataType.logout);
			toServer.writeObject(data);
			toServer.flush();
			
			mainPane.momentsPanel.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getWordNotes() {
		System.out.println("Get all the notes");
		if(Info.getUserName() == null) {
			JOptionPane.showMessageDialog(null, "请先登录", "提示", JOptionPane.PLAIN_MESSAGE, new ImageIcon(MyTheme.Instance().getDialogIcon()));
		}
		else {
			RequestData requestData = new RequestData();
			requestData.setType(dataType.getwordbook);
			
			ResponseData responseData = null;
			try {
				toServer.writeObject(requestData);
				toServer.flush();
				responseData = (ResponseData) input.readObject();
				while(responseData.getResponseType() != dataType.getwordbook)
					responseData = (ResponseData) input.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Vector<String> strings = responseData.getResponse();
			String [][]notes = new String[strings.size() / 2][2];
			for(int i = 0; i < strings.size() / 2; ++ i) {
				notes[i] = new String[2];
				notes[i][0] = strings.get(i * 2);
				notes[i][1] = strings.get(i * 2 + 1);
			}
			Info.setWordNotes(notes);
		}
	}
	
	public void getSentence() {
		System.out.println("Get today sentence");
		RequestData requestData = new RequestData();
		requestData.setType(dataType.everyDay);
		
		ResponseData responseData = null;
		try {
			toServer.writeObject(requestData);
			toServer.flush();
			responseData = (ResponseData) input.readObject();
			while(responseData.getResponseType() != dataType.everyDay)
				responseData = (ResponseData) input.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Vector<String> strings = responseData.getResponse();
		Info.setSentence(strings.get(0));
	}
	
	public void getHotWords() {
		System.out.println("Get hot words");
		RequestData requestData = new RequestData();
		requestData.setType(dataType.hotSearch);
		
		ResponseData responseData = null;
		try {
			toServer.writeObject(requestData);
			toServer.flush();
			responseData = (ResponseData) input.readObject();
			while(responseData.getResponseType() != dataType.hotSearch)
				responseData = (ResponseData) input.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Vector<String> strings = responseData.getResponse();
		Info.setHotWords(strings);
	}
	
	public static void main(String[] args) {
		try {
//			new Client(new Socket("114.212.130.243", 8000));
			new Client(new Socket("localhost", 8000));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}