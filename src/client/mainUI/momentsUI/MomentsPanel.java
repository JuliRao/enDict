package client.mainUI.momentsUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import client.theme.MyTheme;

public class MomentsPanel extends JPanel {
	private MomentsTable momentsTable = new MomentsTable();
	private MomentsDisplay momentsDisplay = new MomentsDisplay();
	private JScrollPane scrollTable = new JScrollPane(momentsTable);
	private JScrollPane scrollPane = new JScrollPane(momentsDisplay);
	
	public MomentsPanel() {
		setBackground(MyTheme.Instance().getBackgroundColor());
		setLayout(null);
		
		scrollTable.setBounds(25, 25, 150, 370);
		scrollPane.setBounds(200, 25, 420, 370);
		
		add(scrollTable);
		add(scrollPane);
		momentsDisplay.setPreferredSize(new Dimension(1000,1000));
	}
}
