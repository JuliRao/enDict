package client.mainUI.pictureUI;

import javax.swing.JButton;

import client.common.Send;

public class CardMediator implements Mediator {
	private CardTable table;
	private JButton sendButton;
	private JButton sendAllButton;
	private Send send;
	
	public void setTable(CardTable table){
		this.table = table;
	}
	
	public void setSend(Send send) {
		this.send = send;
	}
	
	public void setSendButton(JButton sendButton) {
		this.sendButton = sendButton;
	}
	
	public void setSendAllButton(JButton sendAllButton) {
		this.sendAllButton = sendAllButton;
	}
	
	public void startSend() {
		send.sendCard();
	}
}
