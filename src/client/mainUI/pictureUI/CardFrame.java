package client.mainUI.pictureUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import client.common.Send;
import client.config.Config;

public class CardFrame extends JFrame {
	private CardMediator mediator = new CardMediator();
	private CardTable cardTable;
	private JLabel picture = new JLabel(new ImageIcon(Config.getCardBuffer()));
	private JScrollPane scrollTable;
	private JButton sendButton = new CardButton(mediator, "Send", 25, 330);
	private JButton sendAllButton = new CardButton(mediator, "Send all", 25, 365);

	private Send send;

	// TODO ？？？
	public CardFrame(Send send) {
		this.send = send;
		send.getUserList();
		
		cardTable = new CardTable(mediator);
		scrollTable = new JScrollPane(cardTable);
		
		this.setLayout(null);
		this.setTitle("发送单词卡");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 450);
		this.setVisible(true);
		this.setLocationRelativeTo(picture);
		this.getContentPane().setBackground(Color.WHITE);
		
		scrollTable.setBounds(25, 25, 150, 300);
		picture.setBounds(200, 25, 420, 370);
		picture.setIcon(new ImageIcon(Config.getCardBuffer()));
		picture.repaint();
		this.validate();

		add(scrollTable);
		add(picture);
		add(sendButton);
		add(sendAllButton);
		
		mediator.setSendAllButton(sendAllButton);
		mediator.setSendButton(sendButton);
		mediator.setTable(cardTable);
		mediator.setSend(send);
	}

	public Send getSend() {
		return send;
	}

	public void setSend(Send send) {
		this.send = send;
	}
}
