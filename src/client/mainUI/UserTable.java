package client.mainUI;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.common.User;
import client.common.UserList;
import client.theme.MyTheme;

public class UserTable extends JTable {
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	protected UserTable() {
		super(100, 1);
		String[] columnName = {"用户"};
		
		ArrayList<User> list = UserList.getList();
		Object[][] data = new Object[list.size()][];
		for(int i = 0; i < list.size(); ++ i) {
			data[i] = new Object[1]; 
			data[i][0] = list.get(i).getName();
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
		setBackground(MyTheme.Instance().getBackgroundColor());
		
		this.setModel(tableModel);
		this.setRowHeight(25);
		setEnabled(true);
		setDragEnabled(false);
	}
	
	public void showAll() {
		String[] columnName = {"用户"};
		
		ArrayList<User> list = UserList.getList();
		Object[][] data = new Object[list.size()][];
		for(int i = 0; i < list.size(); ++ i) {
			data[i] = new Object[1]; 
			data[i][0] = list.get(i).getName();
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
		this.setModel(tableModel);
	}
	
	public void showOnline() {
		String[] columnName = {"用户"};
		
		ArrayList<User> list = UserList.getList();
		
		int cnt = 0;
		for(User user : list) {
			if(user.isOnline() == true)
				++cnt;
		}
		
		Object[][] data = new Object[cnt][];
		int j = 0;
		for(int i = 0; i < list.size(); ++ i) {
			if(list.get(i).isOnline()) {
				data[j] = new Object[1]; 
				data[j][0] = list.get(i).getName();
				++ j;
			}
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
		this.setModel(tableModel);
	}
}
