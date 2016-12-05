package client.mainUI;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.theme.MyTheme;

public class UserTable extends JTable {
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	protected UserTable() {
		super(100, 1);
		String[] columnName = {"用户"};
		Object[][] data = {{"Lily"}, {"Bob"}, {"Lucy"}};
		DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		this.setModel(tableModel);
		this.setRowHeight(25);
		setEnabled(true);
		setDragEnabled(false);
	}
}
