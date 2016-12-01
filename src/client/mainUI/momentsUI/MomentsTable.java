package client.mainUI.momentsUI;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.theme.MyTheme;

public class MomentsTable extends JTable {
	//表格不允许被编辑
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	MomentsTable() {
		super(100, 1);
		String[] columnName = {"用户"};
		Object[][] data = {{"Lily"}, {"Bob"}, {"Lucy"}};
		DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		this.setModel(tableModel);
		this.setRowHeight(25);
		setEnabled(true);
		setDragEnabled(false);
		setCellSelectionEnabled(false);
	}
}