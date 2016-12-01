package client.run;

import javax.swing.JFrame;

import client.connect.MyClient;
import client.mainUI.MainFrame;

public class DictMain {

	public static void main(String[] args) {
		MyClient.Instance();
		MainFrame frame = new MainFrame();
		
		//loginFrame loginFrame = new loginFrame();
		//frame.changeBackground();
	}
}
