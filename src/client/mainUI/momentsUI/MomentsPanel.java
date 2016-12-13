package client.mainUI.momentsUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import client.common.Send;
import client.common.UserList;
import client.mainUI.UserTable;
import client.mainUI.functionUI.FunctionButton;
import client.theme.MyTheme;
import client.theme.Theme;

public class MomentsPanel extends JPanel {
	private MomentsTable momentsTable = new MomentsTable();
	private MomentsDisplay momentsDisplay = new MomentsDisplay();
	
	public MomentsDisplay getMomentsDisplay() {
		return momentsDisplay;
	}

	private JScrollPane scrollTable = new JScrollPane(momentsTable);
	private JScrollPane scrollPane = new JScrollPane(momentsDisplay);
	private JCheckBox checkBox = new JCheckBox("显示离线用户");
	private FunctionButton refresh = new FunctionButton(MyTheme.Instance().getSearchIcon());
	
	private Send send;
	
	public Send getSend() {
		return send;
	}

	public void setSend(Send send) {
		this.send = send;
	}
	
	public MomentsPanel() {
		setBackground(MyTheme.Instance().getBackgroundColor());
		setLayout(null);
		
		scrollTable.setBounds(25, 25, 150, 330);
		scrollPane.setBounds(200, 25, 420, 370);
		
		checkBox.setBackground(MyTheme.Instance().getBackgroundColor());
		checkBox.setBounds(22, 370, 110, 30);
		
		refresh.setToolTipText("刷新");
		refresh.setBackground(MyTheme.Instance().getBackgroundColor());
		refresh.setBounds(145, 370, 30, 30);
		
		add(scrollTable);
		add(scrollPane);
		add(checkBox);
		add(refresh);
		momentsDisplay.setPreferredSize(new Dimension(400, 350));
		
		checkBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(checkBox.isSelected()) {
					momentsTable.showAll();
				}
				else {
					momentsTable.showOnline();
				}
			}
		});
		
		
		refresh.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				send.getUserList();

				if(checkBox.isSelected()) {
					momentsTable.showAll();
				}
				else {
					momentsTable.showOnline();
				}
				
				send.getCards();
			}
		});
	}
	
	public void refresh() {
		momentsTable.showOnline();
	}
}
