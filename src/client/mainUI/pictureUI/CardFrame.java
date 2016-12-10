package client.mainUI.pictureUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import client.config.Config;

public class CardFrame extends JFrame {
	private CardMediator mediator = new CardMediator();
	private CardTable cardTable = new CardTable(mediator);
	private JLabel picture = new JLabel(new ImageIcon(Config.getCardBuffer()));
	private JScrollPane scrollTable = new JScrollPane(cardTable);
	private JButton sendButton = new CardButton(mediator, "Send", 25, 330);
	private JButton sendAllButton = new CardButton(mediator, "Send all", 25, 365);

	public CardFrame() {
		this.setLayout(null);
		this.setTitle("发送单词卡");
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
	}
}
