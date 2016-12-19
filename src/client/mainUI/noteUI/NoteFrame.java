package client.mainUI.noteUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import client.common.Info;
import client.common.Send;
import client.theme.MyTheme;

@SuppressWarnings("serial")
public class NoteFrame extends JFrame {
	private NoteTable table;
	private JScrollPane pane;
	
	public NoteFrame(Send send) {
		setTitle(Info.getUserName() + " 的单词本");
		setSize(800, 500);
		setResizable(false);
		setVisible(true);
		this.setLayout(null);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		table = new NoteTable();
		pane = new JScrollPane(table);
		pane.setBounds(30, 30, 740, 410);
		add(pane);
	}
}
