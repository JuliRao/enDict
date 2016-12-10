package client.run;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import client.connect.ClientReceive;
import client.connect.ClientSend;
import client.mainUI.MainFrame;

public class DictMain {

	public static void main(String[] args) {
        Socket client;
		try {
			client = new Socket("localhost", 8000);

			ClientSend send = new ClientSend(client);
			ClientReceive receive = new ClientReceive(client);
			
			MainFrame frame = new MainFrame(send);
			frame.addWindowListener(new WindowListener() {
				
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
					
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					send.closeConnection();
					receive.closeConnection();
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					
				}
			});
			
			send.start();
			receive.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
