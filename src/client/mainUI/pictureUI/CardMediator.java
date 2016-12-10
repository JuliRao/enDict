package client.mainUI.pictureUI;

import javax.swing.JButton;

public class CardMediator implements Mediator {
	private CardTable table;
	private JButton sendButton;
	private JButton sendAllButton;
	
	public void setTable(CardTable table){
		this.table = table;
	}
	
	public void setSendButton(JButton sendButton) {
		this.sendButton = sendButton;
	}
	
	public void setSendAllButton(JButton sendAllButton) {
		this.sendAllButton = sendAllButton;
	}
	
	public void send() {
		
	}
}
