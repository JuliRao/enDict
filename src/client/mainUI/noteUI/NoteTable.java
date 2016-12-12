package client.mainUI.noteUI;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.common.Info;
import client.common.Send;
import client.common.User;
import client.common.UserList;
import client.theme.MyTheme;

public class NoteTable extends JTable {
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	public NoteTable() {
		super(100, 2);
		String[] columnName = {"单词", "解释"};
		
		Object[][] data = Info.getWordNotes();
		System.out.println(data.length);
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
		setBackground(MyTheme.Instance().getBackgroundColor());
		setOpaque(false);
		
		this.setModel(tableModel);
		this.setRowHeight(25);
		setEnabled(true);
		setDragEnabled(false);
	}
}
