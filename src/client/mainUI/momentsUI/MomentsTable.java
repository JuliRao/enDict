package client.mainUI.momentsUI;

import client.mainUI.UserTable;

@SuppressWarnings("serial")
public class MomentsTable extends UserTable {
	//表格不允许被编辑
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	MomentsTable() {
		super();
		setCellSelectionEnabled(false);
	}
}