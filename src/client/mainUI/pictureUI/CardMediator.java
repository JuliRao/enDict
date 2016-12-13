package client.mainUI.pictureUI;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;

import client.common.Info;
import client.common.Send;
import client.common.User;
import client.common.UserList;

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
	
	public void startSend(boolean isAll) {
		Vector<String> strings = new Vector<String>();
		strings.add(Info.getWord());
		
		String meaningString = "";
		for(String string : Info.getMeanings().getMeanings(Info.getDefaultDictionary())) {
			meaningString += string + "///";
		}
		
		strings.add(meaningString);
		
		if(isAll) {
			ArrayList<User> list = UserList.getList();
			for(User user : list) {
				strings.add(user.getName());
			}
		}
		else {
			int []NOs = table.getSelectedRows();
			for(int NO : NOs) {
				strings.add(UserList.getList().get(NO).getName());
			}
		}
		
		send.sendCard(strings);
	}
}
